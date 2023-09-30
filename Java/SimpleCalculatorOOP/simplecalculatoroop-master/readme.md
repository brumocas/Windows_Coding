# Simple Calculator Java

This repository contains a code for a simple integer calcular developed with Object-Oriented Programming (OOP).
The goal is to help begginers to understand the basic of OOP implemenation in Java.

## Usage

```sh
$ java -jar .\calculatorExampleOOP.jar
```

### Tasks on IntelliJ (Windows and Linux)

1. Launch IntelliJ
2. `File | Open`
3. Navigate to the Project Directory and click`ok`
4. Build 
5- `Build | Build Module 'calculator_oop'`  (`Ctrl+F9`)
5. Run `DragonsBane`
    - `Run | Run 'calculator_oop'` (`Alt + Shift+F10`)
    -  With Debug: `Run | Debug 'calculator_oop'` (`Alt+ Shift+F9`)


To generate your .Jar file:

1. Configure Your Project Structure:

      Make sure you have set up your project's main class correctly. The main class is the entry point of your application. You can set it in the project configuration settings:

         . Go to `File | Project Structure`.
         . In the left pane, select `Project` and ensure the `Project SDK` is set to the appropriate Java SDK.
         . In the left pane, select `Project Settings | Modules`. Select your module, and in the `Main Class` field, specify the class containing the `main` method of your application.
         . Click `OK` to save your project structure changes.
   
2. Build Your Project:
   
         . Go to ´Build | Build´ Project to compile your Java code.
         . Make sure there are no compilation errors in your code before proceeding.

4. Generate a JAR File::

        . Go to `File | Project` Structure.
        . In the left pane, select `Project Settings | Artifacts`.
        . Click the `+` button to add a new artifact.
        . Select `JAR | From modules with dependencies`.
        . Choose your main module as the main class.
        . Under `JAR files from libraries`, select `Copy to the output directory and link via manifest`.
        . Click `OK` to save the artifact configuration.

5. Build the JAR File:

        . Go to `Build | Build Artifacts`.
        . Select your artifact configuration (the one you just created).
        . Choose `Build` or `Rebuild` to generate the JAR file.

6. Locate the JAR File:

        . After the build process is complete, you can find the generated JAR file in the out directory of your project, usually in a folder like `out/artifacts/your-artifact-name`.

## Support

Please contact Luís C. Santos (luissantos@fe.up.pt / luis.c.santos@inesctec.pt) if you have any questions.
