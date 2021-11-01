package view;

import DAO.ConnectionFactory;
import Utilities.Utils;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SetupConnection extends javax.swing.JPanel {

    private static boolean close = true;
    private final String RecordFile = "database.record";
    private final List<String> rAdd, rDB, rUser, rPass;

    private SetupConnection() {
        this.setName("SetupConnection");
        rAdd = new ArrayList<>();
        rDB = new ArrayList<>();
        rUser = new ArrayList<>();
        rPass = new ArrayList<>();
        initComponents();
        Announcement.setVisible(false);
        checkRecords();
    }
            
    

    public static boolean ShowDialog() {
        try {
            JOptionPane.showOptionDialog(null, new SetupConnection(), "Nova Conexão", -1, -1, null, new Object[]{}, null);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return close;
    }

    private void checkRecords() {
        try (BufferedReader br = Files.newBufferedReader(
                FileSystems.getDefault().getPath(RecordFile),
                Charset.forName("US-ASCII"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("url=(.*) database=(.*) user=(.*)");
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    rAdd.add(matcher.group(1));
                    rDB.add(matcher.group(2));
                    rUser.add(matcher.group(3));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void generateRecord() {
        File f = new File(RecordFile);
        try {
            if (f.canWrite() || f.createNewFile()) {
                FileOutputStream outputStream = new FileOutputStream(f, true);
                outputStream.write(("url=" + txtAddress.getText()).getBytes());
                outputStream.write((" database=" + txtDatabase.getText()).getBytes());
                outputStream.write((" user=" + txtUser.getText()).getBytes());
                outputStream.write("\n".getBytes());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        txtAddress = new Utilities.JSuggestedTextField(rAdd);
        txtDatabase = new Utilities.JSuggestedTextField(rDB);
        txtUser = new Utilities.JSuggestedTextField(rUser);
        txtPassword = new javax.swing.JPasswordField();
        btnCancel = new javax.swing.JButton();
        btnConnect = new javax.swing.JButton();
        addLabel = new javax.swing.JLabel();
        Announcement = new javax.swing.JLabel();

        setEnabled(false);
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(286, 150));
        setMinimumSize(new java.awt.Dimension(286, 150));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(286, 150));

        dbLabel.setText("Database:");

        userLabel.setText("Usuário:");

        passLabel.setText("Senha:");

        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        txtDatabase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
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

        btnConnect.setText("Conectar");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        addLabel.setText("Endereço:");

        Announcement.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Announcement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Announcement.setText("ANNOUNCEMENT"); // NOI18N
        Announcement.setAlignmentX(0.5F);
        Announcement.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Announcement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 108, Short.MAX_VALUE)
                        .addComponent(btnConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addLabel)
                            .addComponent(dbLabel)
                            .addComponent(userLabel)
                            .addComponent(passLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress)
                            .addComponent(txtDatabase)
                            .addComponent(txtUser)
                            .addComponent(txtPassword)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Announcement)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLabel)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbLabel)
                    .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Announcement)
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Enter
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                btnConnectActionPerformed(null);
                break;
            case KeyEvent.VK_ESCAPE:
                btnCancelActionPerformed(null);
                break;
        }
    }//GEN-LAST:event_Enter
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Utils.CloseWindow(this);
    }//GEN-LAST:event_btnCancelActionPerformed
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        String add = txtAddress.getText(),
                db = txtDatabase.getText(),
                user = txtUser.getText(),
                pass = new String(txtPassword.getPassword()),
                err = "";
        if (Utils.isNull(add)) {
            err += (Utils.isNull(err) ? "" : "\n") + "Endereço Inválido.";
        }
        if (Utils.isNull(db)) {
            err += (Utils.isNull(err) ? "" : "\n") + "Database Inválido.";
        }
        if (Utils.isNull(user)) {
            err += (Utils.isNull(err) ? "" : "\n") + "Usuário Inválido.";
        }
        if (Utils.isNull(pass)) {
            err += (Utils.isNull(err) ? "" : "\n") + "Senha Inválida.";
        }
        if (!Utils.isNull(err)) {
            Utils.Announce(err, Announcement, 312, 200);
            return;
        }
        ConnectionFactory.Configure(
                txtAddress.getText(),
                txtDatabase.getText(),
                txtUser.getText(),
                new String(txtPassword.getPassword())
        );
        try {
            if (ConnectionFactory.getConnection() != null) {
                if (!rAdd.contains(add) && !rDB.contains(db) && !rUser.contains(user) && !rPass.contains(pass)) {
                    generateRecord();
                }
                SetupConnection.close = false;
                Utils.CloseWindow(this);
            }
        } catch (java.sql.SQLException e) {
            String msg;
            switch (e.getMessage()) {
                case "The connection attempt failed.":
                    msg = "Usuário ou Senha Incorretos";
                    break;
                case "Connection to localhost:5431 refused. Check that the hostname and port are correct and that the postmaster is accepting TCP/IP connections.":
                    msg = "Servidor não responde.\nVerifique se o mesmo encontra-se no endereço e porta citados e está aberto a conexões TCP/IP.";
                    break;
                case "The authentication type 10 is not supported. Check that you have configured the pg_hba.conf file to include the client's IP address or subnet, and that it is using an authentication scheme supported by the driver.":
                    msg = "Versão do Servidor\ne a versão do programa\nsão diferentes.\n\nServidor não suportado.\n" + e.getMessage();
                    break;
                default:
                    msg = "Erro desconhecido.\nMensagem:\n" + e.getMessage();
                    break;
            }
            Utils.Announce(msg, Announcement, 312, 200);
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Announcement;
    private javax.swing.JLabel addLabel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel dbLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
