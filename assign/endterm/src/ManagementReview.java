class ReviewManagementImpl implements ReviewManagement {
    private Map<Integer, Product> productInventory;

    public ReviewManagementImpl(Map<Integer, Product> productInventory) {
        this.productInventory = productInventory;
    }

    @Override
    public void submitReview(int productId, int score) {
        Product product = productInventory.get(productId);
        if (product != null) {
            product.setReviewScore(score);
            System.out.println("Review submitted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
}
