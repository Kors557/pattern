package Strategy;

public class DownloadLinuxStrategy implements Strategy {
    public void download(String file) {
        System.out.println("linux download: " + file);
    }
}
