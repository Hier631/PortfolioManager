package org.example.utils;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;

public class CayenneUtil {

    private static ServerRuntime serverRuntime;
    private static ObjectContext context;

    private CayenneUtil() { }

    public static ObjectContext getContext(){
        if (serverRuntime == null){
            serverRuntime = ServerRuntime.builder()
                    .addConfig("cayenne-project.xml")
                    .build();

            context = serverRuntime.newContext();
        }

        return context;
    }

    /**
     * Shuts down the Cayenne runtime.
     */
    public static void shutdown() {
        if (serverRuntime != null) {
            serverRuntime.shutdown();
        }
    }
}
