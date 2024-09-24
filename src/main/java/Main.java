import java.util.Scanner;
import java.util.InputMismatchException;

class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

class Race {
    String leaderName = "";
    int leaderDistance = 0;

    public void updateLeader(Car car) {
        int distance = car.getSpeed() * 24;
        if (distance > leaderDistance) {
            leaderName = car.getName();
            leaderDistance = distance;
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.next();

            int speed = 0;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                try {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость. Введите значение от 1 до 250.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Пожалуйста, введите числовое значение.");
                    scanner.next();
                }
            }

            Car car = new Car(name, speed);
            race.updateLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}