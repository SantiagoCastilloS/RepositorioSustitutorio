package uni.edu.pe.backend.dao;

import uni.edu.pe.backend.dto.Intervalo;
import uni.edu.pe.backend.dto.Lavadoras;
import uni.edu.pe.backend.dto.Refrigeradora;

import java.sql.Ref;
import java.util.List;

public interface AppDao {
    List<Lavadoras> reporteLavadoras(Intervalo intervalo);
    Refrigeradora updateFlagFreezer(Refrigeradora refrigeradora);
}
