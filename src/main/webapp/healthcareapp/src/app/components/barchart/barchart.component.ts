import {Component, OnInit, ViewChild} from '@angular/core';
import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import DataLabelsPlugin from 'chartjs-plugin-datalabels';
import DatalabelsPlugin from "chartjs-plugin-datalabels";
import {AdminService} from "../../services/admin.service";
@Component({
  selector: 'app-barchart',
  templateUrl: './barchart.component.html',
  styleUrls: ['./barchart.component.css']
})
export class BarchartComponent{
  @ViewChild(BaseChartDirective) chart: BaseChartDirective | undefined;
  constructor(private adminService : AdminService) {
    //this.getDiagnosisChartData();
  }
  // Pie
  public pieChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    plugins: {
      legend: {
        display: true,
        position: 'top',
      },
      datalabels: {
        formatter: (value, ctx) => {
          if (ctx.chart.data.labels) {
            return ctx.chart.data.labels[ctx.dataIndex];
          }
        },
      },
    }
  };
  public pieChartData: ChartData<'pie', number[], string | string[]> = {
    labels: [  'Eplipsey', 'Stroke', 'Others' ],
    datasets: [ {
      data: [ 2, 3, 5 ]
    } ]
  };
  public pieChartType: ChartType = 'pie';
  public pieChartPlugins = [ DatalabelsPlugin ];

  getDiagnosisChartData(){
    this.adminService.getDiagnosisChartData().subscribe(
      (response:any) =>{
       console.log(response);

      },
      (error:any) => {
        console.log("here");
        console.log(error);
      }
    );
  }

}
