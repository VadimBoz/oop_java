

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        market.acceptToMarket(new Human("Mikl"));
        market.acceptToMarket(new Human("Alexandr"));
        market.update();
        market.acceptToMarket(new Human("Jon"));
        market.update();
        }
    }

