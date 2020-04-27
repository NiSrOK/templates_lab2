package kkm;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class App extends Task_class{
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;

    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestBean testBean  = context.getBean("testBean", TestBean.class);

        System.out.println("Ku ' "+ testBean.getName());

        context.close();

        Worker worker = new Worker(listInt, listStr);
        worker.work();
    }

}
