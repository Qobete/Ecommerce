import { Component, OnInit } from '@angular/core';
import { Item } from '../../../Models/Item';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminServiceService } from '../../../Services/admin-service/admin-service.service';
import { LoggingService } from '../../../Models/LoggingService';
import { HttpClient, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-items-admin',
  templateUrl: './items-admin.component.html',
  styleUrls: ['./items-admin.component.css']
})
export class ItemsAdminComponent implements OnInit {
  searchtext:string=""
  items: Array<Item>;
  itemsRecieved: Array<Item>;
  selectedItem: Item;
  action:string;
  // value:string
  status:boolean
  child_records_found:boolean =false;
  searchText:string

  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;

  
    //Injecting required services 
    constructor(private adminService: AdminServiceService, private activatedRoute: ActivatedRoute, private logger:LoggingService, private router:Router, private httpClient: HttpClient) { }
  
    ngOnInit() {

      //if local storage is null, navigate to home page 
      if (localStorage.email == null) {
        this.router.navigate(['/customer'])
      }
       this.getItems();
    }


  //Function to get all the items
    getItems()
    {

     //Make a call to Sprinf Boot to get the Image Bytes.
    // this.httpClient.get('http://localhost:8094/image/get/' + this.imageName)
    // .subscribe(
    //   res => {
        //this.retrieveResonse = res;
        // this.base64Data = this.retrieveResonse.picByte;
        // this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
    //   }
    // );


      this.adminService.getItems(localStorage.email).subscribe(
        data=>{
        
          this.logger.logStatus("Got all the items successfully");
          this.items=data
          // this.base64Data = this.retrieveResonse.picByte;
          // this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
                }
      )
             
  }


  //passing item id using router params(Activated router) to edit a item
  edit(itemId:number){
    this.logger.logStatus("navigated to edit item");
    this.router.navigate(['/admin/addItem',itemId])
  }
  
  //delete a item
  delete(itemId : number){
  
    //calling a service to delete the item
    this.adminService.deleteItem(itemId).subscribe(data=>{
      this.getItems();
      this.logger.logStatus("Delete the item by item Id");
    },
    
    //error handling messages which are thrown by spring boot
    err=>{
      if(err.error.errorMessage=="child records found") {
        this.child_records_found=true;}
      
    })
    
  }

  //function to update active status of a item
  updateActiveStatus(itemId:number){
  

  var values = (<HTMLInputElement>document.getElementById(itemId.toString()+"-active")).value
  //calling service  to update active status
   this.adminService.updateActiveStatus(itemId,values).subscribe(data=>{
    this.logger.logStatus("updated the active status of the item");
     this.getItems();
    })
  }
}