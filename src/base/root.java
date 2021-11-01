package base;

import Utilities.Utils;
import view.Principal;
import view.SetupConnection;

public final class root extends javax.swing.JFrame {

    private final java.util.Map<String, javax.swing.JPanel> tabStorage;

    public root() {
        initComponents();
        tabStorage = new java.util.HashMap<>();
        jTabbedPane1.setName("rootPane");
        this.setLocationRelativeTo(null);
        addTab(Principal.class.getSimpleName(), new Principal());
    }

    public <T extends javax.swing.JPanel> T getTab(String title, Class<T> target) {
        return (T) tabStorage.get(title);
    }

    public void addTab(String title, javax.swing.JPanel pane) {
        tabStorage.put(title, pane);
        jTabbedPane1.add(title, pane);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
//                if(true){ DAO.ConnectionFactory.Configure("localhost:5433", "postgres", "postgres", "123456");
                if (!SetupConnection.ShowDialog()) {
                    new root().setVisible(true);
                } else {
                    Utils.pop("Conexão não estabelecida.", Utils.pop.WARN);
                }
            } catch (Exception e) {
                System.out.println(e);
                System.exit(1);
            }
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
