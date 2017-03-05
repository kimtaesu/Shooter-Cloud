import {Component, OnInit} from "@angular/core";
import {QueryApps} from "../../../../shared/http/http-requests.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";
import {Applications, DISCOVERY_STATUS} from "../application-response";
interface applicationStatusInfo {
  up: number,
  down: number,
  unknwon: number
}

@Component({
  selector: 'application-summary',
  template: `
        <div>
         <progress-summary [hidden]="!viewStatus.isLoading"></progress-summary>
         <error-summary [hidden]="!viewStatus.isError || viewStatus.isLoading"></error-summary>
         <md-card [hidden]="viewStatus.isLoading">
                <i class="material-icons" (click)="update()">refresh</i>
                <div (click)="onClick()"> 
                  <p>UP {{statusInfo.up}}</p>
                  <p>DOWN {{statusInfo.down}}</p>
                  <p>UNKNWON {{statusInfo.unknwon}}</p>
                </div>    
          </md-card> 
        </div>
       
      
`,
})

export class ApplicationSummaryComponent implements OnInit {
  private httpClient = QueryApps;
  private response: Applications;
  var
  viewStatus = {
    isLoading: true,
  }

  statusInfo: applicationStatusInfo = {
    up: 0,
    down: 0,
    unknwon: 0
  }

  onClick() {
    this.router.navigate(['home', 'application'])
  }

  calculateStatusCount(body: Applications) {
    var applicationStatusInfo: applicationStatusInfo = {
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
                applicationStatusInfo.up++;
                break;
              case DISCOVERY_STATUS.DOWN:
                applicationStatusInfo.down++;
                break;
              case DISCOVERY_STATUS.UNKNWON:
                applicationStatusInfo.unknwon++;
                break;
            }
          })
      });
    return applicationStatusInfo;
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
