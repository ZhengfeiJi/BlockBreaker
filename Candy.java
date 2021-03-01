package hard;

public class Candy {
public int candy(int[] ratings) {
	int len = ratings.length;
	if(len < 1)
		return len;
        int[] candies = new int[len];
        candies[0] = 1;
        for(int i = 1 ; i < len ;i++)
        {
        	candies[i] = ratings[i]>ratings[i-1] ? candies[i-1]+1 : 1;
        }
        int sum = candies[len-1];
        for(int i = len -1 ; i > 0 ;i--)
        {
        	if(ratings[i] <ratings[i-1])
        		candies[i-1] = Math.max(candies[i-1], candies[i]+1);
        	sum += candies[i-1];
        }
        return sum;
    }
}
