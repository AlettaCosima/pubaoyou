import lombok.extern.slf4j.Slf4j;

/**
 * @Author: eric
 * @Date: 2021/7/13 16:32
 * @Version 1.0
 */
public class ThreadTGT{

    public static void main(String[] args) {
        for (int i = 0; i < 200 ; i++) {
            ThreadA threadA = new ThreadA();
            ThreadB threadB = new ThreadB();
            ThreadC threadC = new ThreadC();
            ThreadD threadD = new ThreadD();
            ThreadE threadE = new ThreadE();

            threadA.start();
            threadB.start();
            threadD.start();
            threadC.start();
            threadE.start();
        }
    }

}
