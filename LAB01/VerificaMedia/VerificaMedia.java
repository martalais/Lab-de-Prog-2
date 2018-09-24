/**
* Laboratório de Programação 2 - Lab 1
*
* @author Marta Laís de Macedo Dantas - 116110580
*/

import java.util.Scanner;

public class VerificaMedia {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        double media = (num1 + num2) / 2.0;

        if (media >= 7.0) {
            System.out.println("pass: True!");
        } 
        else{
            System.out.println("pass: False!");

        }
    }
}