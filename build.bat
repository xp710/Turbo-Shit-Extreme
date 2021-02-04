@echo off
javac -d . src/entities/*.java src/graphics/*.java src/highscores/*.java src/menu/*.java src/sound/*.java src/upgrades/*.java src/util/*.java src/world/*.java src/Starlorn.java
jar ecvf edu.stuy.starlorn.Starlorn tse.jar edu/stuy/starlorn/* res music voice
