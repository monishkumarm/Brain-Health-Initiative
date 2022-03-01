import { Component, OnInit } from '@angular/core';
import { setOptions  } from '@mobiscroll/angular';

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

  consultationDetails ={
    date:'',
    time:'',
    complaint:'',
    durationOfIllness:'',
    history:'',
    examination:'',
    illnessSummary:'',
    type:'',
    icdDescription:'',
    icd10:'',
    improvementStatus:'',
    medicineName:'',
    dosage:'',
    dosageTime:'',
    medicineDuration:'',
    remarks:'',
    followup:'',
    refer:'',
    moveToIp: '',
    referOnSos:'',
    refferedBy:'',
    refferedOn:'',
    isConsultation:''

  }

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.consultationDetails);
  }

}
