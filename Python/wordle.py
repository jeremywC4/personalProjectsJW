import random

from colorama import init, Fore, Back, Style
init()

# variables for amount of guesses left, the guess input string, list of possible words, and list for guess input
guess_count = 0
guess_input = ""
wordle_bank = ["ADMIT", "BASIC", "BEBOP", "DEPTH", "DEVIL", "DRESS", "EIGHT", "ERROR", "FORUM", "INDEX", "MATCH", "QUEUE", "SHANK", "SMOKE", "TITAN", "TOAST", "URBAN", "VIDEO", "VISIT", "YIELD"]
user_guess = []

# used to increment guess count and reset guess input
def guess_increment():
  global guess_input
  global guess_count
  guess_count += 1
  guess_input = ""

# randomizes word from bank, prompts guess input from user, determines if guessed letters are in the word and highlights accordingly, displays win if guessed correctly, displays correct word if lost
def wordle_start():   
  global guess_input
  global user_guess
  global wordle
  wordle = list(random.choice(wordle_bank))
  while guess_count < 6:
    guess_input = input("Enter Guess (5 Letters): ")
    guess_input = guess_input.upper()
    user_guess = list(guess_input)
    while len(user_guess) != 5:
      guess_input = input("Enter Guess (5 Letters): ")
      guess_input = guess_input.upper()
      user_guess = list(guess_input)
    for i in range(0,5):
      if user_guess[i] == wordle[i]:
        user_guess[i] = Back.GREEN + user_guess[i] + Back.RESET
      elif user_guess[i] in wordle:
        user_guess[i] = Back.YELLOW + user_guess[i] + Back.RESET     
    print(*user_guess, sep = "")
    if list(guess_input) == wordle:
      print("\n")
      print("CONGLATURATION!")
      print("\n")
      break
    guess_increment()
  if guess_count == 6:
    print("\n")
    print("OUT OF GUESSES")
    print("Word: ", end = " ")
    print(*wordle, sep = "")
    print("\n")

# start menu, prompts new game option after each game until user ends program
start = False
print("\n[W O R D L E]")
while start == False:
  new_game = input("START NEW GAME? (Start, End) ")
  new_game = new_game.upper()
  if new_game == "START":
    guess_count = 0
    guess_input = ""
    user_guess = []
    print("\n")
    wordle_start()
  elif new_game == "END":
    start = True
    print("\n")
    print('Goodbye, Wordle!')
  else:
    start = False
    print("ENTER VALID INPUT")
    print("\n")
