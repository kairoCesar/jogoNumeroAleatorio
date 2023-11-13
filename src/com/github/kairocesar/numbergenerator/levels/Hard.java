package com.github.kairocesar.numbergenerator.levels;

import java.util.Random;

public class Hard extends Levels {

    private int randomNumber;
    private int userInputNumber;
    private int attemptCounter;

    public void play() {
        printMenu();
        randomNumber = generateNumber();
        compareValues(randomNumber);

        if (userInputNumber != randomNumber) {
            System.out.println("Você esgotou o número de tentativas, mas não desanima com a derrota, " +
                    "tem gente que perde no nível fácil! XD ");
            System.out.printf("O número que eu tinha gerado era o %d", randomNumber);
        }
    }

    private void compareValues(int randomNumber) {
        do {
            userInputNumber = collectUserinput();
            System.out.println();
            checkUserInput(userInputNumber, randomNumber);
            attemptCounter++;
            if (userInputNumber != randomNumber && attemptCounter != 0) {
                System.out.printf("Você tem %d tentativas restantes. %n", 5 - attemptCounter);
            }
        } while (userInputNumber != randomNumber && attemptCounter < 5);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Eita, você tá no nível difícil, brabo! aqui você só tem 5 tentativas," +
                "e também não te darei nenhuma dica, só vou rir da sua cara. XD");
        System.out.println("Eu vou gerar um número aleatório de 0 a 450 " +
                "e o seu objetivo é advinhar qual número eu gerei.");
        System.out.println("Mas cuidado, você só tem 5 tentativas. XD");
    }

    private int generateNumber() {
        Random random = new Random();
        System.out.println("Número Gerado!");

        return random.nextInt(450);
    }

    private void checkUserInput(int userInputNumber, int numberGenerated) {
        int difference = Math.abs(userInputNumber - numberGenerated);
        if (difference == 0) {
            System.out.println("Caramba!!! Parabéns! Você acertou! =D");
        } else if (difference < 2) {
            System.out.println("Muuito perto! Passou raspando! =O");
        } else if (difference < 60) {
            System.out.println("KKKKKKKKKKK desiste");
        } else if (difference < 100) {
            System.out.println("Ah não... KKKKKKKK lesado(a) demais =&");
        } else if (difference < 150) {
            System.out.println("KKKKKKKKKKKKKK vai fazer outra coisa, mano(a)!");
        } else if (difference < 250) {
            System.out.println("Vou sumir aqui, tu é ruim demais.");
        } else if (difference < 350) {
            System.out.println("Por que você ainda tá tentando mano(a)?");
        } else {
            System.out.println("Só ladeira abaixo...");
        }
    }

}


