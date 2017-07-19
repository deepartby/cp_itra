/**
 * Created by top_user on 7/19/2017.
 */
import { Component, OnInit } from '@angular/core';

@Component({
    moduleId: module.id,
    templateUrl: 'menu.component.html'
})

export class MenuComponent implements OnInit {

    model: any = {};
    loading = false;
    returnUrl: string;

    ngOnInit(){}
}