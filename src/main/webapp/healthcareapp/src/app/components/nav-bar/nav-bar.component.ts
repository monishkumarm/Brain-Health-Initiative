import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public languages = ['English','हिन्दी','ಕನ್ನಡ'];

  public isLoggedIn = false;

  constructor(private loginService:LoginService, private translateService:TranslateService){}

  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isLoggedIn(); 
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
}
