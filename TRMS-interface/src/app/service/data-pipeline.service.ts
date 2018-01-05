import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserService } from './user.service';
import { Request } from '../class/request';

@Injectable()
export class DataPipelineService {

  constructor(private http: HttpClient) { }

  getData(id: number): Observable<any> {
    const params: HttpParams = new HttpParams().set('id', String(id));
    return this.http.get<any[]>('http://localhost:8080/TRMS_backend/getReimbursements', {params});
  }
  postData(request: Request): Observable<Request> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json')
                               .set('Authorization', 'Bearer ' + localStorage.getItem('token'));
    return this.http.post<Request>('http://localhost:8080/TRMS_backend/postAddReimbursement', request, {headers});
  }
  updateData(id): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json')
                               .set('Authorization', 'Bearer ' + localStorage.getItem('token'));
    const params: HttpParams = new HttpParams().set('id', String(id));
    return this.http.post<Request>('http://localhost:8080/TRMS_backend/postUpdateStatus', ' ', {headers, params});
  }

}
