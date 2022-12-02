import pyautogui
import time
time.sleep(5)
with open("pokemon.txt","r")as pokemones:
    for line in pokemones:
        todos = line.split(",")
        //todos.sort()
        for a in todos:
        
         pyautogui.write(a)
