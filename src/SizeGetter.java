import java.io.File;

public class SizeGetter {
    public long getFolderSize(File folder) {
        long length = 0;

        if (folder.isFile()) {
            length += folder.length();
        } else {
            length += getFolderSize(folder);
        }
        return length;
    }
}
