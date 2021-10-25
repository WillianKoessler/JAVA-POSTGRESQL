package base;

import DAO.ClientDAO;
import DAO.PCDAO;
import java.awt.Container;
import javax.swing.JOptionPane;
import view.MainView;
import view.SetupConnection;

public class root extends javax.swing.JFrame {

    public root() {
        initComponents();
        jTabbedPane1.addTab("Principal", new MainView());
        this.setName("root");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            JOptionPane.showOptionDialog(null, new SetupConnection(), "Nova Conexão", -1, -1, null, new Object[]{}, null);
            try {
                new PCDAO().insert();
                new ClientDAO().insert();
            } catch (ErrorHandling.Error err) {
                System.out.println(err);
                System.exit(1);
            }
            root r = new root();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
