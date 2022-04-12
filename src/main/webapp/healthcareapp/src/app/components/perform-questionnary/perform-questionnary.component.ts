import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { QuestionnaryService } from 'src/app/services/questionnary.service';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';
import { ButtonBase } from '@mobiscroll/angular/dist/js/core/components/button/button';
@Component({
  selector: 'app-perform-questionnary',
  templateUrl: './perform-questionnary.component.html',
  styleUrls: ['./perform-questionnary.component.css']
})
export class PerformQuestionnaryComponent implements OnInit {


  tabs:any;
  Answers:any;
  Questions:any;
  isSave:any;
  Answer:any;
        

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
              ) { }

  ngOnInit(): void {

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

    this.questionnaryService.getCommanQuestions().subscribe(
      (response:any) => {
        this.Answer={}
        for(let ele in response)
        {
          console.log(response[ele].id);
          this.Answer[response[ele].id.toString()] = '';
        }

        response["isSave"]=false;
        // console.log(response);
        this.Questions.push({"commanQuestionnary":response});

        this.tabs.push("commanQuestionnary");
        this.Answers.push({"commanQuestionnary":this.Answer})        
        console.log(this.Questions);
        console.log(this.Answers)
        this.isSave.push(false)
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
    this.isSave[index]=true;
    console.log(this.Answers[index]);
    this.questionnaryService.getNextQuestions(this.Answers[index]).subscribe(
      (response:any) => {
        this.Answer={}
        for(let ele in response)
        {
          console.log(response[ele].id);
          this.Answer[response[ele].id.toString()] = '';
        }

        response["isSave"]=false;
        // console.log(response);
        this.Questions.push({"commanQuestionnary":response});

        this.tabs.push("commanQuestionnary");
        this.Answers.push({"commanQuestionnary":this.Answer})        
        console.log(this.Questions);
        console.log(this.Answers)
        this.isSave.push(false)
      },
      (error:any) => {
        console.log(error);
      }
    );
  }

}
