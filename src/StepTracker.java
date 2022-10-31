public class StepTracker {

    int[][] monthToDay;
    int goalSteps = 10000;

    StepTracker() {
        monthToDay = new int[12][30];
    }

    int goalSteps (int goal){
        if (goal > 0) {
            goalSteps = goal;
        } else System.out.println("Введите положительное значение");
        return goalSteps;
    }
    void saveSteps(int month, int day, int steps) {
            if (steps >= 0) {
                monthToDay[month][day - 1] = monthToDay[month][day - 1] + steps;
                System.out.println("Значение сохранено!");
            } else System.out.println("Введите положительное значение");
    }

    void daySteps(int month) {
        for (int i = 0; i < monthToDay[month].length; i++) {
            System.out.println((i + 1) + " День: " + monthToDay[month][i]);
        }
    }
    int totalSteps(int month) {
        int monthSteps = 0;
        for (int i = 0; i < monthToDay[month].length; i++) monthSteps = monthSteps + monthToDay[month][i];
        return monthSteps;
    }
    int maxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToDay.length; i++) {
            if (monthToDay[month][i] > maxSteps) {
                maxSteps = monthToDay[month][i];
            }
        }
        return maxSteps;
    }
    int averageSteps (int month){
        int averageSteps = 0;
        for (int i = 0; i < monthToDay[month].length; i++) {
            averageSteps = averageSteps + monthToDay[month][i];
        }
        averageSteps = averageSteps / 2;
        return averageSteps;
    }
    int bestSeries(int month){
        int counter = 0;
        int maxCount = 0;
        for (int i = 0; i < monthToDay[month].length; i++){
            if (monthToDay[month][i] >= goalSteps ){
                counter++;
            } else counter = 0;
            if (maxCount < counter) {
                maxCount = counter;
            }
        }
        return maxCount;
    }
}
