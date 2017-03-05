import {Component, OnInit} from "@angular/core";
import "rxjs/add/operator/concatMap";
import {ActivatedRoute} from "@angular/router";
import {Http, Response} from "@angular/http";
import {QueryInstance} from "../../../../shared/http/http-requests.service";
import {Application_Instance} from "../summary/application-response";

@Component({
  template: `<p>detail</p>`,
})
export class ApplicationDetailComponent implements OnInit {
  ngOnInit(): void {
  }

  constructor(private http: Http, private activatedRoute: ActivatedRoute) {
    activatedRoute.params
      .map(data => {
        return data['instanceId'];
      })
      .concatMap(instanceId => {
        return QueryInstance.httpRequest(http, instanceId)
      })
      .map((res: Response) => {
        return res.json()
      })
      .subscribe((instance: Application_Instance) => {
        console.info(instance)
      })
  }
}
