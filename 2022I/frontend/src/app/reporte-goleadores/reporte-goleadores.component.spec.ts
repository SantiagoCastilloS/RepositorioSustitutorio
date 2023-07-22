import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGoleadoresComponent } from './reporte-goleadores.component';

describe('ReporteGoleadoresComponent', () => {
  let component: ReporteGoleadoresComponent;
  let fixture: ComponentFixture<ReporteGoleadoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGoleadoresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReporteGoleadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
