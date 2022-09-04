import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
        const pwShowHide = document.querySelectorAll(".show-btn"),
        pwFields = document.querySelectorAll(".password"),
        showBtn = document.querySelector("#eye");

      pwShowHide.forEach(eyeIcon =>{
        eyeIcon.addEventListener("click", () =>{
          pwFields.forEach(pwField =>{
            if((pwField as HTMLInputElement).type === "password"){
              (pwField as HTMLInputElement).type = "text";
              (showBtn as HTMLSpanElement).className = "bi bi-eye-fill";
              
            }else{
              (pwField as HTMLInputElement).type = "password";
              (showBtn as HTMLSpanElement).className = "bi bi-eye-slash-fill";
            }
          })

        })
        
      })
  }

}
