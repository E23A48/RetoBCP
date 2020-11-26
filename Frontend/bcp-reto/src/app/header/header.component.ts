import { Component, OnInit } from '@angular/core';
import { Client } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { Notify } from './notify';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpRequest, HttpEvent } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';
import * as moment from 'moment';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { Category } from './category';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  animations: [
    trigger('openClose', [
      state('true', style({ color: 'red' })),
      state('false', style({ height: '0px' })),
      transition('false <=> true', [ animate(500) ])
    ])
  ]
})
export class HeaderComponent implements OnInit {

  private client: Client;
  notify: Notify = new Notify();
  searchText;
  notifys: Notify[] = [];
  categories: Category[] = [];
  loginTime: String = moment().format('D [de] MMMM [de] YYYY, h:mm:ss a');
  countNewNotify: number = 0;
  isBellOpen = false;
  constructor(private http: HttpClient) { }
  moment: any = moment;

  ngOnInit(): void {
    moment.locale('es_mx')
    this.getNotifys().subscribe(notifys => {
      this.notifys = notifys
      this.notifys.sort(function(a, b) {
        var keyA = new Date(a.creadtedAt),
          keyB = new Date(b.creadtedAt);
        // Compare the 2 dates
        if (keyA < keyB) return 1;
        if (keyA > keyB) return -1;
        return 0;
      });
      this.notifys.forEach(element => {
        console.log(element);
          if (element.readed == false) {
            this.countNewNotify++;
          }
      });
    });

    this.getCategories().subscribe(categories => {
      this.categories = categories
      console.log(this.categories)
    });

    this.client = new Client();
    this.client.webSocketFactory= () => {
      return new SockJS("http://localhost:8089/notify-websocket");
    };

    this.client.onConnect = (frame) => {
      console.log('Conectado? ' + this.client.connected + ': ' + frame);

      this.client.subscribe('/pusher/webnotify', e => {
        let notify = JSON.parse(e.body) as Notify;
        this.notifys.push(notify);
        this.countNewNotify++;
        this.notifys.sort(function(a, b) {
          var keyA = new Date(a.creadtedAt),
            keyB = new Date(b.creadtedAt);
          // Compare the 2 dates
          if (keyA < keyB) return 1;
          if (keyA > keyB) return -1;
          return 0;
        });
      });
    }

    this.client.activate();
  }

  
  getNotifys(): Observable<Notify[]> {
    return this.http.get<Notify[]>('http://localhost:8089/v1/notifications/all').pipe(
      catchError(e => {
        return throwError(e);
      })
    );
  }

  deleteNotify(id, index) {
    this.notifys.splice(index, 1)
    this.http.delete("http://localhost:8089/v1/notifications/delete/" + id).subscribe(data => {

    });
  }

  getCategories(): Observable<Category[]> {
    return this.http.get<Category[]>('http://localhost:8089/v1/notifications/category/all').pipe(
      catchError(e => {
        return throwError(e);
      })
    );
  }

  public setCountNewNotifys() {
    this.isBellOpen = !this.isBellOpen;
    console.log(this.isBellOpen)
    this.countNewNotify = 0;
    this.setReaded();
  }

  sortNotifys() {
    console.log("a", this.notifys)
  }

  setReaded() {
    this.notifys.forEach(element => {
      if (element.readed == false) {
        console.log(element.id)
        this.http.get("http://localhost:8089/v1/notifications/readed/" + element.id).subscribe(data => {});
      }
    });
  }


}
