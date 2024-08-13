import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../models/account';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class ExpensesServiceService {

  constructor(private http :HttpClient) { }

  getAllAccounts() :Observable<Account[]>{
    return this.http.get<Account[]>('http://localhost:8081/accounts/1');
  }

  getAllCategories():Observable<Category[]>{
    return this.http.get<Category[]>('http://localhost:8081/categories/1');
  }

  addCategory(cat:Category){
    cat.userId = 2
    return this.http.post<Category>('http://localhost:8081/category/create',cat);
  }


  addAccount(act:Account){
    act.userId=2
    return this.http.post<Account>('http://localhost:8081/create/account',act)
  }
}
