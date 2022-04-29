import { MbscModule } from '@mobiscroll/angular';
import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginService } from './services/login.service';
import { AuthGuard } from './services/auth.guard';
import { AuthInterceptor } from './services/auth.interceptor';
import { MatSelectModule } from '@angular/material/select';
import { PatientService } from './services/patient.service';
import { AddPatientComponent } from './components/add-patient/add-patient.component';
import { PatientDetailsComponent } from './components/patient-details/patient-details.component';
import { ConsultationDetailsComponent } from './components/consultation-details/consultation-details.component';
import { AddConsultationDetailsComponent } from "./components/add-consultation-details/add-consultation-details.component";
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import  { MatRadioModule } from '@angular/material/radio';
import { MatTableModule } from '@angular/material/table';
import {MatSortModule } from '@angular/material/sort';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import { MatTooltipModule } from '@angular/material/tooltip';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { MatOptionModule} from '@angular/material/core';
import { MatTabsModule } from '@angular/material/tabs';
import { UserService } from './services/user.service';
import { QuestionnaryService } from './services/questionnary.service';
import { PerformQuestionnaryComponent } from './components/perform-questionnary/perform-questionnary.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { DataService } from './services/data.service';
import {MatStepperModule} from '@angular/material/stepper';
export function HttpLoaderFactory(http: HttpClient){
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    LoginComponent,
    DashboardComponent,
    AddPatientComponent,
    PatientDetailsComponent,
    ConsultationDetailsComponent,
    AddConsultationDetailsComponent,
    PerformQuestionnaryComponent
  ],
  imports: [
    MbscModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatSelectModule,
    MatCheckboxModule,
    MatAutocompleteModule,
    MatRadioModule,
    MatTableModule,
    MatSortModule,
    MatIconModule,
    MatTooltipModule,
    MatMenuModule,
    MatOptionModule,
    MatTabsModule,
    MatSnackBarModule,
    MatStepperModule,
    TranslateModule.forRoot({
      defaultLanguage:localStorage.getItem('language') ?? 'en-US',
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
  ],
  providers: [LoginService,
              PatientService,
              UserService,
              QuestionnaryService, 
              DataService,
              AuthGuard, 
              [{provide:HTTP_INTERCEPTORS, useClass:AuthInterceptor, multi:true}]
             
            ],
  bootstrap: [AppComponent]
})
export class AppModule { }
