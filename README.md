[![Build Status](https://travis-ci.org/ngokcimen/bil481_hw1.svg?branch=master)](https://travis-ci.org/ngokcimen/bil481_hw1)

###### Demo site: https://powerful-wave-29708.herokuapp.com/

# BIL 481 - HW 1

### Goals

  *	 Becoming familiar with all the components of a realistic working environment for a software engineer.

  *	Gaining experience on working on the terminal

  *	Gaining experience on making progress when exposed to many unfamiliar technologies

### Summary
Set up a code repository with continuous integration and deployment.

### Specification
Set up a git repository in your github account. Follow the set up command instructions carefully:
[Instructions for this hw](https://docs.google.com/document/d/1bH7zX7AA93THTylXPwb78P2H2xfyrhwhWiTaXxvJ0aU)

The repository must satisfy the following criteria:
1.	It must contain an App.java file which has a simple static method implementation:
    1.	The method should accept **at least 4 parameters**.
    1. At least two of these parameters must be
        1. Integer [ ] or
        1. ArrayList<Integer>.
    1. The method should perform a __*meaningful*__ computation on the set of strings and return a result.
1.	It must contain a AppTest.java file that implements unit tests for your algorithm implementation.
    1. The file must contain **at least 5 meaningful unit tests** covering your method
1.	It must contain a pom.xml file.
1.	It must have a continuous integration setup with https://travis-ci.org site.
1.	It must have an auto deployment setup with https://www.heroku.com/ site.
    1. The web application should have a UI similar to the shown during the class. For each parameter requested from the user, the UI should have a separate form.
    1.	When the submit button is pressed, the inputs should be given to the algorithm and the result should be shown to the user on the web page.
    1.	The web page should have a description of the algorithm, the input format and the output.
1.	It must have a README.md file describing what your project is about.  In addition,
    1. The file must contain a green marker from travis-ci showing the current build is passing;
    1.	The file must contain a demo site address to the corresponding heroku application.

#### IMPORTANT NOTICE
Make sure that your github repository shows **a meaningful commit history distributed over time**. In other words, we should NOT see that you committed all the files all at once because otherwise this clearly showed that you actually did not follow the instructions properly.

##### Notes
1.	Add a **screenshot** of your travis page showing the latest build (see an example below) to your GitHub page
1.	Add a **screenshot** of the overview page of your heroku app (see an example below) GitHub page

Make sure the heroku app is running until the grading is done (unless you manually delete the app from heroku, it will stay running). If the demo site does not work, we will assume you have not completed the heroku setup.

