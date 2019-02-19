package jmx.jmxlesson;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("jmxlesson:type=Hello");
        Hello mBean = new Hello();
        server.registerMBean(mBean, name);

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
