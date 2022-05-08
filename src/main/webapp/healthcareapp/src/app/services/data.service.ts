import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DataService {

  private dataSourse = new BehaviorSubject({id: 1, diagnosisInfo: 'None'});
  currentData = this.dataSourse.asObservable();

  constructor() { }

  changeData(data:any){
    console.log('data changed');
    console.log(data);
    this.dataSourse.next(data);
    console.log(this.dataSourse);
  }
}
