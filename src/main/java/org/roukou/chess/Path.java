package org.roukou.chess;

import java.util.*;
import java.util.stream.Collectors;

public class Path
{
    private Position start;
    private Position destination;
    private Actor actor;

    public Path( Position start, Position destination, Actor actor )
    {
        this.start = start;
        this.destination = destination;
        this.actor = actor;
    }

    public String findPath( int numberOfMoves )
    {
        HashMap<Position, Position> nodes = new HashMap<>();
        Queue<Position> queue = new LinkedList<>();

        //start
        nodes.put( start, null );
        queue.add( start );

        //find all possible paths
        while( Objects.nonNull(queue.peek()) )
        {
            Position current = queue.poll();

            if( current.equals( destination ) )
            {
                break;
            }

           actor.adjacentPositions( current ).forEach(
                next -> {
                    if( !nodes.containsKey( next ) )
                    {
                        nodes.put( next, current );
                        queue.add( next );
                    }
                }
            );
        }

        //find shortest path
        Position currentPosition = destination;
        Deque<Position> shortestPath = new ArrayDeque<>();

        while( Objects.nonNull( nodes.get( currentPosition ) ) )
        {
            shortestPath.addFirst( currentPosition );
            currentPosition = nodes.get( currentPosition );
        }

        shortestPath.addFirst( start );

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
