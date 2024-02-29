class ProductImpl implements Product {
    private String name;
    private double price;
    private int quantity;
    private int reviewScore;
    private String shortDescription;

    public ProductImpl(String name, double price, int quantity, String shortDescription) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reviewScore = 0;
        this.shortDescription = shortDescription;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getReviewScore() {
        return reviewScore;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }


}
