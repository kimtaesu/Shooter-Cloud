import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {DashBoardComponent} from "./dashboard.component";
import {MaterialModule} from "@angular/material";
import {DynamicComponentModule} from "angular2-dynamic-component";
import {EurekaDetailComponent} from "./summary/eureka/detail/eureka-detail.component";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {EurekaSummaryComponent} from "./summary/eureka/eureka-summary.component";
import {ProgressSummaryComponent} from "./summary/common/progress-summary.component";
import {ErrorSummaryComponent} from "./summary/common/error-summary.component";
@NgModule({
  declarations: [
    DashBoardComponent,
    ProgressSummaryComponent, ErrorSummaryComponent,
    EurekaDetailComponent, EurekaSummaryComponent,

  ],
  imports: [
    BrowserModule,
    MaterialModule,
    NgxDatatableModule,
    DynamicComponentModule,
  ],
  providers: [],
  bootstrap: [DashBoardComponent]
})
export class DashBoardModule {
}
