
public class LookResult {
    public int distance;
    public int cost;
    public Cost totalCost;
    public String result; // "no obstruction" or "obstruction"

    public LookResult(int distance, int cost, Cost totalCost, String result) {
        this.distance = distance;
        this.cost = cost;
        this.totalCost = totalCost;
        this.result = result;
    }

    @Override
    public String toString() {
        return "LookResult{" +
                "distance=" + distance +
                ", cost=" + cost +
                ", totalCost=" + totalCost +
                ", result='" + result + '\'' +
                '}';
    }
}
