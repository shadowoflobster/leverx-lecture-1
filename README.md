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

## 2.Instructions to BUILD and RUN additional branch

### This branch uses external library Lombok

## 2.1 Move to external-library branch

~~~bash
git checkout feature/external-library
~~~

## 2.2 Compile using Maven

~~~bash
mvn compile
~~~

## 2.3 Run using exec-maven plugin
~~~bash
mvn exec:java
~~~




