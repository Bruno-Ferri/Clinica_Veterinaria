/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import model.dao.ClienteDAO;
import model.dao.ConsultaDAO;

import Classes_back.Cliente;
import Classes_back.Consulta;
import Classes_back.Primaria;

/**
 *
 * @author Admin
 */
public class Pesquisa_Primaria extends javax.swing.JFrame {
    
    public int parametro;
    
    public Pesquisa_Primaria() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Pesquisa de consultas");
        
    }
    
    public void readTabelaPesquisaNome(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_primaria.getModel();
        tb.setNumRows(0);
        ConsultaDAO cdao = new ConsultaDAO();
        
        for(Consulta c: cdao.readPesquisaCliente(busca)){
            tb.addRow(new Object[]{c.getId(),c.getNome_cliente(),c.getCpf_cliente(),c.getNome_animal(),
                c.getTipo(),c.getSintomas(),c.getData()});
        }
    }
        public void readTabelaPesquisaCPF(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_primaria.getModel();
        tb.setNumRows(0);
        ConsultaDAO cdao = new ConsultaDAO();
        
        for(Consulta c: cdao.readPesquisaCPF(busca)){
            tb.addRow(new Object[]{c.getId(),c.getNome_cliente(),c.getCpf_cliente(),c.getNome_animal(),
                c.getTipo(),c.getSintomas(),c.getData()});
        }
    }
     public void readTabelaPesquisaAnimal(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_primaria.getModel();
        tb.setNumRows(0);
        ConsultaDAO cdao = new ConsultaDAO();
        
        for(Consulta c: cdao.readPesquisaAnimal(busca)){
            tb.addRow(new Object[]{c.getId(),c.getNome_cliente(),c.getCpf_cliente(),c.getNome_animal(),
                c.getTipo(),c.getSintomas(),c.getData()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton3 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_tb_primaria = new javax.swing.JTable();
        btn_pesquisar = new javax.swing.JButton();
        txt_pesquisa = new javax.swing.JTextField();
        rbt_cpf = new javax.swing.JRadioButton();
        rbt_nome_animal = new javax.swing.JRadioButton();
        rbt_nome_cliente = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btn_excluir = new javax.swing.JButton();

        jRadioButton3.setText("jRadioButton3");

        j_tb_primaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "CPF", "Animal", "Tipo de consulta", "Sintomas", "Data da consulta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        j_tb_primaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_tb_primariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_tb_primaria);

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbt_cpf);
        rbt_cpf.setText("CPF ");

        buttonGroup1.add(rbt_nome_animal);
        rbt_nome_animal.setText("Nome do animal");

        buttonGroup1.add(rbt_nome_cliente);
        rbt_nome_cliente.setText("Nome do cliente");

        jLabel1.setText("Pesquisar por:");

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbt_nome_cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbt_nome_animal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbt_cpf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_excluir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbt_cpf)
                    .addComponent(rbt_nome_animal)
                    .addComponent(rbt_nome_cliente)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pesquisar)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(btn_excluir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        if(rbt_nome_animal.isSelected() || rbt_nome_cliente.isSelected() || rbt_cpf.isSelected()){
            if(rbt_nome_cliente.isSelected())
                readTabelaPesquisaNome(txt_pesquisa.getText());
            if(rbt_nome_animal.isSelected())
                readTabelaPesquisaAnimal(txt_pesquisa.getText());
            if(rbt_cpf.isSelected())
                readTabelaPesquisaCPF(txt_pesquisa.getText());
        }
        else
            readTabelaPesquisaNome(txt_pesquisa.getText());
        
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void j_tb_primariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_tb_primariaMouseClicked

            parametro = Integer.parseInt(j_tb_primaria.getValueAt(j_tb_primaria.getSelectedRow(), 0).toString());
        
    }//GEN-LAST:event_j_tb_primariaMouseClicked

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        Consulta c = new Consulta();
        ConsultaDAO cdao = new ConsultaDAO();
        c.setId(parametro);
        cdao.delete(c);
    }//GEN-LAST:event_btn_excluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Primaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Primaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Primaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Primaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa_Primaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_tb_primaria;
    private javax.swing.JRadioButton rbt_cpf;
    private javax.swing.JRadioButton rbt_nome_animal;
    private javax.swing.JRadioButton rbt_nome_cliente;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
}
