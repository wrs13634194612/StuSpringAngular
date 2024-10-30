
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class Service {
  url = 'https://demo.restheart.org/messages';

  constructor(private http: HttpClient) {
  }

  public get(page: number = 1): Observable<Array<any>> {
    return this.http.get<Array<any>>(`${this.url}?pagesize=5&page=${page}`);
  }

  public size(): Observable<any> {
    return this.http.get(`${this.url}/_size`);
  }

  public delete(id: string): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public getSingleCharacterz(id:string):Observable<any>{
    return this.http.get(`http://localhost:5000/api/water`)
  }

  public getShop(id:string):Observable<any>{
    return this.http.get(`http://localhost:5000/api/shop`)
  }

  public postAddShop(data: any): Observable<any> {
    const shop =  {
      position: '772024102801',
      icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
      name: '兰州拉面',
      phone: '13952141236',
      address: '成都市双流区华阳时代广场a栋701室'
    }
    return this.http.post(`http://localhost:5000/api/shopadd`, shop);
  }



  public postSingleCharacterz(data: any): Observable<any> {
    const water =  {
      watername: '韩红牌纯净水',
      watericon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
      waterstyle: '幻想中...',
      watersize: '50L',
      waterprice: '32',
      shopaccount: '772024102801',
      shopname: '大润发超市'
    }
    return this.http.post(`http://localhost:5000/api/wateradd`, water);
  }


  public post(data: any): Observable<any> {
    const _data = {
      message: data.message,
      from: data.from
    };

    return this.http.post(this.url, _data);
  }
}
