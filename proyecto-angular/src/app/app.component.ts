import { Component } from '@angular/core';

@Component({ // se crea un decorador 
  selector: 'app-root', //para incluir en el futuro en nuestra aplicacion 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent { //accesible afuer 
  title = 'proyecto-angular';


  getName(): void{
    console.log('Hola Luz')
  }
}
