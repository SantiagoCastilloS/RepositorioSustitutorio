package uni.edu.pe.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lavadoras {
    private int idReparacion;
    private String fechaInicio;
    private String fechaCierre;
    private double costo;
    private int idElectrodomestico;
    private String marca;
    private int anio;
    private int idLavadora;
    private int capacidadLavado;
    private int capacidadSecado;
    private int velocidadCentrifugado;
    private String codigo;
    private String nombreCliente;
    private String nombreTecnico;
    private String codigoEmpleado;
}
