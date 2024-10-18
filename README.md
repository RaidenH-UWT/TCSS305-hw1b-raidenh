# TCSS305

Assignment 1B

Raiden H

Autumn 2024

## Assignment Overview
In Assignment 1B we expanded on the StoreItem class we wrote in Assignment 1A by
adding several new classes to the overall application and writing tests to verify
the integrity of those classes and the methods within. This application took
input from a prewritten GUI sending item orders and method calls to
my backend. The backend also had tests to make sure all input cases were
covered given the interface specifications of each class. The purpose of
this assignment was to implement a backend model given an interface and
a frontend GUI application, and make sure the backend worked fully with
any input within the interface specifications.


## Technical Impression:
For this assignment I implemented two test classes, three classes for the
functionality of the application, and wrote JavaDoc for all those as well
as three interfaces. I first wrote the documentation for my interfaces,
then with that information built my test classes, and finally implemented
the classes themselves. I had to tweak my test classes as I developed the
classes, fixing mistakes and correcting goals. My tests had 100% coverage
of my classes, as well as several other tests for edge cases that didn't
add to the coverage.

For `ItemOrderTest` my tests looked very similar to the provided `ItemTest`
test class. I tested the constructor with null and illegal arguments, then I
tested the getter methods, `getItem()` and `getQuantity()`. Finally I tested
the `toString()` method, making sure it returned what I wanted it to.
I definitely could have implemented more test cases here for better coverage,
this was a very short test class. I got 100% coverage however, and hit all
the cases I thought were reasonable.

For `CartTest` I had to test a lot more because it was a mutable object.
I also got to try out the `@BeforeEach` annotation to create a clean Cart
instance for every test. I had to figure out how to add method calls between
my tests, which didn't turn out as clean as I would have liked but did work
as expected. I used `calculateTotal()` to test `setMembership()`.

I ended up with 30 tests throughout the whole project with 100% coverage of
all my classes

My `StoreItem` class looks nearly identical to the same class from Assignment
1A. This is the class where I learned that JavaDoc uses HTML to display its
tooltips, and as such supports some CSS styling which I had a bit of fun with

My `StoreItemOrder` class was very simple, just a single constructor, a
couple getter methods, and a `toString()` method. My implementation was
very similar to my `StoreItem` implementations

For `StoreCart` I did a bit of research on Maps in Java, and decided
to use the HashMap because I didn't need an ordered list and I thought
having a `null` key may be useful. I found out that HashMap also comes
with some helpful methods like `forEach()` to loop through each key/value
pair in the map, I used this for my `getCartSize()` method. I tried doing
the same for my `calculateTotal()` method, but CheckStyle yelled at me
for having too much stuff inside the lambda, and IntelliJ swapped it over
to a for loop using some formatting specific to Maps which I didn't know
about but was very helpful. I implemented the 0-count order overwrite
in my `getCartSize()` method, not in my `add()` method.

I had a lot of fun with this assignment, it challenged me in places but
I never got too stuck to continue. I didn't hit a problem that wasn't
fixed within the day by a bit of research or asking for help in the Discord.
I found the tests very helpful, and the interfaces are very nice to help
me know exactly where to go.

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
You mentioned on Thursday that there wasn't a way to do this, which is
unfortunate, but I'll leave the question here if you think of something.