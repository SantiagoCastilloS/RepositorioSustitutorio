package uni.edu.pe.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GolesPartidos {
    private int idPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private String fecha;
    private String hora;
    private String autorGol;
    private int minuto;
}
