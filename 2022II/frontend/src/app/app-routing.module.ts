import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ReporteLavadorasComponent} from "./reporte-lavadoras/reporte-lavadoras.component";
import {UpdateRefriFreezerComponent} from "./update-refri-freezer/update-refri-freezer.component";

const routes: Routes = [
  {path:"", component:ReporteLavadorasComponent},
  {path:"actualizar", component:UpdateRefriFreezerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
