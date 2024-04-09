

public class NavigatorBot {

    public static void main(String[] args) {
        Grid grid = new Grid("grids/001-direct-10x10.grid");
        grid.PrintGrid();
        grid.PrintDimensions();
        System.out.println("Start Position: " + grid.FindStartPosition());
        System.out.println("Finish Position: " + grid.FindFinishPosition());

        MoveResult m = grid.Move('U',10);
        System.out.println(m);
    }


}