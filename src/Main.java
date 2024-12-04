import boardgame.Board;
import boardgame.Position;

public class Main {
    public static void main(String[] args) {

        Position position = new Position(1,2);
        Board board = new Board(8, 8);
        System.out.println(position);
    }
}