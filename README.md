<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

C. I changed the name and title to Sami's Stuffies (Not for sure if I like the name or not yet) I customized the H2 
headers to reflect my website's products more. Added some styling to make the aesthetics of the page match my theme
to demo.css and then linked the styling in the headers of the templates.

D. I added an about page with a button to line 21 in mainscreen. The about has a simple statement about what the shop
sells. The about is able to link back to the main screen through a link in the main header in line 13 in about html.
I created an about Controller that includes the mapping request to the about page in the Controllers folder. 

E. I added sample data in BootStrapData.java of 5 different accessories/dresses for the stuffed animals as well as 5 
different stuffed animals.I had complications with it duplicating but after emptying out the repository I hope it 
stays at it's correct amount. I also used a simple conditional checking that the repositories are at 0 in order to
input the entries without duplicates. 

F. I added Buy Now buttons to the table on mainscreen by adding a form to hold the button on line 88. I created success 
and error html pages to display the corresponding messages. To get those messages to display accordingly I had to create 
the buyProduct function in ProductServiceImpl.java on line 69 that was implemented in productService.java on line 19
The buyProduct function checked the inventory of the product ID gathered from the form and sends whether it's an error 
or successful purchase to the controller I made in ProductController.java that sends the message to be displayed in the 
html pages. I then had to create controllers for the success and error pages which were simple like the about controller
in the previous step. 

G. I added the form inputs for minimum inventory and maximum inventory for OutsourcedPartForm.html and InhousePartForm.html
on lines 27 and 30. I then initialized min and max variables in Part.java on lines 34 and 36 and set them to 0 and 100. 
I then created setter and getter methods min and max on lines 94 - 100. Then in BootStrapData.java I added sample min
and max inventory values to the current sample data I have. I then satisfied the requirement of renaming my persistent
storage from spring-boot-h2-db.mv.db to parts_with_inventory.db.mv.db. I then added validators to my min and max variables
in Part.java with @Min and @Max annotations on lines 33 and 35 to make sure the minimum inventory input isn't less than 0
and that the maximum inventory isn't more than 1000. 

H. Some of these changes are going to show up in the previous push because I accidentally got ahead of myself trying to match up
with the full project demonstration video. 

I.

J.

