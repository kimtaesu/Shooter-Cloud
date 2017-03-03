import {Component, OnInit, Input} from "@angular/core";
import {Response} from "@angular/http";
@Component({
  selector: 'eureka-summary',
  template: `
                
            `,

})
export class EurekaSummaryComponent implements OnInit {
  @Input('response') response: Response

  ngOnInit(): void {
  }
}
