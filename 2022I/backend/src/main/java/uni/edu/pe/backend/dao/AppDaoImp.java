package uni.edu.pe.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.backend.dto.Equipo;
import uni.edu.pe.backend.dto.Goleadores;
import uni.edu.pe.backend.dto.GolesPartidos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AppDaoImp implements AppDao {
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
    public List<GolesPartidos> reporteGolesPartidos() {
        List<GolesPartidos> golesPartidos = new ArrayList<>();
        try{
            obtenerConexion();
            String sql = "SELECT\n" +
                    "\tp.id_partido,\n" +
                    "\tloc.nombre 'equipoLocal',\n" +
                    "\tvis.nombre 'equipoVisitante',\n" +
                    "\tp.fecha,\n" +
                    "\tp.hora,\n" +
                    "\tj.nombres 'autorGol',\n" +
                    "\tg.minuto\n" +
                    "FROM partido p \n" +
                    "INNER JOIN equipo loc ON (loc.id_equipo = p.id_equipo_local)\n" +
                    "INNER JOIN equipo vis ON (vis.id_equipo = p.id_equipo_visitante)\n" +
                    "INNER JOIN goles g ON (g.id_partido = p.id_partido)\n" +
                    "INNER JOIN jugador j ON (g.id_jugador = j.id_jugador)\n" +
                    "ORDER BY p.id_partido, g.minuto;\n";
            PreparedStatement st = conexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                golesPartidos.add(extraerGolesPartidos(rs));
            }
            rs.close();
            st.close();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return golesPartidos;
    }
    @Override
    public List<Goleadores> reporteGoleadores() {
        List<Goleadores> goleadores = new ArrayList<>();
        try{
            obtenerConexion();
            String sql = "SELECT\n" +
                    "    j.id_jugador,\n" +
                    "    j.nombres,\n" +
                    "    e.nombre AS nombre_equipo,\n" +
                    "    COUNT(g.id_jugador) AS goles\n" +
                    "FROM equipo e\n" +
                    "INNER JOIN jugador j ON j.id_equipo = e.id_equipo\n" +
                    "INNER JOIN goles g ON g.id_jugador = j.id_jugador\n" +
                    "GROUP BY j.id_jugador, j.nombres, e.nombre\n" +
                    "HAVING COUNT(g.id_jugador) > 1\n" +
                    "ORDER BY COUNT(g.id_jugador) DESC;";
            PreparedStatement st = conexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                goleadores.add(extraerGoleadores(rs));
            }
            rs.close();
            st.close();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return goleadores;
    }

    @Override
    public Equipo agregarEquipo(Equipo equipo) {
        try {
            obtenerConexion();
            String sql = "INSERT INTO equipo VALUES (?,?,?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1,equipo.getIdEquipo());
            st.setString(2,equipo.getNombre());
            st.setString(3,equipo.getCiudad());
            st.executeUpdate();
            st.close();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return equipo;
    }

    private GolesPartidos extraerGolesPartidos(ResultSet rs) throws SQLException {
        GolesPartidos golesPartidos = new GolesPartidos(
                rs.getInt("id_partido"),
                rs.getString("equipoLocal"),
                rs.getString("equipoVisitante"),
                rs.getString("fecha"),
                rs.getString("hora"),
                rs.getString("autorGol"),
                rs.getInt("minuto")
        );
        return golesPartidos;
    }

    private Goleadores extraerGoleadores(ResultSet rs) throws SQLException {
        Goleadores goleadores = new Goleadores(
                rs.getInt("id_jugador"),
                rs.getString("nombres"),
                rs.getString("nombre_equipo"),
                rs.getInt("goles")
        );
        return goleadores;
    }

}
