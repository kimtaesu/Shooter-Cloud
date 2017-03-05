import {Component, OnInit} from "@angular/core";
import {EurekaApi} from "../../../../shared/http/http-requests.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";
import {Applications, DISCOVERY_STATUS} from "./eureka-response";
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
  private response: Applications;
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
    this.router.navigateByUrl('/home/application')
  }

  calculateStatusCount(body: Applications) {
    var eurekaStatusInfo: eurekaStatusInfo = {
      up: 0,
      down: 0,
      unknwon: 0
    }
    body.applications.application
      .map(application => {
        return application.instance
          .forEach(instance => {
            switch (+DISCOVERY_STATUS[instance.status]) {
              case DISCOVERY_STATUS.UP:
                eurekaStatusInfo.up++;
                break;
              case DISCOVERY_STATUS.DOWN:
                eurekaStatusInfo.down++;
                break;
              case DISCOVERY_STATUS.UNKNWON:
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
        this.response = res.json();
        this.statusInfo = this.calculateStatusCount(res.json())
      }, (error) => {
        this.viewStatus.isLoading = false;
      }, () => {
        this.viewStatus.isLoading = false;
      })
  }

  ngOnInit(): void {
    this.update()
  }
}
