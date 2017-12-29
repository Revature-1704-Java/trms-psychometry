import { Component, OnInit } from '@angular/core';
import {mock} from '../../mock_reimbursements';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  mock_data=mock;
  headers=["id", "EmployeeName","Request Date","Description","Justification","Event cost","Amount Awarded" ,"Urgency"];
  constructor() { }

  ngOnInit() {
  }

}
