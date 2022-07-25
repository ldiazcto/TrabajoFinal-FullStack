import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/servicios/login.service';
import { PortfolioService } from 'src/app/servicios/portfolio.service';
import { Person } from '../interfaces/ipersona';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  miPortfolio:any;
  public personas!: Person[];
  public pathPersona: String = "home";
  public edit!: Person;
  public isUserLogged: Boolean = false;

  constructor(
    private datosPortfolio:PortfolioService,
    private loginService: LoginService
 ) { }

  ngOnInit(): any {
    //ahora podemos acceder desde el ng Init, accedemos a los metodos
    //que defini en service que no deja de ser una clase
    this.isUserLogged = this.loginService.isUserLogged();
    this.getPerson();

    // this.datosPortfolio.obtenerDatos(1).subscribe(data =>{
    //     console.log(data);
    //     this.miPortfolio = data;
    //     //console.log("Llegue a encabezado");
    //     //console.log(data);
    //   });
  }

  public getPerson(): any {
    this.datosPortfolio.getInfo(this.pathPersona).subscribe({
      next: (response: Person[]) => 
        (this.personas = response),
      
      error: (error : HttpErrorResponse) =>
        (alert(error.message))
    })
  }

  public editPersona(persona: Person): void {
    this.datosPortfolio.editInfo(this.pathPersona, persona ).subscribe({
      next: () => this.getPerson(),

      error: (error: HttpErrorResponse) => {
        (alert(error.message))
      }
    })
  }

  public setInfo(info : any): void {
    this.edit = info;
  }

}
