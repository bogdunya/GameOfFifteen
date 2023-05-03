package Model;
public class Tile {
    private int value;
    private Cell _owner;

    public Tile(int value) {
        this.value = value;
    }

    public void move() {
    if(_owner.hasEmptyNeighbor()){
        Cell emptyNeigh = _owner.getEmptyNeighbor();
        _owner.extractTile(emptyNeigh);
    }

//        if (_owner != null) {
//            _owner.setTile(null);
//        }
//        if (cell != null && cell.getTile() == null) {
//            _owner = cell;
//            cell.setTile(this);
//        }
    }
    public int getValue() {
        return value;
    }

    public Cell getOwner() {
        return _owner;
    }

    public void setOwner(Cell cell) {
        this._owner = cell;
    }

    void removeOwner() {
        _owner = null;
    }
}


