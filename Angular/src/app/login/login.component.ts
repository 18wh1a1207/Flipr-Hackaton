import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NotificationService } from '../notification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:any;
  loggedUser:any;
  demo:any;

  constructor(private service : UserService,private router : Router,private notifyService : NotificationService) {
    this.demo = {mailId : '' , password : ''};
    this.user={};
  }
  showToasterSuccess(){
    this.notifyService.showSuccess("Login Successfull !!", "LOGIN")
}

showToasterError(){
    this.notifyService.showError("Invalid Ceredentials", "FAILED")
}
showToasterSuccess1(){
  this.notifyService.showSuccess("Register Successfull !!", "User Registration")
}
  
  ngOnInit(): void {
  }
  RegisterSubmit(RegisterForm : any): void {
    this.service.registerUser(this.user).subscribe((result: any) =>  {console.log(result); } ) ;
    this.showToasterSuccess1();
    
  }

  async loginSubmit1(loginForm:any) {
    await this.service.loginUser(this.demo.mailId, this.demo.password).then((user) => {console.log(user); this.loggedUser = user} );
    localStorage.setItem('user' , JSON.stringify(this.loggedUser));
    if(this.loggedUser != null){
      this.showToasterSuccess();
      this.router.navigate(['charts']);
    } else {
      this.showToasterError();
    }

  }

}

