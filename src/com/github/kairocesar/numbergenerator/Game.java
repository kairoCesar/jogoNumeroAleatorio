package com.github.kairocesar.numbergenerator;

import com.github.kairocesar.numbergenerator.levels.*;
import com.github.kairocesar.numbergenerator.exceptions.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    static int choice;

    static public void play() {
        showLevelsMenu();
        selectLevelObject();
    }

    static private void selectLevelObject() {
        ArrayList<Levels> levels = new ArrayList<Levels>();
        levels.add(new Easy());
        levels.add(new Middle());
        levels.add(new Hard());

        while (true) {
            try {
                choice = chooseDifficultyLevel();
                levels.get(choice).play();
                break;
            } catch (InvalidValueException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static private void showLevelsMenu() {
        System.out.println("Bem-vindo ao jogo! =)");
        System.out.println();
        System.out.println("Níveis de dificuldade");
        System.out.printf("1. Fácil (Se você for lesado demais)%n" +
                "2. Médio (Se você for lesado, mas nem tanto)%n" +
                "3. Difícil (Se você for brabo(a) mesmo)%n");
    }

    static private int chooseDifficultyLevel() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Escolha (1, 2 ou 3): ");
            setChoice(input.nextInt());
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidValueException("Digite um valor numérico!");
        }

        return choice;
    }

    static private void setChoice(int choice) {
        while (choice > 3) {
            throw new InvalidValueException("Digite um número de 1 a 3!");
        }
        Game.choice = choice - 1;
    }
}
