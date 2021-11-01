package view;

import Utilities.Utils;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;
import model.Entity;

public class ConsultaCliente extends javax.swing.JPanel {

    private ArrayList<model.Entity> query;
    private final PlainDocument regDoc;
    static final private DAO.Controller controller = new DAO.Controller("cliente");

    public ConsultaCliente() {
        initComponents();
        regDoc = (PlainDocument) txtMat.getDocument();
        regDoc.setDocumentFilter(new DocFilter());
        jTable.getModel().addTableModelListener((TableModelEvent tme) -> {
            if (tme.getType() == TableModelEvent.UPDATE && query != null && query.size() > tme.getFirstRow()) {
                try {
                    int row = jTable.getSelectedRow();
                    model.Entity c = new model.Entity();
                    c.set("registry", Integer.parseInt(jTable.getModel().getValueAt(row, 0).toString()));
                    c.set("name", jTable.getModel().getValueAt(row, 1).toString());
                    c.set("phone", jTable.getModel().getValueAt(row, 2).toString());
                    String txtBirth = jTable.getModel().getValueAt(row, 3).toString();
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    c.set("birth", new Date(df.parse(txtBirth).getTime()));
                    c.set("address", jTable.getModel().getValueAt(row, 4).toString());
                    controller.update(c);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "O Formato de Data não pode ser utilizado.\nException thrown: " + ex.getMessage());
                }
            }
        });
        java.awt.EventQueue.invokeLater(() -> {
            Utils.getAncestor(this).setSize(416, 339);
            if (!controller.insert()) {
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
                if (!controller.createTable("cliente", v, t)) {
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
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMat = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnQuery = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtCourse = new javax.swing.JTextField();

        jLabel1.setText("Nome:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        jLabel2.setText("Matrícula:");

        txtMat.addKeyListener(new java.awt.event.KeyAdapter() {
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

        btnQuery.setText("Consultar");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Endereço", "Nascimento", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DeleteFromTable(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Consulta de Cliente");

        jLabel4.setText("Course:");

        txtCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 106, Short.MAX_VALUE)
                                .addComponent(btnQuery)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCourse))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnQuery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.getParent().remove(this);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void Enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Enter
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                btnQueryActionPerformed(null);
                break;
            case KeyEvent.VK_ESCAPE:
                btnCancelActionPerformed(null);
                break;
        }
    }//GEN-LAST:event_Enter

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        int reg = (!Utils.isNull(txtMat) ? Integer.parseInt(txtMat.getText()) : -1);
        Entity q = new Entity();
        q.setID(reg);
        if(!Utils.isNull(txtName)) q.set("name", txtName.getText());
        if(!Utils.isNull(txtCourse)) q.set("course", txtCourse.getText());
        query = controller.retrieve(q);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        query.forEach((c) -> {
            model.addRow(new Object[]{c.getID(), c.get("name"), c.get("address"), c.get("birth"), c.get("course")});
        });
    }//GEN-LAST:event_btnQueryActionPerformed

    private void DeleteFromTable(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DeleteFromTable
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                if (jTable.getModel().getRowCount() < 1) {
                    return;
                }
                controller.delete(Integer.parseInt(jTable.getModel().getValueAt(jTable.getSelectedRow(), 0).toString()));
            } catch (NumberFormatException e) {
                Utils.pop("Erro ao deletar objeto da tabela.\nErro: " + e.getMessage(), Utils.pop.ERRO);
                return;
            }
            btnQueryActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            btnCancelActionPerformed(null);
        }
    }//GEN-LAST:event_DeleteFromTable


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
