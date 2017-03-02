import {Component, OnInit} from "@angular/core";
import {FormGroup, Validators, FormControl} from "@angular/forms";
import {ValidationService} from "../shared/validator/validator";
import {Http, RequestOptionsArgs} from "@angular/http";
import {environment} from "../../environments/environment";
import {getJsonUtf8Header} from "../../common/header-support";

@Component({
  selector: 'app-join',
  templateUrl: 'join.component.html',
  styleUrls: ['join.component.css']
})
export class JoinComponent implements OnInit {

  Form: FormGroup;
  user = {
    userEmail: '',
    userName: '',
    password: '',
  }

  constructor(private http: Http) {

  }

  ngOnInit(): void {
    this.Form = new FormGroup({
      email: new FormControl('', Validators.compose([Validators.required, ValidationService.emailValidator])),
      password: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(20),
        ValidationService.passwordValidator])),
      userName: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(20),
      ])),
    });
  }

  onSave() {
    // let requests: RequestOptionsArgs = {
    //   headers: getJsonUtf8Header()
    // }
    // console.log(requests.headers)
    // this.http.post(environment.api.join, JSON.stringify(this.user), requests)
    //   .subscribe((res) => {
    //     console.info(res)
    //   }, (error) => {
    //     console.info(error)
    //   });
  }
}
