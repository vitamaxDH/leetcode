package concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit; // CommonTask를 위해 추가

// 실제 작업을 시뮬레이션하는 간단한 유틸리티 클래스 (소스에 제시된 CommonTask와 유사)
class SimpleCommonTask {
    public static void doTask() {
        long duration = (long) (Math.random() * 5) + 1; // 1~5초 랜덤 작업
        System.out.printf("%s: 작업 중 %d초...\n", Thread.currentThread().getName(), duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 인터럽트 상태 재설정
            System.err.println(Thread.currentThread().getName() + ": 작업 중단됨.");
        }
    }
}

// 각 태스크가 실행하는 Runnable 클래스
public class SimpleBarrierTask implements Runnable {
    private CyclicBarrier barrier;

    public SimpleBarrierTask(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": **1단계 시작**");
        SimpleCommonTask.doTask(); // 1단계 작업 수행
        try {
            System.out.println(Thread.currentThread().getName() + ": 1단계 완료, 장벽 대기 중...");
            // 모든 태스크가 여기에 도달할 때까지 대기합니다.
            barrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(Thread.currentThread().getName() + ": 장벽 대기 중 인터럽트됨.");
        } catch (BrokenBarrierException e) {
            System.err.println(Thread.currentThread().getName() + ": 장벽이 깨짐: " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + ": **2단계 시작**"); // 모든 태스크가 동시에 2단계 시작
        SimpleCommonTask.doTask(); // 2단계 작업 수행
        System.out.println(Thread.currentThread().getName() + ": 2단계 완료");
    }

    public static void main(String[] args) {
        int numberOfTasks = 3; // 동시에 실행할 태스크 수

        // CyclicBarrier를 생성합니다. 3개의 태스크가 장벽에 도달해야 통과됩니다.
        CyclicBarrier barrier = new CyclicBarrier(numberOfTasks, () -> {
            System.out.println("\n--- 모든 태스크가 1단계를 완료했습니다. 다음 단계로 진행합니다! ---\n");
        });

        System.out.println("태스크 시작 중...");
        for (int i = 0; i < numberOfTasks; i++) {
            new Thread(new SimpleBarrierTask(barrier), "Worker-" + (i + 1)).start();
        }
    }
}
