import { TestBed } from '@angular/core/testing';

import { LoggedInDataService } from './logged-in-data.service';

describe('LoggedInDataService', () => {
  let service: LoggedInDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoggedInDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
