package cn.mydemo.springbootlearn.thread;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearnApplicationTests {
    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void threadTest() {
        for (int i = 0; i < 20; i++) {
            asyncTaskService.executeAsyncTask(i);
        }
    }

}
