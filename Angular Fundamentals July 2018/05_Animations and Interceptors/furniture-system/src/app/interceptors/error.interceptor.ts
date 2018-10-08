import {
    HttpResponse,
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor,
} from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(private toastr: ToastrService) {

    }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(req)
            .pipe(catchError((errRes) => {

                switch (errRes.status) {
                    case 401:
                        this.toastr.error(errRes.error.message);
                        break;
                    case 400:
                        const message = Object.keys(errRes.error.errors)
                            .map(e => errRes.error.errors[e])
                            .join('\n');
                        this.toastr.error(message);
                        break;
                }

                return throwError(errRes);
            }));
    }
}