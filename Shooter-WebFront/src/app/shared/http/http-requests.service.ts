import {Observable} from "rxjs";
import {Response, Http, Headers, RequestOptionsArgs, RequestOptions} from "@angular/http";
import {environment} from "../../../environments/environment";
export interface RequestClient {
  httpRequest(http: Http, requestOption?: RequestOptionsArgs): Observable<Response>
  httpRequest(http: Http, path: string, requestOption?: RequestOptionsArgs): Observable<Response>
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

export const QueryApps: RequestClient = <RequestClient>{
  httpRequest: (http: Http, requestOption?: RequestOptionsArgs) => {
    var header = new Headers();
    header.append('Accept', 'application/json')
    if (requestOption == null) {
      requestOption = new RequestOptions;
    }
    requestOption.headers = header;
    return appendResponseOkThrowing(http
      .get(environment.api.queryApps, requestOption))
  }
}

export const QueryInstance: RequestClient = <RequestClient>{
  httpRequest: (http: Http, instanceId: string, requestOption?: RequestOptionsArgs) => {
    var header = new Headers();
    header.append('Accept', 'application/json')
    if (requestOption == null) {
      requestOption = new RequestOptions;
    }
    requestOption.headers = header;
    return appendResponseOkThrowing(http
      .get(environment.api.queryInstance + '/' + instanceId, requestOption))
  }
}
