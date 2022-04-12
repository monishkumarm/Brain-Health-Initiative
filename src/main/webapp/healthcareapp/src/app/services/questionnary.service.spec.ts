import { TestBed } from '@angular/core/testing';

import { QuestionnaryService } from './questionnary.service';

describe('QuestionnaryService', () => {
  let service: QuestionnaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuestionnaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
