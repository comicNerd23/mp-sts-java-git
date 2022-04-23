package com.moulik.angular;

/**
 * Vid 22: Angular Content Projection with ng-content in Detail
 * 
 * Content Project is all about configurable components. We can pass over content in between the components from parent to
 * child object and see the content in the child.
 * 
 * Suppose we want to pass the <img> tag from the app.html to course-card.html as given below. 
 * 
 * 	<course-card *ngIf="courses[0] as course"
        (courseSelected)="onCourseSelected($event)" [course]="course">

        <img width="300" alt="Angular Logo" *ngIf="course.iconUrl"
            [src]="course.iconUrl">

    </course-card>
 * 
 * In the child.html, at the place where we want this inner content to project, we need to put this:
 * 	<ng-content></ng-content>
 * 
 * Suppose that we have more than just the <img> tag in the inner content but we want only the <img> tag to project. We do
 * that as follows:
 * 
 * <course-card *ngIf="courses[0] as course"
        (courseSelected)="onCourseSelected($event)" [course]="course">

        <img width="300" alt="Angular Logo" *ngIf="course.iconUrl"
            [src]="course.iconUrl">
        <h5>Total lessons: 5</h5>

    </course-card>
 * 
 * <ng-content select="img"></ng-content>
 * 
 * Other than the html tag, we can also restrict using a css class in select attribute.
 * 
 * 	<course-card *ngIf="courses[0] as course"
        (courseSelected)="onCourseSelected($event)" [course]="course">
        <div class="course-image">
            <img width="300" alt="Angular Logo" *ngIf="course.iconUrl"
                [src]="course.iconUrl">
        </div>
        <h5>Total lessons: 5</h5>

    </course-card>
 * 
 * 	<ng-content select=".course-image"></ng-content>
 * 
 * It also supports multi-slot projection. 
 * Consider that we also want the description to be configurable and passed from app.html to course-card.html.
 * 
 * 	<course-card *ngIf="courses[0] as course"
        (courseSelected)="onCourseSelected($event)" [course]="course">
        <div class="course-image">
            <img width="300" alt="Angular Logo" *ngIf="course.iconUrl"
                [src]="course.iconUrl">
        </div>
        <h5>Total lessons: 5</h5>

        <div class="course-description">
            {{ course.longDescription }}
        </div>
        
        
    </course-card>
 * 
 * 	<ng-content select=".course-image"></ng-content>
  	<ng-content select=".course-description"></ng-content>
 * 
 * Consider that we also had some other data in the app.html.
 * 
 * 	Edit Description : <text-area></text-area>
 * 
 * This data which does not match the select of other statements can be made to project using empty <ng-content> as:
 * 
 * 	<ng-content select=".course-image"></ng-content>
  	<ng-content select=".course-description"></ng-content>	
 	<ng-content></ng-content>
 * 
 * 
 * Vid 23: Angular Content Child Decorator - In-depth Explanation
 * 
 * To view the content that is passed in the template to the child, we use @ContentChild. It is similar to @ViewChild, but
 * it is used to see only the passed content (both component or native html element), not the child component or html 
 * elements.
 * 
 * Vid 24: Angular Content Children and the AfterContentInit Lifecycle Hook
 *
 */
public class ContentProjection4 {

}
