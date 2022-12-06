package test;

public enum Meal {
    meatball_soup(140),
    spaghetti_bolognese(260),
    pizza(445);

    private int price;

    Meal(final int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}
