import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getDetails();
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
    public String getDetails() {
        return "Electronics: " + getName();
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
    public String getDetails() {
        return "Groceries: " + getName();
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
    public String getDetails() {
        return "Furniture: " + getName();
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
}

class Display {
    public static void showItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getDetails());
        }
    }
}