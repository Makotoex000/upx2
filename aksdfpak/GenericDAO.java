/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aksdfpak;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author david
 * @param <T>
 */
public abstract class GenericDAO<T> {
    public GenericDAO() {
    }
 
    protected abstract String getInsertQuery();
 
    protected abstract String getUpdateQuery();
 
    protected abstract String getDeleteQuery();
 
    protected abstract String getSelectQuery();
 
    protected abstract void setParameters(PreparedStatement var1, T var2) throws SQLException;
 
    protected abstract T getEntityFromResultSet(ResultSet var1) throws SQLException;
 
    public void salvar(T var1) {
       String var2 = this.getInsertQuery();
       this.executeUpdate(var2, var1);
    }
 
    public void atualizar(T var1) {
       String var2 = this.getUpdateQuery();
       this.executeUpdate(var2, var1);
    }
 
    public void deletar(String var1) {
       String var2 = this.getDeleteQuery();
       Connection var3 = null;
       PreparedStatement var4 = null;
 
       try {
          var3 = DatabaseConnection.getConnection();
          var4 = var3.prepareStatement(var2);
          var4.setString(1, var1);
          var4.executeUpdate();
       } catch (SQLException var9) {
           System.out.println(var9);
       } finally {
          DatabaseConnection.closeStatement(var4);
          DatabaseConnection.closeConnection(var3);
       }
 
    }
 
    public T buscar() {
       String var2 = this.getSelectQuery();
       Connection var3 = null;
       PreparedStatement var4 = null;
       ResultSet var5 = null;
       T var6 = null;
 
       try {
          var3 = DatabaseConnection.getConnection();
          var4 = var3.prepareStatement(var2);
          var5 = var4.executeQuery();
          if (var5.next()) {
             var6 = this.getEntityFromResultSet(var5);
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
 
    private void executeUpdate(String var1, T var2) {
       Connection var3 = null;
       PreparedStatement var4 = null;
 
       try {
          var3 = DatabaseConnection.getConnection();
          var4 = var3.prepareStatement(var1);
          this.setParameters(var4, var2);
          var4.executeUpdate();
       } catch (SQLException var9) {
       } finally {
          DatabaseConnection.closeStatement(var4);
          DatabaseConnection.closeConnection(var3);
       }
 
    }
}