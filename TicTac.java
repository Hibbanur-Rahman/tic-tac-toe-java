
import java.util.Scanner;

class TicTac {
    char arr[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    char p1[] = new char[5];
    char p2[] = new char[5];
    char win[][] = { { '1', '2', '3' },
            { '4', '5', '6' },
            { '7', '8', '9' },
            { '1', '4', '7' },
            { '2', '5', '8' },
            { '3', '6', '9' },
            { '1', '5', '9' },
            { '3', '5', '7' } };

    void designTicTac() {
        System.out.println(" " + arr[0][0] + " |  " + arr[0][1] + "| " + arr[0][2]);
        System.out.println("---|---|---");
        System.out.println(" " + arr[1][0] + " |  " + arr[1][1] + "| " + arr[1][2]);
        System.out.println("---|---|---");
        System.out.println(" " + arr[2][0] + " |  " + arr[2][1] + "| " + arr[2][2]);
    }

    void mapValue(char val, char choice) {
        if (val == '1') {
            arr[0][0] = choice;
        } else if (val == '2') {
            arr[0][1] = choice;
        } else if (val == '3') {
            arr[0][2] = choice;
        } else if (val == '4') {
            arr[1][0] = choice;
        } else if (val == '5') {
            arr[1][1] = choice;
        } else if (val == '6') {
            arr[1][2] = choice;
        } else if (val == '7') {
            arr[2][0] = choice;
        } else if (val == '8') {
            arr[2][1] = choice;
        } else if (val == '9') {
            arr[2][2] = choice;
        }
    }
    int[] findIndex(char val){
        if (val == '1') {
            return new int[] {0,0};
        } else if (val == '2') {
            return new int[] {0,1};
        } else if (val == '3') {
            return new int[] {0,2};
        } else if (val == '4') {
            return new int[] {1,0};
        } else if (val == '5') {
            return new int[] {1,1};
        } else if (val == '6') {
            return new int[] {1,2};
        } else if (val == '7') {
            return new int[] {2,0};
        } else if (val == '8') {
            return new int[] {2,1};
        } else if (val == '9') {
            return new int[] {2,2};
        }
        else{
            System.out.println("value is invalid");
            return new int[] {-1,-1};
        }
    }
    boolean checkEmpty(char val) {
        int[] z=findIndex(val);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (arr[z[0]][z[1]]=='X' || arr[z[0]][z[1]]=='O') {
                    System.out.println("\nthe value is already taken in this box");
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkWin(char player[]) {
        for (int i = 0; i < 8; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (player[k] == win[i][j]) {
                        count++;
                        if (count == 3) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        TicTac t1 = new TicTac();
        System.out.println("Player-1:X\nPlayer-1:O");
        t1.designTicTac();
        System.out.println("Game is started");
        int i = 0;
        int pl1 = 0;
        int pl2 = 0;
        boolean win_flag=true;
        while (win_flag) {
            boolean flag1 = true;
            boolean flag2 = true;
            if (i % 2 == 0) {
                while (flag1) {
                    System.out.print("Enter \"X\" for Player-1: ");
                    t1.p1[pl1] = sc1.next().charAt(0);
                    if (t1.checkEmpty(t1.p1[pl1])) {
                        t1.mapValue(t1.p1[pl1], 'X');
                        t1.designTicTac();
                        pl1++;
                        if (t1.checkWin(t1.p1)) {
                            System.out.println("Player-1 win");
                            win_flag=false;
                        }
                        flag1 = false;
                    }
                }
            } else {
                while (flag2) {
                    System.out.print("Enter \"O\" for Player-2: ");
                    t1.p2[pl2] = sc1.next().charAt(0);
                    if (t1.checkEmpty(t1.p2[pl2])) {
                        t1.mapValue(t1.p2[pl2], 'O');
                        t1.designTicTac();
                        pl2++;
                        if (t1.checkWin(t1.p2)) {
                            System.out.println("Player-2 win");
                            win_flag=false;
                        }
                        flag2=false;
                    }
                    
                }
            }
            i++;
            if (i == 9) {
                System.out.println("the game is draw");
                break;
            }
        }
    }
}