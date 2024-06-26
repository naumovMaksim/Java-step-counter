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
            monthToData[month].dayData[day - 1] = monthToData[month].dayData[day - 1] + steps;
            System.out.println("Значение сохранено!");
    }

    void daySteps(int month) {
            for (int i = 0; i < monthToData[month].dayData.length - 1; i++) {
                System.out.print((i + 1) + " день: " + monthToData[month].dayData[i] + ", ");// Спасибо за уточнение, не заметил, сейчас точь в точь как в задаче: 1 день: 3000, 2 день: 2000, ..., 30 день: 10000
            }
            System.out.println("30 день: " + monthToData[month].dayData[29]);
    }

    int totalSteps(int month) {
        int monthSteps = 0;
            for (int i = 0; i < monthToData[month].dayData.length; i++) monthSteps += monthToData[month].dayData[i];
        return monthSteps;
    }
    int maxSteps(int month) {
        int maxSteps = 0;
            for (int i = 0; i < monthToData[month].dayData.length; i++) {
                if (monthToData[month].dayData[i] > maxSteps) {
                    maxSteps = monthToData[month].dayData[i];
                }
            }
        return maxSteps;
    }
    double averageSteps (int month){
        double averageSteps = 0;
        double counter = 0;
            for (int i = 0; i < monthToData[month].dayData.length; i++) {
                if (0 < monthToData[month].dayData[i]) {
                    counter++;
                    averageSteps = totalSteps(month) / counter;
                }
            }
        return averageSteps;
    }
    int bestSeries(int month){
        int counter = 0;
        int maxCount = 0;
            for (int i = 0; i < monthToData[month].dayData.length; i++) {
                if (monthToData[month].dayData[i] >= goalSteps) {
                    counter++;
                } else counter = 0;
                if (maxCount < counter) {
                    maxCount = counter;
                }
            }
        return maxCount;
    }
    void printStatistics(int month){
        if (month >= 0 & month <= 11) {
            daySteps(month);
            System.out.println("Общее количество шагов за месяц: " + totalSteps(month));
            System.out.println("Максимальное пройденное количество шагов за день, в месяце: " + maxSteps(month));
            System.out.println("Среднее количество шагов: " + averageSteps(month));
            System.out.println("Пройденая дистанция: " + converter.convertCentimeter(totalSteps(month)) + " км");
            System.out.println("Количество сожжённых килокалорий: " + converter.convertKilocalories(totalSteps(month)) + " килокалорий");
            System.out.println("Лучшая серия: " + bestSeries(month));
        }else System.out.println("Введите корректное значение");
    }
    static class MonthData {
        int[] dayData = new int[30];
    }
}
