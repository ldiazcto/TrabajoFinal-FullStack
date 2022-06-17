import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-encabezado',
  templateUrl: './encabezado.component.html',
  styleUrls: ['./encabezado.component.css']
})
export class EncabezadoComponent implements OnInit {
  miPortfolio:any;

  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    //ahora podemos acceder desde el ng Init, accedemos a los metodos
    //que defini en service que no deja de ser una clase 
    this.datosPortfolio.obtenerDatos(1).subscribe(data =>{
        console.log(data);
        this.miPortfolio = data;
        //en data guardo los datos que serian de User
        //que contoenen nombre apellido about, email etc....
        //console.log("Llegue a encabezado");
        //console.log(data);
      });
  }
}
