package org.roukou.chess;

public class ChessApplication
{
    public static void main( String... args )
    {
        if( args.length != 2 )
        {
            System.out.println( "Must inlcude start position and end position and actor." );
            System.out.println( "Usage is: java ChessApplication startPos endPos actor" );
        }
        else
        {
            try
            {
                Path knightShortestPath = new Path(
                    Helper.convertStringCoordinateToPosition( args[0] ),
                    Helper.convertStringCoordinateToPosition( args[1] ), new Knight() );
                System.out.println( "Solution: " + knightShortestPath.findPath( 3) );
            }
            catch( IllegalArgumentException e )
            {
                System.out.println( e.getMessage() );
            }
        }
    }
}
