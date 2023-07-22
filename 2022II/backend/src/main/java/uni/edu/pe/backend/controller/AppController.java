package uni.edu.pe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.backend.dto.Intervalo;
import uni.edu.pe.backend.dto.Refrigeradora;
import uni.edu.pe.backend.dto.rest.RespuestaLavadoras;
import uni.edu.pe.backend.service.AppService;

@RestController
@CrossOrigin(origins = {"*"})
public class AppController {
    @Autowired
    private AppService service;
    @RequestMapping(
            value="/reporteLavadoras",
            method = RequestMethod.POST
    )
    public @ResponseBody RespuestaLavadoras reporteLavadoras(@RequestBody Intervalo intervalo){
        RespuestaLavadoras rpta = new RespuestaLavadoras();
        rpta.setLavadoras(service.reporteLavadoras(intervalo));
        return rpta;
    }
    @RequestMapping(
            value="/updateFlagFreezer",
            method = RequestMethod.POST
    )
    public Refrigeradora updateFlagFreezer(@RequestBody Refrigeradora refrigeradora){
        return service.updateFlagFreezer(refrigeradora);
    }


}
