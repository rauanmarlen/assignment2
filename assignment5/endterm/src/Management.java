class ProductManagementImpl implements ProductManagement {
    private Map<Integer, Product> productInventory;
    private int nextProductId;

    public ProductManagementImpl() {
        productInventory = new HashMap<>();
        nextProductId = 1;
    }

    @Override
    public void addProduct(String name, double price, int quantity, String shortDescription) {
        Product product = new ProductImpl(name, price, quantity, shortDescription);
        productInventory.put(nextProductId, product);
        nextProductId++;
    }

    @Override
    public void updateProduct(int productId, String name, double price, int quantity) {
        Product product = productInventory.get(productId);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void deleteProduct(int productId) {
        if (productInventory.containsKey(productId)) {
            productInventory.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
}
