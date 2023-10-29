import random

# list and variable for forest loop puzzle
forest_count = 0
forest_choice = []


# excalibur ending
def ending_excalibur():
  print("\n")
  print("A sudden wind swirls around you. You find the path interrupted by a large stone once again, the sword within it calling louder now. You grip the hilt and, with ease, you are able to free the blade from the stone. It is like none other you have ever wielded. The forest opens into a clearing as you look down the path again…")
  print("\n")
  print("      ()    ")
  print("      )(    ")
  print("   o======o ")
  print("      ||    ")
  print("      ||    ")
  print("      ||    ")
  print("      ||    ")
  print("      ||    ")
  print("      ||    ")
  print("      \/    ")
  print("\n")
  print("ENDING: Excalibur")
  print("\n")
  start()

# wrong path choice, two options and quit
def cont_wrong():
  cont_w_choice = False
  while cont_w_choice == False:
    print("You continue down the path, further into the forest. But the path seems wrong. There is a strange aura about this place. The dense forest seems to go on forever. After what seems like hours of travel, you find the path interrupted by a large stone. A large sword protrudes from the stone. You halt by the stone and dismount, feeling almost as if the sword itself is calling to you. Upon closer inspection, you find an engraving:")
    print("< > < > < < < >")
    print("It is perfectly identical to the previous sword and stone, almost as if it is the very same. You may continue down the path or attempt to pull the blade out. Or perhaps there is another way to move forward?")
    choice_4N = input("(Continue, Sword, Quit) ")
    choice_4N = choice_4N.upper()
    if choice_4N == "CONTINUE":
      cont_w_choice = True
      print("\n")
      cont_correct(forest_count)
    elif choice_4N == "SWORD":
      cont_w_choice = True
      print("\n")
      sword_N()
    elif choice_4N == "QUIT":
      cont_w_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else:
      cont_w_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

# determines if player forest path is correct
def forest_puzzle(forest_count):
  if forest_count == 1:
    if forest_choice == [0]:
      print("\n")
      cont_correct(forest_count)
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
  elif forest_count == 2:
    if forest_choice == [0, 1]:
      print("\n")
      cont_correct(forest_count)
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
  elif forest_count == 3:
    if forest_choice == [0, 1, 0]:
      print("\n")
      cont_correct(forest_count)
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
  elif forest_count == 4:
    if forest_choice == [0, 1, 0, 1]:
      print("\n")
      cont_correct(forest_count)
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
  elif forest_count == 5:
    if forest_choice == [0, 1, 0, 1, 0]:
      print("\n")
      cont_correct(forest_count)
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
  elif forest_count == 6:
    if forest_choice == [0, 1, 0, 1, 0, 0]:
      print("\n")
      cont_correct(forest_count)
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
  elif forest_count == 7:
    if forest_choice == [0, 1, 0, 1, 0, 0, 0]:
      print("\n")
      cont_correct(forest_count)
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
  elif forest_count == 8:
    if forest_choice == [0, 1, 0, 1, 0, 0, 0, 1]:
      print("\n")
      ending_excalibur()
    else:
      forest_count = 0
      forest_choice.clear()
      print("\n")
      cont_wrong()
      
# correct path choice, 2 options and quit
def cont_correct(forest_count):
  cont_c_choice = False
  while cont_c_choice == False:
    print("You continue down the path, further into the forest. It eventually splits into one path leading left and one path leading right. The dense forest surrounds each path identically.")
    choice_3aN = input("(Left, Right, Quit) ")
    choice_3aN = choice_3aN.upper()
    if choice_3aN == "LEFT":
      cont_c_choice = True
      forest_choice.append(0)
      forest_count = forest_count + 1
      forest_puzzle(forest_count)
    elif choice_3aN == "RIGHT":
      cont_c_choice = True
      forest_choice.append(1)
      forest_count = forest_count + 1
      forest_puzzle(forest_count)
    elif choice_3aN == "QUIT":
      cont_c_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else:
      cont_c_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

# pull sword choice, 1 choice and quit
def sword_N():
  sword_n_choice = False
  while sword_n_choice == False:
    print("You grip the hilt and pull with all your might, but the blade refuses to budge in the slightest. ")
    choice_3bN = input("(Continue, Quit) ")
    choice_3bN = choice_3bN.upper()
    if choice_3bN == "CONTINUE":
      sword_n_choice = True
      print("\n")
      cont_correct(forest_count)
    elif choice_3bN == "QUIT":
      sword_n_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else:
      sword_n_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

# north choice, two options and quit
def north():
  north_choice = False
  while north_choice == False:
    print("You proceed forward and head North into the forest. After what seems like hours of travel, you find the path interrupted by a large stone. A large sword protrudes from the stone. You halt by the stone and dismount, feeling almost as if the sword itself is calling to you. Upon closer inspection, you find an engraving:")
    print("< > < > < < < >")
    print("You may continue down the path or attempt to pull the blade out. Or perhaps there is another way to move forward?")
    choice_2N = input("(Continue, Sword, Quit) ")
    choice_2N = choice_2N.upper()
    if choice_2N == "CONTINUE":
      north_choice = True
      print("\n")
      cont_correct(forest_count)
    elif choice_2N == "SWORD":
      north_choice = True
      print("\n")
      sword_N()
    elif choice_2N == "QUIT":
      north_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else:
      north_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

      
# judgement ending
def ending_kept():
  print("You decide to keep the ring. After spending your final day among the village people, you return to the castle. The green knight awaits. You close your eyes and harden your nerves as he raises his axe. You close your eyes as he raises his axe. The woman's ring suddenly feels heavy in your pocket and begins to burn bright. But there is sudden darkness as the knight brings the axe down…")
  print("ENDING: Judgement of the Green Knight")
  print("\n")
  start()

# gift ending
def ending_returned():
  print("\n")
  print("You show the woman the ring and she embraces you in tears. After spending your final day among the village people, you return to the castle. The green knight awaits. You accept your fate. You close your eyes and harden your nerves as he raises his axe. The knight brings his green axe down, but you open your eyes to see the axe pass through you without any harm. He smiles, and fades away but the green axe remains. It falls to the ground, splitting the stone floor beneath…")
  print("\n")
  print("   /`--[]--'\  ")
  print("  |    ||    | ")
  print("   \.--||--./  ")
  print("       ||      ")
  print("       ||      ")
  print("       ||      ")
  print("       ()      ")
  print("\n") 
  print("ENDING: Gift of the Green Knight")
  print("\n")
  start()

# accept choice, 2 options and quit
def accept():
  accept_choice = False
  while accept_choice == False:
    print("You accept. Taking a nearby sword from the wall, you strike his neck and behead the green knight. However, you watch as his head soon reattaches itself to his body. The green knight declares that he will return. You leave the castle, coming to terms with your eventual fate, and travel to a nearby village ahead. Along the way, you find a luminous ring on the ground. Perhaps a valuable relic? You pocket it. Finders keepers. But you later pass by a troubled woman in the village, asking if anyone has seen her lost ring. Do you return the ring?")
    choice_3E = input("(Return, Keep, Quit) ")
    choice_3E = choice_3E.upper()
    if choice_3E == "RETURN":
      accept_choice = True
      print("\n")
      ending_returned()
    elif choice_3E == "KEEP":
      accept_choice = True
      print("\n")
      ending_kept()
    elif choice_3E == "QUIT":
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else:
      accept_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

# lame ending
def ending_decline():
  print("You decline. Boring. The green knight shrugs. You leave the decrepit castle and move on with your life and never take any risks… ")
  print("ENDING: Lameeee")
  print("\n")
  start()

# east choice, two options and quit
def east():
  east_choice = False
  while east_choice == False:
    print("You turn right and proceed East toward a derelict castle in the distance. Inside the stronghold, a large knight in green looms over you. He declares that if you are able to defeat him in one blow, he will bestow upon you his green axe. If you fail, he will return after a day’s time to deal to you the same blow. Do you accept the challenge?")
    choice_2E = input("(Accept, Decline, Quit) ")
    choice_2E = choice_2E.upper()
    if choice_2E == "ACCEPT":
      east_choice = True
      print("\n")
      accept()
    elif choice_2E == "DECLINE":
      east_choice = True
      print("\n")
      ending_decline()
    elif choice_2E == "QUIT":
      east_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else: 
      east_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

# holy grail ending
def ending_sword():
  print("\n")
  print("You seize the rusty sword. Despite its age, you make a cut at the not yet fully-formed skeleton and scatter the bones. They did not seem to feel like reforming again after that. Making your way around the luxurious chalices, you opt for the humble wooden cup hidden among them. Finding a basin of water nearby, you fill and take a sip from the cup, feeling yourself rejuvenated…")
  print("\n")
  print("   _____  ")
  print("  /`````\ ")
  print("  \=====/ ")
  print("   `-.-'  ")
  print("     |    ")
  print("   __|__  ")
  print("\n")
  print("ENDING: Holy Grail")
  print("\n")
  start()

# fallen ending
def ending_shield():
  print("You seize the old shield. It is covered with mold and as the skeleton manages to completely form, you realize your mistake. The skeleton jabs at you with its sword. You hold up the shield to block but the sword pierces through the weak and molded wood. You fall to the ground…")
  print("ENDING: Fallen")
  print("\n")
  start()

# right passage choice, two options and quit
def right_passage():
  right_passage_choice = False
  while right_passage_choice == False:
    print("You head down the right passage. After a long while, you see a light ahead. Reaching the end of the tunnel, it opens up into a large cavern. Numerous chalices of various designs litter the chamber, almost all bejeweled and gleaming. However, lying on the ground you spot the skeleton of a previous explorer, accompanied by a rusted sword and old wooden shield. A golden chalice lay beside the body as well. However, the bones of the skeleton begin to rise and you sense the need for something to protect yourself. Do you grab the sword or shield?")
    choice_3W = input("(Sword, Shield, Quit) ")
    choice_3W = choice_3W.upper()
    if choice_3W == "SWORD":
      right_passage_choice = True
      print("\n")
      ending_sword()
    elif choice_3W == "SHIELD":
      right_passage_choice = True
      print("\n")
      ending_shield()
    elif choice_3W == "QUIT":
      right_passage_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else: 
      right_passage_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

# labyrinth ending
def ending_left_passage():
  print("You head down the left passage and are met by a fork in the tunnel. Choosing at random, you continue and are continuously met by fork after fork. After what seems like hours, you are surrounded by darkness. You cannot tell where you are, unable to retrace your path…")
  print("ENDING: Labyrinth")
  print("\n")
  start()

# west choice, two options and quit
def west():
  west_choice = False
  while west_choice == False:
    print("You turn left and proceed West toward a distant cave. Several warnings are scattered across the entrance walls and your horse becomes skittish. Regardless, you decide to dismount and press forward into the dark tunnel. But the tunnel eventually splits into two passages. Tossing stones down each tunnel, you soon hear the stone hit a wall in the left passage. You hear nothing from the right passage. Which do you enter?")
    choice_2W = input("(Left, Right, Quit) ")
    choice_2W = choice_2W.upper()
    if choice_2W == "LEFT":
      west_choice = True
      print("\n")
      ending_left_passage()
    elif choice_2W == "RIGHT":
      west_choice = True
      print("\n")
      right_passage()
    elif choice_2W == "QUIT":
      west_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else: 
      west_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")



# beginning, three options and quit
def begin():
  first_choice = False
  while first_choice == False:
    print("You slow your horse to a full stop as you come to a fork in the path. Your objective? To retrieve Arthurian relics. But which path will you follow?")
    choice_1 = input("(North, East, West, Quit) ")
    choice_1 = choice_1.upper()
    if choice_1 == "NORTH":
      first_choice = True
      print("\n")
      north()
    elif choice_1 == "EAST":
      first_choice = True
      print("\n")
      east()
    elif choice_1 == "WEST":
      first_choice = True
      print("\n")
      west()
    elif choice_1 == "QUIT":
      first_choice = True
      print("\n")
      print("EXITING CURRENT GAME...")
      print("\n")
      start()
    else:
      first_choice = False
      print("INVALID INPUT CHOICE")
      print("\n")

# start screen after quit
def start():
  start = False
  while start == False:
    print("[PYTHON: Choose Your Own Adventure]")
    game_start = input("START NEW GAME? (Start)(Quit)")
    game_start = game_start.upper()
    if game_start == "START":
      start = True
      print("\n")
      begin()
    elif game_start == "QUIT":
      print("\nThe journey forward is left untravelled.\n")
      exit()
    else:
      start = False
      print("INVALID INPUT CHOICE")
      print("\n")

# initial start menu to begin story 
start_screen = False
while start_screen == False:
  print("\n[PYTHON: Choose Your Own Adventure]")
  game_start = input("START NEW GAME? (Start)(Quit) ")
  game_start = game_start.upper()
  if game_start == "START":
    start_screen = True
    game = True
    print("\n")
    begin()
  elif game_start == "QUIT":
    print("\nThe journey forward is left untravelled.\n")
    exit()
  else:
    start_screen = False
    print("INVALID INPUT CHOICE")
    print("\n")
