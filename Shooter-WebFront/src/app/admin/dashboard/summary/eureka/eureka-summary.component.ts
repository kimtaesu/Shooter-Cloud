import {Component, OnInit} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
@Component({
  selector: 'eureka-summary',
  templateUrl: 'eureka-summary.component.html',
  styleUrls: ['eureka-summary.component.css'],
})
export class EurekaSummaryComponent implements OnInit {
  ngOnInit(): void {
  }

  constructor(private http: Http) {

  }

  onResponse(response: Observable<Response>) {
    response.subscribe((res) => {
      console.log(res)
    })
  }
}
