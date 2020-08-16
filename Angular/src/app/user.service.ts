import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  

  constructor(private httpClient: HttpClient) { }
 
  registerUser(user: any) {
    console.log('Inside service',user);
    return this.httpClient.post('FullStackDevelopment/webapi/myresource/regUser', user);
  }
  loginUser(mailId: any, password: any): any {
    
    return this.httpClient.get('FullStackDevelopment/webapi/myresource/UserLogin/' + mailId + '/' + password).toPromise();
  }

}
