import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import * as path from "path";
import {ReporteGolesPartidosComponent} from "./reporte-goles-partidos/reporte-goles-partidos.component";
import {ReporteGoleadoresComponent} from "./reporte-goleadores/reporte-goleadores.component";
import {InsertarEquipoComponent} from "./insertar-equipo/insertar-equipo.component";

const routes: Routes = [
  {path: "golesPartidos", component: ReporteGolesPartidosComponent},
  {path: "goleadores", component: ReporteGoleadoresComponent},
  {path: "equipo", component: InsertarEquipoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
