import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({ //este servicio sea inyectado en los componentes, que lo van a consumir
  providedIn: 'root'
})
export class PortfolioService {
  private apiServerUrl = environment.apiBaseUrl;
  // url:string = 'http://localhost:8080/person';
 constructor(private http:HttpClient) { }

  // obtenerDatos(id:number):Observable<any>{
  // //return this.http.get(`${this.url}`);
  //   return this.http.get(this.url+"/"+id);
  //   //la idea esq ahi escribamos una URL que es el Controller del backend
  //   //, por la cual nos vamos a comuninicar
  //   // vamos a enviar un request, y de ahi se obtienelos datos 
  //   //pero por ahora hacemos que devuelva en un json 
  // }


  public getInfo(path: String): Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/${path}`);
  }
  
  public addInfo(path : String, info : any): Observable<any>{
    return this.http.post<any>(`${this.apiServerUrl}/${path}/add`, info);
  }

  public editInfo(path : String, info : any): Observable<any>{
    return this.http.put<any>(`${this.apiServerUrl}/${path}/edit`, info);
  }

  public deleteInfo(path : String, Id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/${path}/delete/${Id}`);
  }

}
//los observables no son mas que una coleccion de futuros eventos
//a los que nos vamos a suscribi 
// or lo que los componentes que lo consuman puedan suscribrise 
//para esperar la respuesta 