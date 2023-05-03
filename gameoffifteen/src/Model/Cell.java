package Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cell {
    private Tile _tile;

    //  Позиция ячейки
    private final int _row;
    private final int _col;

    public int getRow() {
        return _row;
    }
    public int getCol() {
        return _col;
    }

    public Cell(int row, int col) {
        this._row = row;
        this._col = col;
    }
    // ------------------------------- Соседи ---------------------------------
    private final Map<Direction, Cell> _neighbors = new HashMap<>();

    public Cell neighbor(Direction direct) {

        if(_neighbors.containsKey(direct)) {
            return _neighbors.get(direct);
        }

        return null;
    }
    public Map<Direction, Cell> neighbors() {
        return Collections.unmodifiableMap(_neighbors);
    }

    public boolean hasEmptyNeighbor(){
        boolean hasEmptyNei = false;
        if(_neighbors.get(Direction.north()).isEmpty())
            hasEmptyNei = true;
            //Cell emptyNeighbor = _neighbors.get(Direction.north();
            else if(_neighbors.get(Direction.south()).isEmpty())
            hasEmptyNei = true;
            else if(_neighbors.get(Direction.east()).isEmpty())
            hasEmptyNei = true;
            else if(_neighbors.get(Direction.west()).isEmpty())
            hasEmptyNei = true;
        return hasEmptyNei;
    }
    public Cell getEmptyNeighbor(){
        if(_neighbors.get(Direction.north()).isEmpty())
            return neighbor(Direction.north());
        else if(_neighbors.get(Direction.south()).isEmpty())
            return neighbor(Direction.south());
        else if(_neighbors.get(Direction.east()).isEmpty())
            return neighbor(Direction.east());
        else if(_neighbors.get(Direction.west()).isEmpty())
            return neighbor(Direction.west());
        return null;
    }
    void setNeighbor(Direction direct, Cell neighbor) {
        if(neighbor != this && !isNeighbor(neighbor)) {
            _neighbors.put(direct, neighbor);
            neighbor.setNeighbor(direct.opposite(), this);
        }
    }

    public boolean isNeighbor(Cell other) {
        return _neighbors.containsValue(other);
    }

    // ------------------------------- Владение юнитом ---------------------------------
    public Tile getTile() {
        return _tile;
    }
    public void setTile(Tile tile) {
        this._tile = tile;
    }
    public boolean isEmpty() {
        return _tile == null;
    }

    public void extractTile(Cell newOwner){
        if( !isEmpty() ) {     // !!!! У владельца НЕ может быть двух юнитов
            _tile.removeOwner();
        }
        Tile removedUnit = _tile;
        _tile = null;
        newOwner.setTile(removedUnit);
        removedUnit.setOwner(newOwner);
    }
}

