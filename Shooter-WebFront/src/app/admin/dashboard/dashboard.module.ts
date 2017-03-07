import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {DashBoardComponent} from "./dashboard.component";
import {MaterialModule} from "@angular/material";
import {DynamicComponentModule} from "angular2-dynamic-component";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {NgPipesModule} from "ngx-pipes";
import {ProgressSummaryComponent} from "./applications/summary/common/progress-summary.component";
import {ErrorSummaryComponent} from "./applications/summary/common/error-summary.component";
import {ApplicationListComponent} from "./applications/application-list.component";
import {ApplicationSummaryComponent} from "./applications/summary/application-summary.component";
import {ApplicationDetailComponent} from "./applications/detail/application-detail.component";
import {NgxChartsModule} from "@swimlane/ngx-charts";
@NgModule({
  declarations: [
    DashBoardComponent,
    ProgressSummaryComponent, ErrorSummaryComponent,
    ApplicationListComponent, ApplicationSummaryComponent,
    ApplicationDetailComponent

  ],
  imports: [
    NgxChartsModule,
    BrowserModule,
    MaterialModule,
    NgxDatatableModule,
    NgPipesModule,
    DynamicComponentModule,
  ],
  providers: [],
  bootstrap: [DashBoardComponent]
})
export class DashBoardModule {
}
