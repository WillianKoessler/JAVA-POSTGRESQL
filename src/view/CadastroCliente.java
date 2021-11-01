package view;

import Utilities.Utils;
import model.Entity;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.PlainDocument;

public class CadastroCliente extends javax.swing.JPanel {

    private static final DAO.Controller controller = new DAO.Controller("cliente");
    private final PlainDocument regDoc;

    public CadastroCliente() {
        initComponents();
        regDoc = (PlainDocument) txtMat.getDocument();
        regDoc.setDocumentFilter(new DocFilter());
        announcement.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            Utils.getAncestor(this).setSize(416, 339);
            if (!controller.insert()){
                List<String> v, t;
                v = new ArrayList<>();
                t = new ArrayList<>();
                v.add("name");
                v.add("course");
                v.add("birth");
                v.add("address");
                t.add("character varying(256)");
                t.add("character varying(128)");
                t.add("date");
                t.add("character varying(512)");
                if(!controller.createTable("cliente", v, t)){
                    Principal main = Utils.getAncestor(this, Principal.class);
                    main.setButtonEnabled(CadastroCliente.class.getSimpleName(), false);
                    main.setButtonEnabled(ConsultaCliente.class.getSimpleName(), false);
                    main.remove(this);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtMat = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBirth = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCourse = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        announcement = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");

        jLabel2.setText("Nome:");

        txtMat.setFocusable(false);

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
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

        jLabel4.setText("Matrícula:");

        jLabel5.setText("Data de Nascimento:");

        txtBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtBirth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        jLabel3.setText("Endereço:");

        jLabel6.setText("Curso:");

        txtCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        announcement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        announcement.setText("ANNOUNCEMENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCourse))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(announcement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar)
                        .addComponent(btnCancel))
                    .addComponent(announcement, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.getParent().remove(this);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Entity c = new Entity();
        try {
            if (!Utils.isNull(txtName)) {
                c.set("name", txtName.getText());
            } else {
                Utils.Announce("O Nome É Necessário.", announcement, 416, 339);
                return;
            }
            if (!Utils.isNull(txtBirth)) {
                try {
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date data = new java.sql.Date(df.parse(txtBirth.getText()).getTime());
                    c.set("birth", data);
                } catch (ParseException e) {
                    Utils.Announce("O Formato de Data de Nascimento não pode ser utilizado.", announcement, 416, 339);
                    return;
                }
            } else {
                Utils.Announce("A Data de Nascimento\nÉ necessária.", announcement, 416, 339);
                return;
            }
            if (!Utils.isNull(txtCourse)) {
                c.set("course", txtCourse.getText());
            } else {
                Utils.Announce("O Curso É Necessário.", announcement, 416, 339);
                return;
            }
            if (!Utils.isNull(txtAddress)) {
                c.set("address", txtAddress.getText());
            } else {
                Utils.Announce("O Endereço É Necessário.", announcement, 416, 339);
                return;
            }
            txtMat.setText(Integer.toString(controller.insert(c)));
            txtName.setText("");
            txtBirth.setText("");
            txtCourse.setText("");
            txtAddress.setText("");
        } catch (NumberFormatException e) {
            Utils.pop("Formato inválido para Matrícula.\nErro: " + e.getMessage(), Utils.pop.ERRO);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void Enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Enter
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                btnCadastrarActionPerformed(null);
                break;
            case KeyEvent.VK_ESCAPE:
                btnCancelActionPerformed(null);
                break;
        }
    }//GEN-LAST:event_Enter


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel announcement;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JFormattedTextField txtBirth;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
