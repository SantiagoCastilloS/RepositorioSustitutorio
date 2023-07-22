package uni.edu.pe.backend.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.backend.dto.Intervalo;
import uni.edu.pe.backend.dto.Lavadoras;
import uni.edu.pe.backend.dto.Refrigeradora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AppDaoImp implements AppDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection conexion;
    private void obtenerConexion(){
        try {
            conexion = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cerrarConexion() {
        try {
            conexion.close();
            conexion = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Lavadoras> reporteLavadoras(Intervalo intervalo) {
        List<Lavadoras> lavadoras = new ArrayList<>();
        try{
            obtenerConexion();
            String sql = "SELECT\n" +
                    "\tr.id_reparacion,\n" +
                    "\tr.fecha_inicio,\n" +
                    "\tr.fecha_cierre,\n" +
                    "\tr.costo,\n" +
                    "\te.id_electrodomestico,\n" +
                    "\te.marca,\n" +
                    "\te.anio,\n" +
                    "\tl.id_lavadora,\n" +
                    "\tl.capacidad_lavado,\n" +
                    "\tl.capacidad_secado,\n" +
                    "\tl.velocidad_centrifugado,\n" +
                    "\tl.codigo,\n" +
                    "\tc.nombre 'nombre_cliente',\n" +
                    "\tt.nombre 'nombre_tecnico',\n" +
                    "\tt.codigo_empleado\n" +
                    "FROM electrodomestico e\n" +
                    "INNER JOIN reparacion r ON (r.id_electrodomestico = e.id_electrodomestico)\n" +
                    "INNER JOIN lavadora l ON (l.id_electrodomestico = e.id_electrodomestico)\n" +
                    "INNER JOIN cliente c ON (c.id_cliente = r.id_cliente)\n" +
                    "INNER JOIN tecnico t ON (t.id_tecnico = r.id_tecnico)\n" +
                    "WHERE l.capacidad_lavado >= ? AND l.capacidad_lavado <= ?\n" +
                    "ORDER BY e.anio DESC;";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1,intervalo.getMin());
            st.setInt(2,intervalo.getMax());
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                lavadoras.add(extraerLavadoras(rs));
            }
            rs.close();
            st.close();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lavadoras;
    }

    @Override
    public Refrigeradora updateFlagFreezer(Refrigeradora refrigeradora) {
        String sql = "UPDATE refrigeradora r SET r.tiene_freezer = ? WHERE r.capacidad_litros > ?;";
        try{
            obtenerConexion();
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1,refrigeradora.getTieneFreezer());
            st.setInt(2,refrigeradora.getCapacidadLitros());
            st.executeUpdate();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return refrigeradora;
    }

    private Lavadoras extraerLavadoras(ResultSet rs) throws SQLException{
        Lavadoras lavadoras = new Lavadoras(
                rs.getInt("id_reparacion"),
                rs.getString("fecha_inicio"),
                rs.getString("fecha_cierre"),
                rs.getDouble("costo"),
                rs.getInt("id_electrodomestico"),
                rs.getString("marca"),
                rs.getInt("anio"),
                rs.getInt("id_lavadora"),
                rs.getInt("capacidad_lavado"),
                rs.getInt("capacidad_secado"),
                rs.getInt("velocidad_centrifugado"),
                rs.getString("codigo"),
                rs.getString("nombre_cliente"),
                rs.getString("nombre_tecnico"),
                rs.getString("codigo_empleado")
        );
        return lavadoras;
    }

}
