# MyIndividualProject
This repository will serve as the main repository for my individual enterprise Java project.

Problem Statement

For the last 8 years that I have played the White Wolf Tabletop game I have done it all through a manualy process of rolling dice, writing on paper and keeping tedious on the side notes for my character sheets. The site that I will be creating will aid in the process of maintaining a character sheet, facilitate a session between players with a chat services that will be used to perform and log dice rolls. The charact sheet involes a wide array of variables that make up the fictional character come to life while you are playing the game. These are all liable to change throughout the session so they will have to be represented in a flexible database in order to react to changes. The added benifit of this site is that multiple people will be able to log in and then see each other dice rolls and chat and share character sheet information throughout the session.

- Scope Functionality:
  - User can have multiple characters that they can use.
  - Character creation wizard for making new characters
    - Players will be able to allocate the initial faction, starting attribute, starting ability and Discipline scores dependant on the details they provide. I am not going to worry about forcing them to follow the specific games character creation limits in order to keep things open. A reference to character creation rules would be referenced though. 
    - Only Primary Abilties will be intially avaiable to characters.
  - Save and load character details for a user.
  - Reference game descriptions of character information on sheet.
  - Display game mechanics.
    - Current damage ratings will be factored into dice rolling.
      - This will be saved into the character sheet for the next time that it is loaded. 
    - Players will be able to allocate "temporary" dots on their character sheets in order to facilitate "power" effects when they are activated.
    - Players will be able to spend and track experience expenditure on their characters.
    - Specific game functionality of Vampire might be a stretch. Specifically the "POOL" tracking systems of:
      - Blood
      - Humanity (Path Ratings)
  - Players will be able to store specific notes to the characters that they might need or that the website can't support or are out of scope.
  - Role Dice based on character abilities and/or powers.
    - Only 10 sided dice will be supported since this is the only dice that the White Wolf Games use during play. 
    - Dice rolling will be completely set by the player for simplicity. I do not want to create a rule engine to ensure that specific things are being used for specific actions. 
    - 2 Checkboxes will be placed next to attribute and abilties in order to designate them the primary and secondary amounts to create the dice pool.
    - Difficulty thresholds will be able to be set by the player.
    - Aternatly the player can set the number of dice that they want to roll.
    - Extended actions will be supported.
    - Individual rolls of each dice will be displayed.
    - Will be able to designate if re-rolling of 10's should occur. 
    - Will be able to designate whether 1's subtract from the final result.
    - Final result will be displayed to the player and they should have the option to deliver the roll to the chat service or not for the other players to see.
  - Have a chat service that will allow players to chare information and dice rolls while playing the game.
  - Application must be built to accomodate other types of white wolf games, not just the game of Vampire.

WW Vampire Character sheet:
- [Vampire Character Sheet](http://sorwen.com/vampire/BairnAmbroseKane.jpg)
  - This character sheet is what I am aiming to duplicate with a fully interactive website that will allow you to roll dice based on the dots that are next to an ability and it will fully describe the powers and abilities of the character. 

Screenshots from WW-Interface website:
- [sample_image_concept](https://github.com/Demosphere/MyIndividualProject/blob/master/images/sample_design.png)

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
     - Chat Web Service
       - http://chatango.com/
       - <script id="cid0020000115873999830" data-cfasync="false" async src="//st.chatango.com/js/gz/emb.js" style="width: 100%;height: 100%;">{"handle":"demospheregames","arch":"js","styles":{"a":"000000","b":100,"c":"FFFFFF","d":"FFFFFF","k":"000000","l":"000000","m":"000000","n":"FFFFFF","p":"10","q":"000000","r":100}}</script>
       - IRC maybe ????
     - Dice Rolling Web Service
       - Will handle random number generation of multiple dice rolls.
       - http://gmh.xocomp.net/ws/rollgenerator/rollgenerator.asmx 
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
      - EXPERIENCE
    - DESCRULES (FK GAMEKEY)
      - DESCMECHANICS (FK GAMEKEY)
      - DESCPOWERS (FK GAMEKEY)
      - DESCRITUALS (FK GAMEKEY)
      - DESCFACTIONS (FK GAMEKEY)
      - DESCBACKGROUNDS (FK GAMEKEY)
      - DESCNATUREANDDEMENOR (FK GAMEKEY)
      - DESCEXPERIENCE (FK GAMEKEY)
    - EQUIPEMENT (FK GAMEKEY)
      - ARMOR (FK GAMEKEY)
      - WEAPONS (FK GAMEKEY)
      - SPECIAL (FK GAMEKEY)
