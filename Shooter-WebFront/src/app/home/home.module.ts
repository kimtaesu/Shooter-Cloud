import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {MaterialModule} from "@angular/material";
import "hammerjs";
import {HomeComponent} from "./home.component";
import {LoginComponent} from "../login/login.component";
import {AppRoutingModule} from "../app-routing.module";

@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    MaterialModule.forRoot()
  ],
  bootstrap: [HomeComponent, LoginComponent]
})
export class HomeModule {
}
