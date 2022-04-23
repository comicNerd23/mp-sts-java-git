package com.moulik.angular;

/**
 * 
 * Section 1: Introduction
 * 
 * Vid 1: Angular Core Deep Dive: Helicopter View
 * 
 * Core and common modules of Angular Ecosystem. The multiple modes of Change Detection, Dependency Injection,
 * Internationalisation, Elements etc. 
 * Quick Introduction, Angular CLI, Project Scaffolding, Main benefits.
 * Components, Key benefits of Component model, Inputs, Outputs, Custom Events, Building own tree of custom components
 * Angular Directives: ngIf, ngFor, ngContainer
 * 
 * Local Template Querying: View Child and View Children decorators
 * Angular Content Projection
 * ngContent, MultiSlot Projection, ContentChild and ContentChildren Decorators
 * 
 * Template tag, Templates as inputs, ngTemplateOutlet directive
 * 
 * Custom Angular Directives host binding and Host listener Decorators and Export as
 *
 * Vid 2: Important: Recommended Software Versions
 * Install node 16.
 * 
 * Vid 3: Course Kickoff
 * 
 * Angular core module is the basic module from which all other modules are derived. Angular provides not just a framework
 * but also a CLI.
 * First install Node.js and then install Angular using command 'npm install -g @angular/cli' on the terminal. This way 
 * angular is installed globally in your system.
 * Next, create a simple angular project using 'ng new angular-course'. This creates a proper angular project that you can
 * customise to your liking.
 * Finally, run this project on a local server using 'ng serve'
 * 
 * Vid 4: Typescript Jumpstart Ebook
 * 
 * Vid 5: Introduction to Angular: Custom HTML Elements, Model vs View
 * 
 * Angular has a structure of components. So the index.html has a selector added <app-root/>. And this selector is bound to
 * the app component using the decorator on top of the class name in app-root.ts file. The app-root.html file is called the
 * 'view'. From the .ts file, we can pass the data ('model') to our template (view). So we can separate our view and control
 * in separate files and thus make our application loosely coupled.
 * We can thus install our own custom html tags (selector tags) and extend standard browser functionality.
 * 
 * 	data = {
 * 		title = 'Angular Core Deep Dive';
 * 	};
 * 
 * Vid 6: Why Angular? Learn the key features of Angular Core
 * Input Properties, browser events, automatic synchronisation between the data and the view, angular core built-in
 * security features.
 * 
 * 1. Input Property:
 * When we want to pass some data from the ts component to the html, if we pass it into a html tag value, then we use
 * {{ }} called template interpolation. e.g <h1>{{ data.title }}</h1>
 * If we pass it to an html tag attribute, then we use [] bracket. e.g <input class="demo" [value]="data.title">
 * 
 * 2. Browser Native Events:
 * We can detect browser native events and perform actions on it using () parenthesis. 
 * e.g <img width="300" src="..." alt="Angular Logo" (click)="onLogoClicked()" >
 * 
 * This method is resolved in the ts component file.
 * 	onLogoClicked() {
 * 		alert('Hello World');
 * 	}
 * 
 * 3. Giving Elements of a Page a name:
 * We can also assign a specific name to our elements in a page using # syntax. This is called 'templateReference' 
 *  <input class="demo" [value]="data.title" #titleInput>
 *  
 * This reference can be injected in other parts of our page (html) and also can be given to our component (ts). 
 * 	<input class="demo" (keyUp)="onKeyUp(titleInput.value)" [value]="data.title" #titleInput>
 * 
 * 	onKeyUp(newTitle:string) {
 * 		this.data.title = newTitle;
 * 	}
 * 
 * 4. We have an automatic synchronization between the data and view and in a secure way. E.g Let's say, that a hacker was 
 * trying to inject some code in our data.title object from the browser, as given below.
 * 	data = {
 * 		title = '<h1>Angular Core Deep Dive</h1>';
 * 	};
 * 
 * Then Angular is going to detect that this should be interpreted as a String and would not perform the template 
 * interpolation to convert it to html but rather escape/show it in the browser as a String object. 
 * 
 * Lets consider another more malicious example in which the attacker was trying to inject a <script> tag
 * 	data = {
 * 		title = '<h1>Angular Core Deep Dive</h1><script>alert("Attack!")</script>';
 * 	};
 */
public class Introduction1 {

}
