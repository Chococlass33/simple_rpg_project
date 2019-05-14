# Work Breakdown Agreement
This document is intended to break down the tasks into deliverables and specifiy who is responsible for delivering each. This document specifies the planned work distribution.
Unexpected events may result in a slightly different distribution. Any major departure from the planned work distribution will be logged in this document.
## Assignment 1
### Deliverables
* Class diagram
* Interaction diagram
* Design Rationale
### Planned Work Assignment
#### Lawson
* Class diagram
* Part of the desgin rationale
* Validating the interaction diagram
* Validating part of the design rationale

#### Chee
* Interaction diagram
* Part of the design rationale
* Validating the class diagram
* Validating part of the design rationale

### Major Changes to Work Assignment
* None

## Assignment 2
### Planned Deliverables
Planned deliverables are classes designed and identified in Assignment 1. It's possible the specific classes may change if better implementations are found during work. Any deviations in deliverables will be noted at the bottom of the WBA for assignment 2
* Character Class
* StunEffect Class
* StunStatus Class
* StunAction Class
* StunBehaviour Class
* RetreatBehaviour Class
* InsultBehaviour Class
* WanderingBehaviour Class
* TalkAction Class
* GivePlansAction Class
* Ninja Class
* Goon Class
* Grunt Class
* Q Class
* DoctorMaybe Class
* Player Class
* Door Class
* Key Class
* RocketPad Class
* LockedDoorAction Class
* PlacePartAction
* UnlockedDoorAction
* LoopingController

### Planned Work Assignment
#### Lawson. All planned work must be completed by 07/05/2019
* Character Class
* StunEffect Class
* StunStatus Class
* StunAction Class
* StunBehaviour Class
* RetreatBehaviour Class
* InsultBehaviour Class
* Ninja Class
* Goon Class
* Grunt Class
* DoctorMaybe Class
* LoopingController Class
* Validating other classes

#### Chee. All planned work must be completed by 07/05/2019
* Door Class
* Key Class
* RocketPad Class
* LockedDoorAction Class
* PlacePartAction
* UnlockedDoorAction
* Q Class
* WanderingBehaviour Class
* TalkAction Class
* GivePlansAction Class
* Player Class
* Validating other classes


### Agreement
I, Lawson Meulman declare that I believe the above WBA for assignment 2 represents an acceptable split of work.

I, Chee Chin Chan declare that I believe the above WBA for assignment 2 represents an acceptable split of work.

### Deviations from original WBA
#### Chee Chin Chan
* Updates to design
    * Split the Door into a LockedDoor and an UnlockedDoor for simplicity.
    * Added a Warhammer to add weapon functionality and have a purpose for multi-coloured doors.
    * Added a Talk action along with the GivePlansAction, as was required in the specifications.
    * Added color functionality to Doors and Keys. If generated without paramemters, they will automatically create a new color corresponding to the count of Keys/Doors created.
* Additional classes built not within original WBA
    * PlayerController.class
    * UnlockedDoor.class
    * LockedDoor.class
    * Warhammer.class
    * RocketBody.class
    * RocketEngine.class
    * TalkAction.class


#### Lawson
* Updates to design
    * Split decision making from character class into the controller interface.
    * Changed how the Stun feature would be implemented
* Additional classes built not within original WBA
    * Controller.class
    * LoopingController.class
    * EmptyController.class
    * StunnedAction.class
    * LogDisplay.class
    * StandStillBehaviour.class
    * InsultAction.class
    * RocketPlans.class
    * DisplayCharacter.class

## Assignment 3
### Planned Deliverables
Planned deliverables are tasks that need to be completed for assignment 3. These may be tasks relating to documentation, testing, modifying existing classes, or building new classes.
* Documentation Deliverables
  * Design rationale (updated)
  * Class Diagram (updated)
  * Game engine recommendations
* Classes that will require modification
  * Application.class - Changing to add a moon map
  * StatusEffect.class - Change to support an oxygen status effect
  * PlacePartAction.class
* Classes that need to be built
  * Spacesuit.class
  * OxygenDispenser.class
  * OxygenTank.class
  * VacuumEffect.class
  * MapTransfer.class
  * YugoMaxx.class
  * WaterPistol.class
  * Water.class
  * ExoSkeletonStatus.class
  * QuitGameAction.class
  * GameVictoryAction.class
  * GameLossAction.class
  * UseRocketAction.class

### Planned Work Assignment
#### Lawson
* Deliverables due by 21/05/2019
  * Class diagram 
* Deliverables due by 24/05/2019
  * StatusEffect.class
  * Spacesuit.class
  * OxygenDispenser.class 
  * OxygenTank.class
  * VacuumEffect.class
  * ExoSkeletonStatus.class 
  * YugoMaxx.class
* Deliverables due by 30/05/2019
  * Testing of Chee's tasks
  * Part of the design rationale

#### Chee
* Deliverables due by 24/05/2019
  * Game engine recommendations
  * Application.class
  * PlacePartAction.class
  * MapTransfer.class
  * WaterPistol.class
  * Water.class
  * QuitGameAction.class
  * GameVictoryAction.class
  * GameLossAction.class
  * UseRocketAction.class
* Deliverables due by 30/05/2019
  * Testing of Lawson's tasks
  * Part of the design rationale

### Agreement
I, Lawson Meulman Declare that I find this WBA to be an acceptable distribution of work.

### Deviations from WBA
#### Lawson

#### Chee