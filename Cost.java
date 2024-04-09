
public class Cost {
    private int cost = 0;

    public void Add(int a) {
        this.cost += a;
    }

    public String toString() {
        return(String.valueOf(cost));
    }

}
