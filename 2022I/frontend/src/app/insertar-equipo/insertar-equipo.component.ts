import { Component, OnInit } from '@angular/core';
import {Equipo} from "../../interfaces";
import {ApiService} from "../../ApiService";

@Component({
  selector: 'app-insertar-equipo',
  templateUrl: './insertar-equipo.component.html',
  styleUrls: ['./insertar-equipo.component.scss']
})
export class InsertarEquipoComponent implements OnInit {
  data: Equipo = {} as Equipo;
  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }
  registrar() {
    console.log("ESTAMOS EN EL REGISTRO EQUIPO");
    this.api.agregarEquipo(this.data).subscribe(data=>{
        console.log("<== respuesta del metodo insert ==>")
        console.log(data.idEquipo)
      }
    )
  }
}
