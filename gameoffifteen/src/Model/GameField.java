package Model;
import java.util.*;

public class GameField{

    // ---------------------- Размеры -----------------------------

    private final int _width;
    private final int _height;

    public int width() {
        return _width;
    }

    public int height() {
        return _height;
    }
    private final Cell[][] _cells = new Cell[4][4];
    private final List<Tile> _tiles =new ArrayList<>(15);
    //private final HashMap<CellPosition, Cell> _cells = new HashMap<>();
    // ---------------------------- Порождение ---------------------

    public GameField(int height, int width) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        _width = width;
        _height = height;

    }

    public void buildField() {

        // Создаем ячейки
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
                //  CellPosition pos = new CellPosition(row, col);
                _cells[row][col] = new Cell(row, col);
            }
        }

        // Связываем ячейки
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {

                Cell cell = new Cell(row, col);

                if (height() > 1 && row < height() - 1) {
                    cell.setNeighbor(Direction.south(), cell = new Cell(row + 1, col));
                }
                if (row > 0) {
                    cell.setNeighbor(Direction.north(), cell = new Cell(row - 1, col));
                }
                if (width() > 1 && col < width() - 1) {
                    cell.setNeighbor(Direction.east(), cell = new Cell(row, col + 1));
                }
                if (col > 0) {
                    cell.setNeighbor(Direction.west(), cell = new Cell(row, col - 1));
                }
            }
        }
        // Создаем костяшки
        //делаем из двумерного одномерный
//        List<Cell> oneLineCells = new ArrayList<>(16);
//        for (int row = 0; row < height(); row++) {
//            for (int col = 0; col < width(); col++) {
//            oneLineCells.add(_cells[row][col]);
//            }
//        }
        //перемешиваем ячейки
        for (int i = 0; i < width()*height()-1; i++) {
            _tiles.add(new Tile(i+1));
        }
        Collections.shuffle(_tiles);

        //присваиваем костяшкам ячейки
        int oo = 0;

            for (int row = 0; row < height(); row++) {
                for (int col = 0; col < width(); col++) {
                    if(oo!=15) {
                        _cells[row][col].setTile(_tiles.get(oo));
                        _tiles.get(oo).setOwner(_cells[row][col]);
                        oo++;
                    }
                }
            }

    }

    public Cell[][] get_cells(){
        return _cells;
    }
    public List<Tile> get_tiles(){
        return _tiles;
    }
    public boolean isSolved() {
        // проверка, решена ли игра
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
            }
        }
        return false; // ВРЕМЕННАЯ
    }

    // методы для работы с ячейками
//     public Cell getCell(int row, int col) {
//        return cells[row][col];
//    }
}
