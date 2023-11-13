package com.github.kairocesar.numbergenerator.levels;

import java.util.Random;

public class Middle extends Levels {

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
                System.out.printf("Você tem %d tentativas restantes. %n", 7 - attemptCounter);
            }
        } while (userInputNumber != randomNumber && attemptCounter < 7);
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Você está no nível médio, aqui você terá menos dicas " +
                "e também menos tentativas, mas não desanima não!");
        System.out.println("Eu vou gerar um número aleatório de 0 a 250 " +
                "e o seu objetivo é advinhar qual número eu gerei.");
        System.out.println("Mas cuidado, você só tem 7 tentativas. XD");
    }

    private int generateNumber() {
        Random random = new Random();
        System.out.println("Número Gerado!");
        return random.nextInt(250);
    }


    private void checkUserInput(int userInputNumber, int numberGenerated) {
        int difference = Math.abs(userInputNumber - numberGenerated);
        if (difference == 0) {
            System.out.println("Parabéns! Você acertou! =D");
        } else if (difference < 2) {
            System.out.println("Muuito perto! Passou raspando! =O");
        } else if (difference < 20) {
            System.out.println("Tá perto, não desista! =D");
        } else if (difference < 60) {
            System.out.println("Xii, tá meio longe, mas nem tanto! =&");
        } else if (difference < 80) {
            System.out.println("Agora você extrapolou, tá longe demais, mas pode piorar");
        } else if (difference < 120) {
            System.out.println("Piorou Acho que você não vai conseguir...");
        } else if (difference < 150) {
            System.out.println("Desiste logo, tá muito longe!");
        } else {
            System.out.println("Só ladeira abaixo...");
        }
    }

}

