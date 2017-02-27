import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {MaterialModule} from "@angular/material";

import {HomeComponent} from "./home.component";
import {AppRoutingModule} from "../app-routing.module";
@NgModule({
  declarations: [
    HomeComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
  ],
  bootstrap: [HomeComponent]
})
export class HomeModule {
}
