import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { NotfoundComponent } from './pages/notfound/notfound.component';
import { EditProfile } from './pages/editprofile/editprofile.component';
import { RegisterComponent } from './pages/register/register.component';


const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'editprofile', component: EditProfile},
  {path: 'register', component: RegisterComponent},
  {path: '**', component: NotfoundComponent},
  

];

@NgModule({
  imports: [
    BrowserModule ,RouterModule.forRoot(appRoutes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

