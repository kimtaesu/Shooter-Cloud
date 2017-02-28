import {Injectable} from "@angular/core";
import {CanDeactivate, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";

export interface CanComponentDeactivate {
  canDeactivate: () => Observable<boolean> | Promise<boolean> | boolean;
}
@Injectable()
export class CanDeactivateGuard implements CanDeactivate<CanComponentDeactivate> {

  constructor(private _router: Router) {
  }

  canDeactivate() {
    return window.confirm("취소하시겠습니까?");
  }
}
