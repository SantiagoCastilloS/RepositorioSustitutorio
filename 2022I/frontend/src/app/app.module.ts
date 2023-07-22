import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReporteGolesPartidosComponent } from './reporte-goles-partidos/reporte-goles-partidos.component';
import { ReporteGoleadoresComponent } from './reporte-goleadores/reporte-goleadores.component';
import { InsertarEquipoComponent } from './insertar-equipo/insertar-equipo.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    ReporteGolesPartidosComponent,
    ReporteGoleadoresComponent,
    InsertarEquipoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
