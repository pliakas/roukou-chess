package org.roukou.chess;

import java.util.List;

public interface Actor
{
    List<Position> adjacentPositions( Position position );
}
