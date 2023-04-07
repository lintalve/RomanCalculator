import java.util.ArrayList;

public class TestArray {
    public static void main(String[] args){
        int[][] array = {{1, 3, 4, 5}, {3, 5, 1}, {2, 5}, {4, 7, 1, 3, 2}};
        for(int i=0; i< array.length; i++){
            for(int j=0; j<array[i].length; j++){
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.size());
    }
}
