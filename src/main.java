import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class main {
    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<>();
        SizeGetter sizeGetter = null;
        Scanner scanner = new Scanner(System.in);
        long size;
        System.out.println("Enter file url");
        File file1 = new File(scanner.nextLine());
        File[] fileAsArr = file1.listFiles();
        for (File e : fileAsArr) {
            files.add(e);
        }
        System.out.println("How many file is there? ");
        int qty = scanner.nextInt();
        ExecutorService e = Executors.newFixedThreadPool(qty);
        e.submit(new Runnable() {
            @Override
            public void run() {
                long length = 0;

                if (files.get(0).isFile()) {
                    length += files.get(0).length();
                    files.remove(0);
                } else {
                    length += sizeGetter.getFolderSize(files.get(0));
                }
                System.out.println(length);


            }
        });

    }
}
