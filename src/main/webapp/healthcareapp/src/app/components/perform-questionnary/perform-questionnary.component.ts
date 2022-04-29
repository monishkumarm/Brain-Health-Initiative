import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { QuestionnaryService } from 'src/app/services/questionnary.service';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';
import {FormControl} from '@angular/forms';
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition,} from '@angular/material/snack-bar';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-perform-questionnary',
  templateUrl: './perform-questionnary.component.html',
  styleUrls: ['./perform-questionnary.component.css']
})
export class PerformQuestionnaryComponent implements OnInit {


  tabs:any;
  Answers:any;
  Questions:any;
  Question:any;
  GroupId:any;
  SubGroupId:any;
  isSave:any;
  Answer:any;
  isResult:any;
  Result:any;
  selected = new FormControl(0);
 
  patientDetails={
    Id:'',
    ABHAID:'',
    fname:'',
    lname:'',
    gender:'',
    age:'',
    lan:'',
    edu:'',
    occ:'',
    email:'',
    phone:'',
    addLine1:'',
    addLine2:'',
    district:'',
    state:'',
    pin:'',
    carer_name:'',
    carer_rel:'',
  }

  search = {
    option : '4',
    value : '',
  };



  constructor(  private questionnaryService:QuestionnaryService,
                private activatedroute:ActivatedRoute,
                private patientService:PatientService,
                private _snackBar: MatSnackBar,
                private dataService:DataService,
              ) { }

  ngOnInit(): void {

    this.isResult = false;
    this.activatedroute.queryParams.subscribe(
      (params:any) => {
      console.log(params); // { orderby: "price" }
      this.search.value = params['id'];
      }
    );


    this.patientService.getSearchPatients(this.search).subscribe(
      (response:any) => {
        // console.log(response);
        this.patientDetails.Id = response[0].id;
        this.patientDetails.ABHAID = response[0].abhaId;
        this.patientDetails.fname = response[0].firstName;
        this.patientDetails.lname = response[0].lastName;
        this.patientDetails.gender = response[0].gender.toLocaleString();
        this.patientDetails.age = response[0].age;
        this.patientDetails.lan = response[0].languages;
        this.patientDetails.edu = response[0].education;
        this.patientDetails.occ = response[0].occupation;
        this.patientDetails.email = response[0].email;
        this.patientDetails.phone = response[0].phoneNumber;
        this.patientDetails.addLine1 = response[0].addressDetail.addLine1;
        this.patientDetails.addLine2 = response[0].addressDetail.addLine2;
        this.patientDetails.district = response[0].addressDetail.district;
        this.patientDetails.state = response[0].addressDetail.state;
        this.patientDetails.pin = response[0].addressDetail.pin;
        this.patientDetails.carer_name = response[0].informantCaregiverName;
        this.patientDetails.carer_rel = response[0].relationshipWithPatient
        console.log(this.patientDetails);
      },
      (error:any) =>  {
        console.log(error);
      }
    );

    this.tabs = [];
    this.Questions = [];
    this.Answers = [];
    this.isSave = [];
    this.isResult = [];
    this.questionnaryService.getCommanQuestions().subscribe(
      (response:any) => {
        this.Answer= {};
        this.Question = '{ "groupId":' + response["groupId"] + ', "subGroupId":' + response["subGroupId"] +',';
        this.Question = this.Question + '"' + response["questionSetName"] + '":' + JSON.stringify(response["questionSet"]) + '}';
        // response["isSave"]=false;
        this.Questions.push(JSON.parse(this.Question));

        for(let option in response["questionSet"])
        {
            this.Answer[response["questionSet"][option].id.toString()]='';
        }
        this.Answer = '{ "groupId":' + response["groupId"] + ', "subGroupId":' + response["subGroupId"] +',"questionsAnswers":' + JSON.stringify(this.Answer)+'}';
        this.tabs.push(response["questionSetName"]);
        this.Answers.push(JSON.parse(this.Answer));
        for(let question in this.Questions[0][response["questionSetName"]])
        { 
          let id = this.Questions[0][response["questionSetName"]][question].id;
        
          // console.log(this.Questions[0][response["questionSetName"]][question].questionnaireOptionsById.slice(-1)[0].id);
          this.Answers[0]["questionsAnswers"][id]=this.Questions[0][response["questionSetName"]][question].questionnaireOptionsById.slice(-1)[0].id;
        }
        console.log(this.Answers);
        // Answers[index][tab][questions.id]
        this.isSave.push(false);
        this.isResult.push(false);
        console.log("data");
        console.log(this.Questions);
        console.log(this.Answers);
        console.log(this.tabs);
        console.log(this.isSave);
        window.scroll({
          top: 0,
          left: 0,
          behavior: 'smooth'
        });
        if(response["message"].length>0){
          this._snackBar.open(response["message"], 'Close', {
            duration: 3000,
            horizontalPosition: 'center',
            verticalPosition: 'top',
          });
        }
      },
      (error:any) => {
        console.log(error);
      }
      );

  }

  optionSave(index:any)
  {
    this.isSave[index]=!this.isSave[index];
  }

  optionSaveAndNext(index:any)
  {
    
    console.log(this.Answers);
    this.tabs = this.tabs.slice(0,index+1);
    this.Questions = this.Questions.slice(0,index+1);
    this.Answers = this.Answers.slice(0,index+1);
    this.isSave = this.isSave.slice(0,index+1);
    this.isResult = this.isResult.slice(0,index+1);
    this.isSave[index]=true;
    console.log(this.Answers);
    console.log(this.Answers[index]);
    this.questionnaryService.getNextQuestions(this.Answers[index],).subscribe(
      (response:any) => {
        console.log(response);
        if(response["questionSetName"] == null)
        {
          this.isResult.push(true);
          this.Result = '';
          this.Result = response["message"];
          this.tabs.push("protocolResult");
          this.selected.setValue(this.tabs.length - 1);
          // this.dataService.changeData(response["message"]);
        }
        else
        {
          this.Question = '{ "groupId":' + response["groupId"] + ', "subGroupId":' + response["subGroupId"] +',';
          this.Question = this.Question + '"' + response["questionSetName"] + '":' + JSON.stringify(response["questionSet"]) + '}';
          this.Questions.push(JSON.parse(this.Question));

          this.Answer= {};        
          for(let option in response["questionSet"])
          {
              this.Answer[response["questionSet"][option].id.toString()]='';
          }
          this.Answer = '{ "groupId":' + response["groupId"] + ', "subGroupId":' + response["subGroupId"] +',"questionsAnswers":' + JSON.stringify(this.Answer)+'}';
          this.tabs.push(response["questionSetName"]);
          this.Answers.push(JSON.parse(this.Answer));
          for(let question in this.Questions[index+1][response["questionSetName"]])
          { 
            let id = this.Questions[index+1][response["questionSetName"]][question].id;
            this.Answers[index+1]["questionsAnswers"][id]=this.Questions[index+1][response["questionSetName"]][question].questionnaireOptionsById.slice(-1)[0].id;
          }
          this.isSave.push(false);
          this.isResult.push(false);
          console.log("data");
          console.log(this.Questions);
          console.log(this.Answers);
          console.log(this.tabs);
          console.log(this.isSave);
          window.scroll({
            top: 0,
            left: 0,
            behavior: 'smooth'
          });
          this.selected.setValue(this.tabs.length - 1);
          console.log(response["message"])
          if(response["message"].length>0){
            this._snackBar.open(response["message"], 'Close', {
              duration: 3000,
              horizontalPosition: 'center',
              verticalPosition: 'top',
            });
          }   
        }

      },
      (error:any) => {
        console.log(error);
      }
    );
  }

  saveAnswer()
  {
    this.dataService.changeData(this.Result);
    this.questionnaryService.saveAnswers(this.Answers).subscribe(
      (response:any) => {
        console.log(response);
        this._snackBar.open(response, 'Close', {
          duration: 3000,
          horizontalPosition: 'center',
          verticalPosition: 'top',
        });
      },
      (error:any) => {
        console.log(error);
      }
    );
    // window.location.href="/addConsultation?id="+this.patientDetails.Id;
    
  }

}
