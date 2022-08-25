# Let_OS_Play_new
Machine Problem in CMSC 125

-------------------------------------------------------------------------------------------------------------------

To compile and execute source code in the command prompt :

First, change directory to your file path the run the following lines of code:

javac --module-path "libs" --add-modules poi.ooxml,poi src/main/LockdownGameLogic/Entities/*.java src/main/LockdownGameLogic/*.java src/main/*.java -d classes

java --module-path "libs" --add-modules poi.ooxml,poi  -cp classes main.MainGameFrame

-------------------------------------------------------------------------------------------------------------------

To execute JAR file in the command prompt :

[FORMAT]

java -jar ..*FILE_PATH*..\out\artifacts\Let_OS_Play_new_jar\Let_OS_Play.jar

[SAMPLE]

java -jar C:\Users\Me\Desktop\Let_OS_Play_new\out\artifacts\Let_OS_Play_new_jar\Let_OS_Play.jar

-------------------------------------------------------------------------------------------------------------------

To open the executable file in the command prompt :

[FORMAT]

start ..*FILE_PATH*..\Let_OS_Play.exe

[SAMPLE]

start C:\Users\Me\Desktop\Let_OS_Play_new\Let_OS_Play.exe
