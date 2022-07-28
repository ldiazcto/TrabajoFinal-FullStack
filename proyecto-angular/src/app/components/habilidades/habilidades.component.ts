import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Skill} from 'src/app/components/interfaces/iskills'
import { LoginService } from 'src/app/servicios/login.service';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {

  public skills!: Skill[];
  public pathSkills : String = "skills";
  public edit : any;
  public isUserLogged: Boolean = false;

  constructor(
    private infoService : PortfolioService,
    private loginService : LoginService) {

    }

  ngOnInit(): void {
    this.isUserLogged = this.loginService.isUserLogged();
    this.getSkills();
  }
//la info que traigo desde el backend la guardo en skills
  getSkills() {
    this.infoService.getInfo(this.pathSkills).subscribe({
      next: (response: Skill[]) => 
        (this.skills = response),
      
      error: (error : HttpErrorResponse) =>
        (alert(error.message))
    })
  }

  public add_skill(addFormSkill: NgForm): void {
    this.infoService.addInfo(this.pathSkills, addFormSkill.value ).subscribe({
      next: () => {
        this.getSkills();
        addFormSkill.reset();
      },
      error: (error: HttpErrorResponse) => {
        (alert(error.message));
        addFormSkill.reset();
      }
    })
  }

  public edit_skill(skills: Skill): void {
    this.infoService.editInfo(this.pathSkills, skills ).subscribe({
      next: () => this.getSkills(),

      error: (error: HttpErrorResponse) => {
        (alert(error.message))
      }
    })
  }

  public delete_skill(skillId: number): void {
    this.infoService.deleteInfo(this.pathSkills, skillId ).subscribe({
      next: () => this.getSkills(),

      error: (error: HttpErrorResponse) => {
        (alert(error.message))
      }
    })
  }
  public setInfo(info : any): void {
    this.edit = info;
  }
}
