import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockSpanner {
    Stack<Integer> stack;
    List<Integer> stocks;

    public StockSpanner() {
        stack = new Stack<Integer>();
        stocks =  new ArrayList<Integer>();
    }

    public int next(int price) {
        stocks.add(price);
        if(stocks.size() == 1) {
            stack.push(0);
            return 1;
        }
        else
        {
            int i=stocks.size()-1;
            while(!stack.isEmpty() && stocks.get(i)>=stocks.get(stack.peek())) stack.pop();
            int value=0;
            if(stack.isEmpty()) value = i+1;
            else value = stocks.size()-1-stack.peek();
            stack.push(stocks.size()-1);
            return value;
        }
    }
}


class Solution11{
    public static void main(String args[]){
        StockSpanner span = new StockSpanner();
        System.out.println(span.next(100));
        System.out.println(span.next(80));
        System.out.println(span.next(60));
        System.out.println(span.next(70));
        System.out.println(span.next(60));
        System.out.println(span.next(75));
        System.out.println(span.next(85));
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
