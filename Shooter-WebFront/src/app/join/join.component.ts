import {Component, OnInit} from "@angular/core";
import {FormGroup, Validators, FormControl} from "@angular/forms";
import {ValidationService} from "../shared/validator/validator";

@Component({
  selector: 'app-join',
  templateUrl: 'join.component.html',
  styleUrls: ['join.component.css']
})
export class JoinComponent implements OnInit {

  Form: FormGroup;
  user = {
    email: '',
    userName: '',
    password: '',
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
}
