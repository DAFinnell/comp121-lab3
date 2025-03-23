   AUTHOR: Derek Finnell
     DATE: 3/23/25
GRADE NOW: yes

1.  What test cases are needed, and in what order?
    For this, several tests are needed to check the methods we implemented. I would test
    the writeToFile method first, reason being that it will be able to write a file that we can
    then use for testing the readFromFile method. You'll want to ensure you deliberately check
    that all necessary exceptions are thrown from invalid filenames and invalid contents.

    For the BatchProcessor class, you'll want to test the initial commands with both valid and invalid input.
    I included some checks in the code itself, that while they aren't tests, automatically invalidate
    funny input by ensuring the length of the arrays is correct after splitting the line. This was an
    easy way to cover a variety of bad inputs. You'll also want to check the formatting of the date,
    for book and magazine classes, as well as the unique setters outside of the AbstractProduct class
    for the individual Products. There are much less checks for the update and delete commands, so I'd
    check these last, since they also rely on existing information being in place anyway. Finally I'd check
    that the count of successful commands is correctly updated based on a series of successful and unsuccessful
    commands.

2.  What did you not anticipate (e.g. time allocation, test cases,
    algorithms, methods)?
    The BooksAndMore class was very easy to get right. I used some hints from the lecture and put that together
    pretty quickly. I was surprised at how easy the BatchProcessor class was to implement. I was fully planning
    on spending the majority of my Sunday finishing this, and I had some difficulty starting, but once I stopped
    just writing code and thought about using helper methods for implementing it, things came together.

    When I first started the BatchProcessor class, I was using nested if statements and it looked pretty awful.
    I got the idea to use switch statements from the earlier homework with the door game, so I broke the massive
    method up that I was planning on writing into several smaller ones, focusing on individual commands and field
    processing. I got the initial implementation pretty easily, but had to make some revisions to cover failing
    hidden test cases, but the feedback was using in figuring it out for the most part. This is where I added
    some blanket coverage for bad inputs. I wish I'd have implemented some test cases, but I've been very ill
    all week and couldn't get the time to do it. Using the switch statements and hidden test feedback was
    very sufficient to get this functioning well, however.

    After I got the add command covered, I thought implementing the update and delete commands was going to be
    very difficult, but I got both of those working in basically one pass. I was able to utilize my existing
    processFields code for update, which was inadvertent when I initially planned this but I was able to
    use it without any changes to that so that was a really cool execution of programming practices we learned
    in class this semester. Both of these took about a half hour combined to work, so time allocation was
    something I definitely did not anticipate for this one.


3.  What would you do differently next time?
    I'd probably follow the instructions and plan this out before just diving in. Luckily, I didn't lose much
    time because I hated what I was doing early and break the giant method I was working on up. I also fixed
    my mistake of using a ton of nested if statements and using switches instead, which is much more functional
    and readable to me. It was cool to see my progress with working on arrays and it was easy to keep track of
    which index of the arrays I wanted to work with for each method, I simply passed the array along as needed.

    One thing I still don't know if i like is the enhanced for loop in the update and delete processing methods,
    since the array at that point can only be of size 1. It was easy to work with and it's only two lines, so it
    stays. Another thing that I'd change would be to implement some better tests rather than rely on the hidden
    test cases, but they were very thorough and I have been sick all week, so I had to sacrifice those this time.
    I think my implementation is pretty bulletproof except for certain conditions that weren't checked
    (I don't think I account for leading whitespace in the initial input, but that's easily fixed with a trim
    method if needed. I never ran into that issue with the hidden tests so it was omitted). I may have some redundant
    checks for valid input, but I don't think there are many after I cleaned it up.