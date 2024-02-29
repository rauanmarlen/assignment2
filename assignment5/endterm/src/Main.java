public class Main {
    public static void main(String[] args) {
        Map<Integer, Product> productInventory = new HashMap<>();
        ProductManagement productManagement = new ProductManagementImpl();
        ReviewManagement reviewManagement = new ReviewManagementImpl(productInventory);
        DisplayManagement displayManagement = new DisplayManagementImpl(productInventory);
        ProductInfoPage productInfoPage = new ProductInfoPageImpl(displayManagement);


        productManagement.addProduct("Whey Protein Isolate", 39.99, 30, "High-quality protein for muscle growth.");



        displayManagement.displayAllProducts();


        int productIdForReview = 1;
        int reviewScore = 8;
        reviewManagement.submitReview(productIdForReview, reviewScore);


        int productIdForDescription = 2;
        displayManagement.displayShortDescription(productIdForDescription);


        int productIdForInfo = 3;
        productInfoPage.displayProductInformation(productIdForInfo);


    }
}
