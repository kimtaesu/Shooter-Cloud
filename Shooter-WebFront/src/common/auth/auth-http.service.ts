import {Http, RequestOptions, Response, RequestOptionsArgs, Headers, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Injectable} from "@angular/core";
import {AuthResponse} from "./auth-response";

export interface AuthConfig {
  client_id: string,
  client_secret: string,
}

const AuthConfigEnv: AuthConfig = {
  client_id: environment.authCofig.clientId,
  client_secret: environment.authCofig.clientSecret
};

const KeyToken = {
  KEY_TOKEN: 'key_token',
  KEY_REFRESH: 'key_refresh'
}
@Injectable()
export class AuthService {
  constructor(private http: Http, private options: RequestOptions) {
  }

  post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    const request = this.http.post(url, body, this.appendAuthHeader(options));
    return this.interceptResponse(request);
  }

  private appendAuthHeader(options?: RequestOptionsArgs): RequestOptionsArgs {
    let mergedOptions: RequestOptionsArgs;
    if (!options) {
      mergedOptions = {headers: new Headers()};
    } else {
      mergedOptions = options;
    }
    const token = localStorage.getItem(KeyToken.KEY_TOKEN);
    mergedOptions.headers.append('Authorization', `Bearer ${token}`);
    return mergedOptions;
  }

  interceptResponse(observable: Observable<Response>): Observable<Response> {
    return observable.catch((err) => {
      if (err.status == 401) {
        let refreshToken = localStorage.getItem(KeyToken.KEY_REFRESH);
        if (!refreshToken)
          return Observable.throw("dadasdsad");

      }
      return Observable.throw(err);
    });
  }

  private getRefreshToken(): Observable<Response> {
    return null;
  }

  getAccessToken(config?: AuthConfig): Observable<Response> {
    let localConfig: AuthConfig = config;
    if (!localConfig) {
      localConfig = AuthConfigEnv;
    }

    let accessTokenOption: RequestOptionsArgs;
    let encodedSecret = btoa(`${localConfig.client_id}:${localConfig.client_secret}`);
    accessTokenOption = {headers: new Headers()};
    accessTokenOption.headers.append('Content-Type', 'application/x-www-form-urlencoded');
    accessTokenOption.headers.append('authorization', `Basic ${encodedSecret}`);
    let param: URLSearchParams = new URLSearchParams();
    param.append('grant_type', 'password');
    param.append('username', 'test1');
    param.append('password', 'test');
    param.toString()
    let body = param.toString()
    return this.http
      .post(environment.api.token,
        body,
        accessTokenOption
      )
      .map((response) => {
        this.saveToken(response.json())
        return response;
      })
  }

  saveToken(auth: AuthResponse) {
    localStorage.setItem(KeyToken.KEY_TOKEN, auth.access_token);
    localStorage.setItem(KeyToken.KEY_REFRESH, auth.refresh_token);
  }
}

