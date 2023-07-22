import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertarEquipoComponent } from './insertar-equipo.component';

describe('InsertarEquipoComponent', () => {
  let component: InsertarEquipoComponent;
  let fixture: ComponentFixture<InsertarEquipoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertarEquipoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertarEquipoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
