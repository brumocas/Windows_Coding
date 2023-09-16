import time
import webbrowser
import pyautogui
import random

def play_rick_roll():
    # Open the web browser to play the Rick Roll video
    webbrowser.open("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
    time.sleep(5)  # Wait for the page to load

    # Maximize the browser window (adjust coordinates based on your screen resolution)
    pyautogui.hotkey("win", "down")
    time.sleep(2)

    # Move the mouse to close any pop-ups (adjust coordinates based on your screen resolution)
    pyautogui.moveTo(100, 100)

    """
    while True:
        pyautogui.moveTo(random.randint(1,1000), random.randint(1,1000))
    """


if __name__ == "__main__":
    play_rick_roll()