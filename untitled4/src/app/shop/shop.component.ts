import {AfterViewInit, Component, inject, ViewChild, OnInit} from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatIconRegistry, MatIconModule} from '@angular/material/icon';
import {DomSanitizer} from '@angular/platform-browser';
import {MatButtonModule} from '@angular/material/button';


import {Observable, tap} from 'rxjs';
// import { Service } from './service';
import {FormsModule} from '@angular/forms';
import {AsyncPipe, JsonPipe, DatePipe} from '@angular/common';
import {HttpClient, HttpClientModule, HttpHandler} from '@angular/common/http';

import {Service} from '../model/Service';

/**
 * @title Table with pagination
 */
@Component({
  selector: 'app-user',
  standalone: true,
  imports: [FormsModule, AsyncPipe, JsonPipe, DatePipe, HttpClientModule, MatButtonModule, MatTableModule, MatPaginatorModule, MatIconModule],
  templateUrl: './shop.component.html',
  providers: [Service],
  styleUrl: './shop.component.css'
})


export class ShopComponent implements AfterViewInit, OnInit {
  displayedColumns: string[] = ['position', 'name', 'icon', 'phone', 'address', 'operate'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);

  openedManual = false;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private service: Service) {
    const iconRegistry = inject(MatIconRegistry);
    const sanitizer = inject(DomSanitizer);
    // Note that we provide the icon here as a string literal here due to a limitation in
    // Stackblitz. If you want to provide the icon from a URL, you can use:
    // `iconRegistry.addSvgIcon('thumbs-up', sanitizer.bypassSecurityTrustResourceUrl('icon.svg'));`
    iconRegistry.addSvgIconLiteral('thumbs-up', sanitizer.bypassSecurityTrustHtml(THUMBUP_ICON));
    // console.log(this.dat4aSource)
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
    //   console.log(this.onAcceptClick('1'))
    this.test();
  }

  onAcceptClick(key: string) {
    //  console.log('you click onAcceptClick' + key)
    /*  this.service.getShop('1').subscribe(
        (result: any) => {
          console.log(result)
        });*/
    this.test();
  }

  onAddClick(key: string): void {
    //  console.log('you click onAddClick' + key)
    this.service
      .postAddShop('1')
      .pipe(tap())
      .subscribe((resp) => {
        //     console.log(resp)
      });
    /*
    * 新增之后  如何刷新页面 */
    window.location.reload(); // JS 自带的刷新方法
  }

  takeLongTime(): Promise<PeriodicElement[]> {
    return new Promise(resolve => {
      this.service.getShop('1').subscribe(
        (result: any) => {
          resolve(result)
        });
    });
  }

  async test() {
    const v = await this.takeLongTime();
    console.log(v);
    /*接下来把主ui的数组 更新到页面上
    数组 怎么给他赋值呢
    * */
    const age = v[0];
    const sex = age.name;
    console.log(age);
    console.log(sex);
    /* wrsdata  = new MatTableDataSource<PeriodicElement>(v);
     console.log(wrsdata);*/
    console.log(this.openedManual);
    this.openedManual = !this.openedManual;
    console.log(this.openedManual);
    var wrsdata = new MatTableDataSource<PeriodicElement>(v);
    this.dataSource = wrsdata;
    /*
    * 刷新ui
    * */
  }

}

export interface PeriodicElement {
  name: string;
  position: number;
  icon: string;
  address: string;
  phone: string;
  operate: string;
}


const ELEMENT_DATA: PeriodicElement[] = [
  {
    position: 2,
    name: 'Helium',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'He',
    operate: '101'
  },
  {
    position: 3,
    name: 'Lithium',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Li',
    operate: '102'
  },
  {
    position: 4,
    name: 'Beryllium',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Be',
    operate: '103'
  },
  {
    position: 5,
    name: 'Boron',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'B',
    operate: '104'
  },
  {
    position: 6,
    name: 'Carbon',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'C',
    operate: '101'
  },
  {
    position: 7,
    name: 'Nitrogen',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'N',
    operate: '101'
  },
  {
    position: 8,
    name: 'Oxygen',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'O',
    operate: '101'
  },
  {
    position: 9,
    name: 'Fluorine',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'F',
    operate: '101'
  },
  {
    position: 10,
    name: 'Neon',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Ne',
    operate: '101'
  },
  {
    position: 11,
    name: 'Sodium',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Na',
    operate: '101'
  },
  {
    position: 12,
    name: 'Magnesium',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Mg',
    operate: '101'
  },
  {
    position: 13,
    name: 'Aluminum',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Al',
    operate: '101'
  },
  {
    position: 14,
    name: 'Silicon',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Si',
    operate: '101'
  },
  {
    position: 15,
    name: 'Phosphorus',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'P',
    operate: '101'
  },
  {
    position: 16,
    name: 'Sulfur',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'S',
    operate: '101'
  },
  {
    position: 17,
    name: 'Chlorine',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Cl',
    operate: '101'
  },
  {
    position: 18,
    name: 'Argon',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Ar',
    operate: '101'
  },
  {
    position: 19,
    name: 'Potassium',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'K',
    operate: '101'
  },
  {
    position: 20,
    name: 'Calcium',
    icon: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg',
    phone: 'H',
    address: 'Ca',
    operate: '101'
  },
];

const THUMBUP_ICON =
  `
  <svg width="800px" height="800px" viewBox="0 0 1024 1024" class="icon"  version="1.1" xmlns="http://www.w3.org/2000/svg"><path d="M762.9 116.2c-7.2-14-25.9-25.5-41.7-25.5h-417c-15.8 0-34.5 11.5-41.7 25.5L176 285.3c-7.2 14-0.1 25.5 15.6 25.5h642.1c15.8 0 22.8-11.5 15.6-25.5l-86.4-169.1z" fill="#333E48" /><path d="M786.1 161.6H600.4v28.6h200.4l-14.7-28.6z m-561.4 28.7h200.4v-28.6H239.3l-14.6 28.6z" fill="" /><path d="M158.4 289.4h708.7v622.1H158.4z" fill="#00B3E3" /><path d="M766.3 377.5h100.8V426H766.3zM628.4 597.6h100.8v48.5H628.4zM504.1 376.7h100.8v48.5H504.1zM158.4 495h100.8v48.5H158.4zM237.5 332.9h100.8v48.5H237.5zM386.4 667.5h100.8V716H386.4z" fill="" /><path d="M208.7 799.2h100.8v48.5H208.7z" fill="#5D5D5D" /><path d="M766.3 796.5h100.8V845H766.3z" fill="" /><path d="M410.6 691.8h204.3v219.7H410.6z" fill="#FFFFFF" /><path d="M498.4 691.8H527V890h-28.6z" fill="" /><path d="M220.8 425.1h123.8v140H220.8z" fill="#FFFFFF" /><path d="M220.8 425.1h123.8V456H220.8z" fill="" /><path d="M220.8 480.7h123.8v28.6H220.8z" fill="#333E48" /><path d="M235.1 550.7h95.2V439.4h-95.2v111.3z m109.5 28.6H220.8c-7.9 0-14.3-6.4-14.3-14.3V425c0-7.9 6.4-14.3 14.3-14.3h123.8c7.9 0 14.3 6.4 14.3 14.3v140c0.1 7.9-6.4 14.3-14.3 14.3z" fill="#0071CE" /><path d="M450.8 425.1h123.8v140H450.8z" fill="#FFFFFF" /><path d="M450.8 425.1h123.8V456H450.8z" fill="" /><path d="M450.8 480.7h123.8v28.6H450.8z" fill="#333E48" /><path d="M465.1 550.7h95.2V439.4h-95.2v111.3z m109.5 28.6H450.8c-7.9 0-14.3-6.4-14.3-14.3V425c0-7.9 6.4-14.3 14.3-14.3h123.8c7.9 0 14.3 6.4 14.3 14.3v140c0 7.9-6.4 14.3-14.3 14.3z" fill="#0071CE" /><path d="M680.8 425.1h123.8v140H680.8z" fill="#FFFFFF" /><path d="M680.8 425.1h123.8V456H680.8z" fill="" /><path d="M680.8 480.7h123.8v28.6H680.8z" fill="#333E48" /><path d="M695.1 550.7h95.2V439.4h-95.2v111.3z m109.5 28.6H680.8c-7.9 0-14.3-6.4-14.3-14.3V425c0-7.9 6.4-14.3 14.3-14.3h123.8c7.9 0 14.3 6.4 14.3 14.3v140c0 7.9-6.4 14.3-14.3 14.3z" fill="#0071CE" /><path d="M220.8 621.8h123.8v140H220.8z" fill="#FFFFFF" /><path d="M220.8 621.8h123.8v30.9H220.8z" fill="" /><path d="M220.8 677.5h123.8v28.6H220.8z" fill="#333E48" /><path d="M235.1 747.4h95.2V636.1h-95.2v111.3z m109.5 28.7H220.8c-7.9 0-14.3-6.4-14.3-14.3v-140c0-7.9 6.4-14.3 14.3-14.3h123.8c7.9 0 14.3 6.4 14.3 14.3v140c0.1 7.9-6.4 14.3-14.3 14.3z" fill="#0071CE" /><path d="M680.8 621.8h123.8v140H680.8z" fill="#FFFFFF" /><path d="M680.8 621.8h123.8v30.9H680.8z" fill="" /><path d="M680.8 677.5h123.8v28.6H680.8z" fill="#333E48" /><path d="M695.1 747.4h95.2V636.1h-95.2v111.3z m109.5 28.7H680.8c-7.9 0-14.3-6.4-14.3-14.3v-140c0-7.9 6.4-14.3 14.3-14.3h123.8c7.9 0 14.3 6.4 14.3 14.3v140c0 7.9-6.4 14.3-14.3 14.3zM894.1 290.5c0-10.5-8.6-19.1-19.1-19.1H150.4c-10.5 0-19.1 8.6-19.1 19.1v23.2c0 10.5 8.6 19.1 19.1 19.1H875c10.5 0 19.1-8.6 19.1-19.1v-23.2z" fill="#0071CE" /><path d="M960.2 925.3c0 4.2-3.5 7.7-7.7 7.7H72.9c-4.2 0-7.7-3.5-7.7-7.7v-27.6c0-4.2 3.5-7.7 7.7-7.7h879.5c4.2 0 7.7 3.5 7.7 7.7v27.6z" fill="#333E48" /><path d="M349.9 889.9h325.7v43H349.9z" fill="#A4A9AD" /><path d="M545.2 121.4c-7.9 0-14.3 6.4-14.3 14.3v31h-36.3v-31c0-7.9-6.4-14.3-14.3-14.3s-14.3 6.4-14.3 14.3v90.7c0 7.9 6.4 14.3 14.3 14.3s14.3-6.4 14.3-14.3v-31h36.3v31c0 7.9 6.4 14.3 14.3 14.3s14.3-6.4 14.3-14.3v-90.7c0-7.9-6.4-14.3-14.3-14.3z" fill="#FFFFFF" /></svg>
`;
