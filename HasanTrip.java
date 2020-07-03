/*Hasan and Trip
Send Feedback
Hasan has finally finished his final exams and he decided to go in a trip among cities in Syria.
There are N cities in Syria and they are numbered from 1 to N, each city has coordinates on plane, i-th city is in (Xi, Yi).
Hasan is in first city and he wants to visit some cities by his car in the trip but the final destination should be N-th city and the sequence of cities he will visit should be increasing in index (i.e. if he is in city i he can move to city j if and only if i < j ).
Visiting i-th city will increase Hasan's happiness by Fi units (including first and last cities), also Hasan doesn't like traveling too much, so his happiness will decrease by total distance traveled by him.
Help Hasan by choosing a sequence of cities to visit which maximizes his happiness.
Input format:
First line contain integer N.
Next N lines contains three integers each, i-th line contains coordinates of i-th city Xi, Yi and Fi.
Output format:
Output one number rounded to 6 digits after floating point, the maximum possible happiness Hasan can get. Note: If answer is 2 print 2.000000
Constraints:
1 <= N <= 3,000
0 <= Xi, Yi, Fi <= 100,000
Sample Input
3
0 0 1
3 1 1
6 0 9
Sample Output
4.675445*/

import java.util.*;
import java.io.*;
import java.util.stream.*;
class City{
	long px,py;
    long f;
    City(long a[]){
		px = a[0];
        py = a[1];
        f = a[2];
    }
}

public class HasanTrip{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        City cities[] = new City[n];
        for(int i=0;i<n;i++){
			cities[i] = new City(Arrays.stream(br.readLine().split(" ")).mapToLong(
            Long::parseLong).toArray());
        }
        double ans = dpSol(cities);
        System.out.format("%.6f",ans);
	}
    static double dpSol(City cities[]){
		int n = cities.length;
        double dp[] = new double[n];
        Arrays.fill(dp,-1e9);
        dp[0] = cities[0].f;
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i],dp[0]+cities[i].f-getDist(0,i,cities));
			for(int j=i+1;j<n;j++){
				dp[j] = Math.max(dp[j],dp[i]+cities[j].f-getDist(i,j,cities));    
            }
        }
        return dp[n-1];
    }
   static double getDist(int i,int j,City cities[]){
		return Math.sqrt((cities[i].px-cities[j].px)*(cities[i].px-cities[j].px)+
                        (cities[i].py-cities[j].py)*(cities[i].py-cities[j].py));
   }

}
