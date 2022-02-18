import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public isLoggedIn = false;

  constructor(private loginService:LoginService){}

  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isLoggedIn(); 
  }

  logout(){
    this.loginService.logout();
    location.reload();
  }

}
