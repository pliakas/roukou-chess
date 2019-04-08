package org.roukou.chess;

import java.util.function.Consumer;

public class Position
{
    private final int xCoord;
    private final int yCoord;

    public Position( Builder builder)
    {
        this.xCoord = builder.xCoord;
        this.yCoord = builder.yCoord;
    }

    public static class Builder
    {
        int xCoord;
        int yCoord;

        public Builder with( Consumer<Builder> consumer )
        {
            consumer.accept( this );

            return this;
        }

        public Position build()
        {
            return new Position( this );
        }
    }

    public int getxCoord()
    {
        return xCoord;
    }

    public int getyCoord()
    {
        return yCoord;
    }

    @Override
    public String toString()
    {
        return Helper.convertCoordinates( this.xCoord ).name() + yCoord;
    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o )
            return true;
        if( o == null || getClass() != o.getClass() )
            return false;
        Position position = (Position) o;
        return xCoord == position.xCoord && yCoord == position.yCoord;
    }

    @Override
    public int hashCode()
    {
        return Integer.parseInt( this.xCoord + String.valueOf( this.yCoord ) );

    }
}
