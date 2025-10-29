#   Welcome to LeverX Lecture 1 homework

## 1.Instructions to BUILD and RUN Main Branch

### 1.1 Building:

Compile the Java source code using `javac`:

~~~bash
javac src/main/java/org/example/Main.java
~~~

### 1.2 Run

~~~bash
java -cp src/main/java org.example.Main
~~~

## 2.Instructions to BUILD and RUN additional branches

### These branches use external library Lombok

## 2.1 Move to external-library branch

~~~bash
git checkout feature/external-library
~~~

## 2.1 Move to anonymous-classes branch

~~~bash
git checkout feature/anonymous-classes
~~~

## 2.2 Compile program using javac

~~~bash
javac -d out -cp "lib/lombok.jar" src/main/java/org/example/*.java
~~~

## 2.3 Run using java
 #### Windows:
~~~bash
java -cp "out;lib/lombok.jar" org.example.Main
~~~
 #### Mac / Linux:
~~~bash
java -cp "out:lib/lombok.jar" org.example.Main
~~~






