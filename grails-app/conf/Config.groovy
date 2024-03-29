// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [html: ['text/html', 'application/xhtml+xml'],
        xml: ['text/xml', 'application/xml'],
        text: 'text/plain',
        js: 'text/javascript',
        rss: 'application/rss+xml',
        atom: 'application/atom+xml',
        css: 'text/css',
        csv: 'text/csv',
        all: '*/*',
        json: ['application/json', 'text/json'],
        form: 'application/x-www-form-urlencoded',
        multipartForm: 'multipart/form-data'
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable for AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// IMPORTANT - these must be set externally to env if you want to refer to them later for use
// via cxf.  You can also simply hardcode the url in the cxf section and NOT refer to a variable
// as well
service.simple.url = ""
service.complex.url = ""
service.secure.url = ""

// set per-environment service url
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// port is set to 9090 for test use -Dserver.port=9090 during test
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
environments {
    production {
        grails.serverURL = "http://www.changeme.com"
        service.simple.url = "${grails.serverURL}/services/simple"
        service.complex.url = "${grails.serverURL}/services/complex"
        service.secure.url = "${grails.serverURL}/services/secure"
    }
    development {
        grails.serverURL = "http://localhost:8080/${appName}"
        service.simple.url = "${grails.serverURL}/services/simple"
        service.complex.url = "${grails.serverURL}/services/complex"
        service.secure.url = "${grails.serverURL}/services/secure"
    }
    test {
        grails.serverURL = "http://localhost:9090/${appName}"
        service.simple.url = "${grails.serverURL}/services/simple"
        service.complex.url = "${grails.serverURL}/services/complex"
        service.secure.url = "${grails.serverURL}/services/secure"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%c{2} %m%n')
    }

    error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
          'org.codehaus.groovy.grails.web.pages', //  GSP
          'org.codehaus.groovy.grails.web.sitemesh', //  layouts
          'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
          'org.codehaus.groovy.grails.web.mapping', // URL mapping
          'org.codehaus.groovy.grails.commons', // core / classloading
          'org.codehaus.groovy.grails.plugins', // plugins
          'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
          'org.springframework',
          'org.hibernate',
          'net.sf.ehcache.hibernate'

    warn 'org.mortbay.log'

    info 'com.grails.cxf.client'
    info 'org.apache.cxf.interceptor'
    info 'com.cxf.demo.logging'
}

cxf {
    installDir = "C:/apps/apache-cxf-2.4.2" //only used for wsdl2java script target
    client {
        simpleServiceClient {
            wsdl = "docs/SimpleService.wsdl" //only used for wsdl2java script target
            clientInterface = cxf.client.demo.simple.SimpleServicePortType
            serviceEndpointAddress = "${service.simple.url}"
            namespace = "cxf.client.demo.simple"
        }

        simpleServiceInterceptorClient {
            wsdl = "docs/SimpleService.wsdl" //only used for wsdl2java script target
            clientInterface = cxf.client.demo.simple.SimpleServicePortType
            serviceEndpointAddress = "${service.simple.url}"
            outInterceptors = 'customLoggingOutInterceptor' //can use single item, comma separated list or groovy list
            inInterceptors = ['customLoggingInInterceptor', 'verboseLoggingInInterceptor'] //can use single item, comma separated list or groovy list
            enableDefaultLoggingInterceptors = false
            namespace = "cxf.client.demo.simple"
        }

        complexServiceClient {
            wsdl = "docs/ComplexService.wsdl" //only used for wsdl2java script target
            clientInterface = cxf.client.demo.complex.ComplexServicePortType
            serviceEndpointAddress = "${service.complex.url}"
            namespace = "cxf.client.demo.complex"
        }

        insecureServiceClient {
            wsdl = "docs/SecureService.wsdl" //only used for wsdl2java script target
            namespace = "cxf.client.demo.secure"
            clientInterface = cxf.client.demo.secure.SecureServicePortType
            secured = false
            serviceEndpointAddress = "${service.secure.url}"
            namespace = "cxf.client.demo.secure"
        }

        customSecureServiceClient {
            wsdl = "docs/SecureService.wsdl" //only used for wsdl2java script target
            namespace = "cxf.client.demo.secure"
            clientInterface = cxf.client.demo.secure.SecureServicePortType
            secured = true
            securityInterceptor = 'myCustomInterceptor'
            serviceEndpointAddress = "${service.secure.url}"
            namespace = "cxf.client.demo.secure"
        }

        customSecureServiceOutClient {
            wsdl = "docs/SecureService.wsdl" //only used for wsdl2java script target
            namespace = "cxf.client.demo.secure"
            clientInterface = cxf.client.demo.secure.SecureServicePortType
            secured = true
            securityInterceptor = 'myCustomInterceptor'
            outInterceptors = 'customLoggingOutInterceptor' //can use single item, comma separated list or groovy list
            inInterceptors = ['customLoggingInInterceptor', 'verboseLoggingInInterceptor'] //can use single item, comma separated list or groovy list
            enableDefaultLoggingInterceptors = true //true by default (redundant)
            serviceEndpointAddress = "${service.secure.url}"
            namespace = "cxf.client.demo.secure"
        }

        secureServiceClient {
            wsdl = "docs/SecureService.wsdl" //only used for wsdl2java script target
            namespace = "cxf.client.demo.secure"
            clientInterface = cxf.client.demo.secure.SecureServicePortType
            secured = true
            username = "wsuser"
            password = "secret"
            serviceEndpointAddress = "${service.secure.url}"
            namespace = "cxf.client.demo.secure"
        }

        //Another real service to use against wsd2java script
        stockQuoteClient {
            wsdl = "http://www.webservicex.net/stockquote.asmx?WSDL"
            clientInterface = net.webservicex.StockQuoteSoap
            serviceEndpointAddress = "http://www.webservicex.net/stockquote.asmx"
        }
    }
}