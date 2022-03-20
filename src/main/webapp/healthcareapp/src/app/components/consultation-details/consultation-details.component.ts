import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';
@Component({
  selector: 'app-consultation-details',
  templateUrl: './consultation-details.component.html',
  styleUrls: ['./consultation-details.component.css']
})
export class ConsultationDetailsComponent implements OnInit {

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

  consultationRecords:any;

  constructor(private activatedroute: ActivatedRoute, private patientService:PatientService) { }

  ngOnInit(): void {
    this.activatedroute.queryParams.subscribe(
      params => {
        this.search.value = params['id'];
      }
    );
    this.patientService.getSearchPatients(this.search).subscribe(
      (response:any) => {
        console.log("in get patient");
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
      // console.log(this.patientDetails)
    this.patientService.getAllConsultationsByPatient(this.search.value).subscribe(
      (response:any)=>{
        console.log("In get consultation method");
        for(let key in response)
        {
          response[key].isExpand=false
        }
        this.consultationRecords=response;
        console.log(this.consultationRecords)
        
      },
      (error:any)=>{
        console.log(error);
      }
    );
  }

  change(idx:any)
  {
    this.consultationRecords[idx].isExpand = !this.consultationRecords[idx].isExpand;
  }

}
