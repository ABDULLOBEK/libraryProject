package org.example.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetAction {
    public static int  getAction(){
        try {
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter action: ");
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Enter only numbers!");
            return getAction();
        }
    }
}
