# MyIndividualProject
This repository will serve as the main repository for my individual enterprise Java project.

Problem Statement

For the last 8 years that I have played the White Wolf Tabletop game I have done it all through a manualy process of rolling dice, writing on paper and keeping tedious on the side notes for my character sheets. The site that I will be creating will aid in the process of maintaining a character sheet, facilitate a session between players with a chat services that will be used to perform and log dice rolls. The charact sheet involes a wide array of variables that make up the fictional character come to life while you are playing the game. These are all liable to change throughout the session so they will have to be represented in a flexible database in order to react to changes. The added benifit of this site is that multiple people will be able to log in and then see each other dice rolls and chat and share character sheet information throughout the session.

Screenshots from WW-Interface:

[sample_image_concept](https://github.com/Demosphere/MyIndividualProject/blob/master/images/sample_design.png)

Security/Authentication
- Security:
  - Admin role: create/read/update/delete of all data
  - User role: make and update character sheets
- Technolgies:
  - Database (MySQL and Hibernate)
    - Store users and roles
    - Stores character information
    - Stores Game information
    - See database pyhsical structure diagram below
  - Web Services or APIs
     - Yet to be known chat web service to facilitate groups of people seeing each others character information and dice rolls.
     - Random number generator API to simulate the dice rolling for the application. 
  - Bootstrap
- Logging
  zsd- Configurable logging using Log4J. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
  - Site and database hosted on OpenShift
  - Jenkins for Continuous Integration
- Unit Testing
  - JUnit tests to achieve 80% code coverage

Independent Research Topic
TBD
Design

Application Flow - link coming soon
Screen Design - link coming soon

Database Design - 
- Database Sctructure:
  - REGISTRATIONKEYS
  - USER
    - USERRIGHTS
    - USERINFO
  - GAME
    - SESSIONS/LOGS (FK USER, GAMEKEY, CHARACTERKEY, SEQ_NR)
    - DICEROLLS (FK DESCMECHANICS)
    - CHARACTERKEY (FK USER)
      - DEMOGRPHICS (PK SEQ_CHARACTER)
      - ATTRIBUTES (PK SEQ_CHARACTER)
      - ABILITIES (PK SEQ_CHARACTER)
      - POOLTRACKING (PK SEQ_CHARACTER)
      - HEALTHTRACK (PK SEQ_CHARACTER)
      - VIRTUES (PK SEQ_CHARACTER)
      - BACKGROUNDS (PK SEQ_CHARACTER)
      - POWERS (PK SEQ_CHARACTER)
      - RITUALS (PK SEQ_CHARACTER)
      - BACKGROUNDS (PK SEQ_CHARACTER)
    - DESCRULES (FK GAMEKEY)
      - DESCMECHANICS (FK GAMEKEY)
      - DESCPOWERS (FK GAMEKEY)
      - DESCRITUALS (FK GAMEKEY)
      - DESCFACTIONS (FK GAMEKEY)
      - DESCBACKGROUNDS (FK GAMEKEY)
      - DESCNATUREANDDEMENOR (FK GAMEKEY)
    - EQUIPEMENT (FK GAMEKEY)
      - ARMOR (FK GAMEKEY)
      - WEAPONS (FK GAMEKEY)
      - SPECIAL (FK GAMEKEY)
