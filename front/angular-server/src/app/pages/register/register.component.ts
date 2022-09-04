import { Component, OnInit } from '@angular/core';
import {
  FormsModule,
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  registrationForm: FormGroup | any;

  constructor(private fb: FormBuilder, private http: HttpClient) {}

  ngOnInit() {
    const pwShowHide = document.querySelectorAll('.show-btn'),
      pwFields = document.querySelectorAll('.password'),
      showBtn = document.querySelector('#eye'),
      url = 'localhost:8080/api/v1/registration';

    this.registrationForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', Validators.required, Validators.email],
      name: ['', Validators.required],
      country: ['', Validators.required],
      phone_number: ['', Validators.required, Validators.pattern('[0-9]{10}')],
      birth_date: ['', Validators.required],
      password: [
        '',
        Validators.required,
        Validators.pattern(
          '^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|]).{8,32}$'
        ),
      ],
    });

    // Password Validation and icon toggle

    // Password Validation

    // Icon toggle
    pwShowHide.forEach((eyeIcon) => {
      eyeIcon.addEventListener('click', () => {
        pwFields.forEach((pwField) => {
          if ((pwField as HTMLInputElement).type === 'password') {
            (pwField as HTMLInputElement).type = 'text';
            (showBtn as HTMLSpanElement).className = 'bi bi-eye-fill';
          } else {
            (pwField as HTMLInputElement).type = 'password';
            (showBtn as HTMLSpanElement).className = 'bi bi-eye-slash-fill';
          }
        });
      });
    });
  }
}
