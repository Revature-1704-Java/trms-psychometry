import { TestBed, inject } from '@angular/core/testing';

import { DataPipelineService } from './data-pipeline.service';

describe('DataPipelineService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DataPipelineService]
    });
  });

  it('should be created', inject([DataPipelineService], (service: DataPipelineService) => {
    expect(service).toBeTruthy();
  }));
});
