import {Injectable} from "@angular/core";
import {Response, RequestOptionsArgs} from "@angular/http";
import {Observable} from "rxjs";
import {AuthService} from "../../common/auth/auth-http.service";
import {environment} from "../../environments/environment";
@Injectable()
export class LoginService {
  constructor(private authService: AuthService) {
  }

  login(option: RequestOptionsArgs): Observable<Response> {
    return Observable
      .defer(() => {
        return this.authService.getAccessToken();
      })
      .concatMap((res) => {
        return this.authService.post(environment.api.login, option);
      })
  }
}
