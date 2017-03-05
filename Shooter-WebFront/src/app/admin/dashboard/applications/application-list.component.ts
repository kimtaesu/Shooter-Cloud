import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {FlattenPipe} from "ngx-pipes/src/app/pipes/array";
import "rxjs/add/operator/concatMap";
import {Router} from "@angular/router";
import {QueryApps} from "../../../shared/http/http-requests.service";
import {Application_Instance, Applications} from "./application-response";

interface row {
  Application: string
  info: string
  status: string
}
@Component({
  templateUrl: 'application-list.component.html',
  providers: [FlattenPipe]
})
export class ApplicationListComponent implements OnInit {
  private httpClient = QueryApps;
  private rows = [];

  constructor(private http: Http, private flatPipe: FlattenPipe, private router: Router) {
  }

  onClick(application: Application_Instance) {
    this.router.navigate(['home', 'application', application.instanceId])
  }

  ngOnInit(): void {
    this.httpClient.httpRequest(this.http)
    // json 형태 변환
      .map(res => {
        return res.json()
      })
      // application {} Json 을 커스텀 형태로 변환
      .map((res: Applications) => {
        var result = res.applications.application
          .map(application => {
            return application.instance
              .map(instance => {
                instance.metricsUrl = instance.homePageUrl + 'metrics';
                return {
                  name: instance.app,
                  instanceId: instance.instanceId,
                  status: instance.status,
                  infoUrl: instance.statusPageUrl,
                  detail: instance
                };
              })
          })
        return result
      })
      // [][] -> [] flatMap
      .map(result => {
        return this.flatPipe.transform(result)
      })
      // type [{}]
      .subscribe((res) => {
        res
          .map(data => {
            var {name, instanceId, status, infoUrl, detail} = data
            let row = {
              application: name,
              info: instanceId,
              status: status,
              detail: detail
            }
            this.rows.push(row)
          })
      }, (error) => {
        alert(error)
      }, () => {
      })
  }
}
