package kkm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

interface  Task{
    int Question( int type_);
}

class Task_class implements Task {

    @Override
    public int Question(int type_) {

        if (type_ == 1) {
            Scanner in = new Scanner(System.in);
            System.out.println("Тип массива:" + "\n" + "1.Int" + "\n" + "2.String");
            int num = in.nextInt();
            return num;

        }
        if (type_ == 2) {

            Scanner in = new Scanner(System.in);
            System.out.println("Выберите обработчик:" + "\n" + "1.Первый обработчик возвращает их сумму, среднее значение, минимальный и максимальный элемент"
                    + "\n" + "2.Второй обработчик удаляет из списка четные или нечетные элементы, в зависимости от настройки" + "\n" + "3. Применить оба обработчика");
            int num = in.nextInt();
            return num;
        }
        if (type_ == 3) {

            Scanner in = new Scanner(System.in);
            System.out.println("Удалять: " + "\n" + "1.Четные" + "\n" + "2. Нечетные");
            int num = in.nextInt();
            in.close();
            return num;

        }
        if (type_ == 4) {

            Scanner in = new Scanner(System.in);
            System.out.println("Выберите обработчик:" + "\n" + "1.Первый обработчик — возвращает «склеенную» строку"
                    + "\n" + "2.Второй обработчик подсчитывает количество слов в каждой строке, общее количество слов и символов по всем строкам списка" + "\n" + "3.Применить оба обработчика");
            int num = in.nextInt();
            in.close();
            return num;
        } else {
            return 0;
        }
    }
}
class Worker extends Task_class{
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;

    Worker(ArrayList<Integer> listInt, String[][] listStr) throws IOException, InterruptedException {
        this.listInt = listInt;
        this.listStr = listStr;
    }

    public static void work() throws IOException, InterruptedException{

        //Create to hands ( int and string) to help with task
        Handler int_hand = new Handler();
        Handler str_hand = new Handler();

        App task = new App();
        int  q = 0;
        int type = 0;
        String Type = " ";
        q = task.Question(1);
        switch (q) {
            case 1:
                listInt = Generator.Gen(type);
                q = task.Question(2);
                if (q == 1) {
                    int_hand.getIntResultFirst(listInt);
                    break;
                }
                if (q == 2) {
                    q = task.Question(3);
                    if (q == 1 || q == 2) {
                        int_hand.getIntResultSecond(listInt, q);
                        break;
                    } else {
                        System.out.println("Ошибка ввода!");
                        System.exit(0);
                    }
                }
                if (q == 3) {
                    q = task.Question(3);
                    if (q == 1 || q == 2) {
                        int_hand.getIntResultFirst(listInt);
                        System.out.println();
                        int_hand.getIntResultSecond(listInt, q);
                        break;
                    } else {
                        System.out.println("Ошибка ввода!");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Ошибка ввода!");
                    System.exit(0);
                }

            case 2:
                listStr = Generator.Gen(Type);
                q = task.Question(4);
                if (q == 1) {
                    str_hand.getStrResultFirst(listStr);
                    break;
                }
                if (q == 2) {
                    str_hand.getStrResultSecond(listStr);
                    break;
                }
                if (q == 3) {
                    str_hand.getStrResultFirst(listStr);
                    System.out.println();
                    str_hand.getStrResultSecond(listStr);
                    break;
                } else {
                    System.out.println("Ошибка ввода!");
                    System.exit(0);
                }

            default:
                System.out.println("ERROR");
                break;

        }
    }
}