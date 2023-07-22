package uni.edu.pe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.backend.dto.Equipo;
import uni.edu.pe.backend.dto.rest.RespuestaGoleadores;
import uni.edu.pe.backend.dto.rest.RespuestaGolesPartidos;
import uni.edu.pe.backend.service.AppService;

@RestController
@CrossOrigin(origins = {"*"})
public class AppController {
    @Autowired
    private AppService service;

    @RequestMapping(
            value="/reporteGolesPartidos",
            method = RequestMethod.POST
    )
    public @ResponseBody RespuestaGolesPartidos reporteGolesPartidos(){
        RespuestaGolesPartidos rpta = new RespuestaGolesPartidos();
        rpta.setGolesPartidos(service.reporteGolesPartidos());
        return rpta;
    }

    @RequestMapping(
            value="/reporteGoleadores",
            method = RequestMethod.POST
    )
    public @ResponseBody RespuestaGoleadores reporteGoleadores(){
        RespuestaGoleadores rpta = new RespuestaGoleadores();
        rpta.setGoleadores(service.reporteGoleadores());
        return rpta;
    }

    @RequestMapping(
            value="/agregarEquipo",
            method = RequestMethod.POST
    )
    public Equipo agregarEquipo(@RequestBody Equipo equipo){
        return service.agregarEquipo(equipo);
    }
}










