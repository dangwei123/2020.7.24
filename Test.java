C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，
市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式（一组测试用例可能包含多组数据，请注意处理）？
第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
import java.util.Scanner;
public class Main{
    public static int numOfMethod(int[] arr,int n,int t,int c){
        if(c>n||n==0) return 0;
        int[] preSum=new int[n];
        preSum[0]=arr[0];
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+arr[i];
        }
        if(preSum[n-1]<=t) return n-c+1;
        int ret=0;
        if(preSum[c-1]<=t) ret++;
        for(int i=c;i<n;i++){
            if(preSum[i]-preSum[i-c]<=t)
                ret++;
        }
        return ret;
    }
	
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int t=sc.nextInt();
            int c=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int ret=numOfMethod(arr,n,t,c);
            System.out.println(ret);
        }
    }
}

