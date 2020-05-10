package kkm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

interface  Task{
    int Question( int type_);
}

class Task_class implements Task {
private static int num;
private static int handlerInt;
private  static  int even_odd;
private  static  int handlerStr;

    public void setNum(int num) {
        this.num = num;
    }
    public void setHandlerInt(int handlerInt) {
        this.handlerInt = handlerInt;
    }
    public void setEven_odd(int even_odd) {
        this.even_odd = even_odd;
    }
    public void sethandlerStr(int handlerStr) {
        this.handlerStr = handlerStr;
    }
    @Override
    public int Question(int type_) {

        if (type_ == 1||type_ == 2) {
            System.out.println("Type of array:" + "\n" + "1.Int" + "\n" + "2.String"+ "\n" + num);
            return num;
        }

        if (type_ == 2) {
            System.out.println("Choose Handler:" + "\n" + "1. The first handler returns their sum, average value, minimum and maximum element"
                    + "\n" + "2. The second handler removes even or odd elements from the list, depending on the setting" + "\n" + "3. Apply both handlers"+ "\n" + handlerInt);
            return handlerInt;
        }
        if (type_ == 3) {
            System.out.println("Delete: " + "\n" + "1.Even" + "\n" + "2. Odd"+ "\n" + even_odd);
            return even_odd;

        }
        if (type_ == 4) {
            System.out.println("Choose Handler:" + "\n" + "1. The first handler - returns the glued string"
                    + "\n" + "2. The second handler counts the number of words in each line, the total number of words and characters across all lines of the list" +
                    "\n" + "3. Apply both handlers"+ "\n" + handlerStr);
            return handlerStr;
        } else {
            return 0;
        }
    }

}
class Worker extends Task_class{
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;
    private static int q;


    public void setTypes(int types) {
        q  = types;
    }
    public static void work() throws IOException, InterruptedException{
        Handler int_hand = new Handler();
        Handler str_hand = new Handler();

        App task = new App();
        int type = 0;
        String Type = " ";
        task.Question(q);

        switch (Worker.q) {
            case 1:
                listInt = Generator.Gen(type);
                Worker.q = task.Question(2);
                if (Worker.q == 1) {
                    int_hand.getIntResultFirst(listInt);
                    break;
                }
                if (Worker.q == 2) {
                    Worker.q = task.Question(3);
                    if (Worker.q == 1 || Worker.q == 2) {
                        int_hand.getIntResultSecond(listInt, Worker.q);
                        break;
                    } else {
                        System.out.println("Input Error!");
                        System.exit(0);
                    }
                }
                if (Worker.q == 3) {
                    Worker.q = task.Question(3);
                    if (Worker.q == 1 || Worker.q == 2) {
                        int_hand.getIntResultFirst(listInt);
                        System.out.println();
                        int_hand.getIntResultSecond(listInt, Worker.q);
                        break;
                    } else {
                        System.out.println("Input Error!");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Input Error!");
                    System.exit(0);
                }

            case 2:
                listStr = Generator.Gen(Type);
                Worker.q = task.Question(4);
                if (Worker.q == 1) {
                    str_hand.getStrResultFirst(listStr);
                    break;
                }
                if (Worker.q == 2) {
                    str_hand.getStrResultSecond(listStr);
                    break;
                }
                if (Worker.q == 3) {
                    str_hand.getStrResultFirst(listStr);
                    System.out.println();
                    str_hand.getStrResultSecond(listStr);
                    break;
                } else {
                    System.out.println("Input Error!");
                    System.exit(0);
                }

            default:
                System.out.println("ERROR");
                break;

        }
    }
}