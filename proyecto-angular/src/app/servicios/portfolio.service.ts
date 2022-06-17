import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ //este servicio sea inyectado en los componentes, que lo van a consumir
  providedIn: 'root'
})
export class PortfolioService {
  url:string = 'http://localhost:8080/person';
  constructor(private http:HttpClient) { }

  obtenerDatos(id:number):Observable<any>{
  //return this.http.get(`${this.url}`);
    return this.http.get(this.url+"/"+id);
    //la idea esq ahi escribamos una URL que es el Controller del backend
    //, por la cual nos vamos a comuninicar
    // vamos a enviar un request, y de ahi se obtienelos datos 
    //pero por ahora hacemos que devuelva en un json 
  }
}
//los observables no son mas que una coleccion de futuros eventos
//a los que nos vamos a suscribi 
// or lo que los componentes que lo consuman puedan suscribrise 
//para esperar la respuesta 