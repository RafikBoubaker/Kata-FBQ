import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { SERVER_API_TRANSFORM } from '../app.constant';
import { TransformResponse } from '../model/transformResponse';


@Injectable({
  providedIn: 'root', 
})
export class KataService {
  

  constructor(private http: HttpClient) {}


  transformNumber(number: number): Observable<TransformResponse> {
    return this.http.get(`${SERVER_API_TRANSFORM}/${number}`, { responseType: 'text' }).pipe(
      map(result => ({
        nombreSaisie: number,
        resultat: result
      }))
    );
  }

}
