/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.PCDAO;
import com.sun.glass.events.KeyEvent;
import javax.swing.text.PlainDocument;
import model.PC;

/**
 *
 * @author PC 17
 */
public class CadastroPC extends javax.swing.JPanel {
    private final PlainDocument[] ipFilter;
    /**
     * Creates new form CadastroPC
     */
    public CadastroPC() {
        initComponents();
        ipFilter = new PlainDocument[4];
        ipFilter[0] = (PlainDocument)ip1.getDocument();
        ipFilter[1] = (PlainDocument)ip2.getDocument();
        ipFilter[2] = (PlainDocument)ip3.getDocument();
        ipFilter[3] = (PlainDocument)ip4.getDocument();
        
        ipFilter[0].setDocumentFilter(new DocFilter(3));
        ipFilter[1].setDocumentFilter(new DocFilter(3));
        ipFilter[2].setDocumentFilter(new DocFilter(3));
        ipFilter[3].setDocumentFilter(new DocFilter(3));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        ip1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ip2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ip3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ip4 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Computador");

        jLabel2.setText("Nome:");

        jLabel3.setText("IP:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        ip1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip1KeyPressed(evt);
            }
        });

        jLabel4.setText(".");

        ip2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip2KeyPressed(evt);
            }
        });

        jLabel5.setText(".");

        ip3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip3KeyPressed(evt);
            }
        });

        jLabel6.setText(".");

        ip4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip4KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(ip1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ip2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ip3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ip4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ip3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(ip4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ip2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(ip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnCadastrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.getParent().remove(this);
    }//GEN-LAST:event_btnCancelActionPerformed

    private boolean isNull(javax.swing.JTextField txt){
        return txt == null || txt.getText().equals("");
    }
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(isNull(ip1)){
            ip1.setText("000");
        }
        if(isNull(ip2)){
            ip2.setText("000");
        }
        if(isNull(ip3)){
            ip3.setText("000");
        }
        if(isNull(ip4)){
            ip4.setText("000");
        }
        
        String IP = ip1.getText() + "." + ip2.getText() + "." + ip3.getText() + "." + ip4.getText();
        PC pc = new PC();
        if (txtName != null && !txtName.getText().equals("")) {
            pc.setName(txtName.getText());
        }
        if (IP != null && !IP.equals("")) {
            pc.setAddress(IP);
        }
        new PCDAO().insert(pc);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_txtNameKeyPressed

    private void ip1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ip1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_ip1KeyPressed

    private void ip2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ip2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_ip2KeyPressed

    private void ip3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ip3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_ip3KeyPressed

    private void ip4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ip4KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_ip4KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField ip1;
    private javax.swing.JTextField ip2;
    private javax.swing.JTextField ip3;
    private javax.swing.JTextField ip4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
