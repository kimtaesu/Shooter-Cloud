import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomeComponent} from "./home.component";
import {LoginComponent} from "../login/login.component";
import {MaterialModule} from "@angular/material";
import {HomeRoutingModule, homepRoutingProviders} from "./home-routing.module";
import {JoinComponent} from "../join/join.component";
import {DashBoardComponent} from "../admin/dashboard/dashboard.component";
@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent,
    JoinComponent,
    DashBoardComponent,
  ],
  imports: [
    HomeRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule.forRoot(),
  ],
  providers: [
    homepRoutingProviders,
  ],
  bootstrap: [HomeComponent]
})
export class HomeModule {
}
