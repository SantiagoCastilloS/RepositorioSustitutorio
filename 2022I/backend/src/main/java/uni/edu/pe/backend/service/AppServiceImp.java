package uni.edu.pe.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.backend.dao.AppDao;
import uni.edu.pe.backend.dto.Equipo;
import uni.edu.pe.backend.dto.Goleadores;
import uni.edu.pe.backend.dto.GolesPartidos;

import java.util.List;
@Service
@Transactional
public class AppServiceImp implements AppService {
    @Autowired
    private AppDao dao;
    @Override
    public List<GolesPartidos> reporteGolesPartidos() {
        return dao.reporteGolesPartidos();
    }

    @Override
    public List<Goleadores> reporteGoleadores() {
        return dao.reporteGoleadores();
    }

    @Override
    public Equipo agregarEquipo(Equipo equipo) {
        return dao.agregarEquipo(equipo);
    }
}
