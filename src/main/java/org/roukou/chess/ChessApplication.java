package org.roukou.chess;

public class ChessApplication
{
    public static void main( String... args )
    {
        if( args.length != 2 )
        {
            System.out.println( "Must include start position & end position." );
            System.out.println( "Usage is: java ChessApplication E1 G7" );
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
