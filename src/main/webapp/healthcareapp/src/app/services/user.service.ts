import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'http://localhost:5050';

  constructor(private httpClient:HttpClient) { }

  getUsers(){
    return this.httpClient.get(`${this.url}/getUsers`);
  }

  getSpecialists(){
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpClient.get(`${this.url}/getSpecialists`,{'headers':header});
  }
}
