/**
 * Created by linna on 2017/6/18.
 */
//        int n=10;
//        double v=37.618,u=0.422;
//        double[] c = {72.865,126.767,202.680,106.102,99.516,134.418,167.952,173.646,120.210,136.571};
//        double[] d ={2.941,3.664,7.363,4.161,0.246,8.046,5.521,7.473,7.178,5.649};
import java.math.BigDecimal;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double v = sc.nextDouble();
        double u = sc.nextDouble();
        double[] c=new double[n];
        double[] d=new double[n];
        for(int i = 0; i < n; i++){
            c[i]=sc.nextDouble();
        }
        for(int i = 0; i < n; i++){
            d[i]=sc.nextDouble();
        }
        double result=0;
        for (int i=0;i<n;i++)
        {
            double temp=0;
            for (int j=1;j<=n;j++)
            {
                temp=  (temp+u/(c[i]-(j-1)*d[i]-v));
            }
            result=result+temp;
        }
        BigDecimal  b = new BigDecimal( result);
        System.out.println(b.setScale( 3,BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
