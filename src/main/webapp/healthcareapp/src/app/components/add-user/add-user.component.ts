import {Component, Inject, OnInit} from '@angular/core';
import {AdminService} from "../../services/admin.service";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {ToastrService} from "ngx-toastr";
import { FormGroup, FormControl, Validators, FormBuilder } from
    '@angular/forms';
@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  requiredForm: FormGroup;
  // userDetails ={
  //   firstName:'',
  //   lastName:'',
  //   addLine1:'',
  //   state:'',
  //   pincode:'',
  //   district:'',
  //   email:'',
  //   password:'',
  //   phoneNumber:'',
  //   userName:'',
  //   organization:[],
  //   roleTypeId:{}
  // }
  orgList:any;

  roles=[{id:"1",role:"PHC Medical Officer"},{id:"2",role:"Specialist"},{id:"3",role:"Admin"}];
  heading :any;
  constructor(private fb: FormBuilder,private adminService:AdminService,private toastrService: ToastrService,
              private dialogRef: MatDialogRef<AddUserComponent>, @Inject(MAT_DIALOG_DATA) data:any){
    this.requiredForm = this.fb.group({
      firstname: ['',Validators.compose([Validators.required,Validators.pattern('^[a-zA-Z ]*$')])],
      lastname: ['',Validators.compose([Validators.required,Validators.pattern('^[a-zA-Z ]*$')])],
      username: ['',Validators.compose([Validators.required])],
      email : ['',Validators.compose([Validators.required,Validators.pattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")])],
      phone :['', Validators.compose([Validators.required,Validators.minLength(10),
        Validators.maxLength(10),Validators.pattern("^[0-9]*$")])],
      password : ['',Validators.compose([Validators.required])],
      district :['',Validators.compose([Validators.required,Validators.pattern('^[a-zA-Z ]*$')])],
      pincode:['', Validators.compose([Validators.required,Validators.minLength(6),
        Validators.maxLength(6),Validators.pattern("^[0-9]*$")])],
      state:['',Validators.compose([Validators.required,Validators.pattern('^[a-zA-Z ]*$')])],
      addLine1:['',Validators.compose([Validators.required])],
      roletype : ['',Validators.required],
      orgs : ['',Validators.required]
    });
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


    if(this.requiredForm.status=='INVALID'){
      this.showError("Highlighted Fields require Attention");
    }
    else{

      this.adminService.addUser(this.requiredForm.getRawValue()).subscribe(
        (response:any) => {
          console.log(response);
          this.showSuccess("Successfully Added User!");
          setTimeout(() =>
            {
              this.close();
            },
            2000);
        },
        error => {
          console.log(error);
          this.showError("Error While Adding User!");
        }
      );
    }

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
