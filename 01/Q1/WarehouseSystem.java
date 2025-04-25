public class WarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Strawberries"));
        groceriesStorage.addItem(new Groceries("Flour"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Cushions"));
        furnitureStorage.addItem(new Furniture("Coffee Table"));

        System.out.println("All Electronics:");
        Display.showItems(electronicsStorage.getItems());

        System.out.println("\nAll Groceries:");
        Display.showItems(groceriesStorage.getItems());

        System.out.println("\nAll Furniture:");
        Display.showItems(furnitureStorage.getItems());
    }
}
