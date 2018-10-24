package multiThread;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Slf4j
public class ExecutorsDemo {
    public static void main(String[] args) {

        List<ProjectOrderDto> projectOrders = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            projectOrders.add(ProjectOrderDto.builder().partyId(i + "").amount(i).username("test-" + i).build());
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            projectOrders
                    .stream()
                    .map(projectOrderDto -> threadPool.submit(() -> balanceCashBack(projectOrderDto)))
                    .collect(Collectors.toList())
                    .forEach((Future<ProjectOrderDto> it) -> {
                        ProjectOrderDto projectOrderDto = null;
                        try {
                            projectOrderDto = it.get();
                        } catch (InterruptedException | ExecutionException e) {
                            log.error("XXXXX", e);
                        }

                        if (projectOrderDto != null) {
                            log.error("balanceCashBack failed,the ProjectOrderDto is {}", projectOrderDto);
                            projectOrders.remove(projectOrderDto);
                        }
                    });
        } catch (RuntimeException e) {
            log.error("YYYY", e);
        } finally {
            threadPool.shutdown();
        }


        System.out.println(projectOrders.size());
    }

    private static ProjectOrderDto balanceCashBack(ProjectOrderDto projectOrderDto) {
        if (projectOrderDto.getAmount() % 2 == 0) {
            return projectOrderDto;
        } else {
            return null;
        }

    }
}
