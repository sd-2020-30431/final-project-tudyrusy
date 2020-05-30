import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {UserModel} from './user.model';
import {HttpHeaders} from '@angular/common/http';
import {StringObj} from './stringObj.model';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})

export class WelcomeComponent implements OnInit {
  actualToken: string;
  userModel: UserModel = new UserModel();
  admin = false;
  role: string;

  constructor(private http: HttpClient, private router: Router) {
  }

  /*add() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        token: this.actualToken
      })
    };
    this.http.post('http://localhost:8080/users/addItem', this.itemModel, httpOptions).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
        alert('Error');
      }
    );
    setTimeout(() => {
      this.getItems();
    }, 2000);
  }*/

  viewProfile() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        token: this.actualToken
      })
    };
    this.http.get<UserModel>('http://localhost:8080/users/viewProfile', httpOptions).subscribe(
      newUser => {
        this.userModel = newUser;
        console.table(this.userModel);
      },
      error => console.log(error)
    );
  }

  /*getItems() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        token: window.localStorage.getItem('token')
      })
    };
    this.http.get<ItemModel1[]>('http://localhost:8080/users/getItems',
      httpOptions).subscribe(result => {
        this.itemsModel = result;
        console.table(this.itemsModel);
      },
      error => console.log(error));
    setTimeout(() => {
      this.subject.getWaste(this.itemsModel, this.userModel.goal);
    }, 1500);
  }*/

  logout() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        token: this.actualToken
      })
    };
    this.http.get('http://localhost:8080/users/logout', httpOptions).subscribe(result => console.log(result), error => console.log(error));
    this.router.navigateByUrl('/login');
  }

  ngOnInit() {
    this.actualToken = window.localStorage.getItem('token');
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        token: this.actualToken
      })
    };
    this.http.get<StringObj>('http://localhost:8080/users/getRole', httpOptions).subscribe(result => {
      console.log(result);
      this.role = result.myString;
    }, error => console.log(error));
    this.viewProfile();
  }
}
