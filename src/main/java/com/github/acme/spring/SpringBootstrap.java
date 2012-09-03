package com.github.acme.spring;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.acme.spring.event.GreetingStatisticCalculator;

public class SpringBootstrap {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/*.xml");
        GreetingApp greetingApp = ctx.getBean(GreetingApp.class);
        System.out.println("###\n###\n###greetingApp type:" + greetingApp.getClass());
        greetingApp.greet();
        greetingApp.greet("menjunk kavezno!");
        greetingApp.greet("menjunk haza!");
        greetingApp.greet("menjunk vacsorazni!");
        
//        GreetingWS ws = ctx.getBean(GreetingWS.class);
//        
//        String address = InetAddress.getLocalHost().getHostAddress();
//        String url = "http://" + address + ":8080/greeting";
//        System.out.println("### startin WS at:" + url);
//        Endpoint.publish(url, ws);
//
//        GreetingStatisticCalculator statisticCalculator = ctx.getBean(GreetingStatisticCalculator.class);
//        
//        while(true) {
//            Map<String, Integer> wordStatistic = statisticCalculator.getWordStatistic();
//            Map<String, Integer> firstNameCounter = statisticCalculator.getFirstNameCounter();
//            System.out.println("\n=== word statistic ===");
//            for (String nextWord : wordStatistic.keySet()) {
//                System.out.println("\t" + nextWord + " : " + wordStatistic.get(nextWord));
//            }
//            
//            System.out.println("\n=== firstName statistic ===");
//            for (String nextFirstName : firstNameCounter.keySet()) {
//                System.out.println("\t" + nextFirstName + " : " + wordStatistic.get(nextFirstName));
//            }
//
//            System.out.println("\n=== totalGreetings" + statisticCalculator.getTotalGreetings());
//            System.in.read();
//        }
    }

}
