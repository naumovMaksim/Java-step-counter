import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("За какой месяц вы хотите ввести количество шагов: от 0 до 11, где 0- ЯНВ, 11- ДЕК?");
                int month = scanner.nextInt();
                System.out.println("За какой день вы хотите ввести количество шагов: от 1 до 30?");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();
                stepTracker.saveSteps(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("За какой месяц вы хотите посмотреть статистику: от 0 до 11, где 0- ЯНВ, 11- ДЕК?");
                int month = scanner.nextInt();
                stepTracker.printStatistics(month);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов:");
                int goal = scanner.nextInt();
                System.out.println("Цель по количеству шагов: " + stepTracker.goalSteps(goal));
            } else if (userInput == 0){
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

    }

    private static void printMenu(){
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}

