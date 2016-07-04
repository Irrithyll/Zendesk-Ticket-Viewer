# Zendesk-Ticket-Viewer
Zendesk Ticket Viewer - A CLI ticket viewer for the Zendesk Intern Coding Challenge
written by Sarah Giapitzakis

## Installation & Compiling & Running (Mac / Unix command line)

### CHECKING JAVA IS INSTALLED
Ensure that Java and Java C are installed on the machine
(You will require jre1.8.0_65 or greater)
You can check the current version of Java installed by typing:
java -version
And you can check the current Java C version installed by typing:
which javac

### IF YOU DO NOT HAVE JAVA/JAVAC INSTALLED
1. Go to http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
and download and install a relevant version for your operating system
2. Set the CLASSPATH of your newly installed Java by following steps here
https://docs.oracle.com/javase/tutorial/essential/environment/paths.html
relative to your operating system.

### COMPILING THE PROGRAM
1. Navigate to the extracted project directory, where you should see folders like src, libs, ect
2. type: mkdir bin (or system equivalent command to make a new directory named "bin")
3. (note: colons may need to be replaced by semi-colons on a mac cli) Type: <br />
    javac -d bin -sourcepath src -cp libs/json-20160212.jar src/com/zendesk/main/Main.java
4. the program should have successfully compiled
(note: if you receive an error java: Command not found you may have incorrectly
  set the CLASSPATH or downloaded an old version,  type java -version to check)

### RUNNING THE PROGRAM
1. If you have successfully compiled the program you can execute it
2. (note: colons may need to be replaced by semi-colons on a mac cli) Type: <br />
    java -cp bin:libs/json-20160212.jar com.zendesk.main.Main
3. to run the program. Have fun~



## Use

### Displaying All Tickets For The Account
1. Run the Program. The first thing you will see is a welcome message to the program.
To display all tickets you must first go to the main menu by typing: menu
2. You should now see a selection of options that looks something like
  1) Display All Tickets
  2) Display Individual Ticket
  3) Exit program
Simply select option (1) to display all tickets.
3. Tickets will be displayed a maximum of 25 at a time, you can enter n or b to
page forwards and backwards through the tickets respectively.

### Displaying An Individual Ticket (By ID Number)
1. Run the Program. The first thing you will see is a welcome message to the program.
To display an individual ticket you must first go to the main menu by typing "menu".
2. You should now see a selection of options that looks something like
  1) Display All Tickets
  2) Display Individual Ticket
  3) Exit program
Simply select option (2) to display an individual tickets.
3. You will be prompted for an ID number of the ticket you're looking for, enter it and continue
4. If your ticket ID is invalid/incorrect you will be displayed an error message and returned to
the home menu. However, if your ticket exists and the system should successfully return your
ticket information for that ticket.
