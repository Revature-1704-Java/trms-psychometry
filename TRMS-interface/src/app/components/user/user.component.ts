import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http/src/client';
import { DataPipelineService } from '../../service/data-pipeline.service';
import { UserService } from '../../service/user.service';
import { User } from '../../class/user';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import 'rxjs/add/observable/from';
import { OnChanges } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit, OnChanges {
  showForm = false;
  table: Observable<any[]>;
  user_level: number;
  username= '';
  clicked_id= -1;
  headers: string[] = ['employee_name', 'type', 'description', 'justification', 'cost', 'urgency', 'status'];
  constructor(private us: UserService, private router: Router) { }
  getUser(): void {
    this.us.getUser().subscribe(
      res => {
        this.table = res.reimbursements;
        this.user_level = res.employee_type;
        this.username = res.firstName + ' ' + res.lastName;
      },
      err => {
        this.router.navigate(['/login']);
      }
    );
  }
  ngOnInit() {
    this.getUser();
  }
  ngOnChanges() {
    this.getUser();
  }
  handleCellClick(event) {
    this.showForm = false;
    this.clicked_id = event;
  }
  addForm() {
    this.showForm = true;
  }
  logOut(){
    this.us.logout();
    this.router.navigate(['/login']);
  }

}
