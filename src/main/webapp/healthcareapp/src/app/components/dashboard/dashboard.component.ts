import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})


export class DashboardComponent implements OnInit {

  Record:any;

  constructor(private patientService:PatientService) { }

  ngOnInit(): void {
      this.getAllPatients();
  }

  getAllPatients(){
    this.patientService.getAllPatients().subscribe(
      (response:any) => {
        console.log(response);
        this.Record = response;
      },
      error => {
        console.log(error);
      }
    );
  }
}
