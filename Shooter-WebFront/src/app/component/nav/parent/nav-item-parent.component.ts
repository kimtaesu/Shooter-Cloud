import {Component, OnInit} from "@angular/core";
import {navItems} from "../items";
@Component({
  selector: "nav-item-parent",
  templateUrl: 'nav-item-parent.component.html',
  styleUrls: ['nav-item-parent.component.css'],
})
export class NavItemParentComponent {

  items = navItems;

  onSubItemToggle()
  {
    console.log("asdad")
  }
}
