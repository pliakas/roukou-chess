package org.roukou.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathTest
{
    @Test
    @DisplayName( "Find shortest path solution (Including Failed and Success Scenarios)" )
    void testFindPath()
    {
        //faulure (solution found in 4 moves - failure)
        var result = new Path(
            Helper.convertStringCoordinateToPosition( "E1" ),
            Helper.convertStringCoordinateToPosition( "A7" ), new Knight() );
        assertEquals( "No solution found!", result.findPath( 3 ) );

        //faulure (solution found in 4 moves)
        result = new Path(
            Helper.convertStringCoordinateToPosition( "E1" ),
            Helper.convertStringCoordinateToPosition( "A7" ), new Knight() );
        assertEquals( "E1->C2->A3->B5->A7", result.findPath( 4 ) );

        //success ( found in two moves)
        result = new Path(
            Helper.convertStringCoordinateToPosition( "A1" ),
            Helper.convertStringCoordinateToPosition( "C5" ),
            new Knight() );
        assertEquals( "A1->B3->C5", result.findPath( 3 ) );

        //success (solution in three moves)
        result = new Path(
            Helper.convertStringCoordinateToPosition( "A2" ),
            Helper.convertStringCoordinateToPosition( "G5" ),
            new Knight() );
        assertEquals( "A2->C3->E4->G5", result.findPath( 3 ) );
    }
}
