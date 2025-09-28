package creational.builder;

public class Build {
    private Builder builder;

    public Build(int i) {
        if (i == 1) {
            builder = new OneBuilderImpl();
        } else if (i == 2) {
            builder = new TwoBuilderImpl();
        }
    }

    public Car buildCar() {
        return builder.buildCar();
    }
}
