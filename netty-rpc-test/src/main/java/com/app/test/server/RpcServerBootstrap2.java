package com.app.test.server;

import com.app.test.service.HelloServiceImpl;
import com.app.test.service.PersonService;
import com.app.test.service.PersonServiceImpl;
import com.netty.rpc.server.RpcServer;
import com.app.test.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcServerBootstrap2 {
    private static final Logger logger = LoggerFactory.getLogger(RpcServerBootstrap2.class);

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1:18866";
        String registryAddress = "10.217.59.164:2181";
        RpcServer rpcServer = new RpcServer(serverAddress, registryAddress);
        HelloService helloService = new HelloServiceImpl();
        PersonService personService = new PersonServiceImpl();
        rpcServer.addService(HelloService.class.getName(), helloService);
        rpcServer.addService(PersonService.class.getName(), personService);
        try {
            rpcServer.start();
        } catch (Exception ex) {
            logger.error("Exception: {}", ex);
        }
    }
}
