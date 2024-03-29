import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,  } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/servicios/login.service';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {
  form: FormGroup;
  loginError: Boolean = false;

  constructor(
    private loginService : LoginService,
    private formBuilder : FormBuilder,
    private router: Router
  ) {
    this.form = this.formBuilder.group(
      {
        name: ['', [Validators.required]],
        password: ['', [Validators.required]]
      }
    )
   }

  ngOnInit(): void {
  }

  onSubmit(event: Event) {
    event.preventDefault;

    this.loginService.login(this.form.value).subscribe(
      (response: Boolean) => {
        if (response){
          // window.location.reload();
          // this.router.navigate(['/login']);
          console.log('iniciar-sesion Component');
          console.log(response);
          window.location.reload();
        }
        else {
          this.loginError = true;
        }
      }
    );
  }

}
