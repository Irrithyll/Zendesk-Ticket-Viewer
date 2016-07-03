# Zendesk-Ticket-Viewer
Zendesk Ticket Viewer - A CLI ticket viewer for the Zendesk Intern Coding Challenge
written by Sarah Giapitzakis

## Installation & Use (Mac / Unix command line)

### CHECKING JAVA IS INSTALLED
Ensure that Java and Java C are installed on the machine
(You will require jre1.8.0_65 or greater)
You can check the current version of Java installed by typing:
java -version 
And you can check the current Java C version installed by typing:
which javac

### IF YOU DO NOT HAVE JAVA/JAVAC INSTALLED
Go to http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
and download and install a relevant version for your system

### COMPILING THE PROGRAM 
1) Navigate to the extracted project directory, where you should see folders like src, libs, ect
2) (note: colons may need to be replaced by semi-colons on a mac cli) Type:
javac -d bin -sourcepath src -cp libs/json-20160212.jar:libs/jsoup-1.8.3.jar src/com/zendesk/main/Main.java
3) the program should have successfully compiled

### RUNNING THE PROGRAM
1) If you have successfully compiled the program you can execute it
2) (note: colons may need to be replaced by semi-colons on a mac cli) Type: 
java -cp bin:libs/json-20160212.jar:libs/jsoup-1.8.3.jar com.zendesk.main.Main to run the program
3) Have fun~