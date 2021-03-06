
package nproyecto;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class AltaProveedor extends javax.swing.JFrame {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
   
    public void Conectar(){
        try{
        conexion=DriverManager.getConnection("jdbc:mysql://localhost/base_de_datos","wicho","12345");
            st=conexion.createStatement();
            rs=st.executeQuery("Select * from proveedor");
        
            rs.next();
        
        this.jtf_marca_proveedor.setText(rs.getString("marca"));
        this.jtf_nom_proveedor.setText(rs.getString("nom_proveedor"));
        this.jtf_corr_electronico_proveedor.setText(rs.getString("corr_electronico_proveedor"));
        JOptionPane.showMessageDialog(null,"excelente");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    private void siguienteRegistro() throws SQLException{
       try{
            if(rs.isLast()==false){
                rs.next();
            this.jtf_marca_proveedor.setText(rs.getString("marca"));
            this.jtf_nom_proveedor.setText(rs.getString("nom_proveedor"));
            this.jtf_corr_electronico_proveedor.setText(rs.getString("correo_electronico"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());  
        }
    }
    private void anteriorRegistro() throws SQLException{
        try{
            if(rs.isFirst()==false){
                rs.previous();
            this.jtf_marca_proveedor.setText(rs.getString("marca"));
            this.jtf_nom_proveedor.setText(rs.getString("nom_proveedor"));
            this.jtf_corr_electronico_proveedor.setText(rs.getString("correo_electronico"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    
    private void ultimoRegistro() throws SQLException{
        try{
            if(rs.isLast()==false){
                rs.last();
            this.jtf_marca_proveedor.setText(rs.getString("marca"));
            this.jtf_nom_proveedor.setText(rs.getString("nom_proveedor"));
            this.jtf_corr_electronico_proveedor.setText(rs.getString("correo_electronico"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    private void primerRegistro() throws SQLException{
          try{
            if(rs.isFirst()==false){
                rs.first();
            this.jtf_marca_proveedor.setText(rs.getString("marca"));
            this.jtf_nom_proveedor.setText(rs.getString("nom_proveedor"));
            this.jtf_corr_electronico_proveedor.setText(rs.getString("correo_electronico"));
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    private void guardarRegistro(){
         try{
            String marca_proveedor=this.jtf_marca_proveedor.getText();
            String nom_proveedor=this.jtf_nom_proveedor.getText();
            String corr_electronico_proveedor=this.jtf_corr_electronico_proveedor.getText();
            st.executeUpdate("Insert into proveedor(marca,nom_proveedor,corr_electronico_proveedor)"+"values('"+marca_proveedor+"','"+nom_proveedor+"','"+corr_electronico_proveedor+"');"); 
            JOptionPane.showMessageDialog(null,"excelente");
        }catch(SQLException err){
        JOptionPane.showMessageDialog(null,"Error"+err.getMessage());
        }
    }
    public AltaProveedor() {
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

        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtf_marca_proveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtf_nom_proveedor = new javax.swing.JTextField();
        jtf_corr_electronico_proveedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jcontroles_movimiento = new javax.swing.JPanel();
        jb_primero = new javax.swing.JButton();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Jokerman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("Alta de Proveedor");

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jtf_marca_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_marca_proveedorActionPerformed(evt);
            }
        });

        jLabel1.setText("Marca");

        jLabel6.setText("Correo Electronico");

        jLabel4.setText("Nombre Completo:");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGap(46, 46, 46)
                .addComponent(jb_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jb_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jb_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtf_corr_electronico_proveedor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_nom_proveedor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_marca_proveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(105, 105, 105)
                .addComponent(jButton2)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jcontroles_movimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_marca_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nom_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtf_corr_electronico_proveedor))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 29, Short.MAX_VALUE)
                .addComponent(jcontroles_movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_marca_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_marca_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_marca_proveedorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardarRegistro();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Home regre = new Home();
        regre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jb_primeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_primeroMouseClicked

    }//GEN-LAST:event_jb_primeroMouseClicked

    private void jb_primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_primeroActionPerformed
        try {
            primerRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_primeroActionPerformed

    private void jb_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_anteriorMouseClicked

    }//GEN-LAST:event_jb_anteriorMouseClicked

    private void jb_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_anteriorActionPerformed
        try {
            anteriorRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_anteriorActionPerformed

    private void jb_siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_siguienteMouseClicked

    }//GEN-LAST:event_jb_siguienteMouseClicked

    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        try {
            siguienteRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_siguienteActionPerformed

    private void jb_ultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_ultimoMouseClicked

    }//GEN-LAST:event_jb_ultimoMouseClicked

    private void jb_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ultimoActionPerformed
        try {
            ultimoRegistro();
        } catch (SQLException ex) {
            Logger.getLogger(ProYecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_ultimoActionPerformed

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
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_primero;
    private javax.swing.JButton jb_siguiente;
    private javax.swing.JButton jb_ultimo;
    private javax.swing.JPanel jcontroles_movimiento;
    private javax.swing.JTextField jtf_corr_electronico_proveedor;
    private javax.swing.JTextField jtf_marca_proveedor;
    private javax.swing.JTextField jtf_nom_proveedor;
    // End of variables declaration//GEN-END:variables
}
