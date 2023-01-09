import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
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


  constructor(private snack:MatSnackBar,private loginService:LoginService){ }

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
        console.log(user);
      })
    },(error) => {
      console.log(error);
    }
    )
  }

}
