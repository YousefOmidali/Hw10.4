import java.io.File;

public class Threads extends Thread {
    File file;
    SizeGetter sizeGetter;
    long length = 0;

    public Threads(File files, SizeGetter sizeGetter) {
        this.file = file;
        this.sizeGetter = sizeGetter;
    }

    @Override
    public void run() {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += sizeGetter.getFolderSize(file);
            }

        }

    public double getWordCount() {
        return ((double) length/ (1024 * 1024));
    }

}
