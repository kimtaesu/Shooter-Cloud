import {Component, Input, OnInit} from "@angular/core";
import {EurekaApi, RequestClient} from "../../../shared/http/http-requests.service";
import {Http, Response} from "@angular/http";
import {ProgressSummaryComponent} from "./dynamic/progress-summary.component";
import {ErrorSummaryComponent} from "./dynamic/error-summary.component";
import {EurekaSummaryComponent} from "./dynamic/eureka/eureka-summary.component";
import {DynamicModule} from "./dynamic/dynamic.module";
import {GroupByPipe} from "ngx-pipes/src/app/pipes/array";

enum TypeSummary {
  EUREKA = 0,
}

let DYNAMIC_COMPONENTS = {
  extraModule: DynamicModule,

  progress: {
    component: ProgressSummaryComponent,
  },
  error: {
    component: ErrorSummaryComponent,
  },
  context: {
    response: null
  },
  eureka: {
    component: EurekaSummaryComponent,
  },
}
@Component({
  selector: 'summary-content',
  template: `
        <md-card>
            <div>
                <DynamicComponent 
                [componentType]="currentDynamicDirector.component"
                [componentContext]="currentDynamicDirector.context"
                [componentModules]="currentDynamicDirector.extraModule"
                ></DynamicComponent>
            </div>
        </md-card>
    `,
  styleUrls: ['summary-content.component.css'],
})
export class SummaryContentComponent implements OnInit {

  @Input('type') private type: string;
  private httpClient: RequestClient;
  private currentDynamicDirector = {
    component: DYNAMIC_COMPONENTS.progress.component,
    extraModule: DYNAMIC_COMPONENTS.extraModule,
    context: null
  }

  constructor(private http: Http) {
  }

  ngOnInit() {
    switch (TypeSummary[this.type.toUpperCase()]) {
      case TypeSummary.EUREKA:
        this.httpClient = EurekaApi;
        break;
      default:
        throw new Error('Parameter 형식이 잘못되었습니다. TypeSummary 를 참조하세요!')
    }
    this.httpClient.httpRequest(this.http)
      .subscribe((res) => {
        this.currentDynamicDirector.component = DYNAMIC_COMPONENTS.eureka.component
        this.currentDynamicDirector.context = {response: res}
      }, (error) => {
        this.currentDynamicDirector.component = DYNAMIC_COMPONENTS.error.component
      }, () => {
      })
  }
}
