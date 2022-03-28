import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})


export class DashboardComponent implements OnInit {

  Record:any;
  search = {
    option : '',
    value : '',
  };

  isPatientsFound = true;
  constructor(private patientService:PatientService) { }

  ngOnInit(): void {
      this.getAllPatients();
  }

  getAllPatients(){
    this.patientService.getAllPatients().subscribe(
      (response:any) => {
        console.log(response);
        this.Record = response;
        if(this.Record.length == 0)
        {
          this.isPatientsFound = false;
        }
        else
        {
          this.isPatientsFound = true;
        }

      },
      (error:any) => {
        console.log(error);
      }
    );
  }

  onSubmit(){
    console.log("In serch function");
    console.log(this.search.option);
    console.log(this.search.value);
    this.patientService.getSearchPatients(this.search).subscribe(
      (response:any) => {
        console.log(response);
        this.Record = response;
        if(this.Record.length == 0)
        {
          this.isPatientsFound = false;
        }
        else
        {
          this.isPatientsFound = true;
        }
      },
      (error:any) =>  {
        console.log(error);
      }
    );
  }
}
