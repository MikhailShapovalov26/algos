public class Main {
    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    private static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length;
        }
        if (prices[prices.length - 1] < money) {
            return 0;
        }

        int left = 0;
        int right = prices.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (prices[middle] == money) {
                if (prices[middle - 1] ==  money && prices[middle + 1] ==  money)  {
                    for (int i = prices[middle + 1]; i < prices.length; i++) {
                        if (prices[i] >  money){
                            return prices.length - i;
                        }
                    }
                } else {
                    return prices.length - middle - 1;
                }

            } else if (prices[middle] > money) { //26
                right = middle - 1;
                if (prices[right] < money) {
                    return right - 1;
                }

            } else if (prices[middle] < money) {
                left = middle + 1;
                if (prices[left] > money) {
                    return prices.length - left;
                }
            }
        }
        return 0;
    }
}