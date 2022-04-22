import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './pages/home/home.component';
// import { AngularFireModule } from '@angular/fire';

// import { FirebaseTSApp } from 'firebasets/firebasetsApp/firebaseTSApp';
// import { environment } from 'src/environments/environment';
const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', component: HomeComponent},

];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
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
