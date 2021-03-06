package sort.Based_Algorithm;

public class QuickSort {


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[]{4,2,5,3,12};
        QuickSort.quickSort(a, 5);
        for (int i : a) {
            System.out.println(i);
        }
    }


    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    // the choice of pivot can be further optimized.
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] > pivot) { // 此处的条件决定了是顺序还是倒序排
                if (i == j) {
                    ++i; // i == j的情况下，不交换，较少系统CPU运行
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
//        System.out.println(pivot);
//        System.out.println("i=" + i);
        return i;
    }

}
