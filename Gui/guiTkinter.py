import tkinter as tk

window = tk.Tk() # create the window
window.geometry("500x300") # resize the window

def click():
    print('Login in ...') 

txt = tk.Label(text= "Sign in" ) # create text parameter
txt.pack(padx=10, pady=10) # print the text in the window 

button = tk.Button(window ,text = "Login", command = click) # create button parameter
button.pack(padx=10, pady=10) # print the button in the window

window.mainloop()