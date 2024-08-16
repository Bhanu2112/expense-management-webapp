import { Component } from '@angular/core';
import { SplitserviceService } from '../../services/splitservice.service';
import { ActivatedRoute } from '@angular/router';
import { Group } from '../../models/group';
import { Member } from '../../models/member';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-viewgroup',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './viewgroup.component.html',
  styleUrl: './viewgroup.component.css'
})
export class ViewgroupComponent {


    groupId!:number
    group = new Group();
    count!:number
    members:any
    myMember = new Member()

    appUserId!:number


    constructor(private splitService:SplitserviceService, private route:ActivatedRoute){

    }
    ngOnInit(){

      this.appUserId = this.splitService.appUserId;

      this.route.queryParams.subscribe(val =>{
        this.groupId = val['id']
      })


      this.splitService.viewGroup(this.groupId).subscribe(data =>{
        console.log(data);

        this.group = data
        this.count = this.group.groupMembers.length

        this.group.groupMembers.filter(gm => gm.userId===this.appUserId).forEach(m => this.myMember = m);



      })

    }
}
