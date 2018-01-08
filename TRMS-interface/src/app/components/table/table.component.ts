import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { DataPipelineService } from '../../service/data-pipeline.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() headers: string[];
  @Input() data: Observable<any[]>;
  @Input() user: number;
  @Output() clicked_id: EventEmitter<number> = new EventEmitter<number>();
  constructor(private ds: DataPipelineService, private router: Router) {}
  ngOnInit() {
  }
  onClick(id) {
    this.router.navigate(['/user']);
    this.ds.updateData(id).subscribe((res) => {
      console.log(res);
    });
  }
  onCellClick(id) {
    this.clicked_id.emit(id);
  }
}
