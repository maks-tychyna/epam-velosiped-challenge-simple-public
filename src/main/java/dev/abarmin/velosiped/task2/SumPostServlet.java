package dev.abarmin.velosiped.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumPostServlet extends HttpServlet {

  private final ObjectMapper objectMapper = new ObjectMapper();

  protected void doPost(
      HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String body = request.getReader().lines().collect(Collectors.joining());
    Request bodyRequest = objectMapper.readValue(body, Request.class);
    Response responseValue = new Response(bodyRequest.getArg1() + bodyRequest.getArg2());

    response.setContentType("text/html");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().println(objectMapper.writeValueAsString(responseValue));
  }
}