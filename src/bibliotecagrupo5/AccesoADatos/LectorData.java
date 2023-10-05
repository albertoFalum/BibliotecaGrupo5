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
        String sql = "INSERT INTO lector( nombre, apellido, domicilio, mail, estado)"
                + "VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, lector.getNombre());
            ps.setString(2, lector.getApellido());
            ps.setString(3, lector.getDomicilio());
            ps.setString(4, lector.getMail());
            ps.setBoolean(5, lector.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                lector.setNroSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Lector Guardado");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD1 - Error al acceder a la tabla lector: " + ex.getMessage());

        }
    }
      public void modificarLector(Lector lector) {
        String sql = "UPDATE lector SET nombre = ?, apellido = ?, domicilio = ?, mail = ?, estado = ? WHERE nroSocio = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, lector.getNroSocio());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getApellido());
            ps.setString(4, lector.getDomicilio());
            ps.setString(5, lector.getMail());
            ps.setBoolean(6, lector.isEstado());
          
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El lector no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD2 - Error al acceder a la tabla Lector: " + ex.getMessage());
        }
    }
       public void eliminarLector(int id) {
        String sql = "UPDATE lector SET estado = 0 WHERE nroSocio = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Lector eliminado");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD3 - Error al acceder a la tabla Lector: " + ex.getMessage());
        }
    }

}
