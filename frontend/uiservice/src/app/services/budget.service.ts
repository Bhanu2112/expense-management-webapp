import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BudgetManager } from '../models/budget-manager';
import { Budget } from '../models/budget';

@Injectable({
  providedIn: 'root'
})
export class BudgetService {

  constructor(private http : HttpClient) { }

  getBudgetsOfMonth():Observable<BudgetManager>{
    return this.http.get<BudgetManager>('http://localhost:8081/budget/bm/user?monthYear=2024-08&userId=1')
  }

  saveBudget(budget:Budget){
    return this.http.post<Budget>('http://localhost:8081/budget/save',budget)
  }

}
