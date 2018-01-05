import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http/src/client';
import { DataPipelineService } from '../../service/data-pipeline.service';
import { UserService } from '../../service/user.service';
import { User } from '../../class/user';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  showForm = false;
  table: any[] = [];
  user_level: number;
  headers: string[] = ['employee_name', 'type', 'description', 'justification', 'cost', 'urgency', 'status'];
  constructor(private us: UserService, private router: Router) { }
  getUser(): void {
    this.us.getUser().subscribe(
      res => {
        this.table = res.reimbursements;
        this.user_level = res.employee_type;
      },
      err => {
        this.router.navigate(['/login']);
      }
    );
  }
  ngOnInit() {
    this.getUser();
  }
  addForm() {
    this.showForm = true;
  }

}
