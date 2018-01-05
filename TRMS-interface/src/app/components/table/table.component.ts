import { Component, OnInit, Input } from '@angular/core';
import { DataPipelineService } from '../../service/data-pipeline.service';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() headers: string[];
  @Input() data: any[];
  @Input() user: number;
  constructor(private ds: DataPipelineService) {}
  ngOnInit() {
  }
  onClick(id) {
    this.ds.updateData(id).subscribe(() => {});
  }
}
