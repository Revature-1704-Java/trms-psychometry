import { Component, OnInit, Input} from '@angular/core';
import { DataPipelineService } from '../../service/data-pipeline.service';
import { Observable } from 'rxjs/Observable';
import { Event } from '../../class/event';
import { OnChanges } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit, OnChanges {
  EventDetail: Observable<Event[]>;
  g_formats: Object= {
    1: 'Presentation',
    2: 'Grades'
  };
  @Input() clicked_id: number;
  constructor(private ds: DataPipelineService) { }

  ngOnInit() {
    if (this.clicked_id > 0 ) {
      this.EventDetail = this.ds.getData(this.clicked_id);
    }
  }
  ngOnChanges() {
    if (this.clicked_id > 0 ) {
      this.EventDetail = this.ds.getData(this.clicked_id);
      this.ds.getData(this.clicked_id).subscribe(res=>console.log(res));
    }
  }

}
