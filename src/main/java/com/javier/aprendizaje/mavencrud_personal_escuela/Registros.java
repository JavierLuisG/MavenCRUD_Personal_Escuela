package com.javier.aprendizaje.mavencrud_personal_escuela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Registros extends javax.swing.JDialog {

    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet rs;

    String numeroIdentificacion;
    String nombre;
    String email;
    String celular;

    DefaultTableModel model = new DefaultTableModel();

    public Registros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registros");
        setResizable(false);
        cargarModel();
    }

    private void asignarFilaDatos() {
        Personal personal = new Personal();
        conn = personal.getConnection();
        ArrayList<Object[]> persona = new ArrayList<>();

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM personal");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                numeroIdentificacion = String.valueOf(rs.getString("numero_identificacion"));
                nombre = String.valueOf(rs.getString("nombre"));
                email = String.valueOf(rs.getString("email"));
                celular = String.valueOf(rs.getString("celular"));
                Object[] fila = {numeroIdentificacion, nombre, email, celular};
                persona.add(fila);
                model.setRowCount(0);
                for (Object[] objects : persona) {
                    model.addRow(objects);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error, " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException ex) {
                    System.err.println("No se cerró el ResultSet");
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    rs = null;
                } catch (SQLException ex) {
                    System.err.println("No se cerró el ResultSet");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println("No se pudo cerrar la conexión, " + ex);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegistro = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Personal Registrado");

        tableRegistro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableRegistro.setModel(model);
        jScrollPane1.setViewportView(tableRegistro);

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // dispose permite cerrar solo esta ventana, con System.exit(0) se cerraria todo el programa
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cargarModel() {
        model.addColumn("Número Identificación");
        model.addColumn("Nombre");
        model.addColumn("Email");
        model.addColumn("Celular");
        asignarFilaDatos();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registros dialog = new Registros(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRegistro;
    // End of variables declaration//GEN-END:variables
}
