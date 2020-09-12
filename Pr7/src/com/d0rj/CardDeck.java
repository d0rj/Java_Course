package com.d0rj;

import com.d0rj.interfaces.ICard;

import java.util.*;


public class CardDeck<T extends ICard> {

    private Deque<T> cards;


    public CardDeck() {
        cards = new ArrayDeque<>();
    }


    public CardDeck(int size) {
        cards = new ArrayDeque<>(size);
    }


    public CardDeck(T[] elements) {
        cards = new ArrayDeque<>(elements.length);
        addAll(elements);
    }


    private void addAll(Object[] elements) {
        for (var elem : elements)
            cards.add((T)elem);
    }


    public T seeTopCard() {
        return cards.peekFirst();
    }


    public T seeBottomCard() {
        return cards.peekLast();
    }


    public T getTopCard() {
        return cards.pollFirst();
    }


    public T getBottomCard() {
        return cards.pollLast();
    }


    public void addToBottom(T card) {
        cards.addLast(card);
    }


    public void addToTop(T card) {
        cards.addFirst(card);
    }


    public void shuffle() {
        var elements = cards.toArray();
        var list = new ArrayList<Object>(Arrays.asList(elements));
        Collections.shuffle(list);
        cards = new ArrayDeque<>();

        for (var elem : list)
            cards.add((T)elem);
    }


    public int size() {
        return cards.size();
    }
}
