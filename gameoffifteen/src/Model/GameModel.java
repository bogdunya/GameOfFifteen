package Model;
public class GameModel {

    GameField _field;

    public void startGame() {

        _field = new GameField(4,4);
        // заполнение поля костяшками
      //  field.generateField();
    }

    public boolean isGameOver() {
        return _field.isSolved();
    }
}
