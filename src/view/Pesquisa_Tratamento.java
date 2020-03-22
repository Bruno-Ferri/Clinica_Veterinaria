/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import model.dao.ExameDAO;
import model.dao.TratamentoDAO;
import Classes_back.Exame;
import Classes_back.Tratamento;

/**
 *
 * @author Admin
 */
public class Pesquisa_Tratamento extends javax.swing.JFrame {

    private int parametro;
    
    public Pesquisa_Tratamento() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Pesquisa de tratamentos");
    }
  public void readTabelaPesquisaAnimal(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_tratamento.getModel();
        tb.setNumRows(0);
        TratamentoDAO td = new TratamentoDAO();
        
        for(Tratamento t: td.readPesquisaAnimal(busca)){
            tb.addRow(new Object[]{t.getId(),t.getNome_animal(),t.getNome_cliente(),t.getDiagnóstico(),
                t.getTratamento(),t.getObs(),t.getCpf()});
        }
    }
  public void readTabelaPesquisaCliente(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_tratamento.getModel();
        tb.setNumRows(0);
        TratamentoDAO td = new TratamentoDAO();
        
        for(Tratamento t: td.readPesquisaCliente(busca)){
            tb.addRow(new Object[]{t.getId(),t.getNome_animal(),t.getNome_cliente(),t.getDiagnóstico(),
                t.getTratamento(),t.getObs(),t.getCpf()});
        }
    }
    public void readTabelaPesquisaCPF(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_tratamento.getModel();
        tb.setNumRows(0);
        TratamentoDAO td = new TratamentoDAO();
        
        for(Tratamento t: td.readPesquisaCPF(busca)){
            tb.addRow(new Object[]{t.getId(),t.getNome_animal(),t.getNome_cliente(),t.getDiagnóstico(),
                t.getTratamento(),t.getObs(),t.getCpf()});
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rbt_cliente = new javax.swing.JRadioButton();
        rbt_animal = new javax.swing.JRadioButton();
        rbt_cpf = new javax.swing.JRadioButton();
        txt_pesquisa = new javax.swing.JTextField();
        btn_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_tb_tratamento = new javax.swing.JTable();
        btn_excluir = new javax.swing.JButton();

        jLabel1.setText("Pesquisar por:");

        rbt_cliente.setText("Nome do cliente");

        rbt_animal.setText("Animal");

        rbt_cpf.setText("CPF");

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        j_tb_tratamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Animal", "Cliente", "Diagnóstico", "Tratamento", "Observações", "CPF do cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        j_tb_tratamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_tb_tratamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_tb_tratamento);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_excluir)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(rbt_cliente)
                            .addGap(18, 18, 18)
                            .addComponent(rbt_animal)
                            .addGap(18, 18, 18)
                            .addComponent(rbt_cpf)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_pesquisa))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pesquisar)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_excluir)
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(rbt_cliente)
                        .addComponent(rbt_animal)
                        .addComponent(rbt_cpf)
                        .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(btn_pesquisar)
                    .addContainerGap(238, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        if(rbt_animal.isSelected() || rbt_cliente.isSelected() || rbt_cpf.isSelected()){
            if(rbt_cliente.isSelected())
                readTabelaPesquisaCliente(txt_pesquisa.getText());
            if(rbt_animal.isSelected())
               readTabelaPesquisaAnimal(txt_pesquisa.getText());
            if(rbt_cpf.isSelected())
               readTabelaPesquisaCPF(txt_pesquisa.getText());
        }
        else
        readTabelaPesquisaCliente(txt_pesquisa.getText());
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void j_tb_tratamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_tb_tratamentoMouseClicked
      parametro=Integer.parseInt(j_tb_tratamento.getValueAt(j_tb_tratamento.getSelectedRow(), 0).toString());
      
    }//GEN-LAST:event_j_tb_tratamentoMouseClicked

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        TratamentoDAO td = new TratamentoDAO();
        Tratamento t = new Tratamento();
        t.setId(parametro);
        td.delete(t);
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
            java.util.logging.Logger.getLogger(Pesquisa_Tratamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Tratamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Tratamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Tratamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa_Tratamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_tb_tratamento;
    private javax.swing.JRadioButton rbt_animal;
    private javax.swing.JRadioButton rbt_cliente;
    private javax.swing.JRadioButton rbt_cpf;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
}
