import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './services/auth.guard';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { PatientDetailsComponent } from './components/patient-details/patient-details.component';
import { ConsultationDetailsComponent } from './components/consultation-details/consultation-details.component';
import {
  AddConsultationDetailsComponent
} from "./components/add-consultation-details/add-consultation-details.component";
import { PerformQuestionnaryComponent } from './components/perform-questionnary/perform-questionnary.component';


const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full'
  },
  {
    path:'login',
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:'dashboard',
    component:DashboardComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'addPatient',
    component:AddPatientComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'patientDetails',
    component:PatientDetailsComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'consultationDetails',
    component:ConsultationDetailsComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'addConsultation',
    component:AddConsultationDetailsComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'performQuestionnary',
    component:PerformQuestionnaryComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
