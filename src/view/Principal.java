package view;

import Utilities.Utils;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JPanel {
    private final String cacl,capc,cocl,copc;

    public Principal() {
        cacl = CadastroCliente.class.getSimpleName();
        capc = CadastroPC.class.getSimpleName();
        cocl = ConsultaCliente.class.getSimpleName();
        copc = ConsultaPC.class.getSimpleName();
        initComponents();
    }
    
    public void setButtonEnabled(String btnName, boolean value){
        String fullName = "btn" + btnName;
        try{
            javax.swing.JButton instance = (javax.swing.JButton)getClass().getDeclaredField(fullName).get(this);
            instance.setEnabled(value);
        } catch (NoSuchFieldException | SecurityException| IllegalArgumentException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Erro interno.\nBotão '"+btnName+"' não encontrado.\nErro:"+ex.getMessage());
        }
    }

    private void newTab(String name) {
        javax.swing.JTabbedPane parent = Utils.getAncestor(this, javax.swing.JTabbedPane.class);
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
        try{
            javax.swing.JPanel pane = (javax.swing.JPanel)
                            Class.forName("view."+name)
                                    .getConstructor()
                                    .newInstance();
            Utils.getAncestor(this,base.root.class).addTab(name, pane);
            parent.setSelectedIndex(parent.getTabCount() - 1);
        }catch(ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e){
            Utils.pop("Erro ao inserir nova guia no sistema.\nErro: " + e.getMessage(), Utils.pop.ERRO);
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
        btnConsultaCliente = new javax.swing.JButton();
        btnConsultaPC = new javax.swing.JButton();
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

        btnConsultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/istockphoto-517153300-1024x1024.png"))); // NOI18N
        btnConsultaCliente.setText("Clientes");
        btnConsultaCliente.setToolTipText("Consulta de Clientes pré-existentes/recém-contratados no Banco de Dados");
        btnConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaClienteActionPerformed(evt);
            }
        });

        btnConsultaPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/planilha-tela-de-computador-linha-ícone-do-relatório-explicar-financeiro-vetor-projeto-da-ilustra-o-s-mbolo-e-sinal-isolado-no-146689086.png"))); // NOI18N
        btnConsultaPC.setText("Computador");
        btnConsultaPC.setToolTipText("Consulta de Computadores pré-existentes/recém-contratados no Banco de Dados");
        btnConsultaPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaPCActionPerformed(evt);
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
                                    .addComponent(btnConsultaCliente)
                                    .addComponent(btnCadastroCliente))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCadastroPC)
                                    .addComponent(btnConsultaPC))))
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
                    .addComponent(btnConsultaCliente)
                    .addComponent(btnConsultaPC))
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClienteActionPerformed
        newTab(cacl);
    }//GEN-LAST:event_btnCadastroClienteActionPerformed

    private void btnCadastroPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroPCActionPerformed
        newTab(capc);
    }//GEN-LAST:event_btnCadastroPCActionPerformed

    private void btnConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaClienteActionPerformed
        newTab(cocl);
    }//GEN-LAST:event_btnConsultaClienteActionPerformed

    private void btnConsultaPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaPCActionPerformed
        newTab(copc);
    }//GEN-LAST:event_btnConsultaPCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroCliente;
    private javax.swing.JButton btnCadastroPC;
    private javax.swing.JButton btnConsultaCliente;
    private javax.swing.JButton btnConsultaPC;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
