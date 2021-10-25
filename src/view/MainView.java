package view;

import javax.swing.JOptionPane;

public class MainView extends javax.swing.JPanel {

    private javax.swing.JTabbedPane parent;
    private final String cacl, capc, cocl, copc, conn;

    public MainView() {
        cacl = "Cadastro de Cliente";
        capc = "Cadastro de Computador";
        cocl = "Consulta de Cliente";
        copc = "Consulta de Computador";
        conn = "Configuração de Conexão";
        initComponents();
        this.setName("MainView");
    }

    private void newTab(String name) {
        parent = (javax.swing.JTabbedPane) this.getParent();
        if (parent == null) {
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
        } else if (name.equals(conn)) {
            parent.addTab(conn, new ConsultaPC());
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
        btnRegClient = new javax.swing.JButton();
        btnRegPC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnQueryClient = new javax.swing.JButton();
        btnQueryPC = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jButton3.setText("jButton3");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastros");

        btnRegClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/22180638757774.png"))); // NOI18N
        btnRegClient.setText("Clientes");
        btnRegClient.setToolTipText("Cadastro de novos Clientes no Banco de Dados");
        btnRegClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegClientActionPerformed(evt);
            }
        });

        btnRegPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/977403.png"))); // NOI18N
        btnRegPC.setText("Computador");
        btnRegPC.setToolTipText("Cadastro de novos Computadores no Banco de Dados");
        btnRegPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPCActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Consulta");

        btnQueryClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/istockphoto-517153300-1024x1024.png"))); // NOI18N
        btnQueryClient.setText("Clientes");
        btnQueryClient.setToolTipText("Consulta de Clientes pré-existentes/recém-contratados no Banco de Dados");
        btnQueryClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryClientActionPerformed(evt);
            }
        });

        btnQueryPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/planilha-tela-de-computador-linha-ícone-do-relatório-explicar-financeiro-vetor-projeto-da-ilustra-o-s-mbolo-e-sinal-isolado-no-146689086.png"))); // NOI18N
        btnQueryPC.setText("Computador");
        btnQueryPC.setToolTipText("Consulta de Computadores pré-existentes/recém-contratados no Banco de Dados");
        btnQueryPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryPCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnQueryClient)
                            .addComponent(btnRegClient))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegPC)
                            .addComponent(btnQueryPC)))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnRegClient)
                    .addComponent(btnRegPC))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQueryClient)
                    .addComponent(btnQueryPC))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegClientActionPerformed
        newTab(cacl);
    }//GEN-LAST:event_btnRegClientActionPerformed

    private void btnRegPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPCActionPerformed
        newTab(capc);
    }//GEN-LAST:event_btnRegPCActionPerformed

    private void btnQueryClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryClientActionPerformed
        newTab(cocl);
    }//GEN-LAST:event_btnQueryClientActionPerformed

    private void btnQueryPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryPCActionPerformed
        newTab(copc);
    }//GEN-LAST:event_btnQueryPCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQueryClient;
    private javax.swing.JButton btnQueryPC;
    private javax.swing.JButton btnRegClient;
    private javax.swing.JButton btnRegPC;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
