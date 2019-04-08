package org.roukou.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest
{

    @Test
    @DisplayName( "Test Coordinate Conversion from integer to letter (based on AN)" )
    void testConvertCoordinates()
    {
        //success
        assertEquals( Board.D, Helper.convertCoordinates( 4 ));

        //failure
        final IllegalArgumentException expectedException = assertThrows(
            IllegalArgumentException.class, () -> Helper.convertCoordinates( 9 )
        );
        assertEquals( "Invalid coordinate.", expectedException.getMessage() );
    }

    @Test
    @DisplayName( "Validate Coordinates" )
    void testIsValidCoordinates()
    {
        //success
        assertTrue( Helper.isValidCoordinate( 4, 7 ) );
        assertTrue( Helper.isValidCoordinate( 8, 1 ) );

        //failure
        assertFalse( Helper.isValidCoordinate( 9, 9 ) );
        assertFalse( Helper.isValidCoordinate( -1, 4 ) );
        assertFalse( Helper.isValidCoordinate( 10, 7 ) );
    }

    @Test
    @DisplayName( "Convert string coordinate to position node coordinates" )
    void testConvertStringToPosition()
    {
        //success
        var expected = new Position.Builder().with( coordinates -> {
            coordinates.xCoord = 6;
            coordinates.yCoord = 4;
        } ).build();

        assertEquals( expected.toString(), Helper.convertStringCoordinateToPosition( "f4" ).toString() );
    }
}

