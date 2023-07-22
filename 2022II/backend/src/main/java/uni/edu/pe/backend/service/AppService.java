package uni.edu.pe.backend.service;

import uni.edu.pe.backend.dto.Intervalo;
import uni.edu.pe.backend.dto.Lavadoras;
import uni.edu.pe.backend.dto.Refrigeradora;

import java.util.List;

public interface AppService {
    List<Lavadoras> reporteLavadoras(Intervalo intervalo);
    Refrigeradora updateFlagFreezer(Refrigeradora refrigeradora);
}
