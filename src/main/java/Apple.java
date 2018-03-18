public class Apple {


    public Apple(int id, String color, int weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    private int id;
    private String color;
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "id='" + id + '\'' +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
