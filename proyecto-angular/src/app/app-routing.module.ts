import { NgModule } from '@angular/core';
import { BaseRouteReuseStrategy, RouterModule, Routes } from '@angular/router';
import { AcercaDeComponent } from './components/acerca-de/acerca-de.component';
import { HabilidadesComponent } from './components/habilidades/habilidades.component';
import { IniciarSesionComponent } from './components/iniciar-sesion/iniciar-sesion.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';

const routes: Routes = [
  // {path: 'acerca-de', component: AcercaDeComponent},
  // {path: 'proyectos', component: ProyectosComponent},
  // {path: 'skills', component: HabilidadesComponent },
  // {path: 'home', component: BaseRouteReuseStrategy },
  {path: 'login', component: IniciarSesionComponent},
  // {path: '', redirectTo: '/home', pathMatch:'full' },
  { path: '**', redirectTo: '/home'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
