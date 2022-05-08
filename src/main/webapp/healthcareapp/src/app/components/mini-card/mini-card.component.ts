import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-mini-card',
  templateUrl: './mini-card.component.html',
  styleUrls: ['./mini-card.component.css']
})
export class MiniCardComponent {
  @Input() icon='local_hospital';
  @Input() title='Hospital';
  @Input() value= '300';
  @Input() color= 'blue';
  @Input() isIncrease= true;
  @Input() isCurrency=false;
  @Input() duration= 'Since Last Month';
  @Input() percentValue='0.09';

  constructor() { }
}
