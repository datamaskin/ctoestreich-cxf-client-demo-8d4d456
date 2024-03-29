package com.xmlme;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This Web Service takes a phrase from the plays of William Shakespeare and returns the associated speech, speaker, and play. The Shakespeare texts used in this Web Service are the XML versions developed by Jon Bosak.  Go to http://www.oasis-open.org/cover/bosakShakespeare200.html for more information on the texts. See http://www.xmlme.com for a sample client and additional details about the Shakespeare Web Service.
 *
 * This class was generated by Apache CXF 2.5.0
 * 2012-01-25T16:00:25.727-06:00
 * Generated source version: 2.5.0
 * 
 */
@WebServiceClient(name = "Shakespeare", 
                  wsdlLocation = "http://www.xmlme.com/WSShakespeare.asmx?WSDL",
                  targetNamespace = "http://xmlme.com/WebServices") 
public class Shakespeare extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://xmlme.com/WebServices", "Shakespeare");
    public final static QName ShakespeareSoap12 = new QName("http://xmlme.com/WebServices", "ShakespeareSoap12");
    public final static QName ShakespeareSoap = new QName("http://xmlme.com/WebServices", "ShakespeareSoap");
    static {
        URL url = null;
        try {
            url = new URL("http://www.xmlme.com/WSShakespeare.asmx?WSDL");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Shakespeare.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://www.xmlme.com/WSShakespeare.asmx?WSDL");
        }
        WSDL_LOCATION = url;
    }

    public Shakespeare(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Shakespeare(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Shakespeare() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns ShakespeareSoap
     */
    @WebEndpoint(name = "ShakespeareSoap12")
    public ShakespeareSoap getShakespeareSoap12() {
        return super.getPort(ShakespeareSoap12, ShakespeareSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ShakespeareSoap
     */
    @WebEndpoint(name = "ShakespeareSoap12")
    public ShakespeareSoap getShakespeareSoap12(WebServiceFeature... features) {
        return super.getPort(ShakespeareSoap12, ShakespeareSoap.class, features);
    }
    /**
     *
     * @return
     *     returns ShakespeareSoap
     */
    @WebEndpoint(name = "ShakespeareSoap")
    public ShakespeareSoap getShakespeareSoap() {
        return super.getPort(ShakespeareSoap, ShakespeareSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ShakespeareSoap
     */
    @WebEndpoint(name = "ShakespeareSoap")
    public ShakespeareSoap getShakespeareSoap(WebServiceFeature... features) {
        return super.getPort(ShakespeareSoap, ShakespeareSoap.class, features);
    }

}
