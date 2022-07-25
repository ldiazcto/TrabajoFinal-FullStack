import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/servicios/login.service';
import { PortfolioService } from 'src/app/servicios/portfolio.service';
import { Person } from '../interfaces/ipersona';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bar',
  templateUrl: './bar.component.html',
  styleUrls: ['./bar.component.css']
})
export class BarComponent implements OnInit {
  miPortfolio:any;
  public personas!: Person[];
  public pathPersona: String = "home";
  public edit!: Person;
  public isUserLogged: Boolean = false;

  constructor(
    private loginService: LoginService,
    private datosPortfolio: PortfolioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.isUserLogged = this.loginService.isUserLogged();
    this.getPerson();
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

  public logOut():void {
    this.loginService.logout();
    this.isUserLogged = false;
    this.router.navigate(['/login']);
    window.location.reload();
  }
}
