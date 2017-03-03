import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {DashBoardComponent} from "./dashboard.component";
import {EurekaSummaryComponent} from "./summary/eureka/eureka-summary.component";
import {MaterialModule} from "@angular/material";
import {SummaryContentComponent} from "./summary/summary-content.component";
@NgModule({
  declarations: [
    DashBoardComponent,
    EurekaSummaryComponent,
    SummaryContentComponent,
  ],
  imports: [
    BrowserModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [DashBoardComponent]
})
export class DashBoardModule {
}
