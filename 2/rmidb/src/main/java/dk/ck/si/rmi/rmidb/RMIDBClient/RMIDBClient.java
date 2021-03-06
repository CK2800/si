package dk.ck.si.rmi.rmidb.RMIDBClient;
/**
 *
 *
 */

import dk.ck.si.rmi.rmidb.RMIDBServer.BankInterface;
import dk.ck.si.rmi.rmidb.RMIDBServer.Customer;

import java.io.File;
import java.rmi.Naming;
import java.util.List;


public class RMIDBClient
{
    public static void main(String args[])throws Exception
    {
        // name =  rmi:// + ServerIP +  /EngineName;
        String remoteEngine = "rmi://localhost/BankServices";

        // Create local stub, lookup in the registry searching for the remote engine - the interface with the methods we want to use remotely
        BankInterface obj = (BankInterface) Naming.lookup(remoteEngine);

        System.out.println(obj.getTotalCustomers() + " customers in bank.");
        System.out.println("JSON Customers added: " + obj.addCustomers(new File("./src/main/resources/customers.json")));
        System.out.println(obj.getTotalCustomers() + " customers in bank.");
        System.out.println("XML Customers added: " + obj.addCustomers(new File("./src/main/resources/customers.xml")));
        System.out.println(obj.getTotalCustomers() + " customers in bank.");
        System.out.println("CSV Customers added: " + obj.addCustomers(new File("./src/main/resources/customers.csv")));


        /*List<Customer> list=obj.getMillionaires();
        for(Customer c:list)
        {
            System.out.println(c.getAccnum()+ " " + c.getName() + " " + c.getAmount());
        }
*/
    }

}
