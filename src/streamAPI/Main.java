package streamAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new BufferedReader(new InputStreamReader(System.in, "UTF-8")));
            sc.useDelimiter("\s");
            while (sc.hasNext()) {
                message = sc.nextLine();
            }
            sc.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
