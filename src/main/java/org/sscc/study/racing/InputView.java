package org.sscc.study.racing;

import java.util.Scanner;

public class InputView {
    private int count;
    private int number;

    public int getCount() {
        return count;
    }

    public int getNumber() {
        return number;
    }

    public void getValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        number = sc.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        count = sc.nextInt();
    }
}