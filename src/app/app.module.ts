import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TableComponent } from './table/table.component';
import { LoginComponent } from './login/login.component';
import { DefaultComponent } from './default/default.component';
import { TemplateDrivenFormComponent } from './template-driven-form/template-driven-form.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    TableComponent,
    LoginComponent,
    DefaultComponent,
    TemplateDrivenFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,  
    FormsModule,                                              
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
