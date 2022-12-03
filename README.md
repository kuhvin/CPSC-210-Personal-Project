# CPSC 210 Personal Project

## Kevin Li

This project is envisioned as a film and media tracker used for 
controlled organization of a set of films that have been watched or wish to be watched. It will be useful to those who
consume feature-length
media, TV-shows and animation as a simple but effective method to keep their view history tidy and trackable.

This project is of interest to me as I am an avid film buff and consume a wide variety of media, 
from short films to documentaries to Japanese and Western animation. I want to create a program
that is able to track all the shows and films I have watched, and sort them by the criteria I provide. Such a
program would help me better understand the types of media I enjoy, and at the same time provide me with examples
of films for certain genres or styles to recommend to those around me.

### User Stories
#### Phase 0 & 1
- As a user, I want to be able to add movies with descriptors to a list of movies
- As a user, I want to be able to remove a movie from a list of movies
- As a user, I want to be able to select a list to view the names of the films within
- As a user, I want to be able to select a film to view the criteria within

#### Phase 2
- As a user, I want to be able to save my movie lists to a file
- As a user, I want to be able to load pre-existing movie lists from a file

#### Phase 3
- As a user, I want to be able to add a type of media with criterion to a list of movies through graphic prompt
- As a user, I want to be able to see the list of my media as a graphic interface
- As a user, I want to be able to visually select an item of my list to view
- As a user, I want to be able to visually select an item of my list to remove
- As a user, I want to be able to click on a button to save my data
- As a user, I want to be able to click on a button to load pre-existing data

###### Instructions for Grader for Phase 3
- You can generate the first required event relating to adding X's to a Y by creating a media entry
- You can generate the second required event relating to adding X's to a Y by either clicking "Remove Entry" or "View 
Media List" and selecting an entry to interact with
- You can locate my visual component by clicking on "View Media List" if there exists at least 1 entry
- You can save the state of my application by clicking on "Save Data"
- You can reload the state of my application by clicking on "Load Data"

#### Phase 4: Task 2
- The event log will record all events that include pressing a button on the GUI. This means that there will be an event
recorded for adding and removing entries, viewing the entry list and individual entries, and saving and loading data.
- Some examples would include
  - Loaded pre-existing entry list, Tue Nov 29 21:10:52 PST 2022
  - Entry of name Whiplash added, Tue Nov 29 21:10:53 PST 2022
  - Viewed details of entry with name Whiplash, Tue Nov 29 21:10:55 PST 2022

#### Phase 4: Task 3
- After reviewing my UML diagram, I realized that although there could be a small amount of refactoring done, it would
be insignificant to do so. Small things like using more methods to help group code together in order to make it more
legible, especially when creating large amounts of instances. If I had more time, I would expand the scope of the
project, and attempt the "Future/Possible User Stories" I listed bewl

#### Future/Possible User Stories
- As a user, I want to be able to sort a list of entries by the criteria within the entry
- As a user, I want to be able to add lists of entries to a larger, overarching list
- As a user, I want to be able to edit the criteria of entries within the list