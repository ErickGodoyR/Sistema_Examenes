import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarExamenComponent } from './pages/admin/actualizar-examen/actualizar-examen.component';
import { AddCategoriaComponent } from './pages/admin/add-categoria/add-categoria.component';
import { AddExamenComponent } from './pages/admin/add-examen/add-examen.component';
import { AddPreguntaComponent } from './pages/admin/add-pregunta/add-pregunta.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { ViewCategoriasComponent } from './pages/admin/view-categorias/view-categorias.component';
import { ViewExamenPreguntasComponent } from './pages/admin/view-examen-preguntas/view-examen-preguntas.component';
import { ViewExamenesComponent } from './pages/admin/view-examenes/view-examenes.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AdminGuard } from './services/admin.guard';
import { NormalGuard } from './services/normal.guard';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full'
  },
  {
   path:'signup',
   component:SignupComponent,
   pathMatch:'full' 
  },
  {
    path:'login',
    component:LoginComponent,
    pathMatch: 'full'
  },
  {
    path:'admin',
    component:DashboardComponent,
    canActivate:[AdminGuard],
    children:[
      {
        path:'profile',
        component:ProfileComponent
      },
      {
        path:'',
        component: WelcomeComponent
      },
      {
        path:'categorias',
        component: ViewCategoriasComponent
      },
      {
        path:'agregar-categoria',
        component: AddCategoriaComponent
      },
      {
        path:'examenes',
        component: ViewExamenesComponent
      },
      {
        path:'agregar-examen',
        component: AddExamenComponent
      },
      {
        path:'examen/:examenId',
        component:ActualizarExamenComponent
      },
      {
        path:'ver-preguntas/:examenId/:titulo',
        component:ViewExamenPreguntasComponent
      },
      {
        path:'add-pregunta/:examenId/:titulo',
        component: AddPreguntaComponent
      }
    ]
  },
  {
    path:'user',
    component:UserDashboardComponent,
    pathMatch: 'full',
    canActivate:[NormalGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
