package uni.edu.pe.backend.service;

import uni.edu.pe.backend.dto.Equipo;
import uni.edu.pe.backend.dto.Goleadores;
import uni.edu.pe.backend.dto.GolesPartidos;

import java.util.List;

public interface AppService {
    List<GolesPartidos> reporteGolesPartidos();
    List<Goleadores> reporteGoleadores();
    Equipo agregarEquipo(Equipo equipo);
}
