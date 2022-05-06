import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from 'src/app/services/patient.service';
import { MatTableDataSource } from '@angular/material/table';
import {MatSort, Sort} from '@angular/material/sort';
import {LiveAnnouncer} from '@angular/cdk/a11y';

export interface Consulatation { 
  complaintDetail: JSON,
  diagnosisTypeLuByDiagnosisTypeId: JSON,
  improvementStutusLuByImprovementStutusId: JSON,
  appointmentTime: Date
}


@Component({
  selector: 'app-consultation-details',
  templateUrl: './consultation-details.component.html',
  styleUrls: ['./consultation-details.component.css'],

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
  displayRecord:any
 options = {
    page: 1,
    size: 3
  };

  ELEMENT_DATA!: Consulatation[];
  displayedColumns: string[] = ['complaint','diagnosisType','improvementStatus','createdOn'];
  dataSource = new MatTableDataSource<Consulatation>(this.ELEMENT_DATA);

  isExpand=false;

  constructor(private activatedroute: ActivatedRoute, private patientService:PatientService, private _liveAnnouncer: LiveAnnouncer) { }

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
        this.dataSource.data = response as Consulatation[];
        console.log("In get consultation method");
        for(let key in response)
        {
          response[key].isExpand=false
        }
        this.consultationRecords=response;
        console.log(this.consultationRecords)
        
        this.dataSource.data = this.consultationRecords.slice((this.options.page-1)*this.options.size,this.options.page*this.options.size) as Consulatation[];
        // this.dataSource=this.displayRecord;
      },
      (error:any)=>{
        console.log(error);
      }
    );


    this.displayRecord = this.consultationRecords.slice(0,this.options.size);
    // this.dataSource=this.displayRecord;

  }

  display(element:any)
  {
    this.isExpand=true;
    this.displayRecord = element
  }

  change()
  {
    this.isExpand = !this.isExpand;
  }




  get numbers(): number[] {
    const limit = Math.ceil((this.consultationRecords.length) / this.options.size);
    return Array.from({ length: limit }, (_, i) => i + 1);
  }


  next() {
    this.options.page++;
    this.dataSource.data = this.consultationRecords.slice((this.options.page-1)*this.options.size,this.options.page*this.options.size) as Consulatation[];// this.getEmployees();
  }

  prev() {
    this.options.page--;
    this.dataSource.data = this.consultationRecords.slice((this.options.page-1)*this.options.size,this.options.page*this.options.size) as Consulatation[]; // this.getEmployees();
  }

  to(page: number) {
    this.options.page = page;
    this.dataSource.data = this.consultationRecords.slice((this.options.page-1)*this.options.size,this.options.page*this.options.size) as Consulatation[];// this.getEmployees();
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}
