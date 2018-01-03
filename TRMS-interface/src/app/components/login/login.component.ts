import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public login = { username: '', password: '' };
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }
  onSubmit(): void {
    const params: HttpParams = new HttpParams().set('username', this.login.username);
    this.http.post<any>('http://localhost:8080/TRMS_backend/login', this.login.password, { params:params,  observe: 'response' }).subscribe(
      (res) => {
        console.log(res.headers);
        console.log(res);
      });
  }
}
