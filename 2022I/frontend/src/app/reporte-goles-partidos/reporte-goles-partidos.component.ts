import { Component, OnInit } from '@angular/core';
import {GolesPartidos} from "../../interfaces";
import {ApiService} from "../../ApiService";

@Component({
  selector: 'app-reporte-goles-partidos',
  templateUrl: './reporte-goles-partidos.component.html',
  styleUrls: ['./reporte-goles-partidos.component.scss']
})
export class ReporteGolesPartidosComponent implements OnInit {
  lista: GolesPartidos[] = [];
  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.api.reporteGolesPartidos().subscribe(data=>{
      this.lista = data.golesPartidos;
    })
  }

}
