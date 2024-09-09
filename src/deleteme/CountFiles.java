package deleteme;
import java.io.File;
import java.io.IOException;

public class CountFiles {

    public static void main(String[] args) {
        String directoryPath = "D:\\git\\DataStructuresAndAlgorithmsWithJava";
        int javaCount = 0;
        int classCount = 0;

        try {
            File directory = new File(directoryPath);
            countFilesRecursively(directory, ".java", ".class", javaCount, classCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of .java files: " + javaCount);
        System.out.println("Number of .class files: " + classCount);
    }

    private static void countFilesRecursively(File directory, String javaExtension, String classExtension, int javaCount, int classCount) throws IOException {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    countFilesRecursively(file, javaExtension, classExtension, javaCount, classCount);
                }
            }
        } else {
            String fileName = directory.getName();
            if (fileName.endsWith(javaExtension)) {
                javaCount++;
            } else if (fileName.endsWith(classExtension)) {
                classCount++;
            }
        }
    }
}