package org.roukou.chess;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Actor
{
    @Override
    public List<Position> adjacentPositions( Position position )
    {
        List<Position> positions = new ArrayList<>();
        int[] availableMoves = { -2, -1, 1, 2 };

        for( int xAxis : availableMoves )
        {
            for( int yAxis : availableMoves )
            {
                if( Math.abs( xAxis ) != Math.abs( yAxis ) )
                {
                    if( Helper.isValidCoordinate( position.getxCoord() + xAxis, position.getyCoord() + yAxis ) )
                    {
                        positions.add( new Position.Builder().with( coordinates -> {
                                coordinates.xCoord = position.getxCoord() + xAxis;
                                coordinates.yCoord = position.getyCoord() + yAxis;

                            } ).build() );
                    }
                }
            }
        }

        return positions;
    }
}
