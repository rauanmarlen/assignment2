class ProductInfoPageImpl implements ProductInfoPage {
    private DisplayManagement displayManagement;

    public ProductInfoPageImpl(DisplayManagement displayManagement) {
        this.displayManagement = displayManagement;
    }

    @Override
    public void displayProductInformation(int productId) {
        displayManagement.getProductInformation(productId);
    }
}
