import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  text = 'Login';

  constructor() { }

  ngOnInit() {

    const container = document.querySelector(".loginContainer"),
        pwShowHide = document.querySelectorAll(".show"),
        pwFields = document.querySelectorAll(".password");

      pwShowHide.forEach(eyeIcon =>{
        eyeIcon.addEventListener("click", () =>{
          pwFields.forEach(pwField =>{
            if((pwField as HTMLInputElement).type === "password"){
              (pwField as HTMLInputElement).type = "text";

            }else{
              (pwField as HTMLInputElement).type = "password";
            }
          })

        })
        
      })

  }

}
