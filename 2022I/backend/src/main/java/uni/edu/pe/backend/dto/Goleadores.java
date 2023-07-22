package uni.edu.pe.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goleadores {
    private int idJugador;
    private String nombres;
    private String nombreEquipo;
    private int goles;
}
