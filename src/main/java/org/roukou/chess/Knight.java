package org.roukou.chess;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Actor
{
    @Override
    public List<Position> availableMoves( Position position )
    {
        List<Position> positions = new ArrayList<>();
        int[] moves = { -2, -1, 1, 2 };

        for( int xMove : moves )
        {
            for( int yMove : moves )
            {
                if( Math.abs( xMove ) != Math.abs( yMove ) )
                {
                    if( Helper.isValidCoordinate( position.getxCoord() + xMove, position.getyCoord() + yMove ) )
                    {
                        positions.add( new Position.Builder().with( coordinates -> {
                                coordinates.xCoord = position.getxCoord() + xMove;
                                coordinates.yCoord = position.getyCoord() + yMove;

                            } ).build() );
                    }
                }
            }
        }

        return positions;
    }
}
