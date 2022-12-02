import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { CustomerComponent } from '../customer/customer.component';
import { CustomerComponent } from '../customer.component';
import { LoggingService } from 'src/app/Models/LoggingService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router,private customer:CustomerComponent, private logger:LoggingService) { }

  ngOnInit() {
    // this.customer.expandHeader()
    // this.customer.searchText=""
    // this.customer.filter=""
  }

  // Navigating to Items Page
  goToItems(){
     this.customer.filter="Breakfast"
     this.customer.goToItems();
    this.logger.logStatus("Navigating to Items Page !!");

  }

  // Navigating to Signup page
  goToSignUp(){
    this.router.navigate(['authenticate/sign-up'])
    this.logger.logStatus("Navigating to Sign Up Page !!");

  }
}