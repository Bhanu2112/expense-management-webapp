import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { Routes } from '@angular/router';
import { RegisterComponent } from './pages/register/register.component';
import { ManageexpComponent } from './pages/manageexp/manageexp.component';
import { AccountsComponent } from './pages/accounts/accounts.component';
import { CategoriesComponent } from './pages/categories/categories.component';
import { BudgetsComponent } from './pages/budgets/budgets.component';
import { BillsplitterComponent } from './pages/billsplitter/billsplitter.component';
import { ViewgroupComponent } from './pages/viewgroup/viewgroup.component';

export const routes: Routes = [
  {
    path : '',
    component : HomeComponent
  },
  {
    path : 'login',
    component : LoginComponent
  },
  {
    path : 'register',
    component : RegisterComponent
  },
  {
    path : 'expenses',
    component : ManageexpComponent
  },
  {
    path :'accounts',
    component : AccountsComponent
  },
  {
    path : 'categories',
    component : CategoriesComponent
  },
  {
    path : 'budgets',
    component : BudgetsComponent
  },
  {
    path:'split',
    component : BillsplitterComponent
  },
  {
    path:'viewgroup',
    component : ViewgroupComponent
  }
];
