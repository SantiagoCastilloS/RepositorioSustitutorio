package uni.edu.pe.backend.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uni.edu.pe.backend.dto.GolesPartidos;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaGolesPartidos {
    List<GolesPartidos> golesPartidos;
}
