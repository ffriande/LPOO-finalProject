      - Setup/Installation procedure for both project and game/app (how to install the development environment and how to install/run the game/app).

      - Development documentation (Updated UML diagrams, Design Patterns used, other relevant design decisions, major difficulties along the way, lessons learned, overall time spent developing, work distribution amongst team members, etc...)

      - User manual (with screenshots explaining how to play/use the game/app).
-----------------------------------------------------------------------------------------------
To install the apk go to folder sources and you will find FallBall.apk

Architectural pattern used - Model-View-Controller
Design patterns used:
-Singleton (particularly in game Model and Controller classes)

Most of the conception of the project ran smoothly, although, due to the lack of time we had available, we didn't perfect it as much as we wished.
We had some setbacks regarding the understanding and application of the physics simulator and sprite drawing to our needs: 1-Making the bouncing ball disappear on one side and appear on the other without compromising the realism of the game; 2-Preventing the ball from bouncing far away from what it's supposed to; 3-Destroying a platform.

1) Not as a trivial problem to solve as it seems at first glance... Sollution - as the ball starts to go through one side, that piece of sprite is drawn in the other and, only when half the ball is through, the body position is set to that side. But this doesn't solve collisions with platforms problems. So, the sollution was to basically build 3 worlds side by side, but viewport only covers the middle one, where the same platforms exist as triads (one in each world) as bodies are concearned, since sprites are only drawn in the middle world. Like this, the illusion of the ball going through one side to the other is fullfilled.

2) Took us some time thinking about the issue in the beggining, but, when macros were created, thinking in terms of actual real world physics was made easier and we used the principle conservation of mechanical energy.


User Manual

FallBall is a fun, challenging game, in which the goal is to descend through the map and find the big green final platform, thus winning the level; being careful not to hit the red ones.

Main Menu:

https://raw.githubusercontent.com/ffriande/LPOO-finalProject/finalRelease/sources/main%20menu.png?token=Aa1WXLeW5CJHQG_L2JjztGIg2xoTqkMNks5bHxiFwA%3D%3D

Options Menu:

https://raw.githubusercontent.com/ffriande/LPOO-finalProject/finalRelease/sources/options.png?token=Aa1WXHReq5lEolUeiGOQjkC9sgDQhJm0ks5bHxiGwA%3D%3D

1- Sound mute and unmute.(The sound starts muted).

2-Reset all unlocked levels.

Level Selector:
https://raw.githubusercontent.com/ffriande/LPOO-finalProject/finalRelease/sources/level%20selector.png?token=Aa1WXO3krqhacS3wTMWBaP5FUUICTRPgks5bHxiFwA%3D%3D

The buttons with ? are the levels that still locked.

How to play: 

Drag the finger anywhere on the screen to move the ball to the sides.

You can pass from one side of the screen to the other.

https://raw.githubusercontent.com/ffriande/LPOO-finalProject/finalRelease/sources/bounce.png?token=Aa1WXJBfwKiRQMZvOiSLh5JwjRzDh9aVks5bHxiEwA%3D%3D

Hit the red platform, you loose.

https://raw.githubusercontent.com/ffriande/LPOO-finalProject/finalRelease/sources/win.png?token=Aa1WXFrUssnZqxMlv1W7lxSoJzANgw-Kks5bHxmmwA%3D%3D

Hit the green platform, you win.

If the ball has fallen from 3 "storeys" high, the next platform it hits (white or red) is destroyed.

The ball can't dodge platforms to the sides, since, when it goes through one side, it comes out of the other.


Win levels to unlock new ones.

Good luck!

