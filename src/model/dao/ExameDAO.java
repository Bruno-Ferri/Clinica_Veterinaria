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
import Classes_back.Exame;

/**
 *
 * @author Admin
 */
public class ExameDAO {
    public void create(Exame e){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("INSERT INTO tb_exame (cliente, cpf, animal, especie, suspeita, tratamento, tipo_trat, cat_exame, tipo_exame) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, e.getNome_cliente());
            stmt.setString(2, e.getCpf_cliente());
            stmt.setString(3, e.getNome_animal());
            stmt.setString(4, e.getEspecie());
            stmt.setString(5, e.getSuspeita());
            stmt.setBoolean(6, e.isTratamento());
            stmt.setString(7, e.getTipo_ratamento());
            stmt.setString(8, e.getCategoria_exame());
            stmt.setString(9, e.getTipo_exame());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exame registrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar."+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Exame> readPesquisaCliente(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Exame> le = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_exame WHERE cliente LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Exame e = new Exame();
                e.setId(rs.getInt("id"));
                e.setNome_cliente(rs.getString("cliente"));
                e.setCpf_cliente(rs.getString("cpf"));
                e.setCategoria_exame(rs.getString("cat_exame"));
                e.setEspecie(rs.getString("especie"));
                e.setNome_animal(rs.getString("animal"));
                e.setSuspeita(rs.getString("suspeita"));
                e.setTipo_exame(rs.getString("tipo_exame"));
                e.setTipo_ratamento(rs.getString("tipo_trat"));
                e.setTratamento(rs.getBoolean("tratamento"));

                le.add(e);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return le;
    }
    public List<Exame> readPesquisaCPF(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Exame> le = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_exame WHERE cpf LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Exame e = new Exame();
                e.setId(rs.getInt("id"));
                e.setNome_cliente(rs.getString("cliente"));
                e.setCpf_cliente(rs.getString("cpf"));
                e.setCategoria_exame(rs.getString("cat_exame"));
                e.setEspecie(rs.getString("especie"));
                e.setNome_animal(rs.getString("animal"));
                e.setSuspeita(rs.getString("suspeita"));
                e.setTipo_exame(rs.getString("tipo_exame"));
                e.setTipo_ratamento(rs.getString("tipo_trat"));
                e.setTratamento(rs.getBoolean("tratamento"));

                le.add(e);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return le;
    }
   public List<Exame> readPesquisaAnimal(String busca){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Exame> le = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_exame WHERE animal LIKE ?");
            stmt.setString(1, "%"+busca+"%");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Exame e = new Exame();
                e.setId(rs.getInt("id"));
                e.setNome_cliente(rs.getString("cliente"));
                e.setCpf_cliente(rs.getString("cpf"));
                e.setCategoria_exame(rs.getString("cat_exame"));
                e.setEspecie(rs.getString("especie"));
                e.setNome_animal(rs.getString("animal"));
                e.setSuspeita(rs.getString("suspeita"));
                e.setTipo_exame(rs.getString("tipo_exame"));
                e.setTipo_ratamento(rs.getString("tipo_trat"));
                e.setTratamento(rs.getBoolean("tratamento"));

                le.add(e);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return le;
    }
    public boolean verificaExame(String cpf_busca){
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
       public void delete(Exame e){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("DELETE FROM tb_exame WHERE id=?");
            stmt.setInt(1, e.getId());
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
