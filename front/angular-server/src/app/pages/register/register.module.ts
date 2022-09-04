import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './register.component';
import { HttpClientModule } from '@angular/common/http';
import {
  FormsModule,
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FormBuilder,
    FormGroup,
    Validators,
  ],
  declarations: [RegisterComponent],
  exports: [RegisterComponent],
})
export class RegisterModule {}
