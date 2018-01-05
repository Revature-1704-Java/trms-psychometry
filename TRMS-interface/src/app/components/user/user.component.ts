import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http/src/client';
import { DataPipelineService } from '../../service/data-pipeline.service';
import { UserService } from '../../service/user.service';
import { User } from '../../class/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  table: any[] = [];
  user_level: number;
  headers: string[] = ['employee_name', 'type', 'description', 'justification', 'cost', 'urgency', 'status'];
  constructor(private dataService: DataPipelineService, private us: UserService ) { }
  getUser(): void {
    this.us.getUser().subscribe(
      res => {
        this.table = res.reimbursements;
        this.user_level = res.employee_type;
      }
    );
  }

  ngOnInit() {
    this.getUser();
  }

}
