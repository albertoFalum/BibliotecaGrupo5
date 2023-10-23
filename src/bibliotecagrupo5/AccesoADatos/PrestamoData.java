package bibliotecagrupo5.AccesoADatos;

import bibliotecagrupo5.Entidades.Condicion;
import bibliotecagrupo5.Entidades.Ejemplar;
import bibliotecagrupo5.Entidades.Lector;
import bibliotecagrupo5.Entidades.Prestamo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author BETO
 */
public class PrestamoData {

    private Connection con = null;
    private LibroData libroData;
    private EjemplarData ejemplarData;
    private LectorData lectorData;

    public PrestamoData() {
        con = Conexion.getConexion("bibliotecagrupo5");
        libroData = new LibroData();
        ejemplarData = new EjemplarData();
        lectorData = new LectorData();
    }

    public void guardarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo(fechaInicio, fechaFin, codigo, nroSocio, estado) VALUES( ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2, Date.valueOf(prestamo.getFechaFin()));
            ps.setInt(3, prestamo.getEjemplar().getCodigo());
            ps.setInt(4, prestamo.getLector().getNroSocio());
            ps.setBoolean(5, prestamo.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                prestamo.setIdPrestamo(rs.getInt(1));
                System.out.println("Prestamo Guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR PD1 - Error al acceder a la tabla Prestamo: " + ex.getMessage());

        }

    }

    public void modificarPrestamo(Prestamo prestamo) {
        String sql = "UPDATE prestamo SET fechaInicio = ?, fechaFin = ?, codigo = ?, nroSocio = ? WHERE idPrestamo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2, Date.valueOf(prestamo.getFechaFin()));
            ps.setInt(3, prestamo.getEjemplar().getCodigo());
            ps.setInt(4, prestamo.getLector().getNroSocio());
            ps.setInt(5, prestamo.getIdPrestamo());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                System.out.println("Modificado Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El Prestamo no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR PD2 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
    }

    public void eliminarPrestamo(int idPresta) {
        String sql = "DELETE FROM prestamo WHERE idPrestamo = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPresta);

            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Libro devuelto");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR PD3 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
    }

    public TreeSet<Lector> obtenerLectoresPrestamoVencido(LocalDate fechaActual) {
        TreeSet<Lector> listaLectorPrestamoVencido = new TreeSet<>();

        try {
            String sql = "SELECT prestamo.nroSocio, nombre, apellido, dni, domicilio, mail, lector.estado FROM prestamo, "
                    + "lector WHERE prestamo.nroSocio=lector.nroSocio AND fechaFin<?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaActual));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lector lector = new Lector();
                lector.setNroSocio(rs.getInt("nroSocio"));
                lector.setNombre(rs.getString("nombre"));
                lector.setApellido(rs.getString("apellido"));
                lector.setDNI(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setMail(rs.getString("mail"));
                lector.setEstado(rs.getBoolean("estado"));

                listaLectorPrestamoVencido.add(lector);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error PD4 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
        return listaLectorPrestamoVencido;
    }

    public TreeSet<Prestamo> obtenerPrestamosVencidos(LocalDate fechaActual) {
        TreeSet<Prestamo> listaPrestamosVencidos = new TreeSet<>();

        try {
            String sql = "SELECT * FROM prestamo WHERE fechaFin<? AND estado=1";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaActual));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                prestamo.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                prestamo.setEjemplar(ejemplarData.buscarEjemplar(rs.getInt("codigo")));
                prestamo.setLector(lectorData.buscarLectorPorNroSocio(rs.getInt("nroSocio")));
                prestamo.setEstado(true);

                listaPrestamosVencidos.add(prestamo);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error PD5 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
        return listaPrestamosVencidos;
    }

    public TreeSet<Ejemplar> obtenerEjemplaresPrestadosPorFecha(LocalDate fecha) {
        TreeSet<Ejemplar> listaEjemplaresPrestados = new TreeSet<>();

        try {
            String sql = "SELECT prestamo.codigo, idLibro, cantidad, estado, condicion FROM prestamo, "
                    + "ejemplar WHERE prestamo.codigo=ejemplar.codigo AND fechaInicio=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(libroData.buscarLibro(rs.getInt("idLibro")));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setEstado(rs.getBoolean("estado"));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));

                listaEjemplaresPrestados.add(ejemplar);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error PD6 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
        return listaEjemplaresPrestados;
    }

    public TreeSet<Ejemplar> obtenerEjemplaresPrestadosPorLector(int nroSocio) {
        TreeSet<Ejemplar> listaEjemplaresPrestadosPorLector = new TreeSet<>();

        try {
            String sql = "SELECT prestamo.codigo, idLibro, cantidad, prestamo.estado, condicion FROM prestamo, "
                    + "ejemplar WHERE prestamo.codigo=ejemplar.codigo AND prestamo.nroSocio=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSocio);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(libroData.buscarLibro(rs.getInt("idLibro")));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setEstado(rs.getBoolean("estado"));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));

                listaEjemplaresPrestadosPorLector.add(ejemplar);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error PD7 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
        return listaEjemplaresPrestadosPorLector;
    }

    public TreeSet<Prestamo> listarPrestamos() {
        String sql = "SELECT * FROM prestamo WHERE estado = 1";

        TreeSet<Prestamo> Prestamos = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                prestamo.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                prestamo.setEjemplar(ejemplarData.buscarEjemplar(rs.getInt("codigo")));
                prestamo.setLector(lectorData.buscarLectorPorNroSocio(rs.getInt("nroSocio")));
                prestamo.setEstado(rs.getBoolean("estado"));
                Prestamos.add(prestamo);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR PD8 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
        return Prestamos;
    }

    public TreeSet<Prestamo> listarPrestamosPorLector(int nroSocioABuscar) {
        String sql = "SELECT * FROM prestamo WHERE nroSocio=? AND estado = 1";

        TreeSet<Prestamo> Prestamos = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroSocioABuscar);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                prestamo.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                prestamo.setEjemplar(ejemplarData.buscarEjemplar(rs.getInt("codigo")));
                prestamo.setLector(lectorData.buscarLectorPorNroSocio(nroSocioABuscar));
                prestamo.setEstado(rs.getBoolean("estado"));
                Prestamos.add(prestamo);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR PD9 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
        return Prestamos;
    }

    public TreeSet<Prestamo> listarPrestamosPorEjemplar(int idLibro) {
        String sql = "SELECT * FROM prestamo p JOIN ejemplar e ON(p.codigo=e.codigo) WHERE e.idLibro=? AND (e.condicion=? OR e.condicion=?)";
        TreeSet<Prestamo> Prestamos = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLibro);
            ps.setString(2, "PRESTADO");
            ps.setString(3, "RETRASO");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                prestamo.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                prestamo.setEjemplar(ejemplarData.buscarEjemplar(rs.getInt("codigo")));
                prestamo.setLector(lectorData.buscarLectorPorNroSocio(rs.getInt("nroSocio")));
                prestamo.setEstado(rs.getBoolean("estado"));
                Prestamos.add(prestamo);

                // Verificar si el préstamo está vencido
//                LocalDate fechaActual = LocalDate.now();
//                if (prestamo.getFechaFin().isBefore(fechaActual) && prestamo.getEjemplar().getCondicion() != Condicion.RETRASO) {
//                    // Actualizar la condición del ejemplar a "Retrasado"
//                    Ejemplar ejemplar = prestamo.getEjemplar();
//                    ejemplar.setCondicion(Condicion.RETRASO);
//                    ejemplarData.modificarEjemplar(ejemplar);
//                }
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR PD10 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
        return Prestamos;
    }
    
    public TreeSet<Prestamo> obtenerPrestamosPorRangoDeFechas(LocalDate fecha1, LocalDate fecha2) {
    TreeSet<Prestamo> listaPrestamos = new TreeSet<>();

    try {
        String sql = "SELECT * FROM prestamo WHERE fechaInicio BETWEEN ? AND ?";

        PreparedStatement ps = con.prepareStatement(sql);
        Date fechaInicio1 = Date.valueOf(fecha1);
        Date fechaInicio2 = Date.valueOf(fecha2);
        ps.setDate(1, fechaInicio1);
        ps.setDate(2, fechaInicio2);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
            prestamo.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            prestamo.setFechaFin(rs.getDate("fechaFin").toLocalDate());
            prestamo.setEjemplar(ejemplarData.buscarEjemplar(rs.getInt("codigo")));
            prestamo.setLector(lectorData.buscarLectorPorNroSocio(rs.getInt("nroSocio")));
            prestamo.setEstado(rs.getBoolean("estado"));
            listaPrestamos.add(prestamo);
        }
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error PD11 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
    }
    return listaPrestamos;
}


}
