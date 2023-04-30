package Model;
public class GameModel {
    private Field field;

    public void startGame() {
        field = new Field();
        // заполнение поля костяшками
        field.generateField();
    }

    public boolean isGameOver() {
        return field.isSolved();
    }
}
