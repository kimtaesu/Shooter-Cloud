import {Directive, Attribute, Output, EventEmitter, OnInit} from "@angular/core";
import {EurekaApi, RequestClient} from "../../../shared/http/http-requests.service";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";

export enum TypeRequest {
  EUREKA = 0,
}
@Directive({
  selector: '[type-request]',
})
export class SummaryRequestDirective implements OnInit {

  api: RequestClient;

  @Output('onResponse') emitResponse = new EventEmitter<Observable<Response>>();

  constructor(@Attribute('type-request') private type: string, private http: Http) {

  }

  ngOnInit(): void {
    switch (TypeRequest[this.type]) {
      case TypeRequest.EUREKA.valueOf():
        this.api = EurekaApi;
        break;
    }
    this.emitResponse.emit(this.api.httpRequest(this.http))
  }
}
