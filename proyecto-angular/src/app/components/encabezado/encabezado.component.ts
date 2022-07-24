import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/servicios/login.service';
import { PortfolioService } from 'src/app/servicios/portfolio.service';
import { Person } from '../interfaces/ipersona';

@Component({
  selector: 'app-encabezado',
  templateUrl: './encabezado.component.html',
  styleUrls: ['./encabezado.component.css']
})
export class EncabezadoComponent implements OnInit {
  miPortfolio:any;
  public personas!: Person[];
  public pathPersona: String = "home";
  public edit!: Person;
  public isUserLogged: Boolean = false;

  constructor(
    private datosPortfolio:PortfolioService,
    private loginService: LoginService

    ) { }

  ngOnInit(): void {
    //ahora podemos acceder desde el ng Init, accedemos a los metodos
    //que defini en service que no deja de ser una clase 
    // this.datosPortfolio.obtenerDatos(1).subscribe(data =>{
    //     console.log(data);
    //     this.miPortfolio = data;
        //en data guardo los datos que serian de User
        //que contoenen nombre apellido about, email etc....
        //console.log("Llegue a encabezado");
        //console.log(data);
      // });
    this.isUserLogged = this.loginService.isUserLogged();
    this.getPersonas();
  
  }
  public getPersonas(): any {
    this.datosPortfolio.getInfo(this.pathPersona).subscribe({
      next: (response: Person[]) => 
        (this.personas = response),
      
      error: (error : HttpErrorResponse) =>
        (alert(error.message))
    })
  }

  public editPersona(persona: Person): void {
    this.datosPortfolio.editInfo(this.pathPersona, persona ).subscribe({
      next: () => this.getPersonas(),

      error: (error: HttpErrorResponse) => {
        (alert(error.message))
      }
    })
  }

  public setInfo(info : any): void {
    this.edit = info;
  }

}
