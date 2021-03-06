package binary_search;

/*
 * tag
 * lintcode
 * url
 * leetcode
 * url
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4, 1, 12, 3, 4, 31, 31, 21, 29};
        mergeSort(actual, actual.length);
        for (int i = 0; i < actual.length; i++) {
            println(actual[i]);
        }
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void mergeSort(int[] A, int k) {
        if (k < 2) return; //  一直recursion 直到K 小于 2 的时候才停止，然后 才可以调用merge

        int mid = k / 2;

        int[] left = new int[mid];   //notice 这里面从中间把左边，右边分别创建了不同的新的array
        int[] right = new int[k - mid];
        setValue(A, left, 0, mid);  //notice 正式因为前面是新建的array 我们这里才可以从index  0， 开始，
        setValue(A, right, mid, k);
        mergeSort(left, left.length);
        mergeSort(right, right.length);
        merge(A, left, right, left.length, right.length); // notice recursion 到底部，真正的第一次的merge 两边分别只有一个element

    }

    // merge 的方法 有两步
    // 1。 从两个array 分别拿出第一个进行对比
    // 2。 那个小，把哪一个的当前element拿出来
    // 3。 index ++
    // 4. 最后如果某一个array 全部走完了，把另一个array的尾巴全部注入进来
    private static void merge(int[] A, int[] left, int[] right, int leftLength, int rightLength) {
        int l = 0, r = 0, index = 0;
        while (l < leftLength && r < rightLength) {
            if (left[l] <= right[r]) {
                A[index++] = left[l++];
            } else {
                A[index++] = right[r++];
            }
        }
        while (l < leftLength) {
            A[index++] = left[l++];
        }
        while (r < rightLength) {
            A[index++] = right[r++];
        }
    }

    // create new array from start to end
    public static void setValue(int[] A, int[] SUB, int start, int end) {
        for (int i = start; i < end; i++) {
            SUB[i - start] = A[i];  // notice 这个地方比较巧妙
        }
    }
}


//    public static void mergeSort(int[] A, int length) {
//        if (length < 2) return;
//        int mid = length / 2;
//        int[] left = new int[mid];
//        int[] right = new int[length - mid];
//        setValue(A, left, 0, mid);
//        setValue(A, right, mid, length);
//        mergeSort(left, mid);
//        mergeSort(right, length - mid);
//        merge(A, left, right, mid, length - mid);
//    }
//
//    public static void merge(int[] A, int[] left, int[] right, int leftLength, int rightLength) {
//        int l = 0, r = 0, index = 0;
//        while (l < leftLength && r < rightLength) {
//            if (left[l] <= right[r]) {
//                A[index++] = left[l++];
//            } else {
//                A[index++] = right[r++];
//            }
//        }
//        while (l < leftLength) {
//            A[index++] = left[l++];
//        }
//        while (r < rightLength) {
//            A[index++] = right[r++];
//        }
//    }
//
//    public static void setValue(int[] A, int[] SUB, int start, int end) {
//        for (int i = start; i < end; i++) {
//            SUB[i - start] = A[i];
//        }
//    }