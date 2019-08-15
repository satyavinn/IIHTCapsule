CONTENTS OF THIS FILE
---------------------

 * Introduction
 * DB Setup
 * Build Application
 * Run Application

 #Introduction:

 The Task Manager Single Page Applicationallows you to manage task and set their priorities in range of 0 to 30.
 Each task will have parent task (optional/another task can be made parent), start date and end date.

 #DB Setup:

  1. MySQL Server has to be up and running on the port 3306
  2. Create 'taskmanager' Database,
  3. script file 'taskmanager-database-script' can be located under resource folder,import the same.

 #Build Application

   1. Build Application Using Jenkins Job / maven clean install
   2. npm goal is added as execution step and UI build files will be compiled in to static folder.

 #Run Application

   1. Application jar will be available in target folder after a successful maven build
   2. Trigger the command java -jar taskmanager-1.0.jar
   3. Task Manager Application will be running in Port 8081. Access Application from http://localhost:8081