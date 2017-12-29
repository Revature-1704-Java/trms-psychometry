import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { DataPipelineService } from './data-pipeline.service';
import { LoginComponent } from './components/login/login.component';
import { TableComponent } from './components/table/table.component';
import { UserComponent } from './components/user/user.component';
import { DashComponent } from './components/dash/dash.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TableComponent,
    UserComponent,
    DashComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [DataPipelineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
