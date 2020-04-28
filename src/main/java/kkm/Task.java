package kkm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

interface  Task{
    int Question( int type_);
}

class Task_class implements Task {
private static int num;
private  static  int even_odd;
private  static  int str_type;

    public void setNum(int num) {
        this.num = num;
        //System.out.println(q_types);
    }
    public void setEven_odd(int even_odd) {
        this.even_odd = even_odd;
        //System.out.println("______________________" + even_odd);
    }
    public void setStr_type(int str_type) {
        this.str_type = str_type;
        //System.out.println("______________________" + str_type);
    }
    @Override
    public int Question(int type_) {

        if (type_ == 1) {
            //Scanner in = new Scanner(System.in);
            System.out.println("Type of array:" + "\n" + "1.Int" + "\n" + "2.String"+ "\n" + num);
            //int num = in.nextInt();
            return num;
        }

        if (type_ == 2) {
            //Scanner in = new Scanner(System.in);
            System.out.println("Choose Handler:" + "\n" + "1. The first handler returns their sum, average value, minimum and maximum element"
                    + "\n" + "2. The second handler removes even or odd elements from the list, depending on the setting" + "\n" + "3. Apply both handlers"+ "\n" + num);
            //int num = in.nextInt();
            return num;
        }
        if (type_ == 3) {
            //Scanner in = new Scanner(System.in);
            System.out.println("Delete: " + "\n" + "1.Even" + "\n" + "2. Odd"+ "\n" + even_odd);
            //int num = in.nextInt();
            //in.close();
            return even_odd;

        }
        if (type_ == 4) {

            //Scanner in = new Scanner(System.in);
            System.out.println("Choose Handler:" + "\n" + "1. The first handler - returns the glued string"
                    + "\n" + "2. The second handler counts the number of words in each line, the total number of words and characters across all lines of the list" +
                    "\n" + "3. Apply both handlers"+ "\n" + str_type);
            //int num = in.nextInt();
            //in.close();
            return str_type;
        } else {
            return 0;
        }
    }

}
class Worker extends Task_class{
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;
    private static int q;
/*
    Worker(ArrayList<Integer> listInt, String[][] listStr) throws IOException, InterruptedException {
        this.listInt = listInt;
        this.listStr = listStr;
    }
 */
    public void setTypes(int types) {
        q  = types;
        //System.out.println(q);
    }
    public static void work() throws IOException, InterruptedException{
        //Create to hands ( int and string) to help with task
        Handler int_hand = new Handler();
        Handler str_hand = new Handler();

        //Worker Worker = new Worker();
        App task = new App();
        int type = 0;
        String Type = " ";
        System.out.println("Type of array:" + "\n" + "1.Int" + "\n" + "2.String");
        //Worker.q = task.Question(1);

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