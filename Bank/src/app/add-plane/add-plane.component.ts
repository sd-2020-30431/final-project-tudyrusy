import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {StringObj} from '../welcome/stringObj.model';

@Component({
  selector: 'app-add-plane',
  templateUrl: './add-plane.component.html',
  styleUrls: ['./add-plane.component.css']
})
export class AddPlaneComponent implements OnInit {
  model: string;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  menu() {
    this.router.navigateByUrl('/welcome');
  }

  addPlane() {
    this.http.post<StringObj>('http://localhost:8080/users/addPlane', this.model).subscribe(
      result => {
        console.log(result);
        if (result.myString === 'ok') {
          alert('Plane added');
        } else {
          alert('error');
        }
      },
      error => {
        console.log(error);
        alert('error');
      }
    );
  }
}
