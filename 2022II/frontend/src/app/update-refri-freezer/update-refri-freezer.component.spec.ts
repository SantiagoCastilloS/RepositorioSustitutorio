import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRefriFreezerComponent } from './update-refri-freezer.component';

describe('UpdateRefriFreezerComponent', () => {
  let component: UpdateRefriFreezerComponent;
  let fixture: ComponentFixture<UpdateRefriFreezerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateRefriFreezerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateRefriFreezerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
