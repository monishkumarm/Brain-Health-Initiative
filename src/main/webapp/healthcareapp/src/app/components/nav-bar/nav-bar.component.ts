import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { LoginService } from 'src/app/services/login.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {AddHospitalComponent} from "../add-hospital/add-hospital.component";
import {AddUserComponent} from "../add-user/add-user.component";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public languages = ['English','हिन्दी','ಕನ್ನಡ'];

  public isLoggedIn = false;
  public isAdmin = false;

  constructor(private loginService:LoginService, private translateService:TranslateService,private dialog: MatDialog){}

  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isLoggedIn();
    this.isAdmin = this.loginService.isAdmin();
  }

  logout(){
    this.loginService.logout();
    location.reload();
  }

  public selectLanguage(event: any){
    var language = event.target.value;
    var langFile = 'en-US';

    if(language == 'हिन्दी'){
      langFile = 'hi-IN';
    }
    else if(language == 'ಕನ್ನಡ'){
      langFile = 'ka-IN';
    }
    localStorage.setItem("language", langFile);
    this.translateService.use(langFile);
  }
  openHospitalDialog(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;

    dialogConfig.data ={
      heading :"Enter Hospital Details"
    }

    this.dialog.open(AddHospitalComponent,dialogConfig);
  }
  openUserDialog(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;

    dialogConfig.data ={
      heading :"Enter User Details"
    }

    this.dialog.open(AddUserComponent,dialogConfig);
  }
}
