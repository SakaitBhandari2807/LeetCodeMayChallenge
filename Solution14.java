import java.util.Arrays;
import java.util.Comparator;

class Solution14 {
    public String frequencySort(String sequence){
     StringBuilder sorted_sequence = new StringBuilder();
     Node frequency_array[] = new Node[123];

     for(int i=0;i<frequency_array.length;i++) frequency_array[i] = new Node();

     for(int i=0;i<sequence.length();i++) {
         final Node node;
         node = frequency_array[sequence.charAt(i)];
         node.frequency++;
         node.ch = sequence.charAt(i);
     }

     Arrays.sort(frequency_array, new Comparator<Node>() {
         @Override
         public int compare(Node o1, Node o2) {
             return o2.frequency-o1.frequency;
         }
     });


     for(int i=0;i<frequency_array.length;i++){
         Node node = frequency_array[i];
         if(node.frequency == 0) break;
         for(int j=0;j<node.frequency;j++)
            sorted_sequence.append(node.ch);
     }

     return sorted_sequence.toString();
    }

    public static void main(String args[]){
        Solution14 sol = new Solution14();
        System.out.println(sol.frequencySort("aaAbbcc"));
        System.out.println(sol.frequencySort("tree"));
        System.out.println(sol.frequencySort("cccaaa"));
        System.out.println(sol.frequencySort("Aabb"));
        System.out.println(sol.frequencySort("2a554442f544asfasssffffasss"));
        System.out.println(sol.frequencySort("his s he a ha he  ha ae"));
    }

}

class Node{
    int frequency;
    char ch;
}
