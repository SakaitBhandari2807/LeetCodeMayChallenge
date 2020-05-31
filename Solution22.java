import java.util.*;

class Solution22 {
    public int[][] kClosest(int[][] points, int K) {
        // float distance_array[] = new int[points.length];
        ArrayList<Point> points_data = new ArrayList<Point>();
        int output_arr[][] = new int[K][2];

        for(int i=0;i<points.length;i++){
            // distance_array[i] = Math.sqrt((points[i][0])+(points[i][1]));
            Point p = new Point(points[i][0],points[i][1],Math.sqrt((points[i][0]*points[i][0])+(points[i][1]*points[i][1])));
            points_data.add(p);
        }
//        for (Point p:points_data
//
//             ) {
//            System.out.println(p.x+" "+p.y+" "+p.distance_from_origin);
//        }
        Collections.sort(points_data, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(o2.distance_from_origin,o1.distance_from_origin);
            }
        });
//        System.out.println("After sorting");
//        for (Point p:points_data
//        ) {
//            System.out.println(p.x+" "+p.y+" "+p.distance_from_origin);
//        }
        int size = points_data.size()-1;
        int ptr_output = 0;
        while(K>0){
            Point p = points_data.get(size--);
            output_arr[ptr_output][0] = p.x;
            output_arr[ptr_output++][1] = p.y;
            K--;
        }
//        for (int i = 0; i <output_arr.length ; i++) {
//            System.out.println(output_arr[i][0]+" "+output_arr[i][1]);
//        }
//        System.out.println();

        return output_arr;
    }
    public static void main(String args[]){
        Solution22 sol = new Solution22();
        sol.kClosest(new int[][]{ {1,3},{-2,2} },1);
        sol.kClosest(new int[][]{ {3,3},{5,-1},{-2,4} },2);
    }
}

class Point{
    int x,y;
    double distance_from_origin;
    Point(int x,int y,double d){
        this.x = x;
        this.y = y;
        this.distance_from_origin = d;
    }
}
