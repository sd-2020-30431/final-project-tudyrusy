import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {HttpHeaders} from '@angular/common/http';
import {StringObj} from './stringObj.model';
import {PlaneModel} from './plane.model';
import {PlaneModelFull} from './plane.model.full';
import {ReportModel} from './report.model';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})

export class WelcomeComponent implements OnInit {
  actualToken: string;
  role: string;
  planes: PlaneModel[];
  view: string;
  plane: PlaneModelFull;
  reports: ReportModel[];
  view0: string;
  report: ReportModel;
  pilotok: number;

  constructor(private http: HttpClient, private router: Router) {
  }

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

  addPlane(): void {
    this.router.navigateByUrl('/addPlane');
  }

  ngOnInit() {
    this.view = 'menu';
    this.view0 = 'menu';
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
      if (result.myString === 'PILOT') {
        const timerId = setInterval(() => this.http.get<number>('http://localhost:8080/users/getp', httpOptions).subscribe(result1 => {
          console.log(result1);
          this.pilotok = result1;
        }, error => console.log(error)), 2000);
      }
    }, error => console.log(error));
  }

  getPlanes() {
    this.http.get<PlaneModel[]>('http://localhost:8080/users/getPlanes').subscribe(result => {
      console.log(result);
      this.planes = result;
    }, error => console.log(error));
  }


  checkPlane(id: number) {
    this.http.post<PlaneModelFull>('http://localhost:8080/users/checkPlane', id).subscribe(result => {
      console.log(result);
      this.plane = result;
    }, error => console.log(error));
    this.view = 'plane';
  }

  sp() {
    this.view = 'menu';
  }

  wok() {
    this.plane.ws = 1;
  }

  wnok() {
    this.plane.ws = 2;
  }

  eok() {
    this.plane.es = 1;
  }

  enok() {
    this.plane.es = 2;
  }

  lgok() {
    this.plane.lgs = 1;
  }

  lgnok() {
    this.plane.lgs = 2;
  }

  save() {
    this.http.post('http://localhost:8080/users/save', this.plane).subscribe(result => {
      console.log(result);
      alert('saved');
    }, error => console.log(error));
    setTimeout(() => {
      this.getPlanes();
    }, 1500);
  }

  viewReport(r: ReportModel) {
    this.view0 = 'report';
    this.report = r;
  }

  getReports() {
    this.http.get<ReportModel[]>('http://localhost:8080/users/getReports').subscribe(result => {
      console.log(result);
      this.reports = result;
    }, error => console.log(error));
  }

  sp0() {
    this.view0 = 'menu';
  }

  pok(id: number) {
    this.http.post('http://localhost:8080/users/pok', id).subscribe(result => {
      console.log(result);
      alert('Sent OK to PILOT');
    }, error => console.log(error));
  }

  pnok(id: number) {
    this.http.post('http://localhost:8080/users/pnok', id).subscribe(result => {
      console.log(result);
      alert('Sent NOT OK to PILOT');
    }, error => console.log(error));
  }
}
