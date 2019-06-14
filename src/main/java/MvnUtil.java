import com.google.common.collect.*;

import java.io.*;
import java.util.*;


/**
 * mvn install:install-file -DgroupId=alipay -DartifactId=alipay-trade-sdk -Dversion=1.0 -Dpackaging=jar -Dfile=F:\支付宝SDKJARlongguo\alipay-trade-sdk.jar
 * <p>
 * mvn install:install-file -Dfile=<path-to-file>
 * mvn install:install-file -Dfile=<path-to-file> -DpomFile=<path-to-pomfile>
 * ---------------------
 *
 * @author
 */
public class MvnUtil {
    public static void main(String[] args) {

        File file = new File("");

        executeMvnInstall(file);
    }

    private static void executeMvnInstall(File dir) {
        Multimap<String, File> map = LinkedListMultimap.create();

        find(map, dir);

        exec(map);
    }

    private static void exec(Multimap<String, File> map) {
        map.keySet().stream().forEach(key -> {
            Collection<File> files = map.get(key);

            if (files.isEmpty()) {
                return;
            } else {
                try {
                    Iterator<File> iterator = files.iterator();
                    String command = null;

                    while (iterator.hasNext()) {
                        File next = iterator.next();
                        if (next.getName().endsWith("pom")) {
                            if (files.size() > 1) {
                                command =  String.format("mvn install:install-file -Dfile=%s -DpomFile=%s", next.getPath().replace(".pom", ".jar"), next.getPath());
                            } else {
                                command = String.format("mvn install:install-file -Dfile=%s -DpomFile=%s", next.getPath(), next.getPath());
                            }
                            System.out.println(command);

                            Process proc = Runtime.getRuntime().exec(command);
                            InputStream stdin = proc.getInputStream();
                            InputStreamReader isr = new InputStreamReader(stdin);
                            BufferedReader br = new BufferedReader(isr);
                            String line = null;
                            System.out.println("<output></output>");
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                            System.out.println("");
                            int exitVal = proc.waitFor();
                            System.out.println("Process exitValue: " + exitVal);
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    private static void find(Multimap<String, File> map, File file) {
        if (file.isDirectory()) {
            for (File tmp : file.listFiles()) {

                find(map, tmp);
            }
        } else {
            if (!file.getName().endsWith(".repositories")
                    && !file.getName().endsWith(".sha1")
                    && !file.getName().endsWith(".xml")
                    && !file.getName().endsWith(".properties")
                    && !file.getName().endsWith(".DS_Store")) {

                    map.put(file.getPath().replace(".pom","").replace(".jar",""), file);
            }
        }
    }
}
