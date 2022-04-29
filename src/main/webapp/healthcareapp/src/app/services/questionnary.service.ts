import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuestionnaryService {

  url = 'http://localhost:5050';
  constructor(private httpCLient:HttpClient) { }
  getCommanQuestions(){
    console.log("In get Comman Question service")
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.get(`${this.url}/getCommonQuestions`,{'headers':header})
  }

  getNextQuestions(Answer:any){
    console.log("In get next question service");
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/getNextQuestions`,Answer,{'headers':header})
  }

  saveAnswers(Answers:any){
    console.log("in save answer service");
    let token = localStorage.getItem("token");
    let header = new HttpHeaders(
      {
        Authorization  : "Bearer " + token
      }
    )
    return this.httpCLient.post(`${this.url}/saveAnswers`,Answers,{'headers':header})
  }
}

