import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {Project} from 'src/app/components/interfaces/iprojects'
import { LoginService } from 'src/app/servicios/login.service';
import { PortfolioService } from 'src/app/servicios/portfolio.service';
@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  public projects!: Project[];
  public pathProjects : String = "projects";
  public edit : any;
  public isUserLogged: Boolean = false;

  constructor(
    private infoService : PortfolioService,
    private loginService : LoginService
  ) { }

  ngOnInit(): void {
    this.isUserLogged = this.loginService.isUserLogged();
    this.getProjects();
  }
  getProjects() {
    this.infoService.getInfo(this.pathProjects).subscribe({
      next: (response : Project[]) =>
      (this.projects = response),

      error: (error : HttpErrorResponse) =>
      (alert(error.message))
    })
  }

}
