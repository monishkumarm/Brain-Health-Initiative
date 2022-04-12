import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerformQuestionnaryComponent } from './perform-questionnary.component';

describe('PerformQuestionnaryComponent', () => {
  let component: PerformQuestionnaryComponent;
  let fixture: ComponentFixture<PerformQuestionnaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerformQuestionnaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PerformQuestionnaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
