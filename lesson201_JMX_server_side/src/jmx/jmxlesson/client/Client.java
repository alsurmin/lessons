package jmx.jmxlesson.client;
import jmx.jmxlesson.HelloMBean;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Alex on 08.02.2019
 */

public class Client {
    public static void main(String[] args) throws IOException, MalformedObjectNameException, InstanceNotFoundException, InterruptedException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();


        ObjectName mbeanName = new ObjectName("jmxlesson:type=Hello");
        HelloMBean mBeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);

//        mbsc.addNotificationListener(mbeanName, new ClientListener(), null,null);
//
//        mBeanProxy.sayHello();
//        Thread.sleep(1000);
//        System.out.println(mBeanProxy.addInteger(1,2));
//        mBeanProxy.setName("hello Alex");
//        System.out.println(mBeanProxy.getName());
//        System.out.println(mBeanProxy.returnPerson().getName());

        System.out.println("Domains:");
        String domains[] = mbsc.getDomains();
        Arrays.sort(domains);
        for (String domain : domains) {
            System.out.println("Domain = " + domain);
        }

        System.out.println("MBeanServer default domain = "+ mbsc.getDefaultDomain());
        System.out.println("MBean count = "+ mbsc.getMBeanCount());
        Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));
        for (ObjectName name : names) {
            System.out.println("ObjectName = " + name);
        }

        jmxc.close();

    }

}
