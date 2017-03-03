import {Component, Input, OnInit} from "@angular/core";
import {EurekaApi, RequestClient} from "../../../shared/http/http-requests.service";
import {Http} from "@angular/http";
import {ProgressSummaryComponent} from "./dynamic/progress-summary.component";
import {ErrorSummaryComponent} from "./dynamic/error-summary.component";
import {MaterialModule} from "@angular/material";
import {EurekaSummaryComponent} from "./dynamic/eureka-summary.component";

enum TypeSummary {
  EUREKA = 0,
}

const DYNAMIC_COMPONENTS = {
  extraModule: MaterialModule,
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
                [componentType]="currentDynamicComponent.component"
                [componentModules]="currentDynamicComponent.extraModule"
                [componentContext]="currentDynamicComponent.context"
                ></DynamicComponent>
            </div>
        </md-card>
    `,
  styleUrls: ['summary-content.component.css'],
})
export class SummaryContentComponent implements OnInit {

  @Input('type') private type: string;
  private httpClient: RequestClient;
  private currentDynamicComponent = {
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
        this.currentDynamicComponent.component = DYNAMIC_COMPONENTS.eureka.component
        this.currentDynamicComponent.context = {response: res}
      }, (error) => {
        this.currentDynamicComponent.component = DYNAMIC_COMPONENTS.error.component
      }, () => {
      })
  }
}
