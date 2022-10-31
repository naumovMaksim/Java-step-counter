public class Converter {
    double centimeter;
    double kilocalories;

    Converter(double m, double cal){
        centimeter = m;
        kilocalories = cal;
    }
    void convertCentimeter(int steps) {
        double distance = steps * centimeter;
        System.out.println("Пройденая дистанция: " + distance + " км");
    }
    void convertKilocalories (int steps) {
        double allCalories = steps * kilocalories;
        System.out.println("Количество сожжённых килокалорий: " + allCalories + " килокалорий");
    }
}
