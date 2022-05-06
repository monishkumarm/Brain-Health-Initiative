import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url = 'https://brainhealthinitiativebackend.azurewebsites.net';

  constructor(private httpCLient:HttpClient) { }

  addHospital(hospital:any){
    let token = localStorage.getItem("token");

    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/admin/addHospital`,hospital,{'headers':header});
  }
  addUser(user:any){
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/admin/addUser`,user,{'headers':header});
  }

  getAllOrganizations(){
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.get(`${this.url}/admin/getAllOrganizations`,{'headers':header});
  }
}
