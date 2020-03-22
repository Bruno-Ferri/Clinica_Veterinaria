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
import Classes_back.Cliente;

/**
 *
 * @author Admin
 */
public class ClienteDAO {
    
    public void create(Cliente c){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("INSERT INTO tb_cliente (nome, cpf, endereco, numero, complemento, bairro, cidade, estado, tel, cel, email) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getNumero());
            stmt.setString(5, c.getComplemento());
            stmt.setString(6, c.getBairro());
            stmt.setString(7, c.getCidade());
            stmt.setString(8, c.getEstado());
            stmt.setString(9, c.getTelefone());
            stmt.setString(10, c.getCelular());
            stmt.setString(11, c.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente registrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        public void update(Cliente c){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("UPDATE tb_cliente SET nome=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, tel=?, cel=?, email=? WHERE cpf=?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEndereco());
            stmt.setString(3, c.getNumero());
            stmt.setString(4, c.getComplemento());
            stmt.setString(5, c.getBairro());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getEstado());
            stmt.setString(8, c.getTelefone());
            stmt.setString(9, c.getCelular());
            stmt.setString(10, c.getEmail());
            stmt.setString(11, c.getCpf());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Cliente> lc = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_cliente");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setBairro(rs.getString("bairro"));
                c.setCelular(rs.getString("cel"));
                c.setCidade(rs.getString("cidade"));
                c.setComplemento(rs.getString("complemento"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setEstado(rs.getString("estado"));
                c.setNome(rs.getString("nome"));
                c.setNumero(rs.getString("numero"));
                c.setTelefone(rs.getString("telefone"));
                lc.add(c);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lc;
    }
    
    public List<Cliente> readPesquisaNome(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Cliente> lc = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_cliente WHERE nome LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setBairro(rs.getString("bairro"));
                c.setCelular(rs.getString("cel"));
                c.setCidade(rs.getString("cidade"));
                c.setComplemento(rs.getString("complemento"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setEstado(rs.getString("estado"));
                c.setNome(rs.getString("nome"));
                c.setNumero(rs.getString("numero"));
                c.setTelefone(rs.getString("tel"));
                lc.add(c);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lc;
    }
    
    public List<Cliente> readPesquisaCPF(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Cliente> lc = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_cliente WHERE cpf LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setBairro(rs.getString("bairro"));
                c.setCelular(rs.getString("cel"));
                c.setCidade(rs.getString("cidade"));
                c.setComplemento(rs.getString("complemento"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setEstado(rs.getString("estado"));
                c.setNome(rs.getString("nome"));
                c.setNumero(rs.getString("numero"));
                c.setTelefone(rs.getString("tel"));
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
    public void delete(Cliente c){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("DELETE FROM tb_cliente WHERE cpf=? ");
            stmt.setString(1, c.getCpf());
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