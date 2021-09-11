### where do I store my code?

- can I create a new java project?

        create a new project following convention (group id = com.company and artifact id = product)

- can I create a new class?

        create a new class in the src.main.java.com.sda.advanced

- can I write a new java main?

        generate code using shortcut

- can I run the java main?

        print "hello world" and run the application

### do I know how to store my code in projects?

- can I setup a new maven multi project?

        how to create a new maven multi project

- can I clone a project from github?

        clone sda-course project on your computer

- do I know how to display the hidden folders from my disk?

        display hidden folders in windows / mac

- do I know how to break the link between a remote git repo and a local repo?

        clone sda-course project and remove .git hidden folder

### can I use git to version my code?

- can I use fetch command?

        fetch the changes from the group11 project

- can I create initialize a new local repository?

        initialize a new repository in the cloned sda-course project (make sure to delete .git folder first)

- can I define a remote repository in intellij?

        create a new repository on github. set this new repository as a remote repo in intellij

- can I push my changes to the remote repo?

        change a file and push the change to the remote repository (use intellij)

- can I update my project using git?

        update git using intellij (the operation that performs both git fetch and git pull)

- can I handle conflicts?

        TO BE DISCUSSED in class

### do I understand the maven folder structure?

- can I create a new project (module) ?

        create a new project named sda-sample

- can I mark the java and test sources folder?

        mark main.java as sources folder
        mark test.java as sources folder

- can I mark the java and test resources folder?

        mark main.resources as resources folder
        mark test.resources as test resources folder

### can I use packages correctly?

- can I create packages correctly?

  create the following

  given

        src.main.java.com.sda.advanced
            parent.child1

  create child2 next to child1

- can I move packages correctly?

  given

        src.main.java.com.sda.advanced
            parent.child1
        class B
            app
        class A

  move package "app" to

        src.main.java.com.sda.advanced.app
            class A
                parent.child1
            class B

### can I create java files?

- can I create a class?

        create a class

- can I create an abstract class?

        create an abstract class

- can I create an interface?

        create an interface

- can I create an enum?

        create an enum

### can I handle imports?

- can I import automatically a class?

        use class Random and import it automatically

- can I import manually a class

        given 
        package one
        class Garage
        package two
        class Car

  import car in garage

can I remove all unused imports?

        import List, Map, Set, Queue objects from java
        delete those objects
        use shortcut to optimize imports (remove unused imports)

### can I run applications?

- can I run my application?

        create a psvm

- do I know what is a run configuration?

        create a run configuration, delete it, and recreate it

### can I generate stuff?

- can I implement methods of an abstract class?

        given an interface with method:
        String myMethod(int)
        implement myMethod in another class

- can I implement methods of an interface?

        given an interface Moveable with method:
        String move(int distance)

        implement using code generation

- can I extract interface from a class?

  given

        a class Plane with method String fly(int miles)

  extract an interface Flyable automatically

- can I generate constructors?

        create a class and generate constructor for 2 member variables

- can I modify an existing constructor?

        given a class with a member variable in it's constructor
        add a second member variable and add the variable to the existing constructor

- can I generate getters and setters?

        create a class with 2 member variables and generate getters and setters

### can I refactor stuff?

- how do I rename stuff?

        rename package
        rename class
        rename method
        rename variable

- can I move a method to another class?

  given

        Class A
            myMethod()
        Class B

  move my method to class B

- can I move an inner class to public class?

  given

        public Class A {
     
        }
     
        class B

  move class B to B.java

- can I extract a method from a bigger code block?

  given

        a main method with the creation and setting of an object
        and printing object

  extract the creation part into a private method

- can I refactor the return type of a method?

        create a method String calculate() and change it's type to Integer calculate() using refactoring
