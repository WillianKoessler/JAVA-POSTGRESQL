package view;

import DAO.ConnectionFactory;
import ErrorHandling.Error;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class SetupConnection extends javax.swing.JPanel {

    private static final String announceBegin = "<html><div align=center width=190px>";
    private static final String announceEnd = "</div></html>";
    private final String RecordFile = "database.record";
    private List<String> rAdd, rDB, rUser, rPass;

    public SetupConnection() {
        this.setName("SetupConnection");
        rAdd = new ArrayList<String>();
        rDB = new ArrayList<String>();
        rUser = new ArrayList<String>();
        rPass = new ArrayList<String>();
        initComponents();
        Announcement.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            ((javax.swing.JDialog) getAncestor(this)).setResizable(true);
            Announcement.setVisible(false);
            this.getAncestor(this).setSize(312, 200);
        });
        checkRecords();
    }

    private Container getAncestor(Container obj) {
        if ((obj.getParent()).getParent() != null) {
            return getAncestor(obj.getParent());
        } else {
            return obj;
        }
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
//                outputStream.write((" password=" + new String(txtPassword.getPassword())).getBytes()); // should save password?
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void CloseWindow(java.awt.event.ActionEvent evt) {
        if (evt != null) {
            SwingUtilities.getWindowAncestor((JComponent) evt.getSource()).dispose();
        }
    }

    private boolean isNull(String str) {
        return str == null || str.equals("") || str.equals(announceBegin + announceEnd);
    }

    private Color highlight(int code) {
        switch (code) {
            case 0:
                return Color.black;
            case 1:
                return Color.green;
            case 2:
                return Color.yellow;
            case 3:
                return Color.RED;
        }
        return null;
    }

    private void announce(String msg, int codes) {
        if (codes > 9999 || codes < 1000) {
            System.out.println("wrong format");
            return;
        }
        int add = (int) java.lang.Math.floor(codes / 1000);
        int db = (int) java.lang.Math.floor((codes - add * 1000) / 100);
        int user = (int) java.lang.Math.floor((codes - add * 1000 - db * 100) / 10);
        int pass = (int) java.lang.Math.floor(codes - add * 1000 - db * 100 - user * 10);
        addLabel.setForeground(highlight(add));
        dbLabel.setForeground(highlight(db));
        userLabel.setForeground(highlight(user));
        passLabel.setForeground(highlight(pass));

        if (isNull(msg)) {
            return;
        }
        msg = announceBegin + msg.replaceAll("\n", "<br>") + "<br>" + announceEnd;

        int brs = 0;
        Pattern p = Pattern.compile("<br>");
        Matcher m = p.matcher(msg);
        while (m.find()) {
            brs++;
        }
        Announcement.setText(msg);
        Announcement.setVisible(true);
        this.getAncestor(this).setSize(312, 225 + brs * 15);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        txtAddress = new Utils.JSuggestedTextField(rAdd);
        txtDatabase = new Utils.JSuggestedTextField(rDB);
        txtUser = new Utils.JSuggestedTextField(rUser);
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
        Announcement.setText("ANNOUNCEMENT"); // NOI18N
        Announcement.setAlignmentX(0.5F);
        Announcement.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Announcement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(118, Short.MAX_VALUE)
                        .addComponent(btnConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
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
                            .addComponent(txtPassword))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Announcement)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Enter
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER: {
                btnConnectActionPerformed(
                        new java.awt.event.ActionEvent(
                                this,
                                java.awt.event.ActionEvent.ACTION_PERFORMED,
                                "Conectar",
                                this.hashCode(),
                                0
                        )
                );
                break;
            }
            case KeyEvent.VK_DELETE: {
                System.out.println(this.getAncestor(this).getSize());
                break;
            }
        }
    }//GEN-LAST:event_Enter
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        CloseWindow(evt);
    }//GEN-LAST:event_btnCancelActionPerformed
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        String add = txtAddress.getText(),
                db = txtDatabase.getText(),
                user = txtUser.getText(),
                pass = new String(txtPassword.getPassword()),
                err = "";
        int code = 0;
        if (isNull(add)) {
            err += (isNull(err) ? "" : "\n") + "Endereço Inválido.";
            code += 3000;
        }
        if (isNull(db)) {
            err += (isNull(err) ? "" : "\n") + "Database Inválido.";
            code += 300;
        }
        if (isNull(user)) {
            err += (isNull(err) ? "" : "\n") + "Usuário Inválido.";
            code += 30;
        }
        if (isNull(pass)) {
            err += (isNull(err) ? "" : "\n") + "Senha Inválida.";
            code += 3;
        }
        if (!isNull(err)) {
            System.out.println(err);
            announce(err, code);
            return;
        }
        ConnectionFactory.setConnectionConfiguration(
                txtAddress.getText() + '/' + txtDatabase.getText(),
                txtUser.getText(),
                new String(txtPassword.getPassword())
        );
        try {
            if (ConnectionFactory.getConnection() != null) {
                if (!rAdd.contains(add) && !rDB.contains(db) && !rUser.contains(user) && !rPass.contains(pass)) {
                    generateRecord();
                }
                CloseWindow(evt);
            }
        } catch (Error e) {
            if (e.message().equals("Authentication Failed")) {
                announce("Usuário ou Senha Incorretos", 1222);
            } else if (e.message().equals("Server couldn't be reached.")) {
                announce("Servidor não responde", 3000);
            } else {
                announce("Versão do Servidor\ne a versão do programa\nsão diferentes.\n\nServidor não suportado.", 3333);
            }
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
