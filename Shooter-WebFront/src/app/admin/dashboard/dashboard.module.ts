import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {DashBoardComponent} from "./dashboard.component";
import {MaterialModule} from "@angular/material";
import {SummaryContentComponent} from "./summary/summary-content.component";
import {DynamicComponentModule} from "angular2-dynamic-component";
@NgModule({
  declarations: [
    DashBoardComponent,
    SummaryContentComponent,
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    DynamicComponentModule,
  ],
  providers: [],
  bootstrap: [DashBoardComponent]
})
export class DashBoardModule {
}
