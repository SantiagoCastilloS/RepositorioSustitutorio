import { Component, OnInit } from '@angular/core';
import {Goleadores} from "../../interfaces";
import {ApiService} from "../../ApiService";

@Component({
  selector: 'app-reporte-goleadores',
  templateUrl: './reporte-goleadores.component.html',
  styleUrls: ['./reporte-goleadores.component.scss']
})
export class ReporteGoleadoresComponent implements OnInit {
  lista: Goleadores[] = [];
  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.api.reporteGoleadores().subscribe(data=>{
      this.lista = data.goleadores;
    })
  }

}
