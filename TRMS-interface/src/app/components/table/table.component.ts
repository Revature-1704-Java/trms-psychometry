import { Component, OnInit, Input } from '@angular/core';
import {Reimbursement} from '../../Reimbursement';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() headers:string[];
  @Input() data:Reimbursement[];
  constructor() {}
  ngOnInit() {
  }
  objectKeys(obj){
    return Object.keys(obj)
  }
}
