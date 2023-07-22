import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteLavadorasComponent } from './reporte-lavadoras.component';

describe('ReporteLavadorasComponent', () => {
  let component: ReporteLavadorasComponent;
  let fixture: ComponentFixture<ReporteLavadorasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteLavadorasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReporteLavadorasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
