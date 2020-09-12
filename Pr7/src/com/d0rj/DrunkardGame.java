package com.d0rj;


public class DrunkardGame {

    private CardDeck<DrunkardCard> firstCards;
    private CardDeck<DrunkardCard> secondCards;
    private int turns = 0;
    private int winner = 0;


    public DrunkardGame() {
        firstCards = new CardDeck<>(
                new DrunkardCard[]{
                        new DrunkardCard(1, "7"),
                        new DrunkardCard(3, "9"),
                        new DrunkardCard(5, "В"),
                        new DrunkardCard(7, "К"),
                        new DrunkardCard(9, "J"),
                }
        );
        secondCards = new CardDeck<>(
                new DrunkardCard[]{
                        new DrunkardCard(2, "8"),
                        new DrunkardCard(4, "10"),
                        new DrunkardCard(6, "Д"),
                        new DrunkardCard(8, "Т"),
                        new DrunkardCard(0, "6"),
                }
        );
    }


    public DrunkardGame(CardDeck<DrunkardCard> deck1, CardDeck<DrunkardCard> deck2) {
        firstCards = deck1;
        secondCards = deck2;
    }


    public int getTurns() {
        return turns;
    }


    public int getWinner() {
        return winner;
    }


    public boolean nextTurn() {
        ++turns;

        var firstCard = firstCards.getTopCard();
        var secondCard = secondCards.getTopCard();

        if (firstCard.compareTo(secondCard) < 0) {
            secondCards.addToBottom(firstCard);
            secondCards.addToBottom(secondCard);
        }
        else if (firstCard.compareTo(secondCard) > 0) {
            firstCards.addToBottom(firstCard);
            firstCards.addToBottom(secondCard);
        }
        else {
            secondCards.addToBottom(secondCard);
            firstCards.addToBottom(firstCard);
        }

        if (firstCards.size() == 0) {
            winner = 2;
            return false;
        }
        if (secondCards.size() == 0) {
            winner = 1;
            return false;
        }

        if (turns == 106)
            return false;

        return true;
    }
}
