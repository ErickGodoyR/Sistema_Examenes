import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  
  public user = {
    username : '',
    password : '',
    nombre : '',
    apellido : '',
    email : '',
    telefono :''
  }

  constructor(private userService:UserService,private snack:MatSnackBar){}

  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.user);
    if(this.user.username == '' || this.user.username == null){
      this.snack.open('Debe ingresar nombre de usuario!!','ACEPTAR',{
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    this.userService.añadirUsuario(this.user).subscribe(
      {
        next: data =>{
          console.log(data);
          Swal.fire('Usuario Guardado','Usuario guardado exitosamente en el sistema','success');
        //alert('Usuario ha sido guardado con éxito');
      },
      error: error => {
        console.log(error);
        alert('Ha ocurrido un error en el sistema');
      }
      })
  }


}

  