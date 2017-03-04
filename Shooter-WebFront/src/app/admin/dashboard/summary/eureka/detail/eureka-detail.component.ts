import {Component} from "@angular/core";
@Component({
  templateUrl: './eureka-detail.component.html'
})
export class EurekaDetailComponent {
  rows = [
    {application: 'Austin', gender: 'Male', company: 'Swimlane'},
    {application: 'Dany', gender: 'Male', company: 'KFC'},
    {application: 'Molly', gender: 'Female', company: 'Burger King'},
  ];
  columns = [
    {name: 'Application'},
    {name: 'Gender'},
    {name: 'Company'}
  ];
}
