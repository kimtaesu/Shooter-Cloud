import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {EurekaResponse} from "../eureka-response";
import {FlattenPipe} from "ngx-pipes/src/app/pipes/array";
import {EurekaApi} from "../../../../../shared/http/http-requests.service";
import "rxjs/add/operator/concatMap";

interface row {
  Application: string
  info: string
  status: string
}
@Component({
  templateUrl: './eureka-detail.component.html',
  providers: [FlattenPipe]
})
export class EurekaDetailComponent implements OnInit {
  private httpClient = EurekaApi;
  private rows = [];
  columns = [
    {prop: 'Application'},
    {name: 'Info'},
    {name: 'Status'}
  ];

  constructor(private http: Http, private flatPipe: FlattenPipe) {
  }

  ngOnInit(): void {
    this.httpClient.httpRequest(this.http)
    // json 형태 변환
      .map(res => {
        return res.json()
      })
      // application {} Json 을 커스텀 형태로 변환
      .map((res: EurekaResponse) => {
        var result = res.applications.application
          .map(application => {
            return application.instance
              .map(instance => {
                return {
                  name: application.name,
                  instanceId: instance.instanceId,
                  status: instance.status,
                  infoUrl: instance.statusPageUrl
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
            var {name, instanceId, status, infoUrl} = data
            let row = {
              Application: name,
              info: instanceId,
              status: status,
            }
            this.rows.push(row)
          })
      }, (error) => {
        alert(error)
      }, () => {
      })
  }
}
