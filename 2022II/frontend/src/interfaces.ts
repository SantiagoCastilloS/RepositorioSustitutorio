export interface Lavadoras {
  idReparacion: number;
  fechaInicio: string;
  fechaCierre: string;
  costo: number;
  idElectrodomestico: number;
  marca: string;
  anio: number;
  idLavadora: number;
  capacidadLavado: number;
  capacidadSecado: number;
  velocidadCentrifugado: number;
  codigo: string;
  nombreCliente: string;
  nombreTecnico: string;
  codigoEmpleado: string;
}

export interface Intervalo {
  max: number;
  min: number;
}

export interface RespuestaLavadoras {
  lavadoras: Lavadoras[];
}

export interface Refrigeradora {
  tieneFreezer: string;
  capacidadLitros: number;
}
