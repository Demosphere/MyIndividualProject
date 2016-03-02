# MyIndividualProject
This repository will serve as the main repository for my individual enterprise Java project.

Problem Statement

For the past 8 years I have played a table top game via lookings through pyhsical books and electronic pdfs in order to find various rules and such for playing the game. While this is adequate, there is no "good" web medium that allows you to reference all of this information together and therefore it can become encumbersone while playing the game to have various books, notes and pdfs open. "The Codex: Role Playing Game Reference Document" (TheCodexrpgrd) website will aim to correct this by providing a complete reference document that will have organized information based on the game that is being played. 

The game of focus from the initial implementatation will be a game that I am playing at the moment, Vampire: The Masqurade which is a White Wolf / Onyx Path table top roles playing game system. The content of the website will focus primarily on the systems of the game and will leave out much of the fluff information to attempt to avoid causing lawsuits. 

It is my hope that this reference document website can be used by me and other people to streamline there table top role playing game experience.

Scope

- Organize the information of the Vampire: The Masquarade table top roleplaying game in a dynamic database driven application that could support other games of the same type in the future.
- The following information will be cataloged in the game reference document
  - Character types:
    - Vampires
    - Ghouls
  - Factions:
    - Vampire Clans
      - In refernce to the 13 vampire clans
    - Vampire Bloodlines
      - In reference to the several minor bloodlines of vampires
    - Ghouls types
      - In refernce to the 3 different factions of ghouls. (Independant, Vassals, Reverants)
  - Nature and Demenours
    - A simple listing of those provided in the books.
  - Backgrounds
    - A simple listing of those provided in the books.
  - Attributes
    - A simple listing of those provided in the books.
  - Abilities
    - A simple listing of those provided in the books.
  - Role Playing Stats
    - A simple listing of those provided in the books.
    - This is in reference ot a Vampires Virtues
  - Experience Charts
    - Vampire Regular Experience
    - Vampire Maturation Experience
    - Ghoul Experience
  - Powers
    - Vampire Discilines
      - Will include listings for variant selections for powers of the same level.
      - Will include a selection of Rituals for Blood Magic
    - Vampire Combonation Diciplines
  - Merits and Flaws
    - Merit Listing
    - Flaws Listing
  - Path
    - A simple listing of those provided in the books.
  - Systems and Drama
    - Vampire Generational Limits Chart
    - Vampire Character creation quick guide
    - Ghoul Dominator Generational Limits Chart
    - Ghoul Character creation quick guide
    - Blood Use
    - Blood Bonds
    - Health Level Chart Explanation
      - Dice Pool Pentalties
      - Movement Penalities
      - Incapacitated
      - Torpor
      - Final Death
      - Applying Damage
      - Mortal Healing Times Chart
    - Willpower Explanation
    - Humanity Explanation
    - Basic Combat Rules Explanation
      - Types
      - Turns
      - Initiative
      - Resolving Actions
      - Defensive Manuvers
      - Damage
      - Combat Manuvers
    - Dramatic Dice Rolling System Explanation
    - Derangements
    - Deterioation
    - Diaberlie
    - Disease
    - Faith
    - Failing
    - Fire and Burns
    - Frenzy
    - RotScrehck
    - Golconda
    - Becoming Mortal: Humanity
    - Posion and Drugs
    - Sunlight
    - Temperature Extremes
  - In addition to the game reference document the following functionality will be included:
    - Dice Rolling interface
      - Supports standard dice rolling for the game system.
    - Security
      - Developer Login Credentials
        - Will gain access to the CRUD pages.
      - Regular users will not need to login to gain access to information.

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
