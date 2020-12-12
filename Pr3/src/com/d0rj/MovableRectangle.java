package com.d0rj;


public class MovableRectangle implements Movable {

    private MovablePoint topLeft;
    private MovablePoint bottomRight;


    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }


    @Override
    public String toString() {
        return "MovableRectangle {\n" +
                "\ttopLeft = " + topLeft +
                ", \n\tbottomRight = " + bottomRight +
                "\n}";
    }


    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }
}
