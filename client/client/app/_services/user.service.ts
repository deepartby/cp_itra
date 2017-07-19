import { Injectable } from '@angular/core';
import {Http, Headers, Response, RequestOptions} from '@angular/http';

import { User } from '../_models/index';
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class UserService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/users').map((response: Response) => response.json());
    }

    getById(_id: string) {
        return this.http.get('/users/' + _id).map((response: Response) => response.json());
    }

    create(user: User) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json; charset=utf-8');
        headers.append('X-Requested-With','XMLHttpRequest');
        headers.append('Accept-Encoding','gzip, deflate')
        return this.http.post('/sign-up', JSON.stringify(user), new RequestOptions({headers : headers}));
    }

    update(user: User) {
        return this.http.put('/users/' + user._id, user);
    }

    delete(_id: string) {
        return this.http.delete('/users/' + _id);
    }
}