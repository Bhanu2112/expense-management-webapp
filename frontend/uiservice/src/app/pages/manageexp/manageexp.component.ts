import { Component } from '@angular/core';

@Component({
  selector: 'app-manageexp',
  standalone: true,
  imports: [],
  templateUrl: './manageexp.component.html',
  styleUrl: './manageexp.component.css'
})
export class ManageexpComponent {
  currentMonth!: number;
  currentYear!: number;
  months: string[] = [
    'January', 'February', 'March', 'April', 'May', 'June',
    'July', 'August', 'September', 'October', 'November', 'December'
  ];

  ngOnInit(){
    const today = new Date();
    console.log(today.getFullYear());

    this.currentMonth = today.getMonth(); //0-11
    this.currentYear = today.getFullYear();
  }


  goToPreviousMonth(){

    if(this.currentMonth===0){
      this.currentMonth = 11
      this.currentYear--;
    }else{
      this.currentMonth--;
    }

  }

  goToNextMonth() {
    if (this.currentMonth === 11) {
      this.currentMonth = 0;
      this.currentYear++;
    } else {
      this.currentMonth++;
    }
  }


}
