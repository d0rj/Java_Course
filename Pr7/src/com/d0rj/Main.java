package com.d0rj;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        var firstString = input.nextLine().split(" ");
        int[] firstWeights = new int[firstString.length];
        for (int i = 0; i < firstString.length; ++i)
            firstWeights[i] = Integer.parseInt(firstString[i]);

        var secondString = input.nextLine().split(" ");
        int[] secondWeights = new int[secondString.length];
        for (int i = 0; i < secondString.length; ++i)
            secondWeights[i] = Integer.parseInt(secondString[i]);

        var firstCards = new DrunkardCard[firstWeights.length];
        for (int i = 0; i < firstWeights.length; ++i)
            firstCards[i] = new DrunkardCard(firstWeights[i], Integer.toString(firstWeights[i]));

        var secondCards = new DrunkardCard[secondWeights.length];
        for (int i = 0; i < secondWeights.length; ++i)
            secondCards[i] = new DrunkardCard(secondWeights[i], Integer.toString(secondWeights[i]));

        var game = new DrunkardGame(new CardDeck<>(firstCards), new CardDeck<>(secondCards));

        while (game.nextTurn());

        int winnerId = game.getWinner();
        String winner = switch (winnerId) {
            case 1 -> "first " + game.getTurns();
            case 2 -> "second " + game.getTurns();
            default -> "botva";
        };

        System.out.println(winner);
    }
}
