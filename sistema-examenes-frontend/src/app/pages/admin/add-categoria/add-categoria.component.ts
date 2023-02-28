import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CategoriaService } from 'src/app/services/categoria.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-categoria',
  templateUrl: './add-categoria.component.html',
  styleUrls: ['./add-categoria.component.css']
})
export class AddCategoriaComponent implements OnInit{

  categoria = {
    titulo : '',
    descripcion : ''
  }

  constructor(private categoriaService:CategoriaService,private snack:MatSnackBar,private router:Router){

  }

  ngOnInit(): void{
    
  }

  formSubmit(){
    if(this.categoria.titulo.trim() == '' || this.categoria.titulo.trim() == null){
        this.snack.open('El título es reuqerido!!','',{
          duration: 3000
        });
        return;
    }

    this.categoriaService.agregarCategoria(this.categoria).subscribe(
      {
        next: data =>{
          this.categoria.titulo = '';
          this.categoria.descripcion = '';
          Swal.fire('Categoría Guardada','Categoría guardada exitosamente','success');
          this.router.navigate(['/admin/categorias']);
      },
      error: error => {
        console.log(error);
        alert('Ha ocurrido un error en el sistema');
      }
      })
  }
}
