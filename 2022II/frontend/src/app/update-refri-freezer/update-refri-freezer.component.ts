import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../ApiService";
import {Refrigeradora} from "../../interfaces";
import {retry} from "rxjs";

@Component({
  selector: 'app-update-refri-freezer',
  templateUrl: './update-refri-freezer.component.html',
  styleUrls: ['./update-refri-freezer.component.scss']
})
export class UpdateRefriFreezerComponent implements OnInit {
  refrigedor: Refrigeradora = {} as Refrigeradora;
  mensaje: string = "";
  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  actualizar() {
    console.log(this.refrigedor.tieneFreezer)
    console.log(this.refrigedor.capacidadLitros)
    this.api.updateFlagFreezer(this.refrigedor).subscribe(retorno=>{
      this.mensaje = "Las refrigeradoras que tienen mas de" + retorno.capacidadLitros + "como capacidad, ya tiene " + retorno.tieneFreezer + " como freezer";
      console.log(this.mensaje);
    })

  }
}
