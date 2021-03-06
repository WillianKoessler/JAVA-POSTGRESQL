package view;

import Utilities.Utils;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import model.Entity;

public class ConsultaPC extends javax.swing.JPanel {

    private ArrayList<model.Entity> query;
    private static final DAO.Controller controller = new DAO.Controller("computador");

    public ConsultaPC() {
        initComponents();

        jTable.getModel().addTableModelListener((TableModelEvent tme) -> {
            if (tme.getType() == TableModelEvent.UPDATE && query != null && query.size() > tme.getFirstRow()) {
                int row = jTable.getSelectedRow();
                model.Entity pc = new model.Entity();
                pc.setID(Integer.parseInt(jTable.getModel().getValueAt(row, 0).toString()));
                pc.set("address", jTable.getModel().getValueAt(row, 1).toString());
                pc.set("name", jTable.getModel().getValueAt(row, 2).toString());
                controller.update(pc);
            }
        });
        java.awt.EventQueue.invokeLater(() -> {
            Utils.getAncestor(this).setSize(416, 339);
            if (!controller.insert()) {
                List<String> v, t;
                v = new ArrayList<>();
                t = new ArrayList<>();
                v.add("name");
                v.add("address");
                t.add("character varying(256)");
                t.add("character varying(32)");
                if (!controller.createTable("computador", v, t)) {
                    Principal main = Utils.getAncestor(this, Principal.class);
                    main.setButtonEnabled(CadastroPC.class.getSimpleName(), false);
                    main.setButtonEnabled(ConsultaPC.class.getSimpleName(), false);
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
        txtIP = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnQuery = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("Nome:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        jLabel2.setText("Endere??o:");

        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
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
                "ID", "Endere??o", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
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
                jTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(40);
            jTable.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable.getColumnModel().getColumn(1).setMinWidth(100);
            jTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Consulta de Computador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
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
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel)
                    .addComponent(btnQuery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.getParent().remove(this);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        Entity mask = new Entity();
        if (!Utils.isNull(txtName)) {
            mask.set("name", txtName.getText());
        }
        if (!Utils.isNull(txtIP)) {
            mask.set("address", txtIP.getText());
        }
        query = controller.retrieve(mask);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        query.forEach((pc) -> {
            model.addRow(new Object[]{pc.getID(), pc.get("address"), pc.get("name")});
        });
    }//GEN-LAST:event_btnQueryActionPerformed

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

    private void jTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (jTable.getModel().getRowCount() < 1) {
                return;
            }
            controller.delete(Integer.parseInt(jTable.getModel().getValueAt(jTable.getSelectedRow(), 0).toString()));
            btnQueryActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            btnCancelActionPerformed(null);
        }
    }//GEN-LAST:event_jTableKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
