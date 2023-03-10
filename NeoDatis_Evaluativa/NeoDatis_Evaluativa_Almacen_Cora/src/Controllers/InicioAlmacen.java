package Controllers;

import Consumer.Recv;
import Services.PedidoService;

/**
 * Clase que define las funciones de creacion de InicioAlmacen
 * @author cora
 */
public class InicioAlmacen extends javax.swing.JFrame {

     /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private PedidoService pedidoService;

    /**
     * Contructor de la clase InicioAlmacen. Inicializaremos componentes para
     * cargar los datos necesarios, ademas de las clase correspondiente service.
     */
    public InicioAlmacen() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.pedidoService = new PedidoService();
        labelnfo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnLeerPedidos = new javax.swing.JButton();
        btnModificarPedidos = new javax.swing.JButton();
        btnMostrarPedidos = new javax.swing.JButton();
        labelnfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Almacén");

        btnLeerPedidos.setText("Leer pedidos");
        btnLeerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerPedidosActionPerformed(evt);
            }
        });

        btnModificarPedidos.setText("Modificar pedidos");
        btnModificarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPedidosActionPerformed(evt);
            }
        });

        btnMostrarPedidos.setText("Mostrar pedidos");
        btnMostrarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelnfo, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLeerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnModificarPedidos)
                                .addGap(61, 61, 61)
                                .addComponent(btnMostrarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(labelnfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Accion de mostrar pedidos
     * @param evt 
     */
    private void btnMostrarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPedidosActionPerformed

        MostrarPedidos mostrar = new MostrarPedidos();
        mostrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMostrarPedidosActionPerformed

    /**
     * accion de modificar pedidos
     * @param evt 
     */
    private void btnModificarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPedidosActionPerformed

        SeleccionarPedido pedido = new SeleccionarPedido();
        pedido.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnModificarPedidosActionPerformed

    /**
     * accion leer pedidos
     * @param evt 
     */
    private void btnLeerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerPedidosActionPerformed

        Recv recv = new Recv();
        recv.fromRabbit();
        labelnfo.setText("Se han consumido todos los pedidos correctamente");

    }//GEN-LAST:event_btnLeerPedidosActionPerformed

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
            java.util.logging.Logger.getLogger(InicioAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioAlmacen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeerPedidos;
    private javax.swing.JButton btnModificarPedidos;
    private javax.swing.JButton btnMostrarPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelnfo;
    // End of variables declaration//GEN-END:variables
}
