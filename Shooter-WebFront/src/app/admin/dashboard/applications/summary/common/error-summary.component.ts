import {Component} from "@angular/core";
@Component({
  selector: 'error-summary',
  template: `
            <i class="material-icons">warning</i>
                <p>요청을 실패하였습니다.</p>
            `,
})
export class ErrorSummaryComponent {

}
