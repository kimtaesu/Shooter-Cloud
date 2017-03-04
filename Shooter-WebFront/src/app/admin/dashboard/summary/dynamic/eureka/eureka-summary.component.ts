import {Component, OnInit, Input} from "@angular/core";
import {Response} from "@angular/http";
import {EUREKA_STATUS} from "./eureka-response";

interface eurekaStatusInfo {
  up: number,
  down: number,
  unknwon: number
}

@Component({
  selector: 'eureka-summary',
  template: `
                <p>UP {{statusInfo.up}}</p>
                <p>DOWN {{statusInfo.down}}</p>
                <p>UNKNWON {{statusInfo.unknwon}}</p>
            `,
})

export class EurekaSummaryComponent implements OnInit {
  @Input('response') response: Response
  statusInfo: eurekaStatusInfo = {
    up: 0,
    down: 0,
    unknwon: 0
  }

  calculateStatusCount() {
    var eurekaStatusInfo: eurekaStatusInfo = {
      up: 0,
      down: 0,
      unknwon: 0
    }
    this.response.json().applications.application
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

  ngOnInit(): void {
    this.statusInfo = this.calculateStatusCount()
  }

}
