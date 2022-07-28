import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {Project} from 'src/app/components/interfaces/iprojects'
import { LoginService } from 'src/app/servicios/login.service';
import { PortfolioService } from 'src/app/servicios/portfolio.service';
import { NgForm } from '@angular/forms';


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

  public addProyecto(addProyecto: NgForm): void {
    this.infoService.addInfo(this.pathProjects, addProyecto.value ).subscribe({
      next: () => {
        this.getProjects();
        addProyecto.reset();
      },
      error: (error: HttpErrorResponse) => {
        (alert(error.message));
        addProyecto.reset();
      }
    })
  }

  public editProyecto(explab: Project): void {
    this.infoService.editInfo(this.pathProjects, explab ).subscribe({
      next: () => this.getProjects(),

      error: (error: HttpErrorResponse) => {
        (alert(error.message))
      }
    })
  }

  public deleteProyecto(expProyectoId: number): void {
    this.infoService.deleteInfo(this.pathProjects, expProyectoId ).subscribe({
      next: () => this.getProjects(),

      error: (error: HttpErrorResponse) => {
        (alert(error.message))
      }
    })
  }

  public setInfo(info : any): void {
    this.edit = info;
  }
}
