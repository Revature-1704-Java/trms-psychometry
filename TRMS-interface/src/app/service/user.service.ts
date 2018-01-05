import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../class/User';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) {}

  getUser(): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json')
                               .set('Authorization', 'Bearer ' + localStorage.getItem('token'));
    return this.http.get<any>('http://localhost:8080/TRMS_backend/auth', {headers});
  }

  login(username: string, password: string): Observable<any> {
    const params: HttpParams = new HttpParams().set('username', username);
    return this.http.post<any>('http://localhost:8080/TRMS_backend/login', password, { params: params,  observe: 'response' });
  }
}
