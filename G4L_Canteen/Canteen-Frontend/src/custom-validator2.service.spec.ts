import { TestBed } from '@angular/core/testing';

import { CustomValidator2Service } from './custom-validator2.service';

describe('CustomValidator2Service', () => {
  let service: CustomValidator2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomValidator2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
