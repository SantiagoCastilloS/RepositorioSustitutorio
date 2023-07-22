import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../ApiService";
import {Intervalo, Lavadoras} from "../../interfaces";
import {interval} from "rxjs";

@Component({
  selector: 'app-reporte-lavadoras',
  templateUrl: './reporte-lavadoras.component.html',
  styleUrls: ['./reporte-lavadoras.component.scss']
})
export class ReporteLavadorasComponent implements OnInit {
  lista: Lavadoras[] = [];

  max: number = -1;
  min: number = -1;
  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  buscar() {
    const interv: Intervalo = {
      max: this.max,
      min: this.min
    }
    this.api.reporteLavadoras(interv).subscribe(data=>{
      this.lista = data.lavadoras;
      console.log("<==Respuesta==>")
    })
  }

  protected readonly interval = interval;
}
