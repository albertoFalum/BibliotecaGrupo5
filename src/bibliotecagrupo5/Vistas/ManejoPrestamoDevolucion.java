package bibliotecagrupo5.Vistas;

import bibliotecagrupo5.AccesoADatos.EjemplarData;
import bibliotecagrupo5.AccesoADatos.LectorData;
import bibliotecagrupo5.AccesoADatos.PrestamoData;
import bibliotecagrupo5.Entidades.Condicion;
import bibliotecagrupo5.Entidades.Ejemplar;
import bibliotecagrupo5.Entidades.Lector;
import bibliotecagrupo5.Entidades.Prestamo;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author BETO
 */
public class ManejoPrestamoDevolucion extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    private LectorData lectorData = null;
    private EjemplarData ejemplarData = null;
    private PrestamoData prestamoData = null;
    private TreeSet<Lector> listaLector = null;
    private TreeSet<Ejemplar> listaEjemplar = null;

    /**
     * Creates new form ManejoPrestamoDevolucion
     */
    public ManejoPrestamoDevolucion() {
        initComponents();
        armarCabecera();
        ajustarTamañoColumnas();

        lectorData = new LectorData();
        ejemplarData = new EjemplarData();
        prestamoData = new PrestamoData();

        cargarComboLector();
        cargarComboEjemplar();

        borrarTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbLector = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPrestamo = new javax.swing.JTable();
        jbPrestar = new javax.swing.JButton();
        jbDevolver = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jdchFechaInicio = new com.toedter.calendar.JDateChooser();
        jdchFechaFin = new com.toedter.calendar.JDateChooser();
        jcbEjemplar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbMostrarPrestamos = new javax.swing.JButton();

        setClosable(true);
        setTitle("Prestamos y Devoluciones");

        jLabel1.setText("Seleccione un Lector:");

        jcbLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLectorActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione un Ejemplar");

        jTPrestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTPrestamo.getTableHeader().setResizingAllowed(false);
        jTPrestamo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTPrestamo);

        jbPrestar.setText("PRESTAR");
        jbPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrestarActionPerformed(evt);
            }
        });

        jbDevolver.setText("Devolver");
        jbDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDevolverActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Formulario Prestamos y Devoluciones");

        jcbEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEjemplarActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Inicio:");

        jLabel5.setText("Fecha Fin:");

        jbMostrarPrestamos.setText("Mostrar Prestamos");
        jbMostrarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarPrestamosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jdchFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdchFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbEjemplar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbLector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jbPrestar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jbMostrarPrestamos)
                        .addGap(124, 124, 124)
                        .addComponent(jbDevolver)
                        .addGap(173, 173, 173)
                        .addComponent(jbSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcbLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcbEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jbPrestar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jdchFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdchFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMostrarPrestamos)
                    .addComponent(jbDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrestarActionPerformed
        // TODO add your handling code here:
        try {
            borrarTabla();

            Lector lector = (Lector) jcbLector.getSelectedItem();
            Ejemplar ejemplar = (Ejemplar) jcbEjemplar.getSelectedItem();
            LocalDate fechaInicio = jdchFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaFin = jdchFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (fechaFin.isAfter(fechaInicio)) {
                if (ejemplar.getCantidad() >= 1) {

                    Prestamo prestamo = null;

                    Ejemplar ejemplarBuscado = ejemplarData.BuscarEjemplarIdLibroYCondicion(ejemplar.getLibro().getIdLibro(), Condicion.PRESTADO);

                    if (ejemplarBuscado == null) {

                        Ejemplar ejemplarPrestado = new Ejemplar(ejemplar.getLibro(), 1, true, Condicion.PRESTADO);
                        ejemplarData.guardarEjemplar(ejemplarPrestado);
                        prestamo = new Prestamo(fechaInicio, fechaFin, ejemplarPrestado, lector, true);

                    } else {

                        ejemplarBuscado.setCantidad(ejemplarBuscado.getCantidad() + 1);
                        ejemplarData.modificarEjemplar(ejemplarBuscado);
                        prestamo = new Prestamo(fechaInicio, fechaFin, ejemplarBuscado, lector, true);

                    }

                    prestamoData.guardarPrestamo(prestamo);
                    borrarCampos();
                    cargarTabla(prestamo);

                    ejemplar.setCantidad(ejemplar.getCantidad() - 1);
                    ejemplarData.modificarEjemplar(ejemplar);

                    JOptionPane.showMessageDialog(this, "Prestamo Guardado");

                    cargarComboEjemplar();

                } else {
                    JOptionPane.showMessageDialog(this, "No exiten ejemplares para prestar");
                }
            } else {
                JOptionPane.showMessageDialog(this, "La fecha de devolucion debe ser posterior a la fecha de prestamo");
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "MPD 1 - No hay datos cargados " + ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_jbPrestarActionPerformed

    private void jbDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDevolverActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jTPrestamo.getSelectedRow();
        try {
            if (filaSeleccionada != -1) {

                int idPrestamo = (int) jTPrestamo.getValueAt(filaSeleccionada, 0);
                int codigo = (int) jTPrestamo.getValueAt(filaSeleccionada, 2);

                Ejemplar ejemplarPrestado = ejemplarData.buscarEjemplar(codigo);

                prestamoData.eliminarPrestamo(idPrestamo);

                ejemplarPrestado.setCantidad(ejemplarPrestado.getCantidad() - 1);
                ejemplarData.modificarEjemplar(ejemplarPrestado);

                Ejemplar ejemplarDisponible = ejemplarData.BuscarEjemplarIdLibroYCondicion(ejemplarPrestado.getLibro().getIdLibro(), Condicion.DISPONIBLE);
                ejemplarDisponible.setCantidad(ejemplarDisponible.getCantidad() + 1);
                ejemplarData.modificarEjemplar(ejemplarDisponible);
                cargarComboEjemplar();

                borrarTabla();
                cargarTablaLista(prestamoData.listarPrestamos());

            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "MPD 2 - No hay datos cargados " + ex.getMessage());
        }
    }//GEN-LAST:event_jbDevolverActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir?",
                "Salir", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (respuesta == 0) {
            dispose();
        }
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLectorActionPerformed
        // TODO add your handling code here:
        borrarTabla();
        try {
            Lector lector = (Lector) jcbLector.getSelectedItem();

            TreeSet<Prestamo> listaPrestamosLector = prestamoData.listarPrestamosPorLector(lector.getNroSocio());
            cargarTablaLista(listaPrestamosLector);
        } catch (NullPointerException ex) {
            borrarTabla();
        }


    }//GEN-LAST:event_jcbLectorActionPerformed

    private void jcbEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEjemplarActionPerformed
        // TODO add your handling code here:
        borrarTabla();
        try {
            Ejemplar ejemplar = (Ejemplar) jcbEjemplar.getSelectedItem();
            int idLibro = ejemplar.getLibro().getIdLibro();

            TreeSet<Prestamo> listaPrestamosEjemplar = prestamoData.listarPrestamosPorEjemplar(idLibro);
            cargarTablaLista(listaPrestamosEjemplar);
        } catch (NullPointerException ex) {
            borrarTabla();
        }

    }//GEN-LAST:event_jcbEjemplarActionPerformed

    private void jbMostrarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarPrestamosActionPerformed
        // TODO add your handling code here:
        try {
            borrarTabla();
            cargarTablaLista(prestamoData.listarPrestamos());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No hay prestamos para mostrar");
        }

    }//GEN-LAST:event_jbMostrarPrestamosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPrestamo;
    private javax.swing.JButton jbDevolver;
    private javax.swing.JButton jbMostrarPrestamos;
    private javax.swing.JButton jbPrestar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Ejemplar> jcbEjemplar;
    private javax.swing.JComboBox<Lector> jcbLector;
    private com.toedter.calendar.JDateChooser jdchFechaFin;
    private com.toedter.calendar.JDateChooser jdchFechaInicio;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("ID Prestamo");
        modelo.addColumn("Nro Socio");
        modelo.addColumn("Cod Ejemplar");
        modelo.addColumn("Titulo Libro");
        modelo.addColumn("Fecha Prestamo");
        modelo.addColumn("Fecha Finalizacion");
        jTPrestamo.setModel(modelo);
    }

    private void ajustarTamañoColumnas() {
        TableColumn columnaIdPrestamo = jTPrestamo.getColumnModel().getColumn(0);
        columnaIdPrestamo.setPreferredWidth(50);

        TableColumn columnaNroSocio = jTPrestamo.getColumnModel().getColumn(1);
        columnaNroSocio.setPreferredWidth(40);

        TableColumn columnaCodigoEjemplar = jTPrestamo.getColumnModel().getColumn(2);
        columnaCodigoEjemplar.setPreferredWidth(40);

        TableColumn columnaTitulo = jTPrestamo.getColumnModel().getColumn(5);
        columnaTitulo.setPreferredWidth(150);

        TableColumn columnaFechaInicio = jTPrestamo.getColumnModel().getColumn(3);
        columnaFechaInicio.setPreferredWidth(90);

        TableColumn columnaFechaFin = jTPrestamo.getColumnModel().getColumn(4);
        columnaFechaFin.setPreferredWidth(90);

    }

    private void cargarTabla(Prestamo prestamo) {

        modelo.addRow(new Object[]{prestamo.getIdPrestamo(),
            prestamo.getLector().getNroSocio(),
            prestamo.getEjemplar().getCodigo(),
            prestamo.getEjemplar().getLibro().getTitulo(),
            prestamo.getFechaInicio(), prestamo.getFechaFin()});

    }

    private void cargarTablaLista(TreeSet<Prestamo> listaPrestamos) {
        for (Prestamo prestamo : listaPrestamos) {
            cargarTabla(prestamo);
        }
    }

    private void borrarTabla() {
        modelo.setRowCount(0);
    }

    private void borrarCampos() {
        jdchFechaInicio.setDate(null);
        jdchFechaFin.setDate(null);
    }

    private void cargarComboLector() {
        try {
            listaLector = lectorData.listarLector();
            for (Lector lector : listaLector) {
                jcbLector.addItem(lector);
            }
        } catch (NullPointerException ex) {

        }

    }

    private void cargarComboEjemplar() {

        jcbEjemplar.removeAllItems();
        try {
            listaEjemplar = ejemplarData.listarEjemplaresPorCondicion(Condicion.DISPONIBLE);

            for (Ejemplar ejemplar : listaEjemplar) {
                if (ejemplar.getCantidad() >= 1) {
                    jcbEjemplar.addItem(ejemplar);
                }
            }
        } catch (NullPointerException ex) {

        }
    }
}
