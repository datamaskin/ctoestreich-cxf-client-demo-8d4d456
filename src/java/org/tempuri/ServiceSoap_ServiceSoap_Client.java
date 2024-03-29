
package org.tempuri;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2012-01-25T16:26:29.742-06:00
 * Generated source version: 2.5.0
 * 
 */
public final class ServiceSoap_ServiceSoap_Client {

    private static final QName SERVICE_NAME = new QName("http://tempuri.org/", "Service");

    private ServiceSoap_ServiceSoap_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        Service ss = new Service(wsdlURL, SERVICE_NAME);
        ServiceSoap port = ss.getServiceSoap();  
        
        {
        System.out.println("Invoking helloWorld...");
        java.lang.String _helloWorld__return = port.helloWorld();
        System.out.println("helloWorld.result=" + _helloWorld__return);


        }
        {
        System.out.println("Invoking getDataTable...");
        java.lang.String _getDataTable_sql = "";
        org.tempuri.GetDataTableResponse.GetDataTableResult _getDataTable__return = port.getDataTable(_getDataTable_sql);
        System.out.println("getDataTable.result=" + _getDataTable__return);


        }
        {
        System.out.println("Invoking isAlive...");
        boolean _isAlive__return = port.isAlive();
        System.out.println("isAlive.result=" + _isAlive__return);


        }
        {
        System.out.println("Invoking addBP...");
        org.tempuri.BusinessPartner _addBP_bp = null;
        boolean _addBP__return = port.addBP(_addBP_bp);
        System.out.println("addBP.result=" + _addBP__return);


        }
        {
        System.out.println("Invoking connected...");
        boolean _connected__return = port.connected();
        System.out.println("connected.result=" + _connected__return);


        }

        System.exit(0);
    }

}
