package org.sscc.study.racing;

import java.util.Scanner;

public class InputView {
    private static int count;
    private static int number;

    public static int getCount() {
        return count;
    }

    public static int getNumber() {
        return number;
    }

    public static void getValue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        number = sc.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        count = sc.nextInt();
    }
}