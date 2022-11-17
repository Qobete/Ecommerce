import { Component, OnInit, Renderer2, ElementRef, ViewChild, EventEmitter, Output, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SubCategory } from '../../../Models/subCategory';
import { Item } from '../../../Models/Item';
import { AdminServiceService } from '../../../Services/admin-service/admin-service.service';
import { LoggingService } from '../../../Models/LoggingService';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})

export class AddItemComponent implements OnInit {
  selectedType: boolean = false
  selectedSpeciality: boolean = false
  edited:boolean = false
  addItemForm: FormGroup
  editItemForm: FormGroup
  submitted: boolean = false
  subCategories: SubCategory[]
  selectedSubCatgeory: any
  itemId: number;

  select: boolean = true
  item_details: Item
  addedItem: boolean = false;
  editedItem: boolean = false
  item_name_already_exists: boolean = false;

  error: string;
  uploadError: string;

  @Input()
  item: Item;
  imgURL: any;
  private selectedFile;

  @Output()
  itemAddedEvent = new EventEmitter;


  @ViewChild('image') private image: ElementRef;
  @Output() close = new EventEmitter();

  //injecting required services
  constructor(private formBuilder: FormBuilder,private logger:LoggingService, private adminService: AdminServiceService, private route: ActivatedRoute, private router: Router, private renderer: Renderer2, private httpClient: HttpClient) {

    //getting item id for editing an item from other component using activated router
    this.route.params.subscribe(params => {
      this.itemId = params['itemId'];
      if (this.itemId != null) {
        this.select = false
      }
    })
  }

  ngOnInit() {
    //if local storage is null, navigate to home page
    if (localStorage.email == null) {
      this.router.navigate(['/customer'])
    }

    console.log(this.select)


    //setting validations for adding a new Item form
    this.addItemForm = this.formBuilder.group({
      itemName: ['', [Validators.required, Validators.pattern("[A-Za-z].*")]],
      itemDescription: ['', [Validators.required, Validators.pattern("[A-Za-z].*")]],
      itemPrice: ['', [Validators.required, Validators.min(5.00), Validators.max(1000)]],
      speciality: ['', [Validators.required]],
      type: ['', [Validators.required]],
      subCategory: ['', Validators.required]


    })

    this.getSubCategories();

    if (this.select == false) {

      //setting validations for editing a new item form
      this.editItemForm = this.formBuilder.group({
        itemId: [''],
        itemName: ['', [Validators.required, Validators.pattern("[A-Za-z].*")]],
        itemDescription: ['', [Validators.required, Validators.pattern("[A-Za-z].*")]],
        itemPrice: ['', [Validators.required, Validators.min(10), Validators.max(1000)]],
        speciality: ['', [Validators.required]],
        type: ['', [Validators.required]]

      })

      this.getItem(this.itemId)
    }
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }

  // handleFileInput(file: FileList) {
  //   this.selectedFile = file.item(0);
  //   var reader = new FileReader();
  //   reader.onload = (event: any) => {
  //     this.imgURL = event.target.result;
  //   }
  //   reader.readAsDataURL(this.selectedFile);
  // }


  //function to get all the subcategories
  getSubCategories() {

    //calling service to get all the subcategories
    this.adminService.getSubCategories(localStorage.email).subscribe(data => {
      this.logger.logStatus("Got all the subcategories");
      this.subCategories = data}),
      err => { console.log(err) }

  }

  //function to get the item details by item id
  getItem(itemId: number) {
    //calling service to get the item details by item id
    this.adminService.getItem(itemId).subscribe(data => {
      this.logger.logStatus("Got item by item Id");
      this.item_details = data

      this.logger.logStatus("Obtained itemId is set to form");
      //setting the values of item to editform
      this.editItemForm.patchValue(data)
    })
  }

  //function to add a new item
  addItem() {


    this.item_name_already_exists=false
    this.submitted = true

    //return if the form is invalid
    // if (this.addItemForm.invalid) {
    //   return;
    // }

    // else {
      this.item_name_already_exists=false

    //If there is no book id then it is an add book call else it is an edit book call
    // if (this.item.itemId == null) {
      const uploadData = new FormData();
      uploadData.append('imageFile', this.selectedFile, this.selectedFile.name);
      this.selectedFile.imageName = this.selectedFile.name;

      this.httpClient.post('http://localhost:8094/admin/upload', uploadData, {observe: 'response'})
        .subscribe((response) => {
            if (response.status == 200) {
              this.adminService.addItem(localStorage.email, this.selectedSubCatgeory, this.addItemForm.value).subscribe(
                (item) => {
                  this.logger.logStatus("Added item successfully");
                  this.addedItem = true
                }
              );

              console.log('Image uploaded successfully');

            } else {
              console.log('Image not uploaded successfully');
            }
          }
        );
    // } else {
    //   this.adminService.editItem(this.item).subscribe(
    //     (item) => {
    //       this.itemAddedEvent.emit();
    //       this.router.navigate(['admin', 'items']);
    //     }
    //   );
    // }



    // this.item_name_already_exists=false
    // this.submitted = true

    // //return if the form is invalid
    // if (this.addItemForm.invalid) {
    //   return;
    // }

    // else {
    //   this.item_name_already_exists=false


    //   //calling service to add a new item
    //   this.adminService.addItem(localStorage.email, this.selectedSubCatgeory, this.addItemForm.value).subscribe(
    //     data => {
    //       this.logger.logStatus("Added item successfully");
    //       this.addedItem = true
    //     }, err => {
    //       if(err.error.errorMessage=="Item name already exists exception")
    //       {
    //           this.item_name_already_exists=true
    //       }
    //     } )
    // }

  }


  //function to edit a item
  editItem() {


    this.submitted = true

    if(this.editItemForm.invalid)
     return
    //calling service to edit a item
    this.adminService.editItem(this.editItemForm.value).subscribe(data => {
      if (data) {
        this.logger.logStatus("Edited item successfully");
        this.editedItem = true;
        this.router.navigate(['/admin/items']);
      }
    }, err => {}
    )
  }
}
