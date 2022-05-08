import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url = 'http://localhost:5050';

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
  getSummary(){
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.get(`${this.url}/admin/getSummary`,{'headers':header});
  }
  getDiagnosisChartData(){
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.get(`${this.url}/admin/getDiagnosisChartData`,{'headers':header});
  }
}
