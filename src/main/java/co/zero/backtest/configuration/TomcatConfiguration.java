package co.zero.backtest.configuration;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class TomcatConfiguration {
    private static final int DEFAULT_PORT = 8080;
    private static final String ENV_PORT = "PORT";
    private static final String DEFAULT_CONTEXT_PATH = "/back-test";

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(getPort());
        String webappDirLocation = "target/";
        StandardContext ctx = (StandardContext) tomcat.addWebapp(DEFAULT_CONTEXT_PATH, new File(webappDirLocation).getAbsolutePath());
        log.info("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
            additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }

    private static int getPort() {
        String webPort = System.getenv(ENV_PORT);
        return StringUtils.isNotBlank(webPort)? Integer.valueOf(webPort) : DEFAULT_PORT;
    }
}
