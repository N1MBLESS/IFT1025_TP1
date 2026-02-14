# Makefile for Museum Project

# Variables
JAVAC = javac
JAVA = java
SRC_DIR = .
BIN_DIR = .
JUNIT_JAR = /usr/share/java/junit4.jar
HAMCREST_JAR = /usr/share/java/hamcrest.jar
CLASSPATH = .:$(JUNIT_JAR):$(HAMCREST_JAR)

# Sources
SOURCES = $(shell find $(SRC_DIR) -name "*.java")

# Targets
.PHONY: default clean compile run test test-custom

default: compile

compile:
	@echo "Compiling..."
	$(JAVAC) -cp $(CLASSPATH) $(SOURCES)

run: compile
	@echo "Running Main simulation..."
	$(JAVA) -cp $(CLASSPATH) exemple.Main

test: compile
	@echo "Running JUnit tests..."
	$(JAVA) -cp $(CLASSPATH) org.junit.runner.JUnitCore test.SalleTest test.PlanDeVisiteTest test.TouristeTest

test-custom: compile
	@echo "Running Custom tests (No JUnit)..."
	$(JAVA) -cp $(CLASSPATH) testSansJUnit.SalleTest
	$(JAVA) -cp $(CLASSPATH) testSansJUnit.PlanDeVisiteTest
	$(JAVA) -cp $(CLASSPATH) testSansJUnit.TouristeTest

clean:
	@echo "Cleaning..."
	find $(SRC_DIR) -name "*.class" -delete
