package nproyecto;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class ProYecto extends javax.swing.JFrame {
    private Connection conexion;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public void Conectar(){
        try{
        conexion=DriverManager.getConnection("jdbc:mysql://localhost/base_de_datos","wicho","12345");
            st=conexion.createStatement();
            rs=st.executeQuery("Select * from producto");
        
            rs.next();
            
            
        this.jtf_id_producto.setText(rs.getString("id_producto"));
        this.jtf_nombre_producto.setText(rs.getString("nom_producto"));
        this.jtf_precio_compra.setText(rs.getString("precio_compra"));
        this.jtf_existencia.setText(rs.getString("existencia"));
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    public void habilitarCajas(){
        jtf_id_producto.setEditable(true);
        jtf_nombre_producto.setEditable(true);
        jtf_precio_compra.setEditable(true);
        jtf_existencia.setEditable(true);
    }
    private void siguienteRegistro() throws SQLException{
       try{
            if(rs.isLast()==false){
                rs.next();
            this.jtf_id_producto.setText(rs.getString("id_producto"));
            this.jtf_nombre_producto.setText(rs.getString("nom_producto"));
            this.jtf_precio_compra.setText(rs.getString("precio_compra"));
            this.jtf_existencia.setText(rs.getString("existencia"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());  
        }
    }
    private void anteriorRegistro() throws SQLException{
        try{
            if(rs.isFirst()==false){
                rs.previous();
            this.jtf_id_producto.setText(rs.getString("id_producto"));
            this.jtf_nombre_producto.setText(rs.getString("nom_producto"));
            this.jtf_precio_compra.setText(rs.getString("precio_compra"));
            this.jtf_existencia.setText(rs.getString("existencia"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    
    private void ultimoRegistro() throws SQLException{
        try{
            if(rs.isLast()==false){
                rs.last();
            this.jtf_id_producto.setText(rs.getString("id_producto"));
            this.jtf_nombre_producto.setText(rs.getString("nom_producto"));
            this.jtf_precio_compra.setText(rs.getString("precio_compra"));
            this.jtf_existencia.setText(rs.getString("existencia"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    private void primerRegistro() throws SQLException{
          try{
            if(rs.isFirst()==false){
                rs.first();
            this.jtf_id_producto.setText(rs.getString("id_producto"));
            this.jtf_nombre_producto.setText(rs.getString("nom_producto"));
            this.jtf_precio_compra.setText(rs.getString("precio_compra"));
            this.jtf_existencia.setText(rs.getString("existencia"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
        
    private void guardarRegistro(){
         try{
            String nombre_producto=this.jtf_nombre_producto.getText();
            String precio_compra=this.jtf_precio_compra.getText();
            String existencia=this.jtf_existencia.getText();
            st.executeUpdate("Insert into producto(nom_producto,precio_compra,existencia)"+"values('"+nombre_producto+"','"+precio_compra+"','"+existencia+"');");
            this.primerRegistro(); 
            JOptionPane.showMessageDialog(null,"excelente");
        }catch(SQLException err){
        JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    private void borrarRegistro(){
         try{
        st.executeUpdate("delete from producto where id_producto="+this.jtf_id_producto.getText());
        this.primerRegistro();
        }catch(SQLException err){
        JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }   
    public void nuevoRegistro() throws SQLException{
        try{
        String id_producto = jtf_id_producto.getText();
        String nom_producto = jtf_nombre_producto.getText();
        String precio_compra = jtf_precio_compra.getText();
        String existencia = jtf_existencia.getText();

        String sql = "insert into producto(id_producto,nom_producto,precio_compra,existencia)"
                +"values(?,?,?,?);";

        pst = conexion.prepareStatement(sql);
        pst.setString(1, id_producto);
        pst.setString(2, nom_producto);
        pst.setString(3, precio_compra);
        pst.setString(4, existencia);

        pst.executeUpdate();
        JOptionPane.showMessageDialog(this,"registro insertado exitosamente");
        seleccionarTodosLosRegistros();
                                                                                 
        }catch(SQLException err){
            JOptionPane.showMessageDialog(this,"Error"+err.getMessage());
        }
    }
    public void seleccionarTodosLosRegistros(){
        try{
           String sql = "SELECT * FROM productos;";
           pst = conexion.prepareStatement(sql);
           rs = pst.executeQuery();
           rs.first();
        }catch (SQLException err) {
            JOptionPane.showMessageDialog(this, "Error 00" + err.getMessage());
        }
    }

    /**
     * Creates new form ProYecto
     */
    public ProYecto() {
        initComponents();
        this.Conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_id_producto = new javax.swing.JTextField();
        jtf_nombre_producto = new javax.swing.JTextField();
        jtf_precio_compra = new javax.swing.JTextField();
        jtf_existencia = new javax.swing.JTextField();
        jcontroles_movimiento = new javax.swing.JPanel();
        jb_primero = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();
        jcontroles = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jb_actualizar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("  ID:");

        jLabel2.setText("Nombre:");

        jLabel4.setText("Precio:");

        jLabel5.setText("Existencia:");

        jtf_id_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_id_productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jdatosLayout = new javax.swing.GroupLayout(jdatos);
        jdatos.setLayout(jdatosLayout);
        jdatosLayout.setHorizontalGroup(
            jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdatosLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_id_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jtf_nombre_producto)
                    .addComponent(jtf_precio_compra)
                    .addComponent(jtf_existencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdatosLayout.setVerticalGroup(
            jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdatosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtf_existencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jb_primero.setText("l<");
        jb_primero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_primeroMouseClicked(evt);
            }
        });
        jb_primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_primeroActionPerformed(evt);
            }
        });

        jb_anterior.setText("<<");
        jb_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_anteriorMouseClicked(evt);
            }
        });
        jb_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_anteriorActionPerformed(evt);
            }
        });

        jb_siguiente.setText(">>");
        jb_siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_siguienteMouseClicked(evt);
            }
        });
        jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siguienteActionPerformed(evt);
            }
        });

        jb_ultimo.setText(">l");
        jb_ultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_ultimoMouseClicked(evt);
            }
        });
        jb_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ultimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcontroles_movimientoLayout = new javax.swing.GroupLayout(jcontroles_movimiento);
        jcontroles_movimiento.setLayout(jcontroles_movimientoLayout);
        jcontroles_movimientoLayout.setHorizontalGroup(
            jcontroles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontroles_movimientoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jb_primero, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jb_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jb_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jcontroles_movimientoLayout.setVerticalGroup(
            jcontroles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontroles_movimientoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jcontroles_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_primero)
                    .addComponent(jb_anterior)
                    .addComponent(jb_siguiente)
                    .addComponent(jb_ultimo))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });

        jb_actualizar.setText("Actualizar");
        jb_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_actualizarActionPerformed(evt);
            }
        });

        jb_borrar.setText("Borrar");
        jb_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_borrarMouseClicked(evt);
            }
        });
        jb_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_borrarActionPerformed(evt);
            }
        });

        jb_guardar.setText("Guardar");
        jb_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_guardarMouseClicked(evt);
            }
        });
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jb_cancelar.setText("Cancelar");
        jb_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_cancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jcontrolesLayout = new javax.swing.GroupLayout(jcontroles);
        jcontroles.setLayout(jcontrolesLayout);
        jcontrolesLayout.setHorizontalGroup(
            jcontrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontrolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_cancelar)
                .addContainerGap())
        );
        jcontrolesLayout.setVerticalGroup(
            jcontrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcontrolesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jcontrolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_actualizar)
                    .addComponent(jb_borrar)
                    .addComponent(jb_guardar)
                    .addComponent(jb_cancelar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Jokerman", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 204, 255));
        jLabel6.setText("      PRODUCTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcontroles_movimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcontroles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jdatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jcontroles_movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jcontroles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_primeroActionPerformed
        try {
            primerRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_primeroActionPerformed

    private void jb_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_primeroMouseClicked
    
    }//GEN-LAST:event_jb_primeroMouseClicked

    private void jb_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_anteriorMouseClicked
        
    }//GEN-LAST:event_jb_anteriorMouseClicked

    private void jb_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_siguienteMouseClicked
         
    }//GEN-LAST:event_jb_siguienteMouseClicked

    private void jb_ultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_ultimoMouseClicked
       
    }//GEN-LAST:event_jb_ultimoMouseClicked

    private void jtf_id_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_id_productoActionPerformed
    
    }//GEN-LAST:event_jtf_id_productoActionPerformed

    private void jb_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_guardarMouseClicked
     
    }//GEN-LAST:event_jb_guardarMouseClicked

    private void jb_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_borrarMouseClicked
      
    }//GEN-LAST:event_jb_borrarMouseClicked

    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        try {
            siguienteRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void jb_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_anteriorActionPerformed
        try {
            anteriorRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_anteriorActionPerformed

    private void jb_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ultimoActionPerformed
        try {
            ultimoRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_ultimoActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        guardarRegistro();
    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jb_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_borrarActionPerformed
        borrarRegistro();
    }//GEN-LAST:event_jb_borrarActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        try {    
            nuevoRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_actualizarActionPerformed

    private void jb_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelarMouseClicked
        Home regre = new Home();
        regre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_cancelarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProYecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProYecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProYecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProYecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProYecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jb_actualizar;
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_primero;
    private javax.swing.JButton jb_siguiente;
    private javax.swing.JButton jb_ultimo;
    private javax.swing.JPanel jcontroles;
    private javax.swing.JPanel jcontroles_movimiento;
    private javax.swing.JPanel jdatos;
    private javax.swing.JTextField jtf_existencia;
    private javax.swing.JTextField jtf_id_producto;
    private javax.swing.JTextField jtf_nombre_producto;
    private javax.swing.JTextField jtf_precio_compra;
    // End of variables declaration//GEN-END:variables

}
