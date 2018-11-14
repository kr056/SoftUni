import {
    HttpInterceptor,
    HttpHandler,
    HttpEvent,
    HttpRequest,
} from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from "../auth/auth.service";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

    constructor(private authService: AuthService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if ((req.url.includes('posts') || req.url.includes('comments')) && !(req.url.includes('orderBy'))) {
            if (this.authService.isAuthenticated()) {
                const token = this.authService.getToken();
                req = req.clone({
                    url: `${req.url}?auth=${token}`
                })
            }
        }
        return next.handle(req);
    }
}