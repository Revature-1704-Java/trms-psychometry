import { Component, OnInit, Input } from '@angular/core';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() headers:string[];
  @Input() data:any[];
  constructor() {}
  ngOnInit() {
    console.log(this.data);
  }
  objectKeys(obj){
    return Object.keys(obj)
  }
}
