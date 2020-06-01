import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {StringObj} from '../welcome/stringObj.model';
import {PlaneModel1} from './plane.model1';

@Component({
  selector: 'app-add-plane',
  templateUrl: './add-plane.component.html',
  styleUrls: ['./add-plane.component.css']
})
export class AddPlaneComponent implements OnInit {
  plane: PlaneModel1 = new PlaneModel1();
  pilotIds: number[];
  item;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
    this.http.get<number[]>('http://localhost:8080/users/getPilots').subscribe(
      result => {
        console.log(result);
        this.pilotIds = result;
      },
      error => {
        console.log(error);
      }
    );
  }

  menu() {
    this.router.navigateByUrl('/welcome');
  }

  addPlane() {
    this.item = (document.getElementById('item')) as HTMLSelectElement;
    this.plane.pilotId = +(this.item.options[this.item.selectedIndex].text.toString());
    this.http.post<StringObj>('http://localhost:8080/users/addPlane', this.plane).subscribe(
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
