package behavioral.strategy;

public class DownloadWindownsStrategy implements Strategy {
    public void download(String file) {
        System.out.println("windows download: " + file);
    }
}
