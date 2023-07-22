package uni.edu.pe.backend.dao;

import uni.edu.pe.backend.dto.Equipo;
import uni.edu.pe.backend.dto.Goleadores;
import uni.edu.pe.backend.dto.GolesPartidos;

import java.util.List;

public interface AppDao {
    List<GolesPartidos> reporteGolesPartidos();
    List<Goleadores> reporteGoleadores();
    Equipo agregarEquipo(Equipo equipo);
}
