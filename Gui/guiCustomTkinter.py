"""
import tkinter as tk

window = tk.Tk() # create the window
window.geometry("500x300") # resize the window

def click():
    print('Login in ...') 

txt = tk.Label(text = "Sign in" ) # create text parameter
txt.pack(padx=10, pady=10) # print the text in the window 

button = tk.Button(window ,text = "Login", command = click) # create button parameter
button.pack(padx=10, pady=10) # print the button in the window

window.mainloop()
"""

import customtkinter

customtkinter.set_appearance_mode("dark")
customtkinter.set_default_color_theme("green")

window = customtkinter.CTk()
window.geometry("500x300")


def click():
    print('Login in ...') 

txt = customtkinter.CTkLabel(window ,text = "Sign in")
txt.pack(padx=10, pady=10) 


email = customtkinter.CTkEntry(window, placeholder_text = 'Your email')
email.pack(padx=10, pady=10)

password = customtkinter.CTkEntry(window, placeholder_text = 'Your password', show = '*')
password.pack(padx=10, pady=10)

checkbox = customtkinter.CTkCheckBox(window, text = "Remember login")
checkbox.pack(padx=10, pady=10)


button = customtkinter.CTkButton(window ,text = "Login", command = click)
button.pack(padx=10, pady=10)


window.mainloop()