package Model;
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

