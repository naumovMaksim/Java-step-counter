public class Converter {
    double centimeter;
    double kilocalories;

    Converter(double m, double cal){
        centimeter = m;
        kilocalories = cal;
    }
    double convertCentimeter(int steps) {
        return steps * centimeter;
    }
    double convertKilocalories (int steps) {
        return steps * kilocalories;
    }
}