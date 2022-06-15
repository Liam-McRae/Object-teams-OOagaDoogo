public class testing {
    public static void main(String[] args) {
        a[] arr = new a[4];
        arr[0] = new a();
        arr[1] = new a1();
        arr[2] = new a2();
        arr[3] = new a3();

        for(int i = 0; i < arr.length; i++) {
            arr[i].print();
            arr[i].printnum(2);
        }
    }
}