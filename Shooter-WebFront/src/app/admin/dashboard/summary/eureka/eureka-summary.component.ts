import {Component, OnInit} from "@angular/core";
import {EurekaApi} from "../../../../shared/http/http-requests.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";
import {EurekaResponse, EUREKA_STATUS} from "./eureka-response";
interface eurekaStatusInfo {
  up: number,
  down: number,
  unknwon: number
}

@Component({
  selector: 'eureka-summary',
  template: `
        <div>
         <progress-summary [hidden]="!viewStatus.isLoading"></progress-summary>
         <error-summary [hidden]="!viewStatus.isError || viewStatus.isLoading"></error-summary>
         <md-card [hidden]="viewStatus.isLoading">
                <i class="material-icons" (click)="update()">refresh</i>
                <div (click)="onDetail()"> 
                  <p>UP {{statusInfo.up}}</p>
                  <p>DOWN {{statusInfo.down}}</p>
                  <p>UNKNWON {{statusInfo.unknwon}}</p>
                </div>    
          </md-card> 
        </div>
       
      
`,
})

export class EurekaSummaryComponent implements OnInit {
  private httpClient = EurekaApi;
  var
  viewStatus = {
    isLoading: true,
  }

  statusInfo: eurekaStatusInfo = {
    up: 0,
    down: 0,
    unknwon: 0
  }

  onDetail() {
    this.router.navigateByUrl('/home/eureka')
  }

  calculateStatusCount(body: EurekaResponse) {
    var eurekaStatusInfo: eurekaStatusInfo = {
      up: 0,
      down: 0,
      unknwon: 0
    }
    body.applications.application
      .map(application => {
        return application.instance
          .forEach(instance => {
            switch (+EUREKA_STATUS[instance.status]) {
              case EUREKA_STATUS.UP:
                eurekaStatusInfo.up++;
                break;
              case EUREKA_STATUS.DOWN:
                eurekaStatusInfo.down++;
                break;
              case EUREKA_STATUS.UNKNWON:
                eurekaStatusInfo.unknwon++;
                break;
            }
          })
      })
    return eurekaStatusInfo;
  }

  constructor(private http: Http, private router: Router) {

  }

  private update() {
    this.httpClient.httpRequest(this.http)
      .subscribe((res) => {
        console.info("subscribe")
        this.calculateStatusCount(res.json())
      }, (error) => {
        console.info("error")
        this.viewStatus.isLoading = false;
      }, () => {
        this.viewStatus.isLoading = false;
      })
  }

  ngOnInit(): void {
    this.update()
  }
}
