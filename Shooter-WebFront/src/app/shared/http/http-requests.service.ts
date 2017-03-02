import {Observable} from "rxjs";
import {Response, Http, Headers} from "@angular/http";
import {environment} from "../../../environments/environment";
export interface RequestClient {
  httpRequest(http: Http): Observable<Response>
}

export let EurekaApi: RequestClient = <RequestClient>{
  httpRequest: (http: Http) => {
    var header = new Headers();
    header.append('Accept', 'application/json')
    return http.get(environment.api.health_check, {headers: header})
  }
}
