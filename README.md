<h1>SauceDemo automatic tests</h1>

<h2>What is SauceDemo?</h2>
This is a sample test automation framework for www.saucedemo.com. SauceDemo is a sample website created by SauceLabs
that allows users to practice browser automation.

<h2>Prerequisites installed</h2>
<p> 1. Java JDK 1.11</p> 
<p> 2. Maven </p>  

<h2>Setting up config</h2>
<p>1. Clone this repository.</p>
<p>2. You can specify the browser (Chrome or Firefox) you want to use in the parameters "browser" of the regression.xml, negative.xml, smoke.xml files, the default is Chrome.</p>

<h2>What do these tests cover?</h2>
<p>These tests cover many test cases such as log in (positive and negative tests), various actions on the items ​page, adding items to the cart and removing them.</p>  

<h2>Test suites</h2>
<h3>Regression tests</h3>
<p>This suite includes all tests from files: LoginTests, ProductsTests, CartTests. </p> 
<h4>Running the suit</h4>
<p> To execute the test suite, simply run: </p> 
<p> mvn -Dtest=regression.xml test </p> 
<p>And each scenario of this suite will execute. </p> 

<h3>Smoke tests</h3>
<p> This suite includes 2 tests: loginPositiveTest and cartPositiveTest. </p> 
<h4>Running the suit</h4>
<p> To execute the test suite, simply run: </p> 
<p> mvn -Dtest=smoke.xml test </p> 
<p>And each scenario of this suite will execute. </p> 

<h3>Negative tests</h3>
<p>This suite includes loginNegativeTest with 4 variants of input data.</p> 
<h4>Running the suit</h4>
<p> To execute the test suite, simply run: </p> 
<p> mvn -Dtest=negative.xml test </p> 
<p>And each scenario of this suite will execute. </p> 

<h2>Running tests</h2>
<h4>Run tests using mvn clean test command</h4>
<p> mvn clean test </p>

<h4>Running a single test and running a set of methods in a single test class</h4>
<p>1. mvn -Dtest=ProductsTests test</p>
<p>2. mvn -Dtest=CartTests#addItemInCartTest test  </p>
<p>3. mvn -Dtest=LoginTests#loginWithEmptyFieldsTest+loginWithInvalidFieldsTest test  </p> 


