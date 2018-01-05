import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { UserService } from '../../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public login = { username: '', password: '' };
  public loggedin = false;
  public error = '';
  constructor(private us: UserService, private router:Router) { }

  ngOnInit() {
    this.us.logout();
  }
  onSubmit(): void {
      this.us.login(this.login.username, this.login.password).subscribe(
      (res) => {
        if (res.body.token) {
          localStorage.setItem('token', res.body.token);
          this.loggedin = true;
          this.router.navigate(['/']);
        }else {
          this.error = 'Log in failed';
          this.loggedin = false;
        }
      },
      (err) => {
        this.error = 'Log in failed';
        this.loggedin = false;
      });
  }
}
