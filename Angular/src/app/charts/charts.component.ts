import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';  
import { HttpClient } from '@angular/common/http';  
import { Data } from '../../app/Data';
import { UserService } from '../user.service';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnInit {
  url = 'http://localhost:58617/API/Charts/GetCharts';  
  data: Data[];  
  dates=[];
  volume= [];
  Linechart = [];  
  constructor(private httpClient: HttpClient, private service: UserService) { }  
  ngOnInit() {  
   
     }
     ashokley() {
      this.dates = ['2015-08-14', '2015-08-17', '2015-08-18', '2015-08-19', '2015-08-20'];  
      this.volume = ['155900', '174700', '153300', '130500', '184100'];  
     this  
     this.Linechart = new Chart('canvas', {  
       type: 'line',  
       data: {  
         labels: this.dates,  
         datasets: [  
           {  
             data: this.volume,  
             borderColor: '#3cb371',  
             backgroundColor: "skyblue",  
           }  
         ]  
       },  
       options: {  
         legend: {  
           display: false  
         },  
         scales: {  
           xAxes: [{  
             display: true  
           }],  
           yAxes: [{  
             display: true  
           }],  
         }  
       }  
     });  
  
 }  
 cipla() {
  this.dates = ['2015-09-01', '2015-09-02', '2015-09-03', '2015-09-04', '2015-09-05','2015-09-06','2015-09-07','2015-09-08','2015-09-09'];  
  this.volume = ['2567389', '2734383', '3366027', '4428049', '1844881','2197872','3929856','2561345','4028049'];  
 this  
 this.Linechart = new Chart('canvas', {  
   type: 'line',  
   data: {  
     labels: this.dates,  
     datasets: [  
       {  
         data: this.volume,  
         borderColor: '#3cb371',  
         backgroundColor: "lightgreen",  
       }  
     ]  
   },  
   options: {  
     legend: {  
       display: false  
     },  
     scales: {  
       xAxes: [{  
         display: true  
       }],  
       yAxes: [{  
         display: true  
       }],  
     }  
   }  
 });  

 }
 eichermot() {
  this.dates = ['2016-01-01', '2016-01-04', '2016-01-05', '2016-01-06', '2016-01-07','2016-01-08'];  
  this.volume = ['59966', '91743', '56349', '48794', '49624','28252'];  
 this  
 this.Linechart = new Chart('canvas', {  
   type: 'line',  
   data: {  
     labels: this.dates,  
     datasets: [  
       {  
         data: this.volume,  
         borderColor: '#3cb371',  
         backgroundColor: "skyblue",  
       }  
     ]  
   },  
   options: {  
     legend: {  
       display: false  
     },  
     scales: {  
       xAxes: [{  
         display: true  
       }],  
       yAxes: [{  
         display: true  
       }],  
     }  
   }  
 });  

 }
 Reliance() {
  this.dates = ['2016-03-01', '2016-03-02', '2016-03-03', '2016-03-04', '2016-03-06','2016-03-08'];  
  this.volume = ['7521846', '9191772', '7260012', '4108856', '6045108','5419662'];  
 this  
 this.Linechart = new Chart('canvas', {  
   type: 'line',  
   data: {  
     labels: this.dates,  
     datasets: [  
       {  
         data: this.volume,  
         borderColor: '#3cb371',  
         backgroundColor: "lightpink",  
       }  
     ]  
   },  
   options: {  
     legend: {  
       display: false  
     },  
     scales: {  
       xAxes: [{  
         display: true  
       }],  
       yAxes: [{  
         display: true  
       }],  
     }  
   }  
 });  

 }
 Tatasteel() {
  this.dates = ['2020-08-03', '2020-08-04', '2020-08-05', '2020-08-06', '2020-08-07'];  
  this.volume = ['11136971', '11184260', '30559741', '22122807', '15176317'];  
 this  
 this.Linechart = new Chart('canvas', {  
   type: 'line',  
   data: {  
     labels: this.dates,  
     datasets: [  
       {  
         data: this.volume,  
         borderColor: '#3cb371',  
         backgroundColor: "lightgreen",  
       }  
     ]  
   },  
   options: {  
     legend: {  
       display: false  
     },  
     scales: {  
       xAxes: [{  
         display: true  
       }],  
       yAxes: [{  
         display: true  
       }],  
     }  
   }  
 });  

 }
  
}
