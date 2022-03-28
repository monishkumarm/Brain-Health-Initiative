import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddConsultationDetailsComponent } from './add-consultation-details.component';

describe('AddConsultationDetailsComponent', () => {
  let component: AddConsultationDetailsComponent;
  let fixture: ComponentFixture<AddConsultationDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddConsultationDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddConsultationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
