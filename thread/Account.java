import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 100个线程往一个账户存1元
 */
public class Account {
    private ReentrantLock lock = new ReentrantLock();
    private int money;

    public void save(int money) {
        try {
            lock.lock();
            this.money += money;
        } finally {
            lock.unlock();
        }
    }

    public int getMoney() {
        return money;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(new SaveMoney(account, 1, countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println(account.getMoney());
    }
}

class SaveMoney implements Runnable {

    private CountDownLatch countDownLatch;

    private Account account;
    private int money;

    public SaveMoney(Account account, int money, CountDownLatch countDownLatch) {
        this.account = account;
        this.money = money;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        this.account.save(this.money);
        countDownLatch.countDown();
    }
}

