import {Component, Inject, OnInit} from '@angular/core';
import {AdminService} from "../../services/admin.service";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {ToastrService} from "ngx-toastr";
import {delay} from "rxjs";
@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  userDetails ={
    firstName:'',
    lastName:'',
    addLine1:'',
    state:'',
    pincode:'',
    district:'',
    email:'',
    password:'',
    phoneNumber:'',
    userName:'',
    organization:[],
    roleTypeId:{}
  }
  orgList:any;

  roles=[{id:"1",role:"PHC Medical Officer"},{id:"2",role:"Specialist"},{id:"3",role:"Admin"}];
  heading :any;
  constructor(private adminService:AdminService,private toastrService: ToastrService,
              private dialogRef: MatDialogRef<AddUserComponent>, @Inject(MAT_DIALOG_DATA) data:any){

    this.heading = data.heading;
  }


  ngOnInit(): void {
    this.getAllOrganizations();
  }

  public showSuccess(str:any): void {
    this.toastrService.success(str, 'Success!');
  }
  public showError(str:any): void {
    this.toastrService.error(str, 'Error!');
  }
  close() {
    this.dialogRef.close();
  }
  save(){
    console.log(this.userDetails);

    // this.adminService.addHospital(this.hospitalDetails).subscribe(
    //   (response:any) => {
    //     console.log(response);
    //     this.showSuccess("Successfully Added Hospital!");
    //     delay(1000);
    //     this.close();
    //   },
    //   error => {
    //     console.log(error);
    //     this.showError("Error While Adding Hospital!");
    //   }
    //);
  }
  getAllOrganizations(){
    this.adminService.getAllOrganizations().subscribe(
      (response:any) =>{
        //console.log(response);
        this.orgList=response;
        console.log(this.orgList);
      },
      (error:any) =>{
        console.log(error);
      }
    );
  }
}
