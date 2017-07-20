import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
    moduleId: module.id,
    selector: 'app',
    templateUrl: 'app.component.html'
})

export class AppComponent {
    /*constructor(private translate: TranslateService) {
        translate.addLangs(["ru", "en"]);
        translate.setDefaultLang('ru');

        let browserLang = translate.getBrowserLang();
        translate.use(browserLang.match(/ru|en/) ? browserLang : 'en');
    }*/
}