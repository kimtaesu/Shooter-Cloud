import {Component, OnInit} from "@angular/core";
import "rxjs/add/operator/concatMap";
import {ActivatedRoute} from "@angular/router";
import {Http, Response} from "@angular/http";
import {QueryInstance} from "../../../../shared/http/http-requests.service";
import {Application_Instance} from "../application-response";

@Component({
  templateUrl: './application-detail.component.html'
})
export class ApplicationDetailComponent implements OnInit {
  ngOnInit() {
    var data = {
      labels: ['January', 'February'],
      datasets: [{
        label: 'My First dataset',
        fillColor: 'color',
        strokeColor: 'color',
        pointColor: 'color',
        pointStrokeColor: '#fff',
        pointHighlightFill: '#fff',
        pointHighlightStroke: 'color',
        data: [65, 59, 80, 81, 56, 55, 40]
      }]
    };
    var cline: any = document.getElementById('cline');
    new Chart(cline.getContext('2d')).Line(data, { responsive: true });
  }

  single = [
    {
      "name": "Germany",
      "value": 8940000
    },
    {
      "name": "USA",
      "value": 5000000
    },
    {
      "name": "France",
      "value": 7200000
    }
  ];

  view: any[] = [700, 400];
  // options
  showLegend = false;
  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };
  // pie
  showLabels = false;
  explodeSlices = true;
  doughnut = true;
  instance: Application_Instance;

  constructor(private http: Http, private activatedRoute: ActivatedRoute) {
    activatedRoute.params
      .map(data => {
        return data['instanceId'];
      })
      .concatMap(instanceId => {
        return QueryInstance.httpRequest(http, instanceId)
      })
      .map((res: Response) => {
        var response: Application_Instance = res.json().instance
        response.metricsUrl = response.homePageUrl + 'metrics';
        console.info(response)
        return response;
      })
      .concatMap(res => {
        return this.http.get(res.metricsUrl)
          .map(res => {
            return res;
          })
      })
      .subscribe((instance) => {
        // this.instance = instance;
        console.info(instance)
      }, error => {
        alert(error)
      })
  }


}
