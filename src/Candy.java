public class Candy {

    protected String type;
    protected String flavor;
    protected String appearance;
    protected int cost;
    protected int stock;
    protected int isleNum;

    Candy () { }

    Candy(String type, String flavor, int cost, int stock, int isleNum) {
        this.type = type;
        this.flavor = flavor;
        this.cost = cost;
        this.stock = stock;
        this.isleNum = isleNum;
    }

    public String inspect() {
        return "The candy tastes delicious!";
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public int getIsleNum() {
        return isleNum;
    }

    public void IsleNumSet(int x) {
        isleNum = x;
    }

    public void stockChange(int candy) {
        stock += candy;
    }

    public static void main(String[] args) {
        Candy Twizzler = new Candy("soft candy", "Raspberry", 3,5, 2);
        System.out.println(Twizzler.getStock());
        Twizzler.stockChange(25);
        System.out.println(Twizzler.getStock());
    }
}