import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGolesPartidosComponent } from './reporte-goles-partidos.component';

describe('ReporteGolesPartidosComponent', () => {
  let component: ReporteGolesPartidosComponent;
  let fixture: ComponentFixture<ReporteGolesPartidosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGolesPartidosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReporteGolesPartidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
