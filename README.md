# TCSS305

Assignment 1B

Raiden H

Autumn 2024

## Assignment Overview
[Describe your understanding of the purpose and scope of the assignment 
in 250 words or less. The word count is not strict, so don't worry about
going slightly over. Do not just copy text from the assignment description.]

## Technical Impression:
[Describe what you have done to complete the assignment in 200-500 words. 
The word count is not strict, so don't worry about going slightly over; 
however, summaries that do not meet the minimum length requirement or 
are trivial in nature (representing little thought or effort) will not 
get full credit. You can share your personal experiences, things that 
particularly frustrated you about the assignment, things that particularly 
interested you about the assignment, etc. It is especially important that
you document any difficulties you had with tools, Java libraries, etc.]

*You can see that the documentation, then the unit tests were implemented
first by the commit history if you'd like.

## Unresolved problems in my submission:
none

## Citations and Collaborations:
In StoreCart I chose to use a HashMap after looking up the various types of maps.
My original `calculateTotal()` method used the `HashMap.forEach<> method`, but I got a
CheckStyle warning for too many things going on inside the lambda and IntelliJ
swapped it over to a for loop for me. I didn't know for loops worked with HashMaps
like that, but that's pretty cool!

## Questions:
Is there a better way to execute things inside test methods than breaking up
the tests with method calls? For example: I tested `getCartSize()` right after
instantiation, and then wanted to add an item to make sure it was added correctly.
To do this I had to break up my four tests under an `assertAll()` into four
seperate tests with a method call in the middle. Is there a better way
to do that? I tried just adding it into the lambda but it complained, which
makes sense because I don't fully understand lambdas yet.