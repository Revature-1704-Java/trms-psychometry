import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DataPipelineService } from './service/data-pipeline.service';
import { UserService } from './service/user.service';
import { LoginComponent } from './components/login/login.component';
import { TableComponent } from './components/table/table.component';
import { UserComponent } from './components/user/user.component';
import { DashComponent } from './components/dash/dash.component';
import { RequestFormComponent } from './components/request-form/request-form.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TableComponent,
    UserComponent,
    DashComponent,
    RequestFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [DataPipelineService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
