import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//사탕 게임

public class test_3085 {
    public static char [][] matrix;
    public static ArrayList<Integer> maxList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> max = new ArrayList<>();

        matrix = new char[m][m];

        for(int i =0; i<m; i++){
            String s = br.readLine();

            for (int j=0; j<m; j++){
                matrix[i][j] = s.charAt(j);
            }
        }

        //서로 다른 색의 인접한 두곳 찾기
        for(int i=0; i<m; i++){
            for(int j=0; j<m-1; j++){
                swap(i, j, i, j + 1);
                max.add(findMax(m));
                swap(i, j, i, j+1) ; // 원상복귀
            }
        }

        //열
        for (int j =0; j<m; j++){
            for(int i=0; i<m-1; i++){
                swap(i, j, i + 1, j);
                max.add(findMax(m));
                swap(i, j, i+1 , j); // 원상복귀
            }

        }
        int result = Collections.max(max);
        System.out.println(result);
    }
    public static void swap(int i1, int j1, int i2, int j2) {
        char tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
    public static int findMax(int m){
        maxList.clear(); //이전 값들을 모두 지우고 새로운 값을 저장함.

        //행에서 최대값 찾기
        for (int i =0; i<m; i++){
            int cnt = 1;
            for(int j=0; j<m-1; j++){
                if(matrix[i][j] == matrix[i][j+1]){
                    cnt ++;
                }else {
                    maxList.add(cnt);
                    cnt = 1;  // 초기화
                }
            }
            maxList.add(cnt);
        }

        //열에서 최대값 찾기
        for (int j =0; j<m; j++){
            int cnt = 1;
            for(int i=0; i<m-1; i++){
                if(matrix[i][j] == matrix[i+1][j]){
                    cnt ++;
                }else {
                    maxList.add(cnt);
                    cnt = 1;  // 초기화
                }
            }
            maxList.add(cnt);
        }
        int MAX = Collections.max(maxList);
        return  MAX;
    }
}
