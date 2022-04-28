import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PatientService } from 'src/app/services/patient.service';
import {MatSort, Sort} from '@angular/material/sort';
import {LiveAnnouncer} from '@angular/cdk/a11y';
import {LoginService} from "../../services/login.service";

export interface Patient {
  firstName: string;
  phoneNumber: string;
  age: number;
  email: string;
  createdOn: Date
}

 @Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit, AfterViewInit {
  isAdmin = false;
  constructor(private loginService:LoginService, private service: PatientService, private _liveAnnouncer: LiveAnnouncer){
    this.isAdmin = this.loginService.isAdmin();
  }

  @ViewChild(MatSort) sort!: MatSort;

   ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
   }

  ngOnInit(): void {
    this.getAllPatients();
  }

  ELEMENT_DATA!: Patient[];
  displayedColumns: string[] = ['firstName', 'age', 'phoneNumber', 'email', 'createdOn', 'actions'];
  dataSource = new MatTableDataSource<Patient>(this.ELEMENT_DATA);

  public getAllPatients(){
    let response = this.service.getAllPatients();

    response.subscribe(patient => this.dataSource.data = patient as Patient[]);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
}

