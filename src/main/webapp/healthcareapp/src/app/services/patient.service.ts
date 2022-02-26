import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})


export class PatientService {

  url = 'http://localhost:5050';

  constructor(private httpCLient:HttpClient) { }

  getAllPatients(){
    let token = localStorage.getItem("token");
    console.log(token);
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.get(`${this.url}/getAllPatientByUser`,{'headers':header});
  }

  addPatient(patientDetails:any){
    let token = localStorage.getItem("token");
    console.log(token);
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/addPatient`,patientDetails,{'headers':header});
  }
}
  