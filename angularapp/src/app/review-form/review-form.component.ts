import { Component, OnInit } from '@angular/core';
import { Review } from '../Model/Review';
import { Router } from '@angular/router';
import { ReviewServiceService } from '../Services/review-service.service';
import { DatePipe } from '@angular/common';
import { ReviewListserviceService } from '../Services/review-listservice.service';

@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent implements OnInit{

  reviewForm : Review = new Review();
  
  constructor(private reviewService: ReviewServiceService,private RevListservice: ReviewListserviceService ,private router: Router,private datePipe:DatePipe){}

  ngOnInit(): void {
       var today= new Date();
      // this.reviewForm.date=datePipe.transform((new Date),'dd-MM-yyyy');
      this.reviewForm.date=today;

      
  }
  addNewReview(){
    console.log(this.reviewForm);
    this.reviewService.addNewReview(this.reviewForm).subscribe();
    alert('Your Review Form is Submitted.\nBack to review list to see your review')
  }

  goToReviewList(movId:number){
    this.router.navigate(['ReviewList',movId]);
    this.RevListservice.getMovieId(movId);
  }
}
// Aishwarya Ghosh