package net.proselyte.beanpostprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageWithPostBeanProcessorRunner {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("post-processor-config.xml");

        Message message = (Message) context.getBean("message");
        System.out.println("\n==================================");
        System.out.println(message.getMessage());
        System.out.println("==================================\n");
        context.registerShutdownHook();

        Test test = (Test) context.getBean("test");
        System.out.println("\n==================================");
        System.out.println(test.getDate());
        System.out.println("==================================\n");
        System.out.println(test.getMessageMap());
        System.out.println("==================================\n");
        System.out.println(test.getMessageSet());
        System.out.println("==================================\n");
        context.registerShutdownHook();
    }
}