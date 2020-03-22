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
import Classes_back.Consulta;
import Classes_back.Exame;
import Classes_back.Primaria;

/**
 *
 * @author Admin
 */
public class ConsultaDAO {
    
public void create(Consulta c){
        
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
    
        try {
            stmt = con.prepareStatement("INSERT INTO tb_primaria (cliente, cpf, animal, tipo, sintomas, data) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, c.getNome_cliente());
            stmt.setString(2, c.getCpf_cliente());
            stmt.setString(3, c.getNome_animal());
            stmt.setString(4, c.getTipo());
            stmt.setString(5, c.getSintomas());
            stmt.setString(6, c.getData());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     public List<Consulta> readPesquisaCliente(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Consulta> lc = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_primaria WHERE cliente LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setNome_cliente(rs.getString("cliente"));
                c.setCpf_cliente(rs.getString("cpf"));
                c.setData(rs.getString("data"));
                c.setNome_animal(rs.getString("animal"));
                c.setSintomas(rs.getString("sintomas"));
                c.setTipo(rs.getString("tipo"));
                
                lc.add(c);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lc;
    }
         public List<Consulta> readPesquisaCPF(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Consulta> lc = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_primaria WHERE cpf LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setNome_cliente(rs.getString("cliente"));
                c.setCpf_cliente(rs.getString("cpf"));
                c.setData(rs.getString("data"));
                c.setNome_animal(rs.getString("animal"));
                c.setSintomas(rs.getString("sintomas"));
                c.setTipo(rs.getString("tipo"));
                
                lc.add(c);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lc;
    }
    public List<Consulta> readPesquisaAnimal(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Consulta> lc = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_primaria WHERE animal LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setNome_cliente(rs.getString("cliente"));
                c.setCpf_cliente(rs.getString("cpf"));
                c.setData(rs.getString("data"));
                c.setNome_animal(rs.getString("animal"));
                c.setSintomas(rs.getString("sintomas"));
                c.setTipo(rs.getString("tipo"));
                
                lc.add(c);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lc;
    }
      public boolean verificaCliente(String cpf_busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        boolean result=false;
       
        
        try {
            stmt = con.prepareStatement("SELECT cpf FROM tb_cliente where cpf=?");
            stmt.setString(1, cpf_busca);
            rs=stmt.executeQuery();
            if(rs.next())
              result=true;
            else
              result=false;
                
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return result;
    }
      
  public void delete(Consulta c){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("DELETE FROM tb_primaria WHERE id=?");
            stmt.setInt(1, c.getId());
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
