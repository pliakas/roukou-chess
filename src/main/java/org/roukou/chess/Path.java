package org.roukou.chess;

import java.util.*;
import java.util.stream.Collectors;

public class Path
{
    private Position startPosition;
    private Position endPosition;
    private Actor actor;

    public Path( Position startPosition, Position endPosition, Actor pieceType )
    {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.actor = pieceType;
    }

    public String findPath( int numberOfMoves )
    {
        HashMap<Position, Position> parentPosition = new HashMap<>();
        Queue<Position> positionQueue = new LinkedList<>();

        //start
        parentPosition.put( startPosition, null );
        positionQueue.add( startPosition );

        //find all possible paths
        while( Objects.nonNull(positionQueue.peek()) )
        {
            Position currentPostion = positionQueue.poll();

            if( currentPostion.equals( endPosition ) )
            {
                break;
            }

           actor.availableMoves( currentPostion ).forEach(
                adjacentPosition -> {
                    if( !parentPosition.containsKey( adjacentPosition ) )
                    {
                        parentPosition.put( adjacentPosition, currentPostion );
                        positionQueue.add( adjacentPosition );
                    }
                }
            );
        }

        //find shortest path
        Position currentPosition = endPosition;
        Deque<Position> shortestPath = new ArrayDeque<>();

        while( Objects.nonNull( parentPosition.get( currentPosition ) ) )
        {
            shortestPath.addFirst( currentPosition );
            currentPosition = parentPosition.get( currentPosition );
        }

        shortestPath.addFirst( startPosition );

        if( shortestPath.size() <= numberOfMoves + 1 )
        {
            return shortestPath.stream()
                .map( Position::toString )
                .collect( Collectors.joining( "->")  );
        }
        else
        {
            return "No solution found!";
        }
    }

}
