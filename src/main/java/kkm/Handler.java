package kkm;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
interface  Operation{
    int Sum (ArrayList<Integer> list);
    int Min (ArrayList<Integer> list);
    int Max (ArrayList<Integer> list);
    int Mean (int sum, ArrayList<Integer> list);
    void getIntResultFirst (ArrayList<Integer> list);
    void getIntResultSecond (ArrayList<Integer> list, int q) throws IOException;
    ArrayList<Integer> HandIntFirst (ArrayList<Integer> list);
    ArrayList<Integer> HandIntSecond (ArrayList<Integer> list, int q);
    ArrayList<String> HandStrFirst (String[][] list);
    ArrayList<Integer> HandStrSecond (String[][] list);
    void getStrResultFirst (String[][] list);
    void getStrResultSecond (String[][] list);
}


public class Handler implements  Operation{

    public static int s, min, max, mean;
    @Override
    public int Sum (ArrayList<Integer> list){
        int s = 0;
        for(int i = 0; i<list.size(); i++){
            s += list.get(i);
        }
        return s;
    }
    @Override
    public int Min (ArrayList<Integer> list){
        int min = list.get(0);
        for(int i = 0; i<list.size(); i++){
            if (min>list.get(i)){
                min = list.get(i);
            }
        }
        return min;
    }
    @Override
    public int Max (ArrayList<Integer> list){
        int max = list.get(0);
        for(int i = 0; i<list.size(); i++){
            if (max<list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }
    @Override
    public int Mean (int sum, ArrayList<Integer> list){
        int s = sum;
        mean = s/(list.size()+1);
        return mean;
    }
    @Override
    public void getIntResultFirst(ArrayList<Integer> list){
        ArrayList<Integer> res = HandIntFirst(list);

        System.out.println("����� ��������� �������: " + res.get(0));
        System.out.println("����������� ������� �������: " + res.get(1));
        System.out.println("������������ ������� �������: " + res.get(2));
        System.out.println("������� �������� ��������� �������: " + res.get(3));
    }
    @Override
    public void getIntResultSecond (ArrayList<Integer> list, int q) throws IOException{
        ArrayList<Integer> res = HandIntSecond(list, q);

        try(FileWriter writer = new FileWriter("Int2.txt", false)){
            for (int i=0;i<res.size();i++){
                writer.write(Integer.toString(res.get(i))+ " ");
            }
            writer.flush();
        }
        System.out.println("������ ������� � ����");

    }
    @Override
    public ArrayList<Integer> HandIntFirst (ArrayList<Integer> list){
        ArrayList<Integer> Result = new ArrayList<>();
        Result.add(Sum(list));
        Result.add(Min(list));
        Result.add(Max(list));
        Result.add(Mean(Sum(list),list));

        return Result;
    }
    @Override
    public ArrayList<Integer> HandIntSecond (ArrayList<Integer> list, int q){
        ArrayList<Integer> res = new ArrayList<>();
        if (q==2){
            for (int i =0; i<list.size();i++){
                if (list.get(i) % 2==0){
                    res.add(list.get(i));
                    //System.out.println(res.get(i));
                }
            }
        }
        else{
            for (int i =0; i<list.size();i++){
                if (list.get(i)%2!=0){
                    res.add(list.get(i));
                }
            }
        }

		/*for (int i=0;i<res.size();i++){
			System.out.println(res.get(i));
			System.out.println("/n");
		}*/

        return res;
    }
    @Override
    public ArrayList<String> HandStrFirst (String[][] list){
        ArrayList<String> Result = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] != " "){
                    Result.add(list[i][j]);
                }
            }
        }

        return Result;
    }
    @Override
    public void getStrResultFirst (String[][] list){
        ArrayList<String> res = HandStrFirst(list);

        System.out.println("�C��������� ������: ");
        for (int i=0;i<res.size();i++){
            System.out.print(res.get(i));
        }
    }
    @Override
    public ArrayList<Integer> HandStrSecond (String[][] list){
        ArrayList<Integer> Result = new ArrayList<>();
        int amt = 0;
        int length = 0;

        Result.add(list.length);

        for (int i = 0; i < list.length; i++) {
            amt = 0;
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] != (" ")){
                    amt+=1;
                    length += list[i][j].length();
                }
            }
            Result.add(amt);
        }
        Result.add(length);

        return Result;
    }
    @Override
    public void getStrResultSecond (String[][] list){
        ArrayList<Integer> res = HandStrSecond(list);

        int line = res.get(0);
        int S = 0;
        res.remove(0);
        System.out.println("���������� �����: "+ line);

        for (int i=0;i<line;i++){
            System.out.println("���������� ���� � " + (i) + " ������: " + res.get(i));
            S+=res.get(i);
        }
        System.out.println("���������� ���� �����: " + S);
        System.out.println("���������� �������� �����: " + res.get(res.size()-1));

    }

}
