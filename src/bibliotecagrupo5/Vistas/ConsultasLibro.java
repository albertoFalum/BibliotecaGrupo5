package bibliotecagrupo5.Vistas;

import bibliotecagrupo5.AccesoADatos.LibroData;
import bibliotecagrupo5.Entidades.Libro;
import bibliotecagrupo5.Entidades.Tipo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author BETO
 */
public class ConsultasLibro extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    private LibroData libroData = new LibroData();
    private Libro libro = null;
    private TreeSet<Libro> listaLibros = null;

    /**
     * Creates new form ConsultasLibro
     */
    public ConsultasLibro() {
        initComponents();

        cargarComboOpciones();
        armarCabecera();
        ajustarTamañoColumnas();
        cargarComboTipo();
        borrarTabla();

        jyc1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("year".equals(evt.getPropertyName())) {
                    actualizarTablaAnio();
                }
            }
        });

        jyc2.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("year".equals(evt.getPropertyName())) {
                    actualizarTablaAnio();
                }
            }
        });

        activarDesactivar(false);
        jcbTipo.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbOpcionesBusqueda = new javax.swing.JComboBox<>();
        jLabelEntre = new javax.swing.JLabel();
        jyc1 = new com.toedter.calendar.JYearChooser();
        jLabelY = new javax.swing.JLabel();
        jyc2 = new com.toedter.calendar.JYearChooser();
        jcbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLibros = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 255));
        setTitle("Consulta de Libros");

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setText("Elija una opcion de Busqueda");

        jcbOpcionesBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOpcionesBusquedaActionPerformed(evt);
            }
        });

        jLabelEntre.setText("Entre");

        jLabelY.setText("y");

        jcbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoActionPerformed(evt);
            }
        });

        jTLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTLibros.getTableHeader().setResizingAllowed(false);
        jTLibros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTLibros);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelEntre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jyc1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jyc2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbOpcionesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbOpcionesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jyc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jyc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEntre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbOpcionesBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOpcionesBusquedaActionPerformed

        int opcionElegida = jcbOpcionesBusqueda.getSelectedIndex();
        activarDesactivar(false);
        jcbTipo.setVisible(false);

        try {
            switch (opcionElegida) {

                case 0:
                    borrarTabla();
                    listaLibros = libroData.listarLibros();

                    if (!listaLibros.isEmpty()) {
                        cargarListasTabla(listaLibros);
                    } else {
                        JOptionPane.showMessageDialog(this, "No hay libros cargados para mostrar");
                    }

                    break;

                case 1:
                    borrarTabla();
                    Long isbn = Long.valueOf(JOptionPane.showInputDialog(this, "Ingrese el ISBN a buscar"));

                    if (isbn > 0) {
                        libro = libroData.buscarLibroPorIsbn(isbn);

                        if (libro != null) {
                            cargarTabla(libro);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se encontró libro con el isbn " + isbn);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Debe ingresar un valor mayor a 0");
                    }
                    break;

                case 2:
                    borrarTabla();
                    String titulo = JOptionPane.showInputDialog(this, "Ingrese un titulo");

                    if (titulo != null) {
                        libro = libroData.buscarLibroPorTitulo(titulo);
                        if (libro != null) {
                            cargarTabla(libro);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se encontró libro con ese titulo " + titulo);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Debe ingresar un titulo");
                    }

                    break;

                case 3:
                    borrarTabla();
                    String autor = JOptionPane.showInputDialog(this, "Ingrese el nombre del autor");

                    if (autor != null) {
                        listaLibros = libroData.listarLibrosPorAutor(autor);
                        if (!listaLibros.isEmpty()) {
                            cargarListasTabla(listaLibros);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se encontraron libros del autor " + autor);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Debe ingresar un autor");
                    }

                    break;

                case 4:
                    activarDesactivar(true);
                    break;

                case 5:
                    borrarTabla();
                    jcbTipo.setVisible(true);
                    break;

                case 6:
                    borrarTabla();
                    String editorial = JOptionPane.showInputDialog(this, "Ingrese el nombre de  la editorial");

                    if (editorial != null) {
                        listaLibros = libroData.listarLibrosPorEditorial(editorial);
                        if (!listaLibros.isEmpty()) {
                            cargarListasTabla(listaLibros);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se encontraron libros de la editorial " + editorial);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Debe ingresar una editorial");
                    }

                    break;
                default:
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor numerico ");
        } catch (NullPointerException ex) {
            
        }
    }//GEN-LAST:event_jcbOpcionesBusquedaActionPerformed

    private void jcbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoActionPerformed
        // TODO add your handling code here:
        borrarTabla();
        String tipo = jcbTipo.getSelectedItem().toString();

        listaLibros = libroData.listarLibrosPorTipo(tipo);

        if (!listaLibros.isEmpty()) {
            cargarListasTabla(listaLibros);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron libros de esa categoria");
        }
    }//GEN-LAST:event_jcbTipoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir?",
                "Salir", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (respuesta == 0) {
            dispose();
        }
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEntre;
    private javax.swing.JLabel jLabelY;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTLibros;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbOpcionesBusqueda;
    private javax.swing.JComboBox<Tipo> jcbTipo;
    private com.toedter.calendar.JYearChooser jyc1;
    private com.toedter.calendar.JYearChooser jyc2;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("ISBN");
        modelo.addColumn(("Titulo"));
        modelo.addColumn("Autor");
        modelo.addColumn("Año");
        modelo.addColumn("Tipo");
        modelo.addColumn("Editorial");
        jTLibros.setModel(modelo);
    }

    private void ajustarTamañoColumnas() {
        TableColumn columnaIdLibro = jTLibros.getColumnModel().getColumn(0);
        columnaIdLibro.setPreferredWidth(40);

        TableColumn columnaIsbn = jTLibros.getColumnModel().getColumn(1);
        columnaIsbn.setPreferredWidth(100);

        TableColumn columnaTitulo = jTLibros.getColumnModel().getColumn(2);
        columnaTitulo.setPreferredWidth(150);

        TableColumn columnaAutor = jTLibros.getColumnModel().getColumn(3);
        columnaAutor.setPreferredWidth(150);

        TableColumn columnaAño = jTLibros.getColumnModel().getColumn(4);
        columnaAño.setPreferredWidth(50);

        TableColumn columnaTipo = jTLibros.getColumnModel().getColumn(5);
        columnaTipo.setPreferredWidth(80);

        TableColumn columnaEditorial = jTLibros.getColumnModel().getColumn(6);
        columnaEditorial.setPreferredWidth(120);
    }

    private void cargarTabla(Libro libro) {
        modelo.addRow(new Object[]{libro.getIdLibro(), libro.getIsbn(), libro.getTitulo(),
            libro.getAutor(), libro.getAnio(), libro.getTipo(), libro.getEditorial()});
    }

    private void cargarListasTabla(TreeSet<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            cargarTabla(libro);
        }
    }

    private void borrarTabla() {
        modelo.setRowCount(0);
    }

    private void cargarComboOpciones() {

        jcbOpcionesBusqueda.addItem("Listar todos los Libros");
        jcbOpcionesBusqueda.addItem("Por ISBN");
        jcbOpcionesBusqueda.addItem("Por Titulo");
        jcbOpcionesBusqueda.addItem("Por Autor");
        jcbOpcionesBusqueda.addItem("Por rango de años");
        jcbOpcionesBusqueda.addItem("Por Categoria");
        jcbOpcionesBusqueda.addItem("Por Editorial");
    }

    private void activarDesactivar(boolean bool) {
        jyc1.setVisible(bool);
        jyc2.setVisible(bool);
        jLabelEntre.setVisible(bool);
        jLabelY.setVisible(bool);
    }

    private void cargarComboTipo() {
        jcbTipo.setModel(new DefaultComboBoxModel<>(Tipo.values()));
    }

    private void actualizarTablaAnio() {
        try {
            int anio1 = jyc1.getYear();
            int anio2 = jyc2.getYear();

            borrarTabla();

            listaLibros= libroData.listarLibros();
            List<Libro> listaOrdenada = new ArrayList<>(listaLibros);

            
            Collections.sort(listaOrdenada, Libro.ComparadorPorAnio);

            boolean librosEncontrados = false;

            for (Libro libro : listaOrdenada) {
                int anio = libro.getAnio();
                if (anio >= anio1 && anio <= anio2) {
                    cargarTabla(libro);
                    librosEncontrados = true;
                }
            }

            if (!librosEncontrados) {
                JOptionPane.showMessageDialog(this, "No se encontraron libros en ese rango de años");
            }

        } catch (NumberFormatException e) {
            // Manejo de excepciones
        }
    }
}
