/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Classes_back.Animal;
import Classes_back.Tratamento;

/**
 *
 * @author Admin
 */
public class TratamentoDAO {
    public void create(Tratamento t){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("INSERT INTO tb_tratamento (animal, cliente, diagnostico, tratamento, obs, cpf ) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, t.getNome_animal());
            stmt.setString(2, t.getNome_cliente());
            stmt.setString(3, t.getDiagnóstico());
            stmt.setString(4, t.getTratamento());
            stmt.setString(5, t.getObs());
            stmt.setString(6, t.getCpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tratamento registrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
       public List<Tratamento> readPesquisaAnimal(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Tratamento> lt = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_tratamento WHERE animal LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Tratamento t = new Tratamento();
                t.setId(rs.getInt("id"));
                t.setCpf(rs.getString("cpf"));
                t.setDiagnóstico(rs.getString("diagnostico"));
                t.setObs(rs.getString("obs"));
                t.setNome_animal(rs.getString("animal"));
                t.setNome_cliente(rs.getString("cliente"));
                t.setTratamento(rs.getString("tratamento"));
                lt.add(t);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lt;
    }
              public List<Tratamento> readPesquisaCliente(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Tratamento> lt = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_tratamento WHERE cliente LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Tratamento t = new Tratamento();
                t.setId(rs.getInt("id"));
                t.setCpf(rs.getString("cpf"));
                t.setDiagnóstico(rs.getString("diagnostico"));
                t.setObs(rs.getString("obs"));
                t.setNome_animal(rs.getString("animal"));
                t.setNome_cliente(rs.getString("cliente"));
                t.setTratamento(rs.getString("tratamento"));
                lt.add(t);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lt;
    }
      public List<Tratamento> readPesquisaCPF(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Tratamento> lt = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_tratamento WHERE cpf LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Tratamento t = new Tratamento();
                t.setId(rs.getInt("id"));
                t.setCpf(rs.getString("cpf"));
                t.setDiagnóstico(rs.getString("diagnostico"));
                t.setObs(rs.getString("obs"));
                t.setNome_animal(rs.getString("animal"));
                t.setNome_cliente(rs.getString("cliente"));
                t.setTratamento(rs.getString("tratamento"));
                lt.add(t);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lt;
    }
   public void delete(Tratamento t){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("DELETE FROM tb_tratamento WHERE id=?");
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
