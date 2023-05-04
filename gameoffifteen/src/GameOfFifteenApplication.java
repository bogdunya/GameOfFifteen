import Model.Cell;
import Model.GameModel;
import Model.GameField;
import Model.Tile;
import Model.Direction;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfFifteenApplication {
    public static void main(String[] args) {
        GameField field = new GameField(4,4);
        field.buildField();
        Cell[][] cells=field.get_cells();
        List<Tile> tiles = field.get_tiles();

        //Создание первой доски
        int oo=0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if(cells[row][col].getTile()==null){
                        System.out.print("x");
                    }else {
                    System.out.print(cells[row][col].getTile().getValue());
                }
                System.out.print(" ");
                oo++;
            }
            System.out.print("\n");
        }

        //Хожу тайлом
        cells[3][2].getTile().move();
//отрисовка похождения
//        System.out.print("\n");
//        oo=0;
//        for (int row = 0; row < 4; row++) {
//            for (int col = 0; col < 4; col++) {
//                if(cells[row][col].getTile()==null){
//                    System.out.print("x");
//                }else {
//                    System.out.print(cells[row][col].getTile().getValue());
//                }
//                System.out.print(" ");
//                oo++;
//            }
//            System.out.print("\n");
//        }
        System.out.print("\n");
        Map<Direction, Cell> neighbors = cells[2][2].get_neighbors();
        System.out.println(neighbors);
        //две скобочки от класса и main
    }
}
