import { HttpClient, HttpHandler, HttpHeaders, HttpParams } from '@angular/common/http';
import { Token } from '@angular/compiler';
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
    return this.httpCLient.get(`${this.url}/getAllPatients`,{'headers':header});
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

  getSearchPatients(option:any){
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/getSearchPatients`,option,{'headers':header});
  }

  updatePatient(patientDetails:any){
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/updatePatient`,patientDetails,{'headers':header})
  }

  addConsultion(consulatationDetails:any,ABHAID:any){
    let token = localStorage.getItem("token");
    let params = new HttpParams();
    params = params.append('abhaId',ABHAID);
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/patients/addConsultation`,consulatationDetails,{'headers':header,'params':params})
  }

  getAllConsultationsByPatient(patientId:any){
    console.log("In get consultation service")
    let token = localStorage.getItem("token");
    let params = new HttpParams();
    console.log(patientId)
    params = params.append('patientId',patientId);
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.get(`${this.url}/patients/getAllConsultations`,{'headers':header,'params':params})
  }
}
  