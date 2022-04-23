package com.moulik.angular;

/**
 * Vid 18: Angular ViewChild Decorator - How does it work?
 * 
 * We have seen how we can create templateReference variables and use them in our html. But sometimes, we want to get them
 * in the component as well. This can be done by ViewChild/ViewChildren Decorator.
 * 
 * Let's assume we have only 1 course set in the page and we want to access this course-card in our app.ts. 
 * 
 * We can get the reference to it using this syntax below:
 * 	@ViewChild(CourseCardComponent)
  	card: CourseCardComponent;
 *
 * If there are multiple CourseCardComponent in the html, then we will only get the first component.
 * 
 * Vid 19: Learn the multiple View Query Configuration Options.
 * 
 * We have queried in the previous video based on the component. We can also query based on template reference.
 * 
 * 	<div class="course-card">
    	<course-card #cardRef1
        	(courseSelected)="onCourseSelected($event)" [course]="courses[0]">
    	</course-card>

    	<course-card #cardRef2
        	(courseSelected)="onCourseSelected($event)" [course]="courses[1]">
    	</course-card>
	</div>
 * 
 * 	@ViewChild('cardRef1')
  	card1: CourseCardComponent;

  	@ViewChild('cardRef2')
  	card2: CourseCardComponent;
 *
 * Instead of querying components, we can also query plain html elements. Html elements will have a type ElementRef.
 * 
 * 	<div class="course-card" #container>...</div>
 * 
 * 	@ViewChild('container')
  	containerDiv: ElementRef;
 * 
 * This would give reference to the html element and not the component.
 * 
 * We can also get the html element from a template reference on a component.
 * 
 * 	<div class="course-card">
    	<course-card #cardRef1
        	(courseSelected)="onCourseSelected($event)" [course]="courses[0]">
    	</course-card>

    	<course-card #cardRef2
        	(courseSelected)="onCourseSelected($event)" [course]="courses[1]">
    	</course-card>
	</div>
 * 
 * Here the cardRef1 is a template reference on the course card. If we want the html element from it, we use the syntax:
 * 
 *  @ViewChild('cardRef1', {read: ElementRef})
  	card1: ElementRef;
 * 
 * Vid 20: The AfterViewInit Lifecycle Hook - How deep can we query with ViewChild?
 * 
 * At construction time, the viewChild is not available. It will be undefined. The earliest possible moment when the 
 * ViewChild is populated can be found by having the class implement AfterViewInit lifecycle hook.
 * 
 * We should not try to modify the data in this lifecycle hook because Angular will not understand which data to render:
 * the modified data in this method or the initial data. ExpressionChangedAfterItHasBeenCheckedError.
 * We can however add some async code. Only synchronous code would give this type of error.
 *  
 * Please note that it's not possible to reference deeper into the component hierarchy. E.g if there is a tag like <img>
 * in the child component and we give a reference to it, we will only get undefined when we try to view it in AfterViewInit.
 * 
 * Vid 21: The ViewChildren Decorator and QueryList in detail
 * 
 * We can use ViewChildren to reference a collection of related elements. e.g We can get the list of components.
 * 	@ViewChildren(CourseCardComponent)
 *	cards: QueryList<CourseCardComponent>;
 *
 * QueryList is used to hold collections of components. It has some properties similar to arrays in JS.
 * 
 * If we want to access this cards object, we can do it like this in AfterViewInit.
 * 	this.cards.changes.subscribe(
      cards => {
        console.log(cards);
      }, error => {
        console.log('Got error');
      }
    );
 * 
 * Now this line means that we are subscribed to the changes of this cards object. That means, when this cards object
 * changes(e.g when we add a new course to this cards list), we will see the code executed: console.log(cards); 
 * To execute that we can add a button that will add a new object to the end of the courses object.
 * 
 * 
 * We can also query the HTML elements instead of components like
 * 	@ViewChildren(CourseCardComponent, {read: ElementRef})
 *	cards: QueryList<ElementRef>;
 * 
 */
public class LocalTemplateQuerying3 {

}
