import {Component, OnInit} from "@angular/core";
import {logger} from "codelyzer/util/logger";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],

})
export class HomeComponent implements OnInit {
  ngOnInit(): void {
  }

  constructor() {
    var a = 10;
  }

  navigateToHome() {
    logger.info("navigateToHome");
  }

  navigateToHeros() {
    logger.info("navigateToHeros");
  }
}
