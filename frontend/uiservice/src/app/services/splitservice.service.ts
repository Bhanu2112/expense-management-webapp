import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Group } from '../models/group';
import { Reqsettel } from '../models/reqsettel';

@Injectable({
  providedIn: 'root'
})
export class SplitserviceService {


  appUserId = 1;

  constructor(private http:HttpClient) { }

  getGroups(){
    return this.http.get('http://localhost:8081/member/1')
  }


  viewGroup(groupid:number):Observable<Group>{
    return this.http.get<Group>(`http://localhost:8081/group?groupid=${groupid}`)
  }


  getAllRequestsAndSettlementsOfMember(memberId:number):Observable<Reqsettel[]>{
      return this.http.get<Reqsettel[]>(`http://localhost:8081/reqsettlel/${2}`)
  }
}
