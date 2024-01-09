import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class test_2581 {
  public static ArrayList<Integer> prime = new ArrayList<>();
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = Integer.parseInt(br.readLine());
    int B = Integer.parseInt(br.readLine());

    if(A==1){
      A=2;
    }

    //2부터 나눴을 때 나머지가 0이면 제외
    while(A <= B){
      int check = -1;

      for(int i = 2; i < A; i++){
        if(A % i == 0) {
          check ++;
          break;
        }
      }
      if(check == -1){
        prime.add(A);
      }
      A++;
    }
    result();
  }
  public static void result(){
    int result = 0;

    if(prime.size()==0){
      System.out.println(-1);
    }else{
      for(Integer sum : prime){
        result += sum;
      }
      System.out.println(result);
      System.out.println(prime.get(0));
    }
  }

}
