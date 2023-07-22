import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReporteLavadorasComponent } from './reporte-lavadoras/reporte-lavadoras.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import { UpdateRefriFreezerComponent } from './update-refri-freezer/update-refri-freezer.component';

@NgModule({
  declarations: [
    AppComponent,
    ReporteLavadorasComponent,
    UpdateRefriFreezerComponent
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
