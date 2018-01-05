import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public login = { username: '', password: '' };
  constructor(private us: UserService) { }

  ngOnInit() {
  }
  onSubmit(): void {
      this.us.login(this.login.username, this.login.password).subscribe(
      (res) => {
        localStorage.setItem('token', res.body.token);
      });
  }
}
