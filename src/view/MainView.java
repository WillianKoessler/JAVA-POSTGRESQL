package view;

import javax.swing.JOptionPane;

public class MainView extends javax.swing.JPanel {

    private javax.swing.JTabbedPane parent;
    private final String cacl,capc,cocl,copc;

    public MainView() {
        cacl = "Cadastro de Cliente";
        capc = "Cadastro de Computador";
        cocl = "Consulta de Cliente";
        copc = "Consulta de Computador";
        initComponents();
    }

    private void newTab(String name) {
        parent = (javax.swing.JTabbedPane)this.getParent();
        if(parent == null){
            JOptionPane.showMessageDialog(null, "NO PARENT");
            return;
        }
        for (int i = 0; i < parent.getTabCount(); i++) {
            if (name.equals(parent.getTitleAt(i))) {
                parent.setSelectedIndex(i);
                return;
            }
        }
        if (name.equals(cacl)) {
            parent.addTab(cacl, new CadastroCliente());
            parent.setSelectedIndex(parent.getTabCount() - 1);
        } else if (name.equals(capc)) {
            parent.addTab(capc, new CadastroPC());
            parent.setSelectedIndex(parent.getTabCount() - 1);
        } else if (name.equals(cocl)) {
            parent.addTab(cocl, new ConsultaCliente());
            parent.setSelectedIndex(parent.getTabCount() - 1);
        } else if (name.equals(copc)) {
            parent.addTab(copc, new ConsultaPC());
            parent.setSelectedIndex(parent.getTabCount() - 1);
        } else {
            JOptionPane.showMessageDialog(null, "Not Supported Tab Name");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCadastroCliente = new javax.swing.JButton();
        btnCadastroPC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jButton3.setText("jButton3");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastros");

        btnCadastroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/22180638757774.png"))); // NOI18N
        btnCadastroCliente.setText("Clientes");
        btnCadastroCliente.setToolTipText("Cadastro de novos Clientes no Banco de Dados");
        btnCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroClienteActionPerformed(evt);
            }
        });

        btnCadastroPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/977403.png"))); // NOI18N
        btnCadastroPC.setText("Computador");
        btnCadastroPC.setToolTipText("Cadastro de novos Computadores no Banco de Dados");
        btnCadastroPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroPCActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Consulta");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/istockphoto-517153300-1024x1024.png"))); // NOI18N
        jButton1.setText("Clientes");
        jButton1.setToolTipText("Consulta de Clientes pré-existentes/recém-contratados no Banco de Dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/planilha-tela-de-computador-linha-ícone-do-relatório-explicar-financeiro-vetor-projeto-da-ilustra-o-s-mbolo-e-sinal-isolado-no-146689086.png"))); // NOI18N
        jButton2.setText("Computador");
        jButton2.setToolTipText("Consulta de Computadores pré-existentes/recém-contratados no Banco de Dados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(82, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(btnCadastroCliente))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCadastroPC)
                                    .addComponent(jButton2))))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastroCliente)
                    .addComponent(btnCadastroPC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClienteActionPerformed
        newTab(cacl);
    }//GEN-LAST:event_btnCadastroClienteActionPerformed

    private void btnCadastroPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroPCActionPerformed
        newTab(capc);
    }//GEN-LAST:event_btnCadastroPCActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newTab(cocl);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        newTab(copc);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroCliente;
    private javax.swing.JButton btnCadastroPC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
