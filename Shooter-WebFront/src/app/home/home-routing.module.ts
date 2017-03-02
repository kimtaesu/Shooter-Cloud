import {NgModule} from "@angular/core";
import {LoginComponent} from "../login/login.component";
import {RouterModule} from "@angular/router";
import {JoinComponent} from "../join/join.component";
import {DashBoardComponent} from "../admin/dashboard/dashboard.component";

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
      },
      {
        path: 'dashboard',
        component: DashBoardComponent
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
