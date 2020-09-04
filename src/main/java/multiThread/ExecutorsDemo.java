package multiThread;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class ExecutorsDemo {
    public static void main(String[] args) {


        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            IntStream.range(1,100)
                    .mapToObj(it -> threadPool.submit(() -> request(it)))
                    .collect(Collectors.toList())
                    .forEach((Future<String> it) -> {
                        String result = null;
                        try {
                            result = it.get();
                            System.out.println(result);
                        } catch (InterruptedException | ExecutionException e) {
                            log.error("XXXXX", e);
                        }
                    });
        } catch (RuntimeException e) {
            log.error("YYYY", e);
        } finally {
            threadPool.shutdown();
        }
    }

    static  OkHttpClient client=new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)       //设置连接超时
            .readTimeout(60, TimeUnit.SECONDS)          //设置读超时
            .writeTimeout(60,TimeUnit.SECONDS)          //设置写超时
            .retryOnConnectionFailure(true)             //是否自动重连
            .build();

    private static String request(int it) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("username","kobe");
        builder.add("password","123");


        Request request = new Request.Builder()
                .url("http://localhost:8088/redis/origin?key=nba")
                .post(builder.build())
                .build();

        String result = "false";

        try {
            Response response  = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return result;
    }
}
