/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aksdfpak;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class ProfissionalDAO extends GenericDAO<Profissional>{
        public ProfissionalDAO() {
   }

   @Override
   protected String getInsertQuery() {
      return "INSERT INTO profissional (nome, email, especialidade, telefone) VALUES (?, ?, ?, ?, ?)";
   }

   @Override
   protected String getUpdateQuery() {
      return "UPDATE profissional SET nome = ?, especialidade = ? WHERE email = ?";
   }

   @Override
   protected String getDeleteQuery() {
      return "DELETE FROM profissional WHERE email = ?";
   }

   @Override
   protected String getSelectQuery() {
      return "SELECT * FROM profissional";
   }

   @Override
   protected void setParameters(PreparedStatement var1, Profissional var2) throws SQLException {
      var1.setString(1, var2.getNome());
      var1.setString(2, var2.getRg());
      var1.setString(3, var2.getEspecialidade());
      var1.setString(4, var2.getTelefone());
      var1.setString(5, var2.getCpf());
   }

   @Override
   protected Profissional getEntityFromResultSet(ResultSet var1) throws SQLException {
      return new Profissional(var1.getString("id_profissional"), var1.getString("nome"), var1.getString("especialidade"),var1.getString("telefone"),var1.getString("rg"),var1.getString("cpf"));
   }

   public void limparTabela() {
      String var1 = "DELETE FROM profissional";
      Connection var2 = null;
      PreparedStatement var3 = null;

      try {
         var2 = DatabaseConnection.getConnection();
         var3 = var2.prepareStatement(var1);
         var3.executeUpdate();
         System.out.println("Tabela de profissionais limpa!");
      } catch (SQLException var8) {
          System.out.println(var8);
      } finally {
         DatabaseConnection.closeStatement(var3);
         DatabaseConnection.closeConnection(var2);
      }

   }

   @Override
   public void atualizar(Profissional var1) {
      String var2 = this.getUpdateQuery();
      Connection var3 = null;
      PreparedStatement var4 = null;

      try {
         var3 = DatabaseConnection.getConnection();
         var4 = var3.prepareStatement(var2);
         var4.setString(1, var1.getNome());
         var4.setString(2, var1.getEspecialidade());
         var4.setString(3, var1.getRg());
         var4.setString(4, var1.getTelefone());
         var4.setString(5, var1.getCpf());
         var4.executeUpdate();
         System.out.println("Profissional atualizado com sucesso!");
      } catch (SQLException var9) {
          System.out.println(var9);
      } finally {
         DatabaseConnection.closeStatement(var4);
         DatabaseConnection.closeConnection(var3);
      }

   }

   @Override
   public void deletar(String var1) {
      String var2 = this.getDeleteQuery();
      Connection var3 = null;
      PreparedStatement var4 = null;

      try {
         var3 = DatabaseConnection.getConnection();
         var4 = var3.prepareStatement(var2);
         var4.setString(1, var1);
         var4.executeUpdate();
         System.out.println("Profissional deletado com sucesso!");
      } catch (SQLException var9) {
          System.out.println(var9);
      } finally {
         DatabaseConnection.closeStatement(var4);
         DatabaseConnection.closeConnection(var3);
      }

   }

   @Override
   public Profissional buscar() {
      String var2 = this.getSelectQuery();
      Connection var3 = null;
      PreparedStatement var4 = null;
      ResultSet var5 = null;
      Profissional var6 = null;

      try {
         var3 = DatabaseConnection.getConnection();
         var4 = var3.prepareStatement(var2);
         var5 = var4.executeQuery();
         if (var5.next()) {
            var6 = this.getEntityFromResultSet(var5);
            PrintStream var10000 = System.out;
            String var10001 = var6.getNome();
            var10000.println("Profissional encontrado: " + var10001 + ", " + var6.getNome() + ", " + var6.getEspecialidade() + ", " + var6.getTelefone());
         }
      } catch (SQLException var11) {
          System.out.println(var11);
      } finally {
         DatabaseConnection.closeResultSet(var5);
         DatabaseConnection.closeStatement(var4);
         DatabaseConnection.closeConnection(var3);
      }

      return var6;
   }
}