import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {DashBoardComponent} from "./dashboard.component";
import {SummaryRequestDirective} from "./summary/summary-request.directive";
import {EurekaSummaryComponent} from "./summary/eureka/eureka-summary.component";
import {MaterialModule} from "@angular/material";
@NgModule({
  declarations: [
    DashBoardComponent,
    SummaryRequestDirective,
    EurekaSummaryComponent,
  ],
  imports: [
    BrowserModule,
    MaterialModule.forRoot(),
  ],
  providers: [],
  bootstrap: [DashBoardComponent]
})
export class DashBoardModule {
}
