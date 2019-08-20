import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Transaction} from './Transaction.model';
import { productReturn } from './return.model';
import { Observable } from 'rxjs';


const httpOptions={
    headers: new HttpHeaders({ 'Content-Type' : 'application/json'})
};

@Injectable()
export class TransactionService{
    constructor(private http:HttpClient){}

    private userUrl='http://localhost:5000/orders';



    public getTransactionDetailsByTrId(TransactionId: number):Observable<productReturn> {
        
        return this.http.get<productReturn>(this.userUrl + "/myorders/"+TransactionId);
    }
    public getTranactions(userId:number):Observable<any>{
        return this.http.get<any>(this.userUrl+"/myorders/userid/"+userId)

    }

    

   



}
