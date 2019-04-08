package org.roukou.chess;

import java.util.Arrays;

public final class Helper
{
    private Helper() {}

    public static final int CHESS_BOARD_SIZE = 8;

    public static Board convertCoordinates( int coord )
    {
        return Arrays.stream( Board.values() ).filter( entry -> entry.getValue() == coord ).findAny()
            .orElseThrow( () -> new IllegalArgumentException( "Invalid coordinate." ) );
    }

    public static boolean isValidCoordinate( int xCoordinate, int yCoordinate )
    {
        return xCoordinate >= 1 && xCoordinate <= CHESS_BOARD_SIZE && yCoordinate >= 1
            && yCoordinate <= CHESS_BOARD_SIZE;
    }

    public static Position convertStringCoordinateToPosition( String coordinate )
    {
        if( coordinate.length() == 2 )
        {
            var xCoord = Board.valueOf( coordinate.substring( 0, 1 ).toUpperCase() ).getValue();
            var yCoord = Integer.parseInt( coordinate.substring( 1 ) );

            return new Position.Builder().with( coordinates -> {
                coordinates.xCoord = xCoord;
                coordinates.yCoord = yCoord;
            } ).build();
        }
        else
        {
            throw new IllegalArgumentException( "Invalid Coordinates." );
        }
    }
}
