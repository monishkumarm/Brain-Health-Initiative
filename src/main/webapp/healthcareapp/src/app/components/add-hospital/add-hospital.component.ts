import {Component, Inject, OnInit} from '@angular/core';
import {AdminService} from "../../services/admin.service";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {ToastrService} from "ngx-toastr";
import {delay} from "rxjs";

@Component({
  selector: 'app-add-hospital',
  templateUrl: './add-hospital.component.html',
  styleUrls: ['./add-hospital.component.css']
})
export class AddHospitalComponent implements OnInit {

  hospitalDetails ={
    name:'',
    addLine1:'',
    state:'',
    pincode:'',
    district:''
  }
  heading :any;
  constructor(private adminService:AdminService,private toastrService: ToastrService,
              private dialogRef: MatDialogRef<AddHospitalComponent>, @Inject(MAT_DIALOG_DATA) data:any){

    this.heading = data.heading;
  }

  ngOnInit():void {

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
  console.log(this.hospitalDetails);
    this.adminService.addHospital(this.hospitalDetails).subscribe(
      (response:any) => {
        console.log(response);
        this.showSuccess("Successfully Added Hospital!");
        delay(1000);
        this.close();
      },
      error => {
        console.log(error);
        this.showError("Error While Adding Hospital!");
      }
    );
  }
}
