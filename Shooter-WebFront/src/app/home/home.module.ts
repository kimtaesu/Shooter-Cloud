import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomeComponent} from "./home.component";
import {LoginComponent} from "../login/login.component";
import {MaterialModule} from "@angular/material";
import {HomeRoutingModule, homepRoutingProviders} from "./home-routing.module";
import {JoinComponent} from "../join/join.component";
import {DashBoardComponent} from "../admin/dashboard/dashboard.component";
import {SummaryRequestDirective} from "../admin/dashboard/summary/summary-request.directive";
import {EurekaSummaryComponent} from "../admin/dashboard/summary/eureka/eureka-summary.component";
import {DashBoardModule} from "../admin/dashboard/dashboard.module";
@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent,
    JoinComponent,
  ],
  imports: [
    HomeRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    DashBoardModule,
    MaterialModule.forRoot(),
  ],
  providers: [
    homepRoutingProviders,
  ],
  bootstrap: [HomeComponent]
})
export class HomeModule {
}
