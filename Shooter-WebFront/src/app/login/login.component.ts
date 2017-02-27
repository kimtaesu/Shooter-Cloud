import {Component} from "@angular/core";
import {LoginService} from "./login-http.service";
import {GrantType} from "../../common/auth/grant_type.enum";
import {RequestOptionsArgs} from "@angular/http";
import {createJsonHeader} from "../../common/api-support";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private loginService: LoginService) {
  }

  onJoin() {
    console.info("onJoin")
  }

  onLogin(/*username: string, password: string*/) {
    console.info("click")
    let user = {
      grant_type: GrantType[GrantType.PASSWORD],
      username: 'test1',
      password: 'test'
    }
    let requestBody: RequestOptionsArgs = {
      body: JSON.stringify(user),
      headers: createJsonHeader()
    }
    this.loginService.login(requestBody)
      .subscribe((res) => {
        console.info(res)
      }, (error) => {
        console.info(error)
      });
  }
}
