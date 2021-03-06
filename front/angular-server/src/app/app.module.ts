import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './pages/home/home.component';
import {LoginComponent} from './pages/login/login.component';

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', component: HomeComponent},
  {path: 'login', component: LoginComponent},

];

@NgModule({
  declarations: [	
    AppComponent,
    HomeComponent,
    LoginComponent,
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    // AngularFireModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  // constructor() {
  // //   FirebaseTSApp.init(environment.firebaseConfig);
  // }
}
