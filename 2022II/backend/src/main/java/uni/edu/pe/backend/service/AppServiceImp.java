package uni.edu.pe.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.backend.dao.AppDao;
import uni.edu.pe.backend.dto.Intervalo;
import uni.edu.pe.backend.dto.Lavadoras;
import uni.edu.pe.backend.dto.Refrigeradora;

import java.util.List;
@Service
@Transactional
public class AppServiceImp implements AppService{
    @Autowired
    private AppDao dao;
    @Override
    public List<Lavadoras> reporteLavadoras(Intervalo intervalo) {
        return dao.reporteLavadoras(intervalo);
    }

    @Override
    public Refrigeradora updateFlagFreezer(Refrigeradora refrigeradora) {
        return dao.updateFlagFreezer(refrigeradora);
    }
}
