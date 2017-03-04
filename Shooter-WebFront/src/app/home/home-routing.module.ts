import {NgModule} from "@angular/core";
import {LoginComponent} from "../login/login.component";
import {RouterModule} from "@angular/router";
import {JoinComponent} from "../join/join.component";
import {DashBoardComponent} from "../admin/dashboard/dashboard.component";
import {HomeComponent} from "./home.component";
import {EurekaDetailComponent} from "../admin/dashboard/summary/eureka/detail/eureka-detail.component";

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
        path: 'home',
        component: HomeComponent,
        children: [
          {
            path: 'dashboard',
            component: DashBoardComponent
          },
          {
            path: 'eureka',
            component: EurekaDetailComponent
          }
        ],
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
