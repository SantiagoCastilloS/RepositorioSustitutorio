package uni.edu.pe.backend.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uni.edu.pe.backend.dto.Goleadores;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaGoleadores {
    List<Goleadores> goleadores;
}
