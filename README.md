# ntz-java

ntz is a commandline notes taker. use HashMap to store all the things.

## What is ntz?

*How do you "persist" data from one running of a program to another??*

This lab shows a simple "store it in a file" solution. 
It also encourages you to try to make this useful to you so that you might end up using your own code as a tool to keep yourself organized(!).

NTZ is a command line note tool that doesn't involve terminal based editors, but does involve Java.
You've been provided with a very simple file backed data store called `FileMap`.
It acts like a Key/Value database, which can be stored in a file.
It has an internal `HashMap<String,NoteList>` and all it does is `load()` and `save()` itself to
a file named "ntz.db".
It's purpose is to show you a simple way to persist your Notez' data into a file.
See more about the ObjectInputStream/ObjectOutputStream classes.

A `NoteList` is merely an ArrayList<String>. 
Each Item in the FileMap's hashmap should use the key String for the Category name, and then append a notes to the NoteList held as the map's value.

This lab requires you to figure out how to take things from the command line and manipulate a `database` to
store text notes.
You should work on it over the course of the week.

## Why?

Keeping track of a small list of things to remember or stuff that needs doing is a pain.
Remembering its location, manually accessing it, formatting it and all of the clicking that entails,
is something many find unpleasant.

Other command line note tools out there are...clunky. 
They require interacting with vim or nano, and manual formatting. 
Yuck.

ntz takes command line arguments and builds tidy todo/remember lists using Java. 
The result is a notes system that is easily manipulated with the command line 
using ntz' interface.

## What's it look like? - Usage

### Showing notes

Typing `ntz` with no arguments should display all your notes.
It should number them so you can perform forget/change on them.

```
ntz
1) "hello!"
2) "second note"
```

### adding/forgetting and changing notes

`ntz` has four commandline options.

* [-r]emember
* [-c] creates and/or appends to a category
* [-f]orget a note
* [-e]dit (replace) a note

#### Remember

Adds a note to the general category.

```
ntz -r "This is a note"
# which should be the same as 
ntz -c "General" "This is a note"
```

#### Create/Append to Category

Adds another note to a category, if the category doesn't exist,
adds a new category and appends the note to it.
```
ntz
1) "hello!"
2) "second note"

ntz -c "Todo" "Buy Milk."

ntz
1) "hello!"
2) "second note"
 Todo
1) "Buy Milk."
```

#### Forget a note

Removes a note from a category

```
ntz
1) "hello!"
2) "second note"

ntz -f 1

ntz
1) "second note"
```

### Edit a note

Replace a note with a new one.

```
ntz
1) "hello!"
2) "second note"

ntz -e 2 "replaced second note"

ntz
1) "hello!"
2) "replaced second note"
```

## How to do this Lab

You need to be thinking in phases.
Phase 1, and then 2 and then 3 and so on.

Phases

* Get the bare ntz command working.
  * You should put a couple of notes into the general category (in code)
  * built a method to print out the FileMap
* Get the simple remember command working.
  * pull the data from the command line
  * call the method to add the note to the category
* Build the category (-c) command functionality
* Add delete note capability
* Finish with the "edit" capability

Each phase needs to be clear piece of work.
You have to make the code in the phase work.
It's probably by adding a method to the Notez class.
Then you have to do a git commit and push.
You must decide on a few tests and write them.
Then you have to do a git commit and push.
Once you have completed a phase you move onto the next one.
At the end of each phase the program must work well.

Things you need to think about as you're doing each phase

* How do you figure out what was passed to the program's input on the command line?
* How do you *carefully* break that line into pieces you can handle.
* How do you handle the "command" ( -r, -c, -f, -e) and it's arguments?
  * How do you design a method in the Notez class to handle the command.

## Database "BackEnd"

Yes, the backend (the FileMap) is a very crude database.
It is a HashMap<String, Notelist> and a NoteList is merely an ArrayList<String>.
FileMap wraps (forwards) all the Map required methods to its internal HashMap.
FileMap then implements two methods that save/load the hashmap to a file and back.
You might want to get ntz running and then replace the database with something else.
Feel free to use another one.
These are all suggestions:

* SQLite3
* BerkeleyDB
* jdbm2
* BananaDB
* REDIS
* anything else your heart desires.

## Installation (Once you have it written)

This is waving hands.
Need real instructions here.
The issues, which make this a little brittle or difficult, is often the relative paths within the shell script.

1. Look at the `ntz.sh` file.
2. It might work for you.
3. Place it somewhere that's in your shell's $PATH. Either /bin, /usr/bin or ~/bin
4. Add this line to your .bashrc or .zshrc in the alias section (which is probably in ~/) -> alias ntz='ntz.sh'

That should do it. To make ntx executable in a shell, just `chmod +x ntz` and it'll probably do the trick.

-kristofer