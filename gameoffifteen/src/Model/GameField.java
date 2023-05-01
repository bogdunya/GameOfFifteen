package Model;
import java.util.Random;
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
    private final Cell[][] cells = new Cell[4][4];

    // ---------------------------- Порождение ---------------------

    public GameField(int height, int width) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }

        _width = width;
        _height = height;
        buildField();

    }

    private void buildField() {

        // Создаем ячейки
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {
                CellPosition pos = new CellPosition(row, col);
                _cells.put(pos, new Cell(pos));
            }
        }

        // Связываем ячейки
        for (int row = 0; row < height(); row++) {
            for (int col = 0; col < width(); col++) {

                Cell cell = cell(row, col);

                if (height() > 1 && row < height() - 1) {
                    cell.setNeighbor(Direction.south(), cell(row + 1, col));
                }
                if (row > 0) {
                    cell.setNeighbor(Direction.north(), cell(row - 1, col));
                }
                if (width() > 1 && col < width() - 1) {
                    cell.setNeighbor(Direction.east(), cell(row, col + 1));
                }
                if (col > 0) {
                    cell.setNeighbor(Direction.west(), cell(row, col - 1));
                }
            }
        }
    }

    public void generateTiles() {
        // генерация костяшек
        // расстановка костяшек на поле

    }

    public boolean isSolved() {
        // проверка, решена ли игра
        return false; // ВРЕМЕННАЯ 
    }

    // методы для работы с ячейками
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(int row, int col, Tile tile) {
        cells[row][col].setTile(tile);
    }
}
