import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials={
    username:'',
    password:''
  }

  isError = false;
  errorMsg = '';

  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  onSubmit(){

    if(this.credentials.username != '' && this.credentials.password != ''){
      this.loginService.generateToken(this.credentials).subscribe(
        (response:any) => {
          this.isError = false;
          this.errorMsg = '';
          console.log(response.token);

          this.loginService.loginUser(response.token);
          window.location.href="/dashboard";
        },
        (error:any) => {
          this.isError = true;
          this.errorMsg = error.error.message;
          console.log(error.error.message);

        }
      );
    }
    else{

    }
  }

}
