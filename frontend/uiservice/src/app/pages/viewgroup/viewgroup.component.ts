import { Component } from '@angular/core';
import { SplitserviceService } from '../../services/splitservice.service';
import { ActivatedRoute } from '@angular/router';
import { Group } from '../../models/group';

@Component({
  selector: 'app-viewgroup',
  standalone: true,
  imports: [],
  templateUrl: './viewgroup.component.html',
  styleUrl: './viewgroup.component.css'
})
export class ViewgroupComponent {


    groupId!:number
    group = new Group();
    count!:number
    members:any



    constructor(private splitService:SplitserviceService, private route:ActivatedRoute){

    }
    ngOnInit(){
      this.route.queryParams.subscribe(val =>{
        this.groupId = val['id']
      })


      this.splitService.viewGroup(this.groupId).subscribe(data =>{
        console.log(data);

        this.group = data

        this.count = this.group.groupMembers.length
      })

    }
}
