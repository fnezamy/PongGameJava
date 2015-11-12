# project1

#Description

The game is a simple pong game. The objective is to not allow the ball to bounce off the wall on your side. If the ball bounces three times off your wall, you lose. But, if you get the ball to bounce three times off the AI's wall you win!

You play simply by pressing the "W" key to move up and the "S" key to move down.

#Works Cited

https://www.youtube.com/watch?v=kzM84kEv7d8&authuser=0

I used this youtube tutorial to help me figure out the math behind how to make the player paddle and ai paddle move, how to set bounds on the ball and how to create a menu. 

#Code Summary

New classes : InputHandler, PlayerPaddle, AIPaddle, MainMenu, GameFrame.

InputHandler methods - keyPressed, keyReleased, keyTyped
PlayerPaddle methods - PlayerPaddle constructor, tick, render
AIPaddle methods - AIPaddle constructor, tick, render
MainMenu methods - MainMenu constructor, addButtons, addActions
GameFrame methods - GameFrame constructor

Changed classes - GamePanel, GameObject, Main

GamePanel changed methods - Added a stop method to stop the game
GameObject changed methods - Added a collide and bounce method to deal with the ball bouncing off the walls and colliding                                 with a paddle.

Main changed methods - Added a single call to MainMenu to start the entire program.

#Extra Credit

Added logic for a two player implementation; needs more work though
Added a score for player one and player two
Added a menu launcher
Added AI Paddle logic
