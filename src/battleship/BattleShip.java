/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author alfath
 */
public class BattleShip{

    private final Point L[];
    private final Point LR[];
    private final Point T[];
    private final Point I[];
    private final LinkedList<Point> cek = new LinkedList<>();
    Random rand = new Random();

    public BattleShip() {
        L = new Point[6];
        LR = new Point[4];
        T = new Point[4];
        I = new Point[2];
    }

    public LinkedList<Point> getCek() {
        return cek;
    }
    
    
    public void Generate() {
        if(rand.nextInt()%2==0){
            L();
        }else{
            L2();
        }
        if(rand.nextInt()%2==0){
            LR();
        }else{
            LR2();
        }
        if(rand.nextInt()%2==0){
            T();
        }else{
            T2();
        }
        if(rand.nextInt()%2==0){
            I();
        }else{
            I2();
        }
    }

    private void L() {
        int x = rand.nextInt(6)+3;
        int y = rand.nextInt(7);
        L[0] = new Point(x, y);
        cek.add(L[0]);
        for (int i = 1; i <= 3; i++) {
            x--;
            L[i] = new Point(x, y);
            cek.add(L[i]);
        }
        for (int i = 4; i <= 5; i++) {
            y++;
            L[i] = new Point(x, y);
            cek.add(L[i]);
        }
    }
    private void L2() {
        int x = rand.nextInt(6)+3;
        int y = rand.nextInt(7);
        L[0] = new Point(x, y);
        cek.add(L[0]);
        for (int i = 1; i <= 2; i++) {
            y++;
            L[i] = new Point(x, y);
            cek.add(L[i]);
        }
        for (int i = 3; i <= 5; i++) {
            x--;
            L[i] = new Point(x, y);
            cek.add(L[i]);
        }
        
    }

    public void printL() {
        System.out.println("L");
        for (int i = 0; i < L.length; i++) {
            Point temp = L[i];
            System.out.println(temp.getX() + "," + temp.getY());
        }
    }

    private void LR() {
        boolean temp = true;
        Point s = new Point();
        while (temp) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(6);
            LR[0] = new Point(x, y);
            for (int i = 1; i <= 3; i++) {
                y++;
                LR[i] = new Point(x, y);
            }

            int i = 0, j;
            boolean sama = false;
            while (i < LR.length && sama == false) {
                j = 0;
                while (j < cek.size() && sama == false) {
                    if (s.EQ(LR[i], cek.get(j))) {
                        sama = true;
                    }
                    j++;
                }
                i++;
            }

            if (sama == false) {
                temp = false;
                for (int k = 0; k < LR.length; k++) {
                    cek.add(LR[k]);
                }
            }
        }
    }
    private void LR2() {
        boolean temp = true;
        Point s = new Point();
        while (temp) {
            int y = rand.nextInt(9);
            int x = rand.nextInt(6)+3;
            LR[0] = new Point(x, y);
            for (int i = 1; i <= 3; i++) {
                x--;
                LR[i] = new Point(x, y);
            }

            int i = 0, j;
            boolean sama = false;
            while (i < LR.length && sama == false) {
                j = 0;
                while (j < cek.size() && sama == false) {
                    if (s.EQ(LR[i], cek.get(j))) {
                        sama = true;
                    }
                    j++;
                }
                i++;
            }

            if (sama == false) {
                temp = false;
                for (int k = 0; k < LR.length; k++) {
                    cek.add(LR[k]);
                }
            }
        }
    }

    public void printLR() {
        System.out.println("LR");
        for (int i = 0; i < LR.length; i++) {
            Point temp = LR[i];
            System.out.println(temp.getX() + "," + temp.getY());
        }
    }

    private void T() {
        boolean temp = true;
        Point s = new Point();
        while (temp) {
            int x = rand.nextInt(8) + 1;
            int y = rand.nextInt(7);
            T[0] = new Point(x, y);
            for (int i = 1; i <= 3; i++) {
                y++;
                T[i] = new Point(x, y);
                if (i == 1) {
                    i++;
                    x--;
                    T[i] = new Point(x, y);
                    x++;
                }

            }
            int i = 0, j;
            boolean sama = false;
            while (i < T.length && sama == false) {
                j = 0;
                while (j < cek.size() && sama == false) {
                    if (s.EQ(T[i], cek.get(j))) {
                        sama = true;
                    }
                    j++;
                }
                i++;
            }

            if (sama == false) {
                temp = false;
                for (int k = 0; k < T.length; k++) {
                    cek.add(T[k]);
                }
            }
        }
    }
    private void T2() {
        boolean temp = true;
        Point s = new Point();
        while (temp) {
            int x = rand.nextInt(8) + 1;
            int y = rand.nextInt(7);
            T[0] = new Point(x, y);
            for (int i = 1; i <= 3; i++) {
                y++;
                T[i] = new Point(x, y);
                if (i == 1) {
                    i++;
                    x++;
                    T[i] = new Point(x, y);
                    x--;
                }

            }
            int i = 0, j;
            boolean sama = false;
            while (i < T.length && sama == false) {
                j = 0;
                while (j < cek.size() && sama == false) {
                    if (s.EQ(T[i], cek.get(j))) {
                        sama = true;
                    }
                    j++;
                }
                i++;
            }

            if (sama == false) {
                temp = false;
                for (int k = 0; k < T.length; k++) {
                    cek.add(T[k]);
                }
            }
        }
    }

    public void printT() {
        System.out.println("T");
        for (int i = 0; i < T.length; i++) {
            Point temp = T[i];
            System.out.println(temp.getX() + "," + temp.getY());
        }
    }

    private void I() {
        boolean temp = true;
        Point s = new Point();
        while (temp) {
            int x = rand.nextInt(8) + 1;
            int y = rand.nextInt(9);
            I[0] = new Point(x, y);
            x--;
            I[1] = new Point(x, y);
            int i = 0, j;
            boolean sama = false;
            while (i < I.length && sama == false) {
                j = 0;
                while (j < cek.size() && sama == false) {
                    if (s.EQ(I[i], cek.get(j))) {
                        sama = true;
                    }
                    j++;
                }
                i++;
            }

            if (sama == false) {
                temp = false;
                for (int k = 0; k < I.length; k++) {
                    cek.add(I[k]);
                }
            }
            
        }
    }
    private void I2() {
        boolean temp = true;
        Point s = new Point();
        while (temp) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(8);
            I[0] = new Point(x, y);
            y++;
            I[1] = new Point(x, y);
            int i = 0, j;
            boolean sama = false;
            while (i < I.length && sama == false) {
                j = 0;
                while (j < cek.size() && sama == false) {
                    if (s.EQ(I[i], cek.get(j))) {
                        sama = true;
                    }
                    j++;
                }
                i++;
            }

            if (sama == false) {
                temp = false;
                for (int k = 0; k < I.length; k++) {
                    cek.add(I[k]);
                }
            }
            
        }
    }

    public void printI() {
        System.out.println("I");
        for (int i = 0; i < I.length; i++) {
            Point temp = I[i];
            System.out.println(temp.getX() + "," + temp.getY());
        }
    }

}
