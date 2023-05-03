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

    public Tile extractTile(){
        if( !isEmpty() ) {     // !!!! У владельца НЕ может быть двух юнитов
            _tile.removeOwner();
        }

        Tile removedUnit = _tile;
        _tile = null;

        return removedUnit;
    }



}

