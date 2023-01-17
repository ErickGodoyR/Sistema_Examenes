import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{

  user:any = null;

  constructor(private loginService:LoginService){

  }

  ngOnInit(): void{
    //Para mostrar el usuario actual que está conectado
    this.user = this.loginService.getUser();

    //Otra opcion para ver al usuario que está conectado
    /*this.loginService.getCurrentUser().subscribe(
      (user:any) => {
        this.user = user;
      },
      (error) => {
        alert("error");
      }
    )
    */
  }
}
