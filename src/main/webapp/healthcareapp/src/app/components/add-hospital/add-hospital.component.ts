import {Component, Inject, OnInit} from '@angular/core';
import {AdminService} from "../../services/admin.service";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {ToastrService} from "ngx-toastr";
import { FormGroup, FormControl, Validators, FormBuilder } from
    '@angular/forms';
@Component({
  selector: 'app-add-hospital',
  templateUrl: './add-hospital.component.html',
  styleUrls: ['./add-hospital.component.css']
})
export class AddHospitalComponent implements OnInit {
  requiredForm: FormGroup;
  heading :any;

  constructor(private fb: FormBuilder,private adminService:AdminService,private toastrService: ToastrService,
              private dialogRef: MatDialogRef<AddHospitalComponent>, @Inject(MAT_DIALOG_DATA) data:any){
    this.requiredForm = this.fb.group({
      district :['',Validators.compose([Validators.required,Validators.pattern('^[a-zA-Z ]*$')])],
      pincode:['', Validators.compose([Validators.required,Validators.minLength(6),
        Validators.maxLength(6),Validators.pattern("^[0-9]*$")])],
      state:['',Validators.compose([Validators.required,Validators.pattern('^[a-zA-Z ]*$')])],
      name:['',Validators.compose([Validators.required,
        Validators.maxLength(50),Validators.pattern('^[a-zA-Z ]*$')])],
      addLine1:['',Validators.compose([Validators.required])]
    });
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

   if(this.requiredForm.status=='INVALID'){
     this.showError("Highlighted Fields require Attention");
   }
   else{
     this.adminService.addHospital(this.requiredForm.getRawValue()).subscribe(
       (response:any) => {
         console.log(response);
         this.showSuccess("Successfully Added Hospital!");
         this.requiredForm.reset();
         setTimeout(() =>
           {
             this.close();
           },
           2000);
       },
       error => {
         console.log(error);
         this.showError("Error While Adding Hospital!");
       }
     );
   }

  }
}
