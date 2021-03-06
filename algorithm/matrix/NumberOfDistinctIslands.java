package matrix;

import java.util.*;

/**
 * @author cicidi on 5/26/19
 * Lintcode 860. Number of Distinct Islands
 * url https://www.lintcode.com/problem/number-of-distinct-islands/description
 */
public class NumberOfDistinctIslands {
// public class Solution {
//     /**
//      * @param grid: a list of lists of integers
//      * @return: return an integer, denote the number of distinct islands
//      */
//     public int numberofDistinctIslands(int[][] grid) {
//         // write your code here

//         if (grid.length==0)
//             return 0;
//         int row=grid.length;
//         int col=grid[0].length;
//         int[][] visited=new int[row][col];

//         // GeoSort sorter=new GeoSort();
//         Set<String> set=new HashSet<>();
//         for (int x=0;x<col;x++){
//             for(int y=0;y<row;y++){
//                 if(visited[y][x]!=1){
//                     StringBuilder record=new StringBuilder();
//                     record=traverse(x,y,row,col,x,y,record,visited,grid);
//                     if(record.length()!=0)
//                         set.add(record.toString());
//                 }
//             }
//         }
//         return set.size();
//     }

//     StringBuilder traverse(int x, int y,int row, int col,int x_o,int y_o,StringBuilder record,int[][]visited,int [][] grid){


//         if(x<0||x>=col||y<0||y>=row||grid[y][x]==0||visited[y][x]==1){
//             return record;
//         }
//         visited[y][x]=1;

//         record.append(""+(x-x_o)+""+(y-y_o));
//         record.append(traverse(x+1,y,row,col,x_o,y_o,record,visited,grid));
//         record.append(traverse(x,y+1,row,col,x_o,y_o,record,visited,grid));
//         record.append(traverse(x-1,y,row,col,x_o,y_o,record,visited,grid));
//         record.append(traverse(x,y-1,row,col,x_o,y_o,record,visited,grid));

//         return record;
//     }

// }


// Solution 2

    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */

    /*
     * Steps:
     * 0. Can be solved by BFS try it later
     * 1. This question is solved by DFS, use recursion to find all neighbour. and get
     * neighbour relative location to the original location
     * 2. add to the list, the list is represent as the island
     *
     * */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here

        if (grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        GeoSort sorter = new GeoSort();
        Set<List<GeoType>> set = new HashSet<>();
        for (int x = 0; x < col; x++) {
            for (int y = 0; y < row; y++) {
                if (visited[y][x] != 1) {
                    // question 这个地方是不是还应该加上grid[x][y]==1
                    // 因为没有必要起点在0的位置开始走一遍
                    // notice 测试过了，确实应该应该家grid[y][x]==1  这里x 代表纵轴 row x 代表横轴
                    List islands = new ArrayList<GeoType>();
                    traverse(x, y, row, col, x, y, islands, visited, grid);
                    Collections.sort(islands, sorter);
                    if (islands.size() != 0)
                        set.add(islands);
                }
            }
        }
//        for (List<GeoType> list : set) {
//            for (GeoType geoType : list) {
        // System.out.printf("x %d,y %d \n", geoType.x,geoType.y);
//            }
        // System.out.println("====");
//        }
        return set.size();
    }

    List<GeoType> traverse(int x, int y, int row, int col, int x_o, int y_o, List<GeoType> list, int[][] visited, int[][] grid) {
        if (x < 0 || x >= col || y < 0 || y >= row || grid[y][x] == 0 || visited[y][x] == 1) {
            return list;
        }
        visited[y][x] = 1;
        // important 这里要用x-x_original
        //  因为是求不同的形状， 要把岛上每个点相对于原来的点相对位置保留并对比，
        //  如果不用original，那么在不同位置但是形状相同的岛就这个case 就不适用了

        list.add(new GeoType(x - x_o, y - y_o));
        traverse(x + 1, y, row, col, x_o, y_o, list, visited, grid);
        traverse(x, y + 1, row, col, x_o, y_o, list, visited, grid);
        traverse(x - 1, y, row, col, x_o, y_o, list, visited, grid);
        traverse(x, y - 1, row, col, x_o, y_o, list, visited, grid);

        return list;
    }

}

class GeoSort implements Comparator<GeoType> {
    public int compare(GeoType a, GeoType b) {
        if (a.x == b.x) {
            return a.y - b.y;
        } else {
            return a.x - b.x;
        }
    }
}

class GeoType {
    int x;
    int y;

    public GeoType(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        GeoType geoType = (GeoType) o;
        return x == geoType.x &&
                y == geoType.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
