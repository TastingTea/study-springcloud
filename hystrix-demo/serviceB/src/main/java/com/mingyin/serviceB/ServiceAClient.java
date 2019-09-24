package com.mingyin.serviceB;

import com.mingyin.api.ServiceAInterface;
import com.mingyin.api.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "ServiceA",
             fallbackFactory = ServiceAClient.ServiceAClientFallbackFactory.class)
public interface ServiceAClient extends ServiceAInterface {

    @Component
    static class ServiceAClientFallbackFactory implements FallbackFactory<ServiceAClient> {

        @Override
        public ServiceAClient create(Throwable throwable) {
            //每次要降级的时候，可以根据异常来区别处理

            return new ServiceAClient() {
                @Override
                public String sayHello(Long id, String name, Integer age) {
                    System.out.println("sayHello()方法的降级机制");
                    return null;
                }

                @Override
                public String createUser(User user) {
                    return null;
                }

                @Override
                public String updateUser(Long id, User user) {
                    return null;
                }

                @Override
                public String deleteUser(Long id) {
                    return null;
                }

                @Override
                public User getById(Long id) {
                    return null;
                }
            };
        }
    }
}
