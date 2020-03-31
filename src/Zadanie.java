import java.util.Scanner;
import java.util.Arrays;

public class Zadanie {

    static String Function_1(String sDNA) {
        StringBuilder sb = new StringBuilder();
        int n=sDNA.length();
        for ( int i=0; i<n; i++){
            char sign = sDNA.charAt(i);
            if(sign =='T') sb.append('U');
            else sb.append(sign);
        }
        String sRNA = sb.toString();
        // String sRNA = sDNA.replace("T", "U");
        return sRNA;
    }

    static String Function_2(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        char tmp;
        for (int i = 0; i < n; i++) {
            char sign = s.charAt(i);
            if (sign == 'A') sb.append('T');
            else if (sign == 'T') sb.append('A');
            else if (sign == 'G') sb.append('C');
            else sb.append('G');
        }

        String newS = sb.toString();
        String actualNewS = sb.reverse().toString();
        return actualNewS;
    }


    static int[] Function_3(String s){
        int count_A=0;
        int count_C=0;
        int count_G=0;
        int count_T=0;

        int n=s.length();
        for(int i=0; i<n; i++){

            char sign = s.charAt(i);
            if(sign =='A') count_A=count_A+1;
            else if(sign =='C') count_C=count_C+1;
            else if(sign =='G') count_G=count_G+1;
            else count_T=count_T+1;

        }
        int [] tableResult = new int[] { count_A, count_C, count_G, count_T };
        return tableResult;

    }
    static String Function_4(String s1, String s2){
        String Short;
        String Long;
        if(s1.length()>s2.length()) {
            Short = s2;
            Long = s1;

        }else{
            Short = s1;
            Long = s2;
        }
        for( int cut=0; cut<Short.length(); cut++){
            for( int j=0; j<=cut; ++j) {
                int cutFront = j;
                int cutBack = cut-j;
                String Substring = Short.substring(cutFront, Short.length()-cutBack);
                int position = Long.indexOf(Substring);
                if(position != -1){
                    return Substring;
                }

            }
        }
        return "";
    }
    static String Function_5(String a, String b) {

        int m = a.length();
        int n = b.length();

        if(m==0 || n == 0)
            return "";

        int[][] c = new int[m+1][n+1];

        for(int i=1; i<=m; ++i)
            for(int j=1; j<=n; ++j)
                if(a.charAt(i-1) == b.charAt(j-1))
                    c[i][j] = c[i-1][j-1]+1;
                else
                    c[i][j] = Math.max(c[i-1][j], c[i][j-1]);

        //int maxlen = c[m][n];

        return backtrack(c, a, b, m, n);
    }

    private static String backtrack(int[][] c, String x, String y, int i, int j) {
        if(i==0 || j == 0)
            return "";
        if(x.charAt(i-1) == y.charAt(j-1))
            return backtrack(c, x, y, i-1, j-1) + x.charAt(i-1);
        if(c[i][j-1] > c[i-1][j])
            return backtrack(c, x, y, i, j-1);
        else
            return backtrack(c, x, y, i-1, j);
    }




    public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);
        //String sequence;
        //System.out.print("Enter the sequence: " );
        //sequence = scan.next();
        //System.out.println("Sekwencja RNA: "+Function_1("ATGGACAATTAA"));
        //System.out.println("Komplementarna i odwrocona sekwencja: "+Function_2("ATGGACAATTAA"));
        int[] score = Function_3("ATGGACAATTAA");
        String resultString = Arrays.toString(score);
       System.out.println(resultString);
        //System.out.println(Function_4("abbacdaktk","kabackt"));
        //System.out.println(Function_5("abbacdaktk","kabackt"));


    }
}


