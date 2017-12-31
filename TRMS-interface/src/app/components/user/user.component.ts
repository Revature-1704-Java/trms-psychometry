import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http/src/client';
import { DataPipelineService } from '../../data-pipeline.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  mocks:any[]=[];
  headers:string[]=[];
  constructor(private dataService:DataPipelineService) { }
  getData():void {
    this.dataService.getData().subscribe(
      data=>{
        this.mocks=data;
        this.headers=Object.keys(data[0]);
      }
    )
  };
  ngOnInit() {
    this.getData();
  }

}
