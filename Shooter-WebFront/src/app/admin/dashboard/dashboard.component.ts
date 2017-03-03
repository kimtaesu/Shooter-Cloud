import {Component, Input, OnInit} from "@angular/core";
import {TypeSummary} from "./summary/summary-provider";
@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashBoardComponent {

  ngAfterViewInit() {
    console.log(this.type)
  }
  @Input('type') type: TypeSummary

}
