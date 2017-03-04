import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {MaterialModule} from "@angular/material";
import {ProgressSummaryComponent} from "./progress-summary.component";
import {ErrorSummaryComponent} from "./error-summary.component";
import {EurekaSummaryComponent} from "./eureka/eureka-summary.component";
import {NgPipesModule} from "ngx-pipes";
import {GroupByPipe} from "ngx-pipes/src/app/pipes/array";
@NgModule({
  declarations: [
    ProgressSummaryComponent,
    ErrorSummaryComponent,
    EurekaSummaryComponent,

  ],
  imports: [
    BrowserModule,
    MaterialModule,
    NgPipesModule,
  ],
  exports: [MaterialModule, NgPipesModule],
  providers:[GroupByPipe],
  bootstrap: [ProgressSummaryComponent],

})
export class DynamicModule {
}
