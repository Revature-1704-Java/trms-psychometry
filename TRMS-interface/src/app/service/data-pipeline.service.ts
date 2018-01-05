import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserService } from './user.service';

@Injectable()
export class DataPipelineService {

  constructor(private http: HttpClient) { }

  getData(id: number): Observable<any> {
    const params: HttpParams = new HttpParams().set('id', String(id));
    return this.http.get<any[]>('http://localhost:8080/TRMS_backend/getReimbursements', {params});
  }

}
