import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginData = {
    "username" : '',
    "password" : ''
    }


  constructor(private snack:MatSnackBar,private loginService:LoginService,private router:Router){ }

  ngOnInit(): void{
  }


  formSubmit(){
    if(this.loginData.username.trim() == '' || this.loginData.username.trim() == null){
        this.snack.open('Debe ingresar nombre de usuario!!','Aceptar',{duration:3000})
        return;
    }

    if(this.loginData.password.trim() == '' || this.loginData.password.trim() == null){
      this.snack.open('Debe ingresar su password!!','Aceptar',{duration:3000})
      return;
    }
   
    
    this.loginService.generateToken(this.loginData).subscribe(
    (data:any) => {
      console.log(data);

      this.loginService.loginUser(data.token);
      this.loginService.getCurrentUser().subscribe((user:any) => {
        this.loginService.setUser(user);
        console.log(user);

        if(this.loginService.getUserRole() == "ADMIN"){
          //Mostrar dashboard de administrador con window
          //window.location.href = '/admin';
          
          //Mostrar dashboard de administrador con navigate
          this.router.navigate(['admin']);
          //Evita hacer doble click para iniciar sesión
          this.loginService.loginStatusSubjec.next(true);
        }
        else if(this.loginService.getUserRole() == "NORMAL"){
          //Mostrar dashboard normal
          //window.location.href = '/user';

          //Mostrar dashboard de usuario con navigate
          this.router.navigate(['user']);
          //Evita hacer doble click para iniciar sesión
          this.loginService.loginStatusSubjec.next(true);
        }
        else {
          this.loginService.logout();
        }
      })
    },(error) => {
      console.log(error);
      this.snack.open('Detalles inválidos, vuelva a intentar','Aceptar',{
        duration:3000
      });
    }
    )
  }

}
