package com.moulik.bootstrap;

/**
 * Introduction:
 * What is Bootstrap?
 * Installation.
 * Grid System
 * Components
 * 
 * What is Bootstrap?
 * 	Most popular FrontEnd Framework
 * 	Used for building responsive, mobile first websites and web applications
 * 	HTML/CSS/Javascript
 * 
 * Why use Bootstrap?
 * 	Increase Development Speed
 *  Assure Responsiveness
 *  Prevent repetition between projects
 *  Add Consistency
 *  Ensure cross browser compatibility
 *  Large Community
 *  Customizable
 *  
 * Bootstrap Components and Helpers
 * 
 * Installation (using downloaded zip)
 * 	1. Download and Extract Bootstrap 5.1.3 into a location of your choice. Then just create an index.html file in the same 
 * location where the css and js folders are present.
 * 	(Learn Emmet. It is a great tool that speeds up your development)
 * 	2. In the index.html, press ! and hit Tab. It will generate boilerplate HTML code.
 * 	3. Add link for css/bootstrap.css and script src for js/bootstrap.js (Bootstrap also depends on Popper. So you can add 
 * that as well as a script)
 * 	4. In case you want to use the version with all dependencies bundled, you can use js/bootstrap.bundle.js
 *
 * Installation (Via CDN)
 * 	Create an index.html file and add the css and js and popperjs from CDN URLs given on the Bootstrap website.
 * 
 * Installation (Via NPM)
 * 	1. Open Terminal in VS Code. Make sure you have npm installed.
 * 	2. Type npm init so as to create a barebore project. Give the entries such as package name etc and accept defaults if
 * 	required.
 * 	3. Type npm install bootstrap. This will install all the dependencies for bootstrap under node-modules.
 * 	4. Then link the css and add script js using node_modules/bootstrap/dist/css/bootstrap.css and 
 * 	node_modules/bootstrap/dist/js/bootstrap.bundle.js
 * 	5. If you want to have popper added separately, then run npm install @popperjs/core --save and then add it as a script
 * 	src="node_modules/@popperjs/core/dist/umd/popper.min.js", but just before bootstrap.js script tag.
 * 
 * Grid System
 * 	Why Bootstrap became popular is because of Grid System.
 * The Grid System provides responsiveness to the page. Bootstrap imagines our screen in the forms of rows and each row has
 * 12 columns. Also, we can define bootstrap to change the column structure after it reaches certain breakpoint. These 
 * breakpoints are defined as under:
 * 	Breakpoint			Class infix			Dimensions
 * 	X-Small				None				<576px
 * 	Small				sm					>=576px
 * 	Medium				md					>=768px
 * 	Large				lg					>=992px
 * 	Extra large			xl					>=1200px
 * 	Extra Extra Large	xxl					>=1400px
 * 
 * These breakpoints are customizable via Sass—you’ll find them in a Sass map in our _variables.scss stylesheet.
 * 
 * First class that you can add to your body is 'container'. This will have some margin on left and right, ie it will have 
 * a max-width that changes at each breakpoint. 
 * You can use class border along with container to see the actual border of the row.
 * If you use 'container-fluid' class, then it will take the whole width of your screen without leaving any margin.
 * We can also have responsive containers. These containers act as container until certain breakpoint and once you go below
 * the breakpoint, it will act as container-fluid, ie, it will span the whole view-port. eg .container-sm will be 100% wide
 * until small breakpoint, beyond which max-width will be applied similar to the case of container.
 * 
 * Check https://getbootstrap.com/docs/5.1/layout/containers/
 * 
 * Grid System is built on flexbox.
 * 	1. It supports 6 responsive breakpoints. (xs, sm, md, lg, xl, xxl)
 * 	2. Containers center and horizontally pad your content. (.container, .container-fluid, .container-md etc)
 * 	3. Rows are wrappers for columns: Each column has horizontal padding (aka gutter) for controlling the space between 
 * 	them.
 * 	4. Columns are incredibly flexible: here are 12 template columns available per row, allowing you to create different 
 * 	combinations of elements that span any number of columns.
 * 	5. Gutters are also responsive and customizable: Change horizontal gutters with .gx-* classes, vertical gutters with 
 * 	.gy-*, or all gutters with .g-* classes. .g-0 is also available to remove gutters.
 * 	6. Sass variables, maps, and mixins power the grid: If you don’t want to use the predefined grid classes in Bootstrap, 
 * 	you can use our grid’s source Sass to create your own with more semantic markup.
 * 
 * You can mix and match column width to make sure it has some width for some screen and changes column width for smaller or
 * larger screen. Below example will consider col-1 for xxl screen, col-2 for xl screen, col-3 for lg screen and so on.
 * 	<div class="col-xxl-1 col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12">
 * 
 * Columns:
 * You can also align the columns vertically or horizontally.
 *  Vertical Alignment: 
 *  	<div class="row align-items-start">		aligns the row to the start of the column vertically
 *  	<div class="row align-items-center">	aligns the row to the center of the column vertically
 *  	<div class="row align-items-end">		aligns the row to the end of the column vertically
 * 		<div class="col align-self-start">		aligns the column to the start of the column vertically
 * 		<div class="col align-self-center">		aligns the column to the center of the column vertically
 * 		<div class="col align-self-end">		aligns the column to the end of the column vertically
 * 
 * 	Horizontal Alignment:
 * 		<div class="row justify-content-start">
 * 		<div class="row justify-content-center">
 * 		<div class="row justify-content-end">
 * 		<div class="row justify-content-around">
 * 		<div class="row justify-content-between">
 * 		<div class="row justify-content-evenly">
 * 
 * Gutters:
 * Gutters are the gaps between column content, created by horizontal padding.
 * 
 * <div class="my-5"> means we want to have margin of 5 for y-axis, that is from top and bottom.
 * Similarly <div class="mx-5"> means we want to have margin of 5 for x-axis, that is from right and left.
 * 
 * Gutter can be set similar to how margin is set.
 * It can have values from 1-5. eg g-1 or gx-1 till g-5 or gx-5 or gy-5
 * 
 * We can also make this space similar to Gutter using Padding and Margin but Gutter is just an easier way to do this.
 * 
 * BUTTONS:
 * 1. By simply adding a few button classes to the button tag, it will change the structure and color of the button.
 * 
 * <button type="button" class="btn btn-primary">Primary</button>
 * <button type="button" class="btn btn-secondary">Secondary</button>
 * <button type="button" class="btn btn-success">Success</button>
 * <button type="button" class="btn btn-danger">Danger</button>
 * <button type="button" class="btn btn-warning">Warning</button>
 * <button type="button" class="btn btn-info">Info</button>
 * <button type="button" class="btn btn-light">Light</button>
 * <button type="button" class="btn btn-dark">Dark</button>
 * <button type="button" class="btn btn-link">Link</button>
 * 
 * Note: In a <button>, if we don't set any 'type' attribute, it defaults to 'type=submit', so under a <form> tag, it will
 * try to submit the form along with the click-event function that you bind to it.
 * 
 * 2. If you don’t want the button text to wrap, you can add the .text-nowrap class to the button
 * 
 * 3. We can also have buttons which don't have the backgrounds set as in the normal case above. Only the outlines of such
 * buttons are set. These are called outline buttons and are set by the class btn-outline-*.
 * <button type="button" class="btn btn-outline-primary">Primary</button>
 * 
 * 4. Size: Other than the regular size button, we can have 2 other sizes
 * 	<button type="button" class="btn btn-primary btn-lg">Large button</button>
 * 	<button type="button" class="btn btn-primary btn-sm">Small button</button>
 * 
 * 5. Make buttons look inactive by adding the 'disabled' boolean attribute to any <button> element
 * 	<button type="button" class="btn btn-lg btn-primary" disabled>Primary button</button>
 *  
 * 6. Block Buttons
 * Create responsive stacks of full-width, “block buttons” like those in Bootstrap 4 with a mix of our display (d-grid) 
 * and gap (gap-*) utilities
 * 
 * 	<div class="d-grid gap-2">
 * 		<button class="btn btn-primary" type="button">Button</button>
 * 		<button class="btn btn-primary" type="button">Button</button>
 * 	</div>
 * 
 * Similarly such buttons can be made responsive so that they can change the width after reaching certain breakpoint.
 * 
 * 7. Button Plugins: The button plugin allows you to create simple on/off toggle buttons.
 * Add data-bs-toggle="button" to toggle a button’s active state. If you’re pre-toggling a button, you must manually add
 * the .active class and aria-pressed="true" to ensure that it is conveyed appropriately to assistive technologies.
 * 
 * Methods: You can create a button instance with the button constructor, for example:
 * 	var button = document.getElementById('myButton')
 *	var bsButton = new bootstrap.Button(button)
 *
 * Check more on https://getbootstrap.com/docs/5.1/components/buttons/
 * 
 * CARDS:
 * 1. A card is a flexible and extensible content container. Cards are like Bootstrap 3 panels which can have multiple 
 * content types like images, text, list groups, links, and more.
 * 	.card-body: A body will show text but it can contain elements such as .card-title, .card-subtitle, .card-text, 
 * 				.card-link
 * 	.card-img-top: places an image at the top of the card.
 * 	
 * We can also have list of contents in a card with a flush 'list group'. Mix and match multiple content types to create 
 * the card you need, or throw everything in there.
 * 
 * 	.card-header: Add an optional header or footer within a card.
 * 
 * 2. Sizing:
 * Cards assume no specific width to start, so they’ll be 100% wide unless otherwise stated. You can change this as needed
 * with custom CSS, grid classes, grid Sass mixins, or utilities.
 * 	
 * Using Grid markup: Using the grid, wrap cards in columns and rows as needed
 * 	<div class="row">
  		<div class="col-sm-6">
    		<div class="card">..
    	<div class="col-sm-6">
    		<div class="card">..
    </div>
 * 
 * Using utilities: Use available sizing utilities to quickly set a card’s width.
 * 	<div class="card w-75">
 * 		<div class="card">..
 * 	</div>
 * 
 * Using custom css: Use custom CSS in your stylesheets or as inline styles to set a width.
 * 	<div class="card" style="width: 18rem;">
 * 
 * 3. Text alignment: You can quickly change the text alignment of any card—in its entirety or specific parts—with our 
 * text align classes.
 * 
 * 4. Navigation: Add some navigation to a card’s header (or block) with Bootstrap’s nav components.
 * 
 * 5. Images: Choose from appending “image caps” at either end of a card, overlaying images with card content, or simply 
 * embedding the image in a card.
 * 
 * 	<div class="card mb-3">
 * 		<img src="..." class="card-img-top" alt="...">
 * 		<div class="card-body">...
 * 	
 * 	<div class="card bg-dark text-white">
 * 		<img src="..." class="card-img" alt="...">
 * 		<div class="card-img-overlay">
 * 			<h5 class="card-title">Card title</h5>...
 * 		</div>
 * 
 * 6. Card Styles: Cards include various options for customizing their backgrounds, borders, and color.
 * Use text color and background utilities to change the appearance of a card.
 * 	
 * 	<div class="card text-white bg-primary mb-3">...
 * 
 * Use border utilities to change just the border-color of a card. Note that you can put .text-{color} classes on the 
 * parent .card or a subset of the card’s contents.
 * 
 * 	<div class="card border-dark mb-3">...
 * 
 * You can also change the borders on the card header and footer as needed, and even remove their background-color with
 * .bg-transparent.
 * 
 * 7. Card Layout: In addition to styling the content within cards, Bootstrap includes a few options for laying out series
 * of cards. For the time being, these layout options are 'not' yet responsive.
 * 
 * Card Groups:
 * 	<div class="card-group">
 * 		<div class="card">..
 * 
 * 	When using card groups with footers, their content will automatically line up.
 * 
 * Grid cards: Use the Bootstrap grid system and its .row-cols classes to control how many grid columns (wrapped around 
 * your cards) you show per row. 
 * 
 * TYPOGRAPHY:
 *  Typography deals with the text. What's interesting about it is like everything in Bootstrap, this is also responsive.
 *  
 * 1. Headings <h1>..<h6>
 * There are situations where we would like to have some elements have the same font and other attributes similar to 
 * elements like <h1>. For that, we can use prebuilt .h1, .h2 etc.
 * 
 * 2. Bootstrap also comes with Display headings- which are slightly bigger headings. '.display-*'
 * 
 * 3. Make a paragraph stand out by adding '.lead'.
 * 
 * 4. Inline Text Elements: Styling for common inline HTML5 elements. <b> <i> etc
 * .mark, .del, .small, .text-decoration-underline, .text-decoration-line-through should be used instead of <mark>, <del>
 * <small>, <u>, <s> if the purpose to use them is styling only.
 * 
 * Sidenote: earlier it used to be left to right. But some countries read from right to left. So when bootstrap added RTL
 * support, they had to change the names to start and end so that it makes sense for RTL as well.
 * 
 * 5. Abbreviations
 * 6. Blockquotes
 * 7. Lists: Unstyled, Inline, Description List
 * 8. Responsive Font Sizes
 * Also check out RFS as a separate project, which can help in resizing everything
 * 
 * RESPONSIVE IMAGES:
 * Bootstrap allows you to make images responsive.
 * To make an image responsive, add .img-fluid in the <img>
 * To make an image a thumbnail template, add .img-thumbnail
 * 
 * To give alignment to the image, use .float-end/.float-start and w-25 for width 25.
 * 
 * To center align it, '.d-block mx-auto w-25'. 
 * Also we can give rounded corners to the image as .rounded
 * 
 * Picture
 * 
 * UTILITIES:
 * Many Utilities are available. Most important is Spacing.
 * 
 * TABLES:
 * .table-responsive-* makes the table responsive (till specific breakpoint)
 * .table-primary etc gives different colors to the table
 * .table-bordered gives border to the table
 * .table-borderless makes the table borderless
 * .table-hover make the row highlight when you hover over the rows of the table
 * .table-striped gives the alternate table rows different colors
 * .table-active makes a row or cell that is having this property as active (highlighted).
 * .table-sm to make any .table more compact by cutting all cell padding in half.
 * 
 * You can have the thead and tfoot have some specific table styles. You can also add a caption to a table which is
 * basically a small description for a table. Caption is placed by default at the bottom of the table. To make it appear
 * at top, use .caption-top
 * 
 * 	<table class="table table-sm caption-top">
 * 		<caption>List of users</caption>
 * 
 * Tables can be nested in rows as well but the styles will not be same.
 * 
 * ALERTS:
 * 1. To use an alert, simply use .alert and some class for the color .alert-primary/.alert-secondary etc. 
 * 2. Use role="alert" to make it dynamic for HTML page.
 * 3. Use the .alert-link utility class to quickly provide matching colored links within any alert.
 * 4. To create alert with icons, use <svg> elements.
 * 5. Using the alert JavaScript plugin, it’s possible to dismiss any alert inline.
 * 
 * TOASTS:
 * Toasts are lightweight notifications designed to mimic the push notifications that have been popularized by mobile and
 * desktop operating systems. They’re built with flexbox, so they’re easy to align and position.
 * 
 * NAVBAR:
 * 
 * NAV and TABS:
 * Navs can be used without a bar as well. They can be arranged horizontally like on Amazon or vertically.
 * 
 * ICONS:
 * bootstrap now has its own icons. You can either add the whole library of icons to your projects similar to how to install
 * bootstrap to your project. Otherwise, if you need just 1 or 2 icons, then you can use svg.
 * 
 * FORMS:
 * Forms are used to save form data. 
 * 
 * OTHER COMPONENTS:
 * ACCORDION
 * BADGE .badge .bg-secondary
 * BREADCRUMBS	.breadcrumb	.breadcrumb-item
 * DROPDOWNS .dropdown-item			Put dropdowns on buttons.
 * MODAL	like a Popup
 * SPINNER like a waiting circle
 * PROGRESS	for progress bar etc
 * SCROLLSPY like a nav bar but on the right and matches the content headings on the page
 * 
 * After creating the page, you need to navigate to its location and then type 'mdb publish'. Note you need to install it 
 * first using 'npm install -g mdb-cli'.
 * 
 * 
 * 
 * 
 * 	
 *
 */
public class Introduction1 {

}
