package dev.abarmin.velosiped.task2;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class VelosipedTask2Impl implements VelosipedTask2 {

  private Server server;

  @Override
  public void startServer(int port) {
    try {
      server = new Server();
      ServerConnector connector = new ServerConnector(server);
      connector.setPort(port);
      server.setConnectors(new Connector[] {connector});

      ServletHandler servletHandler = new ServletHandler();
      servletHandler.addServletWithMapping(SumPostServlet.class, "/sum-post");

      server.setHandler(servletHandler);
      server.start();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void stopServer() {
    try {
      server.stop();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
