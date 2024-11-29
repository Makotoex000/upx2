/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.upx2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfissionalDAO extends GenericDAO<Profissional> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Profissional (nome, cpf, rg, especialidade, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Profissional SET nome = ?, cpf = ?, rg = ?, especialidade = ?, telefone = ?, email = ? WHERE id_profissional = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Profissional WHERE id_profissional = ?";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT id_profissional, nome, cpf, rg, especialidade, telefone, email FROM Profissional WHERE id_profissional = ?";
    }

    @Override
    protected void setParameters(PreparedStatement stmt, Profissional profissional) throws SQLException {
        stmt.setString(1, profissional.getNome());
        stmt.setString(2, profissional.getCpf());
        stmt.setString(3, profissional.getRg());
        stmt.setString(4, profissional.getEspecialidade());
        stmt.setString(5, profissional.getTelefone());
        stmt.setString(6, profissional.getEmail());
    }

    @Override
    protected Profissional getEntityFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_profissional");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String rg = rs.getString("rg");
        String especialidade = rs.getString("especialidade");
        String telefone = rs.getString("telefone");
        String email = rs.getString("email");

        return new Profissional(id, nome, cpf, rg, especialidade, telefone, email);
    }

    public Profissional buscarPorId(int idProfissional) {
        String sql = getSelectQuery();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Profissional profissional = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfissional);
            rs = stmt.executeQuery();

            if (rs.next()) {
                profissional = getEntityFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeResultSet(rs);
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }

        return profissional;
    }
    public void inserirProfissional(Profissional profissional) {
        String sql = "INSERT INTO Profissional (nome, cpf, rg, especialidade, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
    
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
    
            stmt.setString(1, profissional.getNome());
            stmt.setString(2, profissional.getCpf());
            stmt.setString(3, profissional.getRg());
            stmt.setString(4, profissional.getEspecialidade());
            stmt.setString(5, profissional.getTelefone());
            stmt.setString(6, profissional.getEmail());
    
            stmt.executeUpdate();
            System.out.println("Profissional inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeStatement(stmt);
            DatabaseConnection.closeConnection(conn);
        }
    }
    
}
