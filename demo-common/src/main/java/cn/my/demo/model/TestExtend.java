package cn.my.demo.model;

/**
 * @author wxh
 * @date 2019/11/13
 */
public class TestExtend {

    private Game game;
    private BoardGame boardGame;

    class Game{
        Game(int i){
            System.out.println("Game - " + i);
        }

        void get(int i){
            System.out.println("Game"+i);
        }

    }
    class BoardGame extends Game{

        BoardGame(int i) {
            super(i);
        }

        @Override
        void get(int i){
            System.out.println("BoradGame"+i);
        }
    }

    public TestExtend(){
        game = new Game(1);
        boardGame = new BoardGame(2);
    }

    public static void main(String[] args) {
        TestExtend testExtend = new TestExtend();
        testExtend.game.get(9);
        testExtend.boardGame.get(9);
    }

}
