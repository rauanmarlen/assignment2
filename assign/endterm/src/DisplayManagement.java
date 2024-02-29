class DisplayManagementImpl implements DisplayManagement {
    private Map<Integer, Product> productInventory;

    public DisplayManagementImpl(Map<Integer, Product> productInventory) {
        this.productInventory = productInventory;
    }

    @Override
    public void displayShortDescription(int productId) {
        Product product = productInventory.get(productId);
        if (product != null) {
            System.out.println("Short Description: " + product.getShortDescription());
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void getProductInformation(int productId) {
        Product product = productInventory.get(productId);
        if (product != null) {
            System.out.println(product.toString() + "\nShort Description: " + product.getShortDescription());
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void displayAllProducts() {
        if (productInventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Map.Entry<Integer, Product> entry : productInventory.entrySet()) {
                System.out.println("Product ID: " + entry.getKey() + "\n" + entry.getValue() + "\n");
            }
        }
    }
}
