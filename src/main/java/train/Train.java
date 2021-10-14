package train;

import java.util.ArrayList;

public class Train {

    private String name;
    private Locomotive locomotive;
    private ArrayList<Car> cars;

    public Train(String name, Locomotive locomotive) {
        this.name = name;
        this.locomotive = locomotive;
        this.cars = new ArrayList<>(locomotive.getCapacity());
    }

    public void loadCars(ArrayList<Car> carsToLoad) {
        try {
            cars.addAll(carsToLoad);
        } catch (Exception ee) {
            System.out.println("train capacity overload");
        }
    }

    public void unloadCars(ArrayList<Car> carsToUnload) {
            cars.removeAll(carsToUnload);
    }
}
