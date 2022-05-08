import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PatientService } from 'src/app/services/patient.service';
import {MatSort, Sort} from '@angular/material/sort';
import {LiveAnnouncer} from '@angular/cdk/a11y';
import {LoginService} from "../../services/login.service";
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import {AdminService} from "../../services/admin.service";
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
  constructor(private adminService:AdminService, private breakpointObserver: BreakpointObserver,private loginService:LoginService, private service: PatientService, private _liveAnnouncer: LiveAnnouncer){
    this.isAdmin = this.loginService.isAdmin();
  }

  @ViewChild(MatSort) sort!: MatSort;

   ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
   }

  ngOnInit(): void {

    if(this.isAdmin) {
      this.getSummary();
    }
    else{
      this.getAllPatients();
    }
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




  //Admin
   cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
     map(({ matches }) => {
       if (matches) {
         return{
           columns: 1,
           miniCardCols :1,
           miniCardRows:1,
           chartCardRows: 2,
           chartCardCols :1
         };
       }

       return {
         columns: 4,
         miniCardCols :1,
         miniCardRows:0.5,
         chartCardRows: 2,
         chartCardCols :2
       };
     })
   );


   //mini card data

   miniCardData=[
     {
       icon:"domain",
       title: "Hospitals",
       value:"93",
       color:"red",
       isIncrease:true,
       isCurrency:false,
       percentValue:'0.09'
     },
     {
       icon:"account_circle",
       title: "Users",
       value:"231",
       color:"yellow",
       isIncrease:true,
       isCurrency:false,
       percentValue:'0.05'
     },
     {
       icon:"local_hospital",
       title: "Patients",
       value:"23561",
       color:"blue",
       isIncrease:true,
       isCurrency:false,
       percentValue:'0.08'
     },
     {
       icon:"library_books",
       title: "Consultations",
       value:"1991",
       color:"black",
       isIncrease:true,
       isCurrency:false,
       percentValue:'0.05'
     }
   ];

   getSummary(){
     this.adminService.getSummary().subscribe(
       (response:any) =>{

        for(let i=0;i<4;i++){
          this.miniCardData[i].value =  (response[i]+113).toString();
        }
       },
       (error:any) => {
         console.log(error);
       }
     );
   }
}

