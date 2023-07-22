import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, retry, throwError} from "rxjs";
import {Intervalo, Refrigeradora, RespuestaLavadoras} from "./interfaces";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json;charset=utf-8'
    })
  };
  errorHandl(error:any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
  constructor(private http: HttpClient) { }

  reporteLavadoras(data: Intervalo): Observable<RespuestaLavadoras> {
    return this.http.post<RespuestaLavadoras>('http://localhost:8081/reporteLavadoras', data,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  updateFlagFreezer(data: Refrigeradora): Observable<Refrigeradora> {
    return this.http.post<Refrigeradora>('http://localhost:8081/updateFlagFreezer', data,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
}
