import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("Tyler", 23);
        Student s2 = new Student("Kevin", 25);
        Student s3 = new Student("Kyla", 24);
        Student s4 = new Student("Justin", 18);
        Student s5 = new Student("Nancy", 29);
        Student s6 = new Student("Sydney", 26);

        Student[] students = {s1, s2, s3, s4, s5, s6};

        //mergeSort(students, 0, students.length-1);

        quickSort(students, 0, students.length - 1);

        int search_ix = binarySearch(students, 0, students.length, s4);
        System.out.println(search_ix);

        for(int i = 0; i <students.length; i++) {
            System.out.println(students[i]);
        }


    }

    // Binary Search
    public static <T extends Comparable<T>> int binarySearch(T[] arr, int low, int high, T element) {

        if(low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int comparison = arr[mid].compareTo(element);

        if(comparison == 0)
            return mid;
        else if (comparison < 0)
            return binarySearch(arr, mid+1, high, element);
        else
            return binarySearch(arr, low, mid - 1, element);
        
    }

    // Quick sort
    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {

        if(low >= high)
            return;
        
        int pivot_index = partition(arr, low, high - 1, high);

        quickSort(arr, low, pivot_index - 1);
        quickSort(arr, pivot_index + 1, high);
    }

    private static <T extends Comparable<T>> int partition(T[]arr, int leftMarker, int rightMarker, int last_index){
        int low = leftMarker;
        while(leftMarker <= rightMarker) {
            while(leftMarker < last_index && arr[leftMarker].compareTo(arr[last_index]) < 0) {
                leftMarker++;
            }
            while(rightMarker >= low && arr[rightMarker].compareTo(arr[last_index]) >= 0 ) {
                rightMarker--;
            }

            if(leftMarker <= rightMarker) {
                swap(arr, leftMarker, rightMarker);
            } 
        }
        swap(arr, last_index, leftMarker);
        return leftMarker;
    }
    private static <T> void swap(T[] arr, int src, int dest) {
        T temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }

    

    // Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] arr, int low, int high) {

        if(low >= high) {
            return;
        }
        
        int mid = low + (high - low) / 2;

        T[] temp = Arrays.copyOf(arr, arr.length);

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, temp, low, mid, high);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] temp, int low, int mid, int high) {

        int left_ix = low; 
        int right_ix = mid+1;

        for(int i = low; i <= high; i++) {
            if(left_ix <= mid && right_ix <= high) {
                if(arr[left_ix].compareTo(arr[right_ix]) <= 0) {
                    temp[i] = arr[left_ix];
                    left_ix++;
                } else {
                    temp[i] = arr[right_ix];
                    right_ix++;
                }
            } else if(left_ix > mid) {
                temp[i] = arr[right_ix];
                right_ix++;
            } else {
                temp[i] = arr[left_ix];
                left_ix++;
            }
        }
        
        for(int i = low; i <= high; i++){
            arr[i] = temp[i];
        }
    }
}

    


    

