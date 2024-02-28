package com.javier.aprendizaje.mavencrud_personal_escuela;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Personal extends javax.swing.JFrame {

    // variables para conexion a la db
    public String driver;
    public String username;
    public String password;
    public String hostname;
    public String port;
    public String database;
    public String url;

    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet rs;

    String id;
    String buscar_identificacion;
    String identificacion;
    String nombre;
    String email;
    String direccion;
    String celular;
    String fecha_ingreso;
    String genero;
    // generar los valores del JComboBox
    String[] generoArray = {"", "Masculino", "Femenino"};
    DefaultComboBoxModel model = new DefaultComboBoxModel(generoArray);

    public Personal() {
        initComponents();
        // Permite localizar en el centro de la pantalla
        setLocationRelativeTo(null);
        // No permite modificar el tamaño
        setResizable(false);
        // No necesitamos la visibilidad de la cajaId
        cajaId.setVisible(false);
        // titulo de la ventana
        setTitle("Registro del personal de la escuela");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cajaBuscar = new javax.swing.JTextField();
        cajaId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cajaIdentificacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cajaEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cajaDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cajaCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cajaIngreso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuRegistrados = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ingrese N° Identificación");

        cajaBuscar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        cajaId.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Número Identificación:");

        cajaIdentificacion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nombre y apellidos:");

        cajaNombre.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Correo electrónico:");

        cajaEmail.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Dirección:");

        cajaDireccion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Celular:");

        cajaCelular.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fecha ingreso:");

        cajaIngreso.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Genero:");

        comboGenero.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        comboGenero.setModel(model);

        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(236, 233, 233));

        jMenu1.setText("Menú");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        menuRegistrados.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        menuRegistrados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/registros.png"))); // NOI18N
        menuRegistrados.setText("Personal registrado");
        menuRegistrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistradosActionPerformed(evt);
            }
        });
        jMenu1.add(menuRegistrados);
        jMenu1.add(jSeparator1);

        menuSalir.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 16, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(330, 330, 330)
                            .addComponent(cajaId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel1)
                            .addGap(21, 21, 21)
                            .addComponent(cajaIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel2)
                            .addGap(36, 36, 36)
                            .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel3)
                            .addGap(39, 39, 39)
                            .addComponent(cajaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel4)
                            .addGap(97, 97, 97)
                            .addComponent(cajaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(cajaCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(cajaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 17, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(2, 2, 2)
                            .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addComponent(cajaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cajaIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cajaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cajaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cajaCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cajaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(66, 66, 66)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        conn = getConnection();
        String query = "SELECT * FROM personal where numero_identificacion = ?";
        // se verifica si se ha ingresado un valor en la cajaBuscar
        if (!cajaBuscar.getText().trim().isEmpty()) {
            try {
                // obtener el valor del No identificacion ingresado por el usuario
                buscar_identificacion = cajaBuscar.getText().trim(); // (.trim() quita los espacios antes y despues)
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, buscar_identificacion); // pasa el valor al parametro ? de la query
                rs = preparedStatement.executeQuery();
                // se establece un if para saber si es o no una identificación registrada
                if (rs.next()) { // como el valor ha encontrar es Unique, el if es apropiado
                    // obtener los valores que se encuentran en la db
                    identificacion = String.valueOf(rs.getString("numero_identificacion"));
                    nombre = String.valueOf(rs.getString("nombre"));
                    email = String.valueOf(rs.getString("email"));
                    direccion = String.valueOf(rs.getString("direccion"));
                    celular = String.valueOf(rs.getString("celular"));
                    fecha_ingreso = String.valueOf(rs.getDate("fecha_ingreso"));
                    genero = rs.getString("genero");
                    // obtener el valor del id para generar actualización
                    cajaId.setText(String.valueOf(rs.getInt("idPersonal")));
                    // teniendo el valor en las variables ahora los envio a las cajas
                    cajaIdentificacion.setText(identificacion);
                    cajaNombre.setText(nombre);
                    cajaEmail.setText(email);
                    cajaDireccion.setText(direccion);
                    cajaCelular.setText(celular);
                    cajaIngreso.setText(fecha_ingreso);
                    comboGenero.setSelectedItem(genero); // el valor en la db debe ser igual que en el comboGenero (tener en cuenta las mayusculas y minusculas
                    JOptionPane.showMessageDialog(null, "Consulta exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "N° Identificación no registrado");
                    // si no está registrado el valor ingresado pasa a la cajaIdentificacion para que pueda realizar el registro
                    limpiar();
                    cajaIdentificacion.setText(buscar_identificacion);
                }
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta");
                System.err.println("Error al realizar consulta, " + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar N° Identificación para realizar consulta");
            limpiar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        conn = getConnection();
        String query = "INSERT INTO personal (numero_identificacion,nombre,email,direccion,celular,fecha_ingreso,genero)"
                + " value (?,?,?,?,?,?,?)";
        try {
            preparedStatement = conn.prepareStatement(query);
            // obtener los valores ingresados por el usuario en cada caja de texto
            identificacion = cajaIdentificacion.getText().trim();
            nombre = cajaNombre.getText().trim();
            email = cajaEmail.getText().trim();
            direccion = cajaDireccion.getText().trim();
            celular = cajaCelular.getText().trim();
            fecha_ingreso = cajaIngreso.getText().trim();
            genero = String.valueOf(comboGenero.getSelectedItem());
            // identificar si las variables están vacias para no enviar datos vacios a ls db
            if (!identificacion.isEmpty() && !nombre.isEmpty() && !email.isEmpty()
                    && !direccion.isEmpty() && !celular.isEmpty() && !genero.isEmpty()) {
                // mandar los valores a la db
                preparedStatement.setString(1, identificacion);
                preparedStatement.setString(2, nombre);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, direccion);
                preparedStatement.setString(5, celular);
                // @validacionIngresoFecha si el usuario no ingresa una fecha, por Default se pondra la fecha actual
                preparedStatement.setString(6, validacionIngresoFecha(fecha_ingreso));
                preparedStatement.setString(7, genero);
                // para que se ejecute la modificación
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos");
            }
            conn.close();
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "N° Identificación ya registrado");
        } catch (MysqlDataTruncation ex) { // si excede o hay errores en los campos solicitados
            JOptionPane.showMessageDialog(null, "Ingrese correctamente los valores solicitados");
        } catch (SQLException ex) {
            System.err.println("Error en registrar, " + ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        conn = getConnection();
        String query = "UPDATE personal SET numero_identificacion = ?,nombre = ?,email = ?,direccion = ?,"
                + "celular = ?,fecha_ingreso = ?,genero = ? WHERE idPersonal = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            // obtener los valores de las cajas
            id = cajaId.getText();
            identificacion = String.valueOf(cajaIdentificacion.getText().trim());
            nombre = String.valueOf(cajaNombre.getText().trim());
            email = String.valueOf(cajaEmail.getText().trim());
            direccion = String.valueOf(cajaDireccion.getText().trim());
            celular = String.valueOf(cajaCelular.getText().trim());
            fecha_ingreso = String.valueOf(cajaIngreso.getText().trim());
            genero = String.valueOf(comboGenero.getSelectedItem());
            // identificar si las variables están vacias para no enviar datos vacios a la db
            if (!identificacion.isEmpty() && !nombre.isEmpty() && !email.isEmpty()
                    && !direccion.isEmpty() && !celular.isEmpty() && !genero.isEmpty()) {
                // pasar los valores al query correspondiente
                preparedStatement.setString(1, identificacion);
                preparedStatement.setString(2, nombre);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, direccion);
                preparedStatement.setString(5, celular);
                // @validacionIngresoFecha si el usuario no ingresa una fecha, por Default se pondra la fecha actual
                preparedStatement.setString(6, validacionIngresoFecha(fecha_ingreso));
                preparedStatement.setString(7, genero);
                preparedStatement.setString(8, id);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos");
            }
            conn.close();
        } catch (MysqlDataTruncation ex) { // si excede o hay errores en los campos solicitados
            JOptionPane.showMessageDialog(null, "Ingrese correctamente los valores solicitados");
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Realice consulta del registro para poder actualizar los datos");
        } catch (SQLException ex) {
            System.err.println("Error en actualización, " + ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        conn = getConnection();
        String query = "DELETE FROM personal WHERE idPersonal = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            id = cajaId.getText();
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            limpiar();
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar, " + ex);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void menuRegistradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistradosActionPerformed
        // true no permite realizar acciones en la ventana primaria
        Registros registros = new Registros(this, true);
        registros.setVisible(true);
    }//GEN-LAST:event_menuRegistradosActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    // metodo para leer los valores que se encuentran en la propertie
    private void loadPropertiesDB() {
        // crear instancia de la propiedad para porder instanciar la configuracionDB 
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            // forma de llamar la propertie (de esta manera esta bien para el momento de crear el .exe)
            inputStream = getClass().getClassLoader().getResourceAsStream("configuracionDB.properties");
            // leer la informacion de la propertie
            properties.load(inputStream);
            // por medio de la clave acceder a los valores
            driver = properties.getProperty("driver");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            hostname = properties.getProperty("hostname");
            port = properties.getProperty("port");
            database = properties.getProperty("database");
            url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
        } catch (NullPointerException ex) {
            System.err.println("Error, " + ex);
        } catch (FileNotFoundException ex) {
            System.err.println("Error, loading properties: " + ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // metodo para la conexion a la db
    public Connection getConnection() {
        Connection conexion = null;
        try {
            // llamar el metodo que traera los valores de la DB
            loadPropertiesDB();
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error en la conexión, " + ex);
        }
        return conexion;
    }

    public void limpiar() {
        cajaBuscar.setText("");
        cajaId.setText("");
        cajaIdentificacion.setText("");
        cajaNombre.setText("");
        cajaEmail.setText("");
        cajaDireccion.setText("");
        cajaCelular.setText("");
        cajaIngreso.setText("");
        comboGenero.setSelectedItem("");
    }

    private static String validacionIngresoFecha(String fecha_ingreso) {
        // si el usuario no ingresa una fecha, por Default se pondra la fecha actual
        if (fecha_ingreso.isEmpty()) {
            return obtenerFechaActual();
        } else {
            return fecha_ingreso;
        }
    }

    private static String obtenerFechaActual() {
        // Método para obtener la fecha actual en formato "yyyy-MM-dd"
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaActual.format(formatter);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaCelular;
    private javax.swing.JTextField cajaDireccion;
    private javax.swing.JTextField cajaEmail;
    private javax.swing.JTextField cajaId;
    private javax.swing.JTextField cajaIdentificacion;
    private javax.swing.JTextField cajaIngreso;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuRegistrados;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}
