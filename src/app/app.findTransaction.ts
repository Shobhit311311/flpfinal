import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Transaction } from './Transaction.model';
import { TransactionService } from './TransactionService';
import { productReturn } from './return.model';



@Component({
    selector: 'find-acc',
    templateUrl: 'find-transaction.html'
})

export class FindTransactionComponent implements OnInit{
    ngOnInit(): void {
      this.getTransaction()
    }
    transaction: Transaction = {
        transactionId: 0, modeOfPurchase: "", status: "", user: null, products: null
    }

    transactionid: number;
      

    return: productReturn;

    status: boolean = false;

    transactions:number[]=[]

    constructor(private router: Router, private transactionService: TransactionService) { }


    searchTransactionAccount() {
        //this.status = true;
        if (confirm("Are you sure you want to return?")) {
            this.transactionService.getTransactionDetailsByTrId(this.transactionid).subscribe(
                res=>{
                    this.return = res;
                    if(this.return.returnId===0){
                        alert("Already Returned")
                    }else{
                        this.return = res;
                        this.status = true;
                    }
                }
            )
        }
    }
    onChange($event){
        this.transactionid=$event.target.options[$event.target.options.selectedIndex].value
    }

    getTransaction(){
        this.transactionService.getTranactions(1).subscribe(data=>{
            this.transactions = data;
            console.log(this.transactions)
        })
    }
}