public class StepTracker {

    double centimeter = 0.00075;
    double kilocalories = 0.005;
    Converter converter = new Converter(centimeter, kilocalories);

    MonthData[] monthToData;

    int goalSteps = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    int goalSteps (int goal){
        if (goal > 0) {
            goalSteps = goal;
        } else System.out.println("Введите положительное значение");
        return goalSteps;
    }
    void saveSteps(int month, int day, int steps) {
        if (month >= 0 & month <= 11 & day >= 0 & day <= 30 & steps >= 0) {
            monthToData[month].dayData[day - 1] = monthToData[month].dayData[day - 1] + steps;
            System.out.println("Значение сохранено!");
        } else System.out.println("Введите корректные значения");
    }

    void daySteps(int month) {
        if (month >= 0 & month <= 11) {
            for (int i = 0; i < monthToData[month].dayData.length; i++) {
                System.out.print((i + 1) + " День: " + monthToData[month].dayData[i] + " , ");
            }
            System.out.println(" ");
        } else System.out.println("Введите корректное значение");
    }

    int totalSteps(int month) {
        int monthSteps = 0;
        if (month >= 0 & month <= 11) {
            for (int i = 0; i < monthToData[month].dayData.length; i++) monthSteps += monthToData[month].dayData[i];
        } else System.out.println("Введите корректные значения");
        return monthSteps;
    }
    int maxSteps(int month) {
        int maxSteps = 0;
        if (month >= 0 & month <= 11) {
            for (int i = 0; i < monthToData[month].dayData.length; i++) {
                if (monthToData[month].dayData[i] > maxSteps) {
                    maxSteps = monthToData[month].dayData[i];
                }
            }
        } else System.out.println("Введите корректные значения");
        return maxSteps;
    }
    double averageSteps (int month){
        double averageSteps = 0;
        double counter = 0;
        if (month >= 0 & month <= 11) {
            for (int i = 0; i < monthToData[month].dayData.length; i++) {
                if (0 < monthToData[month].dayData[i]) {
                    counter++;
                    averageSteps = totalSteps(month) / counter;
                }
            }
        } else System.out.println("Введите корректные значения");
        return averageSteps;
    }
    int bestSeries(int month){
        int counter = 0;
        int maxCount = 0;
        if (month >= 0 & month <= 11) {
            for (int i = 0; i < monthToData[month].dayData.length; i++) {
                if (monthToData[month].dayData[i] >= goalSteps) {
                    counter++;
                } else counter = 0;
                if (maxCount < counter) {
                    maxCount = counter;
                }
            }
        } else System.out.println("Введите корректные значения");
        return maxCount;
    }
    void printStatistics(int month){
        daySteps(month);
        System.out.println("Общее количество шагов за месяц: " + totalSteps(month));
        System.out.println("Максимальное пройденное количество шагов за день, в месяце: " + maxSteps(month));
        System.out.println("Среднее количество шагов: " + averageSteps(month));
        System.out.println("Пройденая дистанция: " + converter.convertCentimeter(totalSteps(month)) + " км");
        System.out.println("Количество сожжённых килокалорий: " + converter.convertKilocalories(totalSteps(month)) + " килокалорий");
        System.out.println("Лучшая серия: " + bestSeries(month));
    }
    static class MonthData {
        int[] dayData = new int[30];
    }
}
