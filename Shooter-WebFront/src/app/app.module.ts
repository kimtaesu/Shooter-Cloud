import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import "hammerjs";
import {LoginComponent} from "./login/login.component";
import {AuthServiceProvider} from "../common/auth/auth-http.provider";
import {HttpModule} from "@angular/http";
import {LoginService} from "./login/login-http.service";
import {MaterialModule} from "@angular/material";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule.forRoot(),
  ],
  providers: [AuthServiceProvider, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
