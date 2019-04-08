package org.roukou.chess;

public enum Board
{
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private int coordinate;

    Board(final int coordinate)
    {
        this.coordinate = coordinate;
    }

    public int getValue()
    {
        return this.coordinate;
    }
}
