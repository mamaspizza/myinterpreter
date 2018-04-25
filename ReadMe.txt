Title: Java based Interpreter for Integer-C

This java program is an interpreter for Integer-C. This simply executes the codes written in Integer-C syntax. This interpreter does  not use GUI.

A. Instructions
The interpreter does not use GUI. The codes of integer-C is simply written in text file and this file will be read and executed by the java program. To run this program, make sure Java Runtime Environment (JRE) is installed in your PC. If not, you can download it at http://java.com/en/download/index.jsp After installing JRE, you can execute the codes using windows command prompt.

Steps 
1. Extract the compressed file and/or copy it in a specified directory in yourcomputer. Make sure that the directory where you extracted your files can be found easily.
2. Open windows command prompt.
3. Go to directory where you extracted your files.
4. Type "java MyInterpreter mycodes" where the first argument is the java command to run the java program, second is the name of the program and the last is the name of the Integer-C file.
 
Writing the Integer-C codes
* Expression and variables should always have space between. Also, provide a space on every code line.
* The java interpreter cannot handle more than two variables on its right side of equation. If you have more than two variables then you can write these on additional lines

B. Achievements/Functionalities
This java based interpreter uses string parsing technique to read and process the code of Integer-C. The java based interpreter uses objects to store integer variables and call this to the expression. It uses the nesting function to process the string parsing and handle the Integer-C code syntax.

C. Details on how I did the implementation
I used a java string tokenizer of java to read each string in the codes. These string of codes are processed inside the nested IF. First IF statement determines if the string token is an input for int variable. Inside this statement, the next string token will be read and then the variable name is stored in a new created object. The object will be stored on a Vector. Next, an ELSE IF statement reads the token if it is a "write/writeline" command of Integer-C. Inside this statement, it handles the next string token whether it will display the written string or the value of a variable. Similarly, another IF statement will determine the "read/readline" command in Integer-C. Inside this statement, the next string token is processed to search the variable. And the, the readline command of java will provide an keyboard input. The last is assignment statement. This searches the first variable in a line and then reading the "=" will followed. Inside this statement, it will determine one or two varible in the right side of the equation. If there are two then it will process its operands. If only one then it assigns the value of the variable to the left side variable.

D. References
[1] Java String Tokenizer http://cgi.csc.liv.ac.uk/~frans/OldLectures/COMP101/AdditionalStuff/tokenizing1.html

E. Limitation

This interpreter is limited to use only two variables in the right side of an equation,
a = b + c
but you cannot,
a = b + c - d
Also, it cannot the following syntaxes
1. parenthesis ()
2. main
3. {} 