import time
import pyautogui

def automate_search(query):
    # Open the web browser (adjust the coordinates based on your screen resolution)
    pyautogui.press("win")
    time.sleep(1)
    pyautogui.write("chrome")
    pyautogui.press("enter")
    time.sleep(1)

    # Navigate to the search engine
    pyautogui.write("https://www.google.com")
    pyautogui.press("enter")
    time.sleep(5
    )

    # Perform the search
    pyautogui.write(query)
    pyautogui.press("enter")
    time.sleep(1)

if __name__ == "__main__":
    #search_query = input("Enter the search query: ")
    search_query = 'https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley'
    automate_search(search_query)
    print("Search automation completed.")