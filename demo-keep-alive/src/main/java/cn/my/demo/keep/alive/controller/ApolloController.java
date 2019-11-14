package cn.my.demo.keep.alive.controller;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.Set;

@RestController
public class ApolloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //guava中的Multimap，多值map,对map的增强，一个key可以保持多个value
    private SetMultimap<Object, Object> watchRequests = Multimaps.synchronizedSetMultimap(HashMultimap.create());


    //模拟长轮询
    @RequestMapping(value = "/watch/{namespace}", method = RequestMethod.GET, produces = "text/html")
    public DeferredResult<String> watch(@PathVariable("namespace") final String namespace) {
        logger.info("Request received");
        final DeferredResult<String> deferredResult = new DeferredResult<String>();
        //当deferredResult完成时（不论是超时还是异常还是正常完成），移除watchRequests中相应的watch key
        deferredResult.onCompletion(new Runnable() {
            public void run() {
                System.out.println("remove key:" + namespace);
                watchRequests.remove(namespace, deferredResult);
            }
        });
        watchRequests.put(namespace, deferredResult);
        logger.info("Servlet thread released");
        return deferredResult;
    }

    //模拟发布namespace配置
    @RequestMapping(value = "/publish/{namespace}", method = RequestMethod.GET, produces = "text/html")
    public Object publishConfig(@PathVariable("namespace") String namespace) {
        if (watchRequests.containsKey(namespace)) {
            Set<Object> deferredResults = watchRequests.get(namespace);
            Long time = System.currentTimeMillis();
            //通知所有watch这个namespace变更的长轮训配置变更结果
            for (Object object : deferredResults) {
                DeferredResult<String> deferredResult = (DeferredResult<String>)object;
                deferredResult.setResult(namespace + " changed:" + time);
            }
        }
        return "success";
    }
}