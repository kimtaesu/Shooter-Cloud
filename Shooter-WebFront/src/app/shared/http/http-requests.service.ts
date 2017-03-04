import {Observable} from "rxjs";
import {Response, Http, Headers} from "@angular/http";
import {environment} from "../../../environments/environment";
export interface RequestClient {
  httpRequest(http: Http): Observable<Response>
}

let appendResponseOkThrowing = (res: Observable<Response>) => {
  return res
    .map((res: Response) => {
      if (!res.ok) {
        throw new Error('The response not ok ' +
          'code : ' + res.status)
      }
      return res;
    })
}

export let EurekaApi: RequestClient = <RequestClient>{
  httpRequest: (http: Http) => {
    var header = new Headers();
    header.append('Accept', 'application/json')
    return appendResponseOkThrowing(http
      .get(environment.api.health_check, {headers: header}))
  }
}
