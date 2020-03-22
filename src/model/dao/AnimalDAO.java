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
import Classes_back.Cliente;

/**
 *
 * @author Admin
 */
public class AnimalDAO {
    public void create(Animal a){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("INSERT INTO tb_animal (animal, especie, sexo, cpf, cliente) VALUES (?,?,?,?,?)");
            stmt.setString(1, a.getNome_animal());
            stmt.setString(2, a.getEspecie());
            stmt.setString(3, a.getSexo());
            stmt.setString(4, a.getCpf());
            stmt.setString(5, a.getNome_cliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Animal registrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void update(Animal a){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("UPDATE tb_animal SET especie=?, sexo=?,  cliente=? WHERE cpf=? and animal=?");
            stmt.setString(1, a.getEspecie());
            stmt.setString(2, a.getSexo());
            stmt.setString(3, a.getNome_cliente());
            stmt.setString(4, a.getCpf());
            stmt.setString(5, a.getNome_animal());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Animal atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
       public List<Animal> readPesquisaAnimal(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Animal> la = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_animal WHERE animal LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Animal a = new Animal();
                a.setCpf(rs.getString("cpf"));
                a.setEspecie(rs.getString("especie"));
                a.setSexo(rs.getString("sexo"));
                a.setNome_animal(rs.getString("animal"));
                a.setNome_cliente(rs.getString("cliente"));
                la.add(a);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return la;
    }
     public List<Animal> readPesquisaCPF(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Animal> la = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_animal WHERE cpf LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Animal a = new Animal();
                a.setCpf(rs.getString("cpf"));
                a.setEspecie(rs.getString("especie"));
                a.setSexo(rs.getString("sexo"));
                a.setNome_animal(rs.getString("animal"));
                a.setNome_cliente(rs.getString("cliente"));
                la.add(a);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return la;
    }
     
      public List<Animal> readPesquisaCliente(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Animal> la = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_animal WHERE cliente LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Animal a = new Animal();
                a.setCpf(rs.getString("cpf"));
                a.setEspecie(rs.getString("especie"));
                a.setSexo(rs.getString("sexo"));
                a.setNome_animal(rs.getString("animal"));
                a.setNome_cliente(rs.getString("cliente"));
                la.add(a);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return la;
    }
      public boolean verificaAnimal(String cpf_busca, String animal_busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        boolean result=false;
       
        
        try {
            stmt = con.prepareStatement("SELECT cpf, animal FROM tb_animal where cpf=? and animal=?");
            stmt.setString(1, cpf_busca);
            stmt.setString(2, animal_busca);
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
    public void delete(Animal a){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("DELETE FROM tb_animal WHERE cpf=? and animal=?");
            stmt.setString(1, a.getCpf());
            stmt.setString(2, a.getNome_animal());
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
