package com.github.kairocesar.numbergenerator.levels;

import java.util.Random;

public class Easy extends Levels {

    private int randomNumber;
    private int userInputNumber;
    private int attemptCounter;

    public void play() {
        printMenu();
        randomNumber = generateNumber();
        compareValues(randomNumber);

        if (userInputNumber != randomNumber) {
            System.out.println("Você esgotou o número de tentativas, mas não desanima com a derrota! =b ");
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
                System.out.printf("Você tem %d tentativas restantes. %n", 10 - attemptCounter);
            }
        } while (userInputNumber != randomNumber && attemptCounter < 10);
    }


    private void printMenu() {
        System.out.println();
        System.out.println("Você tá no nível fácil. Parece que alguém ainda usa bicicleta com rodinha, né?");
        System.out.println("Eu vou gerar um número aleatório de 0 a 100 " +
                "e o seu objetivo é advinhar qual número eu gerei.");
        System.out.println("Mas cuidado, você só tem 10 tentativas. XD");

    }

    private int generateNumber() {
        Random random = new Random();
        System.out.println("Número Gerado!");

        return random.nextInt(100);
    }

    private void checkUserInput(int userInputNumber, int numberGenerated) {
        int difference = Math.abs(userInputNumber - numberGenerated);
        if (difference == 0) {
            System.out.println("Parabéns! Você acertou! =D");
        } else if (difference < 2) {
            System.out.println("Muuito perto! Passou raspando! =O");
        } else if (difference < 5) {
            System.out.println("Tá perto, não desista! =D");
        } else if (difference < 10) {
            System.out.println("Tá chegando, continue tentando! =D");
        } else if (difference < 15) {
            System.out.println("Você não tá longe! =)");
        } else if (difference < 20) {
            System.out.println("Tá esquentando! =3");
        } else if (difference < 30) {
            System.out.println("Errooou! Tenta de novo. =/");
        } else if (difference < 40) {
            System.out.println("Xii, passou longe! =&");
        } else if (difference < 50) {
            System.out.println("Errou feio! Achei que você era inteligente. =C");
        } else if (difference < 70) {
            System.out.println("Errou feio demais! Acho que você não vai conseguir...");
        } else if (difference < 80) {
            System.out.println("Errou! Desiste logo!");
        } else {
            System.out.println("Só ladeira abaixo...");
        }
    }
}

