package com.moulik.angular;

/**
 * Section 2: Angular Components, Core Directives and Pipes
 * 
 * Vid 7: New Section: Angular Components and Core Directives
 * We need to checkout branch: https://github.com/angular-university/angular-course/tree/1-components
 * 
 * To do this, we write in git terminal: git checkout -b 1-components origin/1-components
 * Now, we will have the code downloaded from this branch. To run this code, use 'npm install'. This will install all the 
 * required dependencies to run our playground (including a server with REST API).
 * Once installation is complete, run 'npm start'. This will run our app at port 4200.
 * This app is similar to the one we had in the previous section but the differences are, it has some extra css code and 
 * it has code to create and run a server.
 * 
 * Vid 8: Building our First Angular Component
 * To create a new component, 'ng generate component course-card'
 * This creates 4 files: ts, spec.ts, html and css. HTML contains the template, css contains the style for that particular
 * component, ts contains the logic and spec.ts contains the test code.
 * We can reuse the code in various places by just creating a component and using that component selector tag in various
 * places.
 * 
 * Vid 9: Component Inputs and the @Input Decorator
 * 
 * Suppose we have a constant file db-data.ts which contains an array of different courses, eg Angular Core Course, Rxjs 
 * Course, NgRx course etc.
 * In order to use some value in the html, we need to have it in the ts component of the app. So we will set some variables
 * in ts file using the array in db-data.ts
 * 	coreCourse = COURSES[0];
 * 	rxjsCourse = COURSES[1];
 * 	ngrxCourse = COURSES[2];
 * 
 * Then we can use these variables in the html file like {{ coreCourse.description }}
 * 
 * Now we have a parent component 'app' and a child component 'course-card'. In parent, we have called <course-card>
 * In parent.ts, we have some value like title, that we can get into our parent.html using 
 * 	<course-card [title]="coreCourse.description">
 * 
 * Now to add this title in the child.ts, we need to use @Input on the property which will get this value. E.g
 * 	@Input('title')courseTitle: string
 * 
 * So the value is travelling from Parent.html in child selector tag [property] to child.ts using @Input('property') 
 * 
 * This can then be used in a simple way in the child.html {{ courseTitle }}
 * 
 * So now we can see that our child is showing different titles for each course. Same way, we can do it for other properties
 * as well. But instead of passing each property, we can pass a complete js model class like Course.
 * 
 * 	export interface Course {
    	id:number;
    	description:string;
    	iconUrl: string;
    	longDescription: string;
    	category:string;
    	lessonsCount:number;
	}
 * 
 * So, in the app.html (parent), we pass the course object instead of just the title.
 * 	<course-card [course]="coreCourse"></course-card>
 * 
 * Then in the course-card.ts (child), we get the object using @Input()
 * 	@Input('course') courseObj: Course;
 * 
 * Then we use this 'courseObj' in the course-card.html.
 * 	For title: 							{{ courseObj.description }}
 * 	For image url: 						<img [src]="courseObj.iconUrl">
 * 	For course description: 			{{ courseObj.longDescription }}
 * 
 * Vid 10: Angular Component @Output - Custom Events and Event Emitters
 * 
 * Here we are going to learn how to emit events from child, that can be handled at the parent component. We are going to
 * add a button in course-card that will emit events which will be handled in app.
 * 
 * The mechanism for handling custom events in Angular looks exactly the same for handling native browser events. But the 
 * difference between the native browser events and custom events is that the custom events do not bubble up the component
 * hierarchy. This bubbling up of events is standard browser mechanism.
 * 
 * Lets say we create a button in course-card.html
 * 	<button (click)="onCourseViewed()">View Course</button>
 * 
 * Now we need to have a method definition in the course-card.ts
 * 	onCourseViewed() {
    	console.log('course-card component - course clicked');
  	}
 * 
 * Now whenever we click this button, we will see log in the console. Note that since this is a browser event, this will be
 * trigger up in the component hierarchy. E.g If we add a function that catches it in the parent html, it can be used to
 * trigger functionality from parent ts as shown below. In app.html, we add (click)="courseClick()"
 * 
 * 	<course-card (click)="courseClick()" [course]="coreCourse"></course-card>
 * 
 * This courseClick() will be then triggered whenever a click event is triggered in the child.html
 * 	courseClick() {
    	console.log("app component - course click");
  	}
 * 
 * Now, let's say, in the app.html, instead of (click) event, we want to respond to a custom event 'courseSelected'.
 * 	<course-card (courseSelected)="onCourseSelected()" [course]="coreCourse"></course-card>
 * 
 * 	onCourseSelected() {
    	console.log("app component - onCourseSelected");
  	}
 * 
 * To emit some custom event from child.ts, first we need to create an EventEmitter. This emitter will emit the event. We
 * need to annotate it with @Output to tell that this event needs to be emitted.
 * 
 * 	@Output()
 * 	courseSelected: new EventEmitter<Course>();
 * 
 * This below line is used to trigger the emit.
 * 	this.courseSelected.emit(this.course); 
 * 
 * Please keep in mind that custom events do not bubble up the component tree as native events do. 
 * 
 * To catch the event being triggered in html, we need to use onCourseSelected($event). $event is a special syntax used to
 * pass the emitted variable. 
 * 
 * <course-card *ngIf="courses[0] as course"
        (courseSelected)="onCourseSelected($event)" [course]="course">
    ...
   </>
 * 
 * 
 * Vid 11: The Angular ngFor Core Directive
 * 
 * When you want to give a loop of events, e.g in our app.html, we are calling the same child 3 times for 3 courses, here
 * we can just use a ngFor Directive.
 * in app.ts, we are now getting and setting an array directly, not each its individual member.
 * We use this directive as: This loop content is similar to how it works in JS.
 * 	*ngFor="let course of courses"
 * 
 * <course-card *ngFor="let course of courses"
        (courseSelected)="onCourseSelected($event)" [course]="course"></course-card>
        
 * We can also refer to an index element of this array using 'index'. This index is 0-based.
 * 
 *  *ngFor="let course of courses; index as i"
 * 
 * To use this 'i' index variable, in our example, we want to pass this property to the child.html. So, we want to pass
 * this from parent to child. We do this by passing an attribute [cardIndex]="i+1" using the @Input() property on child.ts
 * to capture that property. Then we can simply use {{ }} to get that value from ts.
 * 
 *  <course-card *ngFor="let course of courses; index as i"
        (courseSelected)="onCourseSelected($event)" [course]="course" [cardIndex]="i + 1"></course-card>
 *       
 * *ngFor also has other attributes to refer to specific elements of the array. e.g first, last, even, odd
 * 
 * <course-card *ngFor="let course of courses; index as i; first as isFirst; last as isLast; even as isEven; odd as isOdd" 
        (courseSelected)="onCourseSelected($event)" [course]="course" [cardIndex]="i+1"
        [class.is-first]="isFirst" [class.is-last]="isLast" [class.is-even]="isEven"
        [class.is-odd]="isOdd">
        
 * Here we are using 'class' property to access the style properties on the class and setting the corresponding style from
 * styles.css file on the class by checking the condition in RHS of the style-condition (key-value) attribute pair. 
 * If on RHS, we had set to "true", then that style would have been set for the whole class.
 * 
 * Vid 12: Angular ngIf Directive and the Elvis Operator
 * 
 * *ngIf="somebooleanExpression" is another directive. In this case, if this 'somebooleanExpression' evaluates to true, 
 * then we are going to see the DOM element in the view. Otherwise, this element will not be present in the view.
 * 
 * Note: If we pass some string, Angular will try to coerce it into a boolean. E.g For strings, if the value is undefined,
 * then it will be false. For any other value, it will be true. 
 * 
 * 	<div class="course-card" *ngIf="courseObj">...
 * 	OR
 * 	<img width="300" alt="Angular Logo" *ngIf="courseObj.iconUrl"
            [src]="courseObj.iconUrl">
 * 
 * We can also use Elvis operator ( ?. ) to show that element only when that element is not undefined.
 * 
 * 	<img width="300" alt="Angular Logo" *ngIf="courseObj.iconUrl"
            [src]="courseObj?.iconUrl">
 * 
 * We can also use else block with ngIf. In the else block we need to pass a templateReference to a ng-Template element.
 * <img width="300" alt="Angular Logo" *ngIf="courseObj.iconUrl; else noImage"
            [src]="courseObj.iconUrl">
        <ng-template #noImage>
            <p>No image is available.</p>
        </ng-template> 
 * 
 * Vid 13: Angular ngClass Core Directive - Learn all features
 * 
 * ngClass is used to provide Conditional Styling to our classes. It takes in the name of the style class, ie a string. 
 * We can pass in a string or an array of Strings or a configuration object which has styleStrings:boolean syntax.
 * 
 * 	[ngClass]="'beginner'" or [ngClass]="['beginner','course-card']" or [ngClass]="{'beginner':true,'course-card':true}"
 * 
 * The recommended approach is to provide it a method from the ts, and this method will provide it the style classes.
 * 	[ngClass]="cardClasses()"
 * 
 * 	In course-card.ts:
 * 
 * 	cardClasses() {
    	if(this.courseObj.category == 'BEGINNER') {
      		return {'beginner':true};			OR 		return 'beginner';
    	}
  	}
  	
  	OR
  	
  	cardClasses() {
    	return {'beginner':this.courseObj.category == 'BEGINNER'};
  	}
 * 
 * Let's say we want to add a style called beginner to all courseCards which are having category as beginner.
 * 
 * First we create a style in our course-card.css for beginners.
 * 	.course-card.beginner {
 * 		background: lightsalmon;
 * 	}
 * 
 * Now we want to set the condition on the component.
 * 	[ngClass]="cardClasses()"
 * 
 * 
 * NOTE: We are only supposed to use ngClass to give conditional styling, we are NOT supposed to replace the css 'class'
 * property of an html.
 * 
 * 
 * Vid 14: Angular ngStyle Core Directive - When to use it and why?
 * 
 * Similar to how we can add css classes conditionally with ngClass, we can also add css styles conditionally with ngStyle.
 * 	[ngStyle]="cardStyles()"
 * 
 * 	cardStyles() {
    	return {
      		'text-decoration':'underline'
    	}
  	}
  	
 * ngStyle should only be used for properties that are dynamic and dependent on content of the data. E.g Instead of giving
 * an <img> in html, we want to give the image as the css background of the course card. 
 * 
 *  cardStyles() {
    	return {
      		'background-image':'url(' + this.courseObj.iconUrl +')';
    	}
  	}	
 * 
 * and then call this in our course-card:		 [ngStyle]="cardStyles()"
 * 
 * In conclusion for styling, most of the times, we will use plain css classes, e.g <div class="course-title">
 * In some cases, we might want to add css classes based on certain conditions. Then we use [ngClass].
 * In even less cases, we might want to add css styles based on certain dynamic properties. Then we use [ngStyle]
 * 
 * Vid 15: Angular ngSwitch Core Directive in detail
 * This is similar to Javascript switch statement.
 * 
 * 	.course-category {
  		margin-top: 15px;
	}
 * 
 * 	<div class="course-category" [ngSwitch]="courseObj.category"> 
    	<div *ngSwitchCase="'BEGINNER'">Beginner</div>
        <div *ngSwitchCase="'INTERMEDIATE'">Intermediate</div>
        <div *ngSwitchCase="'ADVANCED'">Advanced</div>
        <div *ngSwitchDefault>All Levels</div>
     </div>
 * 
 * How it is different from *ngIf is we can cover multiple alternative cases and we can provide a default case. 
 * In *ngIf, we can only provide 2 cases: if and else.
 * 
 * Vid 16: Angular ng-container Core Directive - When to use it?
 * 
 * Usually we are adding *ngIf on <div>. This will create a new DOM for every div. Instead to keep our class lightweight,
 * we can use <ng-container> instead of <div>
 * <ng-container> is only a container element which can take in other directives like *ngIf or [ngSwitch]
 * 
 * 		<ng-container [ngSwitch]="courseObj.category">
            <div class="course-category"> 
                <ng-container *ngSwitchCase="'BEGINNER'">
                    <div class="category" >Beginner</div>
                </ng-container>
                <div class="category" *ngSwitchCase="'INTERMEDIATE'">Intermediate</div>
                <div class="category" *ngSwitchCase="'ADVANCED'">Advanced</div>
                <div class="category" *ngSwitchDefault>All Levels</div>
            </div>
        </ng-container>
        
 * Additional Sources:
 * What is the difference between ng-template, ng-container, ng-content?
 * 	https://vibhas1892.medium.com/difference-between-ng-template-ng-
 * 	container-and-ng-content-a1d264619655#:~:text=To%20sum%20up%2C%20ng%2Dcontent,your%20template%20or%20you%20code.
 * How Browser Rendering works:
 * 	https://medium.com/jspoint/how-the-browser-renders-a-web-page-dom-cssom-and-rendering-df10531c9969
 * 	https://blog.logrocket.com/how-browser-rendering-works-behind-scenes/
 * 
 * Vid 17: Angular Built-in pipes - Complete Catalog
 *
 * Pipe is a template mechanism that transforms the input into a formatted output. It is a function.
 * It can take further arguments as well {{ variable | pipeName :arg1 :arg2 :arg3 }}. Without any arguments, it takes in the
 * default format.
 * 
 * 1. date: to transform into a date format. 
 * 		<div>Birth Date: {{ birthDate | date : 'MM/dd/yyyy'}}</div> or 'MMM/dd/yyyy'
 * 
 * 2. string
 * 		<div>Title : {{ title | uppercase }}</div> or lowercase or titlecase
 * 3. number
 * 		<div>Price : {{ price | number :'3.3-5'}}</div>
 * 4. currency
 * 		<div>Price : {{ price | currency : 'EUR'}}</div> or 'GBP' or 'USD'(default)
 * 5. percentage
 * 		<div>Percentage : {{ rate | percent }}</div>
 * 
 * 6. slice: for handling collections of data
 * 		<course-card *ngFor="let course of courses | slice: 0:2 ; index as i;" 
        	(courseSelected)="onCourseSelected($event)" [course]="course" [cardIndex]="i+1">
    	</course-card>
 * 
 * 7. json: very useful for debugging. Displays the element in a tree with all properties in the form of a json.
 * 		{{ courses | json }}
 * 
 * 8. keyvalue: shows key-value pairs of an object
 * 		<div *ngFor=" let pair of course | keyvalue">
    		{{ pair.key + ':' + pair.value }}
		</div>
		
 * Consider the below variables for above examples:
 *	courses = COURSES;
 *	birthDate = new Date(1992, 9, 23);
 *	title = "angular core deep dive";
 *	price = 9.99;
 *	rate = 0.67;
 *	course = COURSES[0];
 *	
 * Source: https://angular.io/api/core/PipeTransform
 * 
 */
public class ComponentsDirectivesPipes2 {

}
