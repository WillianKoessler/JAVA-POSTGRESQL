package view;

import DAO.PCDAO;
import com.sun.glass.events.KeyEvent;
import java.awt.KeyboardFocusManager;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import model.PC;

public class CadastroPC extends javax.swing.JPanel {

    private final PlainDocument[] ipDoc;
    private final String[] ip;

    public CadastroPC() {
        ip = new String[4];
        for (int i = 0; i < 4; i++) {
            ip[i] = "000";
        }
        initComponents();
        ipDoc = new PlainDocument[4];
        ipDoc[0] = (PlainDocument)jip1.getDocument();
        ipDoc[1] = (PlainDocument)jip2.getDocument();
        ipDoc[2] = (PlainDocument)jip3.getDocument();
        ipDoc[3] = (PlainDocument)jip4.getDocument();
        ipDoc[0].setDocumentFilter(new IPFilter());
        ipDoc[1].setDocumentFilter(new IPFilter());
        ipDoc[2].setDocumentFilter(new IPFilter());
        ipDoc[3].setDocumentFilter(new IPFilter());
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jip3 = new javax.swing.JFormattedTextField();
        jip4 = new javax.swing.JFormattedTextField();
        jip1 = new javax.swing.JFormattedTextField();
        jip2 = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(350, 136));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Computador");

        jLabel2.setText("Nome:");

        jLabel3.setText("IP:");

        txtName.setNextFocusableComponent(jip1);
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
        btnCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelKeyPressed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setRequestFocusEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        btnCadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCadastrarKeyPressed(evt);
            }
        });

        jLabel4.setText(".");

        jLabel5.setText(".");

        jLabel6.setText(".");

        jip3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        jip3.setNextFocusableComponent(jip4);
        jip3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jip3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jip3FocusLost(evt);
            }
        });
        jip3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jip3KeyReleased(evt);
            }
        });

        jip4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        jip4.setNextFocusableComponent(btnCadastrar);
        jip4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jip4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jip4FocusLost(evt);
            }
        });
        jip4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jip4KeyReleased(evt);
            }
        });

        jip1.setColumns(3);
        try {
            jip1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jip1.setNextFocusableComponent(jip2);
        jip1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jip1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jip1FocusLost(evt);
            }
        });
        jip1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jip1KeyReleased(evt);
            }
        });

        try {
            jip2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jip2.setNextFocusableComponent(jip3);
        jip2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jip2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jip2FocusLost(evt);
            }
        });
        jip2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jip2KeyReleased(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 133, Short.MAX_VALUE)
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel))
                            .addComponent(txtName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jip1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jip2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jip3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jip4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jip2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jip3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jip4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        PC pc = new PC();
        String IP = "";

        for (int i = 0; i < 3; i++) {
            try{
                Integer.parseInt(ip[i]);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid characters for IP Address on field '"+(i+1)+"'.\nException thrown: "+e.getMessage());
                return;
            }
            IP += ip[i] + '.';
        }
        IP += ip[3];
        System.out.println(IP);

        if (txtName != null && !txtName.getText().equals("")) {
            pc.setName(txtName.getText());
        }
        pc.setAddress(IP);
        new PCDAO().insert(pc);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCadastrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void jip4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip4FocusGained
        jip4.setText("");
        ip[3] = "";
    }//GEN-LAST:event_jip4FocusGained
    private void jip4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip4FocusLost
        jip4.setText(ip[3]);
    }//GEN-LAST:event_jip4FocusLost
    private void jip4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jip4KeyReleased
        passFocus(evt, jip4, 3);
    }//GEN-LAST:event_jip4KeyReleased

    private void jip3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jip3KeyReleased
        passFocus(evt, jip3, 2);
    }//GEN-LAST:event_jip3KeyReleased

    private void jip3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip3FocusLost
        jip3.setText(ip[2]);
    }//GEN-LAST:event_jip3FocusLost

    private void jip3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip3FocusGained
        jip3.setText("");
        ip[2] = "";
    }//GEN-LAST:event_jip3FocusGained

    private void jip2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jip2KeyReleased
        passFocus(evt, jip2, 1);
    }//GEN-LAST:event_jip2KeyReleased

    private void jip2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip2FocusLost
        jip2.setText(ip[1]);
    }//GEN-LAST:event_jip2FocusLost

    private void jip2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip2FocusGained
        jip2.setText("");
        ip[1] = "";
    }//GEN-LAST:event_jip2FocusGained

    private void jip1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jip1KeyReleased
        passFocus(evt, jip1, 0);
    }//GEN-LAST:event_jip1KeyReleased

    private void jip1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip1FocusLost
        jip1.setText(ip[0]);
    }//GEN-LAST:event_jip1FocusLost

    private void jip1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jip1FocusGained
        jip1.setText("");
        ip[0] = "";
    }//GEN-LAST:event_jip1FocusGained

    private void btnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarKeyPressed

    private void btnCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) btnCancelActionPerformed(null);
    }//GEN-LAST:event_btnCancelKeyPressed

    private void passFocus(java.awt.event.KeyEvent evt, javax.swing.JFormattedTextField txt, int i) {
        if (evt.getKeyChar() == '.') {
            if (txt.getText().contains(".")) {
                ip[i] = "";
                for(int j = 0; j < 3-txt.getText().length(); j++){
                    ip[i] += '0';
                }
                ip[i] += txt.getText().substring(0,txt.getText().indexOf("."));
            } else {
                ip[i] = txt.getText().substring(0, 3);
            }
            KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
        }
    }

    //    <editor-fold defaultstate="collapsed" desc="Variables Declarations">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField jip1;
    private javax.swing.JFormattedTextField jip2;
    private javax.swing.JFormattedTextField jip3;
    private javax.swing.JFormattedTextField jip4;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}

class IPFilter extends javax.swing.text.DocumentFilter {
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string,AttributeSet attr) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.insert(offset, string);

      if (test(sb.toString())) {
         super.insertString(fb, offset, string, attr);
      } else {
         // warn the user and don't allow the insert
      }
   }
   private boolean test(String text) {
      try {
         Integer.parseInt(text);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
   @Override
   public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,AttributeSet attrs) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);

      if (test(sb.toString())) {
         super.replace(fb, offset, length, text, attrs);
      }
   }
   @Override
   public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.delete(offset, offset + length);

      if (test(sb.toString())) {
         super.remove(fb, offset, length);
      }
   }
}