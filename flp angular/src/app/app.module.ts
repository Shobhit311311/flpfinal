import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';



import {FindTransactionComponent} from './app.findTransaction';



import {RouterModule, Routes} from '@angular/router'; 
import {FormsModule} from '@angular/forms';
import {TransactionService} from './TransactionService';
import {HttpClientModule} from '@angular/common/http';



const routes: Routes = [
  //  { path: 'view-all', component: AccountComponent},
   // { path: 'new', component: AddAccountComponent},
 //   { path: 'find', component: FindAccountComponent},
    
];

@NgModule({
    imports: [
        BrowserModule, RouterModule.forRoot(routes),FormsModule,HttpClientModule
        
    ],

    declarations: [
        FindTransactionComponent, AppComponent
		],
    providers: [ TransactionService ],
    bootstrap: [AppComponent]
})

export class AppModule { }