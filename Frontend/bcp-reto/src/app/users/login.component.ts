import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import { User } from './user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  page_title:string = 'Reto BCP: Login';
  user:User;

  constructor(private titleService:Title, private router: Router) { 
    this.titleService.setTitle(this.page_title);
    this.user = new User();
    console.log(this.user);
  }

  ngOnInit(): void {
  }

  login(): void {
    console.log(this.user);
  }

}
