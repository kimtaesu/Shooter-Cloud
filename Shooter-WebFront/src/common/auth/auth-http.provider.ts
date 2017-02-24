import {Http, RequestOptions} from "@angular/http";
import {AuthService} from "./auth-http.service";

export function AuthServiceFactory(http:Http, options: RequestOptions) {
  return new AuthService(http, options);
};

export let AuthServiceProvider = {
  provide: AuthService,
  deps: [Http, RequestOptions],
  useFactory: AuthServiceFactory,
};

