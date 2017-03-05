import {Component, OnInit} from "@angular/core";
import "rxjs/add/operator/concatMap";
import {ActivatedRoute} from "@angular/router";
import {Http, Response} from "@angular/http";
import {QueryInstance} from "../../../../shared/http/http-requests.service";
import {Application_Instance} from "../application-response";

@Component({
  templateUrl: './application-detail.component.html'
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
        var response: Application_Instance = res.json().instance
        response.metricsUrl = response.homePageUrl + 'metrics';
        console.info(response)
        return response;
      })
      .subscribe((instance: Application_Instance) => {
        console.info(instance)
      }, error => {
        alert(error)
      })
  }
}
