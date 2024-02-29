interface Product {
    String getName();
    double getPrice();
    int getQuantity();
    int getReviewScore();
    String getShortDescription();
}

interface ProductManagement {
    void addProduct(String name, double price, int quantity, String shortDescription);
    void updateProduct(int productId, String name, double price, int quantity);
    void deleteProduct(int productId);
}

interface ReviewManagement {
    void submitReview(int productId, int score);
}

interface DisplayManagement {
    void displayShortDescription(int productId);
    void getProductInformation(int productId);
    void displayAllProducts();
}

interface ProductInfoPage {
    void displayProductInformation(int productId);
}
