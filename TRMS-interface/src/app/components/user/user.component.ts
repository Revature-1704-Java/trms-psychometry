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
  mocks: any[] = [];
  headers: string[] = [];
  user: User;
  constructor(private dataService: DataPipelineService, private us: UserService ) { }
  getUser(): void {
    this.us.getUser().subscribe(
      res => {
        this.getData(res.e_id);
      }
    );
  }
  getData(id): void {
    this.dataService.getData(id).subscribe(
      data => {
        console.log(data);
        this.mocks = data;
        this.headers = Object.keys(data[0]);
      });
  }
  ngOnInit() {
    this.getUser();
  }

}
