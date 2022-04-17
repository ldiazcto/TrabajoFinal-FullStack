import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    //ahora podemos acceder desde el ng Init, accedemos a los metodos
    //que defini en service que no deja de ser una clase 
    this.datosPortfolio.obtenerDatos(1).subscribe(data =>{
        console.log(data);
        this.miPortfolio = data;
        //console.log("Llegue a encabezado");
        //console.log(data);
      });
  }

}
