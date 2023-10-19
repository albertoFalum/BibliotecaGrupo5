package bibliotecagrupo5.Vistas;

import bibliotecagrupo5.AccesoADatos.EjemplarData;
import bibliotecagrupo5.AccesoADatos.PrestamoData;
import bibliotecagrupo5.Entidades.Condicion;
import bibliotecagrupo5.Entidades.Ejemplar;
import bibliotecagrupo5.Entidades.Prestamo;
import java.awt.Color;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author BETO
 */
public class ConsultaDemoraFechaDevolucion extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    private PrestamoData prestamoData = null;
    private EjemplarData ejemplarData = null;
    private Ejemplar ejemplarNuevo=null;
    private TreeSet<Prestamo> listaPrestamo = null;

    /**
     * Creates new form ConsultaFechaDevolucion
     */
    public ConsultaDemoraFechaDevolucion() {
        initComponents();
        armarCabecera();
        ajustarTamañoColumnas();
        this.setBackground(Color.getHSBColor(0, 255, 255));
        prestamoData = new PrestamoData();
        ejemplarData = new EjemplarData();
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
        jbLimpiar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLectores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 255));
        setClosable(true);
        setTitle("Consulta Demora Fecha de Devolucion");

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jbLimpiar.setText("Limpiar Tabla");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbConsultar.setText("Consultar");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jTLectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTLectores.getTableHeader().setResizingAllowed(false);
        jTLectores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTLectores);

        jLabel1.setText("Lectores con Prestamos Vencidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jbConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227)
                .addComponent(jbLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConsultar)
                    .addComponent(jbSalir)
                    .addComponent(jbLimpiar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        // TODO add your handling code here:
        borrarTabla();
        LocalDate fechaActual = LocalDate.now();


        try {
            listaPrestamo = prestamoData.obtenerPrestamosVencidos(fechaActual);

            for (Prestamo aux : listaPrestamo) {
                long diferenciaEnDias = aux.getFechaFin().until(fechaActual, ChronoUnit.DAYS);
                

                modelo.addRow(new Object[]{
                    aux.getLector().getNroSocio(),
                    aux.getLector().getNombre(),
                    aux.getLector().getApellido(),
                    aux.getEjemplar().getLibro().getTitulo(),
                    aux.getFechaFin(),
                    fechaActual,
                    diferenciaEnDias,});
                
//                ejemplarNuevo=aux.getEjemplar();
//                ejemplarNuevo.setCondicion(Condicion.RETRASO);
//                ejemplarNuevo.setCantidad(1);
//                ejemplarData.
//                
//                aux.getEjemplar().setCantidad(aux.getEjemplar().getCantidad()-1);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "No hay datos para mostrar: " + ex.getMessage());
        }

    }//GEN-LAST:event_jbConsultarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir?",
                "Salir", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (respuesta == 0) {
            dispose();
        }
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
        borrarTabla();
    }//GEN-LAST:event_jbLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTLectores;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("Nro Socio");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Ejemplar");
        modelo.addColumn("Fin Prestamo");
        modelo.addColumn("Fecha Actual");
        modelo.addColumn("Retraso en (Dias)");
        jTLectores.setModel(modelo);
    }

    private void ajustarTamañoColumnas() {

        TableColumn columnaNroSocio = jTLectores.getColumnModel().getColumn(0);
        columnaNroSocio.setPreferredWidth(60);

        TableColumn columnaNombre = jTLectores.getColumnModel().getColumn(1);
        columnaNombre.setPreferredWidth(120);

        TableColumn columnaApellido = jTLectores.getColumnModel().getColumn(2);
        columnaApellido.setPreferredWidth(80);

        TableColumn columnaEjemplar = jTLectores.getColumnModel().getColumn(5);
        columnaEjemplar.setPreferredWidth(40);

        TableColumn columnaFinPrestamo = jTLectores.getColumnModel().getColumn(3);
        columnaFinPrestamo.setPreferredWidth(40);

        TableColumn columnaFechaActual = jTLectores.getColumnModel().getColumn(4);
        columnaFechaActual.setPreferredWidth(40);
        
        TableColumn columnaRetraso = jTLectores.getColumnModel().getColumn(4);
        columnaRetraso.setPreferredWidth(80);

    }

    private void borrarTabla() {
        modelo.setRowCount(0);
    }
}
