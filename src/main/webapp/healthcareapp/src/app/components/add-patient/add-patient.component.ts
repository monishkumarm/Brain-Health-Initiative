import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/services/patient.service';
import { ActivatedRoute , Router} from '@angular/router';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  patientDetails={
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

  constructor(private patientService:PatientService,private router:Router) { }

  ngOnInit(): void {
  }


  onSubmit(){
    console.log(this.patientDetails);
    this.patientService.addPatient(this.patientDetails).subscribe(
      (response:any) => {
        console.log(response);
        this.router.navigateByUrl("/dashboard");
      },
      error => {
        console.log(error);
      }
    );
  }


}
