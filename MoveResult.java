
public class MoveResult {
    public Position position;
    public int distanceMoved;
    public int cost;
    public Cost totalCost;
    public String result; // "Success", "Wall", or "Finish"

    public MoveResult(Position position, int distanceMoved, int cost, Cost totalCost, String result) {
        this.position = position;
        this.distanceMoved = distanceMoved;
        this.cost = cost;
        this.totalCost = totalCost;
        this.result = result;
    }

    @Override
    public String toString() {
        return "MoveResult{" +
                "position=" + position +
                ", distanceMoved=" + distanceMoved +
                ", cost=" + cost +
                ", totalCost=" + totalCost +
                ", result='" + result + '\'' +
                '}';
    }
}
