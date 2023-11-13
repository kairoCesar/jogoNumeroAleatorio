package com.github.kairocesar.numbergenerator.levels;

import com.github.kairocesar.numbergenerator.exceptions.InvalidValueException;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Levels {
    private int userInputNumber;

    public abstract void play();

    public int collectUserinput() {
        while (true) {
            try {
                treatException();
                return userInputNumber;
            } catch (InvalidValueException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int treatException() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Insira o número que eu gerei: ");
                userInputNumber = userInput.nextInt();
                return userInputNumber;
            } catch (InputMismatchException e) {
                throw new InvalidValueException("Digite um valor numérico!");
            }
        }
    }

    public int getUserInputNumber() {
        return userInputNumber;
    }
}
