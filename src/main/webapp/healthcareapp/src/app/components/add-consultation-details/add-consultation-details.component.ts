import { Component, OnInit } from '@angular/core';
import { setOptions  } from '@mobiscroll/angular';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';
import { UserService } from 'src/app/services/user.service';
import {MatTabsModule} from '@angular/material/tabs';

setOptions({
  theme: 'ios',
  themeVariant: 'light'
});

@Component({
  selector: 'app-add-consultation-details',
  templateUrl: './add-consultation-details.component.html',
  styleUrls: ['./add-consultation-details.component.css']
})
export class AddConsultationDetailsComponent implements OnInit {

  medicine:any;
  consultationDetails ={
    complaint:'',
    history:'',
    examination:'',
    illnessSummary:'',
    type:'',
    icdDescription:'',
    icd10:'',
    improvementStatus:'',
    medicine:'',
    medicineDuration:'',
    remarks:'',
    treatmentInstructions:'',
    followup:'',
    refer:'',
    moveToIp:false,
    referSos:false,
  }

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

  Specilist:any;

  icdOptions = [
  "A00-B99: Certain infectious and parasitic diseases",
  "C00-D49: Neoplasms",
  "D50-D89: Diseases of the blood and blood-forming organs and certain disorders involving the immune mechanism",
  "E00-E89: Endocrine, nutritional and metabolic diseases",
  "F01-F99: Mental, Behavioral and Neurodevelopmental disorders",
  "G00-G99: Diseases of the nervous system",
  "H00-H59: Diseases of the eye and adnexa",
  "H60-H95: Diseases of the ear and mastoid process",
  "I00-I99: Diseases of the circulatory system",
  "J00-J99: Diseases of the respiratory system",
  "K00-K95: Diseases of the digestive system",
  "L00-L99: Diseases of the skin and subcutaneous tissue",
  "M00-M99: Diseases of the musculoskeletal system and connective tissue",
  "N00-N99: Diseases of the genitourinary system",
  "O00-O9A: Pregnancy, childbirth and the puerperium",
  "P00-P96: Certain conditions originating in the perinatal period",
  "Q00-Q99: Congenital malformations, deformations and chromosomal abnormalities",
  "R00-R99: Symptoms, signs and abnormal clinical and laboratory findings, not elsewhere classified",
  "S00-T88: Injury, poisoning and certain other consequences of external causes",
  "U00-U85: Codes for special purposes",
  "V00-Y99: External causes of morbidity",
  "Z00-Z99: Factors influencing health status and contact with health services"
  ]

  constructor(private activatedroute: ActivatedRoute,
              private patientService:PatientService,
              private userService:UserService,
              ) { }

  ngOnInit(): void {


    console.log("in init of add consulatation");
    this.medicine = [];
    this.consultationDetails.medicine = this.medicine;

    this.activatedroute.queryParams.subscribe(
      (params:any) => {
      console.log(params); // { orderby: "price" }
      this.search.value = params['id'];
      }
    );

    this.userService.getSpecialists().subscribe(
      (response:any)=> {
        this.Specilist = [];
        console.log(response);
        for(let key in response){
          let specilist = {
            id:response[key].username,
            name:'Dr. ' + response[key].firstName + ' ' + response[key].lastName
          }
          this.Specilist.push(specilist);
        }

      },
      (error:any)=>{
        console.log(error);
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



  }


  onSubmit(){
    console.log(this.consultationDetails);
    this.patientService.addConsultion(this.consultationDetails,this.patientDetails.ABHAID).subscribe(
      (response:any)=>{
        console.log(response);
      },
      (error:any)=>{
        console.log(error);
      }
    )
  }

  addMedicine(){
    let med =  {
      medicineName:'',
      Dosage:'',
      isMorning:false,
      isAfternoon:false,
      isNight:false
    }

    this.medicine.push(med);
    console.log(this.medicine);
  }

  removeMedicine(index:any)
  {
    this.medicine.splice(index,1);
    console.log(this.medicine)
  }


}
