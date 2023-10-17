/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecagrupo5.AccesoADatos;

import bibliotecagrupo5.Entidades.Lector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class LectorData {

    private Connection con = null;

    public LectorData() {

        con = Conexion.getConexion();

    }

    public void guardarLector(Lector lector) {
        String sql = "INSERT INTO lector( nombre, apellido, dni, domicilio, mail, estado)"
                + "VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, lector.getNombre());
            ps.setString(2, lector.getApellido());
            ps.setInt(3, lector.getDNI());
            ps.setString(4, lector.getDomicilio());
            ps.setString(5, lector.getMail());
            ps.setBoolean(6, lector.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                lector.setNroSocio(rs.getInt(1));
//                JOptionPane.showMessageDialog(null, "Lector Guardado");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LeD1 - Error al acceder a la tabla lector: " + ex.getMessage());

        }
    }

    public void modificarLector(Lector lector) {
        String sql = "UPDATE lector SET nombre = ?, apellido = ?, dni=?, domicilio = ?, mail = ? WHERE nroSocio = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lector.getNombre());
            ps.setString(2, lector.getApellido());
            ps.setInt(3, lector.getDNI());
            ps.setString(4, lector.getDomicilio());
            ps.setString(5, lector.getMail());
            ps.setInt(6, lector.getNroSocio());

            int exito = ps.executeUpdate();

            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
//                JOptionPane.showMessageDialog(null, "El lector no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LeD2 - Error al acceder a la tabla Lector: " + ex.getMessage());
        }
    }

    public Lector buscarLectorPorNombreApellido(String nom, String ape) {
        String sql = "SELECT nroSocio,nombre,apellido,dni,domicilio,mail,estado FROM lector WHERE UPPER(nombre) =UPPER (?) AND UPPER(apellido)=UPPER(?) AND estado = 1 ";
        Lector lector = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, ape);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lector.setNroSocio(rs.getInt("nroSocio"));
                lector.setNombre(rs.getString("nombre"));
                lector.setApellido(rs.getString("apellido"));
                lector.setDNI(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setMail(rs.getString("mail"));
                lector.setEstado(rs.getBoolean("estado"));

            } else {
//                JOptionPane.showMessageDialog(null, "No existe el lector");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error LeD3 - Error al acceder a la tabla Lector: " + ex.getMessage());
        }
        return lector;
    }

    public void desactivarLector(int id) {
        String sql = "UPDATE lector SET estado = 0 WHERE nroSocio = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {

//                JOptionPane.showMessageDialog(null, "Lector eliminado");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LeD4 - Error al acceder a la tabla Lector: " + ex.getMessage());
        }
    }

    public void activarLector(int id) {
        String sql = "UPDATE lector SET estado = 1 WHERE nroSocio = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {

//                JOptionPane.showMessageDialog(null, "Lector agregado");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LeD5 - Error al acceder a la tabla Lector: " + ex.getMessage());
        }
    }

    public TreeSet<Lector> listarLector() {
        String sql = "SELECT * FROM lector WHERE estado = 1";

        TreeSet<Lector> lectores = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

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

                lectores.add(lector);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LeD6 - Error al acceder a la tabla Lector: " + ex.getMessage());
        }
        return lectores;
    }

    public Lector buscarLectorPorNroSocio(int nroABuscar) {

        Lector lector = null;
        String sql = "SELECT * FROM lector WHERE nroSocio = ? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroABuscar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lector = new Lector();
                lector.setNroSocio(rs.getInt("nroSocio"));
                lector.setNombre(rs.getString("nombre"));
                lector.setApellido(rs.getString("apellido"));
                lector.setDNI(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setMail(rs.getString("mail"));
                lector.setEstado(rs.getBoolean("estado"));

            } else {
//                JOptionPane.showMessageDialog(null, "No existe el Lector");

                ps.close();
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERROR LeD7 - Error al acceder a la tabla Lector: " + ex.getMessage());

        }
        return lector;

    }

}
