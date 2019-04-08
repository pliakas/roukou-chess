package org.roukou.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest
{

    @Test
    @DisplayName( "Find available Knight moves bases on its current position" )
    void testActorAvailableMoves()
    {
        Knight knight = new Knight();

        // A1 -> C2, B3
        var result = knight.adjacentPositions( Helper.convertStringCoordinateToPosition( "A1"  ) );
        assertTrue( result.stream().anyMatch( entry -> entry.toString().equalsIgnoreCase( "C2" )) );
        assertTrue( result.stream().anyMatch( entry -> entry.toString().equalsIgnoreCase( "B3" )) );

        // E1 -> C2, D3, F3, G2
        result = knight.adjacentPositions( Helper.convertStringCoordinateToPosition( "E1" ) );
        assertTrue( result.stream().anyMatch( entry -> entry.toString().equalsIgnoreCase( "C2" )) );
        assertTrue( result.stream().anyMatch( entry -> entry.toString().equalsIgnoreCase( "D3" )) );
        assertTrue( result.stream().anyMatch( entry -> entry.toString().equalsIgnoreCase( "F3" )) );
        assertTrue( result.stream().anyMatch( entry -> entry.toString().equalsIgnoreCase( "G2" )) );
    }
}
