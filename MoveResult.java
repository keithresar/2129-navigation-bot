
public class MoveResult {
    public Position position;
    public int distanceMoved;

    public MoveResult(Position position, int distanceMoved) {
        this.position = position;
        this.distanceMoved = distanceMoved;
    }

    @Override
    public String toString() {
        return "MoveResult{" +
                "position=" + position +
                ", distanceMoved=" + distanceMoved +
                '}';
    }
}
