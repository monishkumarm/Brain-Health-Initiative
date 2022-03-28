import { SelectorMatcher } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

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

  disable = true;

  isPatientUpdate = true;
  errorMsg = '';

  constructor(private activatedroute: ActivatedRoute, private patientService:PatientService) {   }
  ngOnInit() {

    this.activatedroute.queryParams
      .subscribe(params => {
        console.log(params); // { orderby: "price" }
        this.search.value = params['id'];
        }
      );
      console.log(this.search)
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
  }

  change(){
    this.disable = !this.disable;
  }

  onSubmit(){
    this.disable = !this.disable;
    this.patientService.updatePatient(this.patientDetails).subscribe(
      (response:any) => {
        // console.log(response);

        this.isPatientUpdate = true;
        this.errorMsg = '';
        this.patientDetails.Id = response.id;
        this.patientDetails.ABHAID = response.abhaId;
        this.patientDetails.fname = response.firstName;
        this.patientDetails.lname = response.lastName;
        this.patientDetails.gender = response.gender.toLocaleString();
        this.patientDetails.age = response.age;
        this.patientDetails.lan = response.languages;
        this.patientDetails.edu = response.education;
        this.patientDetails.occ = response.occupation;
        this.patientDetails.email = response.email;
        this.patientDetails.phone = response.phoneNumber;
        this.patientDetails.addLine1 = response.addressDetail.addLine1;
        this.patientDetails.addLine2 = response.addressDetail.addLine2;
        this.patientDetails.district = response.addressDetail.district;
        this.patientDetails.state = response.addressDetail.state;
        this.patientDetails.pin = response.addressDetail.pin;
       this.patientDetails.carer_name = response.informantCaregiverName;
        this.patientDetails.carer_rel = response.relationshipWithPatient
        console.log(this.patientDetails);
      },
      (error:any) =>  {
        console.log(error);
        this.isPatientUpdate = false;
        this.errorMsg = error.error.message;
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
            this.patientDetails.addLine1 = response[0].addressDetail.add1;
            this.patientDetails.addLine2 = response[0].addressDetail.add2;
            this.patientDetails.carer_name = response[0].informantCaregiverName;
            this.patientDetails.carer_rel = response[0].relationshipWithPatient
            console.log(this.patientDetails);
          },
          (error:any) =>  {
            console.log(error);
          }
        );
      }
    );
  }

}
