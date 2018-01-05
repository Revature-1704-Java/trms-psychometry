import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isAuth: boolean;
  user: User;
  constructor(private us: UserService) { }
  ngOnInit() {
    this.isAuth = localStorage.getItem('token') != null;
    this.user.getUser().subscribe(
      (res) => {},
      (err) => {this.isAuth = false; }
  );
  }

}
