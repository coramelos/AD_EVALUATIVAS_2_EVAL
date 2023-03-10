package Controllers;

import Models.Pedido;
import Models.Producto;
import Models.Usuario;
import Producer.Send;
import Repositories.DataBaseNeodatis;
import Services.PedidoService;
import Services.ProductoService;
import Services.UsuarioService;
import Utils.Serializer;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.neodatis.odb.ODB;

/**
 * Clase que define las funciones de creacion de CrearPedidos
 * @author Cora
 */
public class CrearPedido extends javax.swing.JFrame {

    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private String email;
    private PedidoService pedidoService;
    private ProductoService productoService;
    private UsuarioService usuarioService;
    private DefaultListModel modelListaIzquierda;
    private DefaultListModel modelListaDerecha;

    private final String ERROR_NO_ELECCION = "debes Elegir un producto al menos";

    /**
     * Contructor de la clase CrearPedidos. Inicializaremos componentes para
     * cargar los datos necesarios, ademas de las clase correspondiente service.
     * Recibe un email que hace referencia al usuario al que se le asignará el
     * pedido
     *
     * @param email
     */
    public CrearPedido(String email) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);

        this.email = email;
        this.pedidoService = new PedidoService();
        this.productoService = new ProductoService();
        this.usuarioService = new UsuarioService();
        setInfoUser();

        this.modelListaIzquierda = new DefaultListModel();
        this.modelListaDerecha = new DefaultListModel();
        loadProductsInList();
    }

    /**
     *
     */
    public void setInfoUser() {
        DataBaseNeodatis dataBaseNeodatis = new DataBaseNeodatis();
        ODB dataBaseConection = dataBaseNeodatis.open();
        Usuario usuario = this.usuarioService.findByEmailAndDataBase(this.email, dataBaseConection);

        this.labelNombre.setText("Nombre: " + usuario.getNombre());

        this.labelEmail.setText("Email: " + this.email);

        dataBaseNeodatis.close(dataBaseConection);
    }

    /**
     * Funcion para cargar los datos
     */
    public void loadProductsInList() {
        ArrayList<Producto> productos = this.productoService.getAll();

        for (Producto producto : productos) {
            if (producto.getStock() > 0) {
                this.modelListaIzquierda.addElement(producto.getNombre());
            }
        }
        this.jListDisponibles.setModel(this.modelListaIzquierda);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSeleccionadas = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListDisponibles = new javax.swing.JList<>();
        labelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Crear Pedidos");

        labelNombre.setText("Nombre:    ");

        labelEmail.setText("Email:   ");

        jLabel4.setText("Disponibles");

        jLabel5.setText("Seleccionadas");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jListSeleccionadas);

        jScrollPane4.setViewportView(jListDisponibles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeleccionar)))
                .addGap(30, 30, 30)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     *
     * @param evt
     */
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        InicioTienda tienda = new InicioTienda();
        tienda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed
   
    /**
     *
     * @param evt
     */
    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int index = this.jListDisponibles.getSelectedIndex();

        if (index == -1) {
            this.labelError.setText(ERROR_NO_ELECCION);

        } else {
            String nombreProducto = (String) this.modelListaIzquierda.getElementAt(index);

            this.modelListaDerecha.addElement(nombreProducto);
            this.jListSeleccionadas.setModel(modelListaDerecha);

            this.modelListaIzquierda.removeElement(nombreProducto);
            this.jListDisponibles.setModel(modelListaIzquierda);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     *
     * @param evt
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = this.jListSeleccionadas.getSelectedIndex();

        String nombreProducto = (String) this.modelListaDerecha.getElementAt(index);
        this.modelListaIzquierda.addElement(nombreProducto);
        this.jListDisponibles.setModel(modelListaIzquierda);

        this.modelListaDerecha.removeElement(nombreProducto);
        this.jListSeleccionadas.setModel(modelListaDerecha);

    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * funcion que guarda un pedido y envia mensaje al almacen para dar la orden
     *
     * @param evt
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ArrayList<String> listaProductos = new ArrayList<>();
        Pedido pedido;

        if (!modelListaDerecha.isEmpty()) {

            for (int i = 0; i < modelListaDerecha.getSize(); i++) {
                listaProductos.add(String.valueOf(modelListaDerecha.getElementAt(i)));
            }

            DataBaseNeodatis dataBaseNeodatis = new DataBaseNeodatis();
            ODB dataBaseConection = dataBaseNeodatis.open();

            ArrayList<Producto> productos = new ArrayList<>();
            Producto producto;

            for (String nombreProducto : listaProductos) {
                producto = this.productoService.findProductByProductNameAndDataBase(nombreProducto, dataBaseConection);

                productos.add(producto);
            }
            pedido = this.pedidoService.createPedido(productos);
            Usuario usuario = this.usuarioService.findByEmailAndDataBase(this.email, dataBaseConection);
            usuario.addPedido(pedido);
            this.usuarioService.saveByDataBaseConnection(usuario, dataBaseConection);
            

            try {
                mandarPedido(pedido);
            } catch (Exception exception) {
                this.labelError.setText(exception.getMessage());
            }

            dataBaseNeodatis.close(dataBaseConection);
            actualizarStock(productos);
            btnAtrasActionPerformed(evt);
        } else {
            this.labelError.setText(ERROR_NO_ELECCION);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * ejecucion del envio del mensaje
     *
     * @param pedido
     */
    public void mandarPedido(Pedido pedido) {
        String jsonString = Serializer.toJson(pedido);
        this.labelError.setText("Pedido realizado correctamente");
        Send.toRabbit(jsonString);
    }

    /**
     * Funcion que actualiza el stock de los productos
     *
     * @param productos
     */
    public void actualizarStock(ArrayList<Producto> productos) {
        int stock;
        for (Producto producto : productos) {
            stock = producto.getStock();
            stock--;
            producto.setStock(stock);
            this.productoService.updateStock(producto);
        }
    }

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
            java.util.logging.Logger.getLogger(CrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new CrearPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListDisponibles;
    private javax.swing.JList<String> jListSeleccionadas;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
}
