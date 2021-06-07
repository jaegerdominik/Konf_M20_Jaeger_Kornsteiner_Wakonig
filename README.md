# Software Configuration Management #
## Konf_M20_Jaeger_Kornsteiner_Wakonig ##
Creators: Jäger Dominik, Kornsteiner Lion, Wakonig Gregor

## Classes ##
- Cocktail.java
- HotDrink.java
- Beer.java
- BeerType.java
- BeerTest.java
- CocktailTest.java
- HotDrinkTest.java

## Steps with Git ##

### Task one ###

- Step1: Create Git-Repository
- Step1.1: Add teammebers to you Team and give them permission
- Step2: Push Drink-Smaple to Git
- Step2.1: Clone/Pull the Repository to all Team-Members
- Step3: Create a README.md template
- Step4: Specify the new java classes in the README.md
- Step5: Add the specified java classes to the java project
- Step6: Implement the Functions into the java classes
- Step7: git add class.java
- Step8: git commit -m "message"
- Step9: git push
- Step9.1: tell other Team Members to git pull
- Step10: repeat Step4 - Step9.1

#### Issues ####
-- We ran into issues with our push-/ pull workflow.
	Several times we had to merge our branches. 
	We believe that this was caused by us working on the same file simultaneously.
	Perhaps we caused it by not cleanly pulling our repositories before making changes.
	After we started to be mindful of this problem we ceased to have said issues.


### Task two ###

- Step 1: Create a new branch e.g. Classname_JUnit
- Step 2: Checkout into the new branch
- Step 3: Create tests for each class
- Step 3.5: In the process of Step 3, sometimes other classes need to be adjusted
- Step 4: Add JavaDoc comments if not already done
- Step 5: Add the modified files to git, then commit and push the changes
- Step 6: Checkout into the main branch
- Step 7: Merge the main branch with Classname_JUnit branch
- Step 8: Push the merge to the remote repository 


### Task three ###

- Step 1: Create New Branch for the implementation of Registrierkasse.java - we left the Name Registrierkasse as seen and clearly **instructed in the requirements** sheet in order to not interfere with testcases; as opposed to calling it CashRegister to be conform with English naming conventions.
- Step 2: Checkout into the newly created branch
- Step 3: Created the classes Registrierkasse.java, CASH_REGISTER_CLASS.java and CashRegisterDrink.java.
     Registrierkasse.java contains methods to calculate sales.
     CASH_REGISTER_CLASS is an Enum that describes the type of drink
     CashRegisterDrink.java is the interface
     For Information on these classes refer to DESIGNDECISIONS.md.
- Step 4: Write the site.xml in src/site to add files to the maven site
- Step 5: Create the Files for mvn site in the folder src/site/markdown: DESIGNDECISION.md, TESTABDECKUNG.md, TUTORIAL.md. As specified in the POM.xml, the 
README.md is copied to this folder from the root folder on executing mvn site.
- Step 6: Writing Java Doc comments in all the newly implemented classes and thoroughly describe all newly implemented functionality.
- Step 7: Writing thourough documentation in our README.md, TESTABDECKUNG.md and DESIGNDECISION.md of what and how we implemented things in order to let us remember what we did and let other people understand what we did by reading our documentation. The documentation of this project should be fit to be used by other students as a resource to learn the concepts of configuration management in a self-study mode. The README.md was written following guidelines that are outlined on *https://www.makeareadme.com/*



#### JavaDoc Crashcourse ####

JavaDoc is a writing standard for documentation of code in java. It helps to standardise how people write their code. It helps to keep an overview of your own code aswell as to read and understand code that others have written. 
Many IDEs also integrate support for JavaDoc, e.a. IntelliJ lets you hover your mouse over called method names and other things and shows the JavaDoc of that segment in a tooltip.
A typical JavaDoc comment would look like this:
 
 	`/**
     * Creates a drink object with given name, e.g. juice or orange juice
     *
     * @param name        	name of the drink
     * @param ingredients 	list of liquids
     */
     public HotDrink(String name, Liquid... ingredients){...}`

This is a method header that shows after @param which parameter the method needs. 

Other tags, as described in https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html are:

@author (classes and interfaces only, required)
@version (classes and interfaces only, required. See footnote 1)
@param (methods and constructors only)
@return (methods only)
@exception (@throws is a synonym added in Javadoc 1.2)
@see
@since
@serial (or @serialField or @serialData)
@deprecated (see How and When To Deprecate APIs)



## Used sources ##

- https://www.makeareadme.com/
- https://chris.beams.io/posts/git-commit/#seven-rules

### Task one ###

- https://www.makeareadme.com/
- https://documentation.divio.com/
- https://www.markdownguide.org/cheat-sheet
- https://www.youtube.com/watch?v=6A5EpqqDOdk

### Task two ###

- https://docs.github.com/en/github/getting-started-with-github/pushing-commits-to-a-remote-repository
- https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html
- https://www.writethedocs.org/guide/writing/beginners-guide-to-docs/
- https://chris.beams.io/posts/git-commit/#seven-rules

## Repository Link ##
https://github.com/jaegerdominik/Konf_M20_Jaeger_Kornsteiner_Wakonig





