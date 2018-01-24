# data-services-inject

Data service: `/src/main/groovy/demo/data/AuditService.groovy`

Grails service: `/grails-app/services/demo/listeners/LoggingService.groovy`

## Steps:

1. Run application.

2. Run following curl command: 

```
curl -X "POST" "http://localhost:8080/book" \
     -H 'Content-Type: application/json; charset=utf-8' \
     -d $'{
  "title": "Definitive Guide to Grails 2",
  "pages": "400",
  "author": "Jeff Brown"
}'
```
 
3. Excerpt from stacktrace: 

```
java.lang.NullPointerException: Cannot invoke method saveAudit() on null object
	at org.codehaus.groovy.runtime.NullObject.invokeMethod(NullObject.java:91)
	at org.codehaus.groovy.runtime.callsite.PogoMetaClassSite.call(PogoMetaClassSite.java:48)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)
	at org.codehaus.groovy.runtime.callsite.NullCallSite.call(NullCallSite.java:35)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:48)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:113)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:133)
	at demo.listeners.LoggingService.$tt__afterSave(LoggingService.groovy:20)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
```
