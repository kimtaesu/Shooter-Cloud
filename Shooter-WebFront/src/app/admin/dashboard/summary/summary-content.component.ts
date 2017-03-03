import {Component, Input, OnInit} from "@angular/core";
import {TypeSummary} from "./summary-provider";

@Component({
  selector: 'summary-content',
  template: `
        <md-card>
            <div>
                <md-progress-circle mode="indeterminate" [color]="color"></md-progress-circle>
            </div>
            <div [hidden]="!isFetch">
                <i class="material-icons">warning</i>
                <p>요청을 실패하였습니다.</p>
            </div>
            <div>
                            
            </div>
        </md-card>
    `,
  styleUrls: ['summary-content.component.css'],
})
export class SummaryContentComponent implements OnInit{

  @Input('type') private type: TypeSummary

  // ngOnChanges() { console.log("2--컴포넌트 : ngOnChanges()" + this.type); }
  ngOnInit() {
    console.log(TypeSummary.EUREKA)
    console.log(TypeSummary[this.type])
    // switch (TypeSummary[this.type]) {
    //   case TypeSummary.EUREKA:
    //     console.log("haha")
    //     break;
    // }
  }
  // ngDoCheck() { console.log("4----컴포넌트 : ngDoCheck()"+ this.type); }
  // ngAfterContentInit() { console.log("5-----컴포넌트 : ngAfterContentInit()"+ this.type); }
  // ngAfterContentChecked() { console.log("6------컴포넌트 : ngAfterContentChecked()"+ this.type); }
  // ngAfterViewInit() { console.log("7-------컴포넌트: ngAfterViewInit()"+ this.type); }
  // ngAfterViewChecked() { console.log("8--------컴포넌트 : ngAfterViewChecked"+ this.type); }
  // ngOnDestroy() { console.log("9---------컴포넌트 : ngOnDestroy()"+ this.type); }

  // ngOnInit(): void {
  //   console.log(this.type)
  //   switch (TypeSummary[this.type]) {
  //     case TypeSummary.EUREKA.valueOf():
  //       console.log("haha")
  //       break;
  //   }
  // }
}
