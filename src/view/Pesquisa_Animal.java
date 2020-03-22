/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import model.dao.AnimalDAO;
import model.dao.ExameDAO;
import Classes_back.Animal;
import Classes_back.Exame;

/**
 *
 * @author Admin
 */
public class Pesquisa_Animal extends javax.swing.JFrame {
     private String especie;
     private String sexo;
    /**
     * Creates new form Pesquisa_Animal
     */
    public Pesquisa_Animal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Pesquisa de animais");
    }

     public void readTabelaPesquisaCliente(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_animal.getModel();
        tb.setNumRows(0);
         AnimalDAO adao = new AnimalDAO();
        
        for(Animal a: adao.readPesquisaCliente(busca)){
            tb.addRow(new Object[]{a.getNome_animal(),a.getEspecie(),a.getSexo(),a.getNome_cliente(),
            a.getCpf()});
        }
    }
     public void readTabelaPesquisaCPF(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_animal.getModel();
        tb.setNumRows(0);
         AnimalDAO adao = new AnimalDAO();
        
        for(Animal a: adao.readPesquisaCPF(busca)){
            tb.addRow(new Object[]{a.getNome_animal(),a.getEspecie(),a.getSexo(),a.getNome_cliente(),
            a.getCpf()});
        }
    }
     public void readTabelaPesquisaAnimal(String busca){
        DefaultTableModel tb = (DefaultTableModel) j_tb_animal.getModel();
        tb.setNumRows(0);
         AnimalDAO adao = new AnimalDAO();
        
        for(Animal a: adao.readPesquisaAnimal(busca)){
            tb.addRow(new Object[]{a.getNome_animal(),a.getEspecie(),a.getSexo(),a.getNome_cliente(),
            a.getCpf()});
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbt_cliente = new javax.swing.JRadioButton();
        rbt_animal = new javax.swing.JRadioButton();
        rbt_cpf = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_tb_animal = new javax.swing.JTable();
        txt_pesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_pesquisar = new javax.swing.JButton();

        buttonGroup1.add(rbt_cliente);
        rbt_cliente.setText("Nome do cliente");

        buttonGroup1.add(rbt_animal);
        rbt_animal.setText("Nome do animal");

        buttonGroup1.add(rbt_cpf);
        rbt_cpf.setText("CPF do cliente");

        j_tb_animal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Animal", "Espécie", "Sexo", "Cliente", "CPF do cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        j_tb_animal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_tb_animalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_tb_animal);

        jLabel1.setText("Pesquisar por:");

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbt_cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbt_animal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbt_cpf)
                        .addGap(18, 18, 18)
                        .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_pesquisar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(rbt_cliente)
                    .addComponent(rbt_animal)
                    .addComponent(rbt_cpf))
                .addGap(18, 18, 18)
                .addComponent(btn_pesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        if(rbt_animal.isSelected() || rbt_cliente.isSelected() || rbt_cpf.isSelected()){
             if(rbt_animal.isSelected())
                 readTabelaPesquisaAnimal(txt_pesquisa.getText());
             if(rbt_cliente.isSelected())
                 readTabelaPesquisaCliente(txt_pesquisa.getText());
             if(rbt_cpf.isSelected())
                 readTabelaPesquisaCPF(txt_pesquisa.getText());
        }
        else
            readTabelaPesquisaCliente(txt_pesquisa.getText());
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void j_tb_animalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_tb_animalMouseClicked
        Cadastro_animal ca = new Cadastro_animal();
        ca.setVisible(true);
        especie=j_tb_animal.getValueAt(j_tb_animal.getSelectedRow(), 1).toString();
        sexo=j_tb_animal.getValueAt(j_tb_animal.getSelectedRow(), 2).toString();
        if("Cão".equals(especie) || "Gato".equals(especie)){
        if("Cão".equals(especie))
            ca.rbt_cao.setSelected(true);
        if("Gato".equals(especie))
            ca.rbt_gato.setSelected(true);
        }
        else{
            ca.rbt_outros.setSelected(true);
            ca.txt_outros.setText(especie);
        }
        if("M".equals(sexo))
            ca.rbt_macho.setSelected(true);
        if("F".equals(sexo))
            ca.rbt_femea.setSelected(true);
        ca.txt_cpf.setText(j_tb_animal.getValueAt(j_tb_animal.getSelectedRow(), 4).toString());
        ca.txt_nome_animal.setText(j_tb_animal.getValueAt(j_tb_animal.getSelectedRow(), 0).toString());
        ca.txt_nome_cliente.setText(j_tb_animal.getValueAt(j_tb_animal.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_j_tb_animalMouseClicked

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
            java.util.logging.Logger.getLogger(Pesquisa_Animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_Animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa_Animal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_tb_animal;
    private javax.swing.JRadioButton rbt_animal;
    private javax.swing.JRadioButton rbt_cliente;
    private javax.swing.JRadioButton rbt_cpf;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
}
