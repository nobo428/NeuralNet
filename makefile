JFLAGS = -g

default:
	@echo "'make clean' removes all class and star files"
	@echo "'make compile' compiles all java files"
clean: 
	rm -f *~
	rm -f *.class

compile:
	javac $(JFLAGS) *.java

start:
	java XOrNet
