package com.d0rj;


public class TestMovableRectangle {

    public static void main(String[] args) {
        var rect = new MovableRectangle(
                new MovablePoint(1, 1, 1, 1),
                new MovablePoint(4, 4, 1, 1));

        System.out.println(rect);

        rect.moveRight();
        rect.moveDown();

        System.out.println(rect);
    }
}
