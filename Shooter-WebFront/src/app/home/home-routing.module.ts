import {NgModule} from "@angular/core";
import {LoginComponent} from "../login/login.component";
import {RouterModule} from "@angular/router";
import {JoinComponent} from "../join/join.component";

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'join',
        component: JoinComponent
      }
    ]),
  ],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
export const homepRoutingProviders = [
  // authProviders,
  // CanDeactivateGuard
];
