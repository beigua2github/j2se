package runtime;

import java.io.*;

public class ExecDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec(new String[]{"/bin/bash", "-c", "jps -l"});
        InputStream inputStream = exec.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(System.out::println);
        bufferedReader.close();
        inputStream.close();
    }
}
