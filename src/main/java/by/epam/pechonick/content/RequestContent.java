package by.epam.pechonick.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestContent {

  private HashMap<String, Object> requestAttributes;
  private HashMap<String, String[]> requestParameters;
  private HashMap<String, Object> sessionAttributes;
  private String requestURI;
  private boolean sessionInvalidateFlag;

  public RequestContent(HttpServletRequest request) {
    requestAttributes = new HashMap<>();
    requestParameters = new HashMap<>();
    sessionAttributes = new HashMap<>();
    fillValues(request);
  }

  private void fillRequestAttributes(HttpServletRequest request) {
    Enumeration<String> attributeNames = request.getAttributeNames();

    while (attributeNames.hasMoreElements()) {
      String attributeName = attributeNames.nextElement();
      requestAttributes.put(attributeName, request.getAttribute(attributeName));
    }
  }

  private void fillRequestParameters(HttpServletRequest request) {
    Enumeration<String> parameterNames = request.getParameterNames();

    while (parameterNames.hasMoreElements()) {
      String parameterName = parameterNames.nextElement();
      requestParameters.put(parameterName, request.getParameterValues(parameterName));
    }
  }

  private void fillSessionAttributes(HttpServletRequest request) {
    HttpSession session = request.getSession(false);

    if (session != null) {
      Enumeration<String> sessionAttributeNames = session.getAttributeNames();

      while (sessionAttributeNames.hasMoreElements()) {
        String sessionAttributeName = sessionAttributeNames.nextElement();
        sessionAttributes.put(sessionAttributeName, session.getAttribute(sessionAttributeName));
      }
    }
  }

  private void fillValues(HttpServletRequest request) {

    fillRequestAttributes(request);
    fillRequestParameters(request);
    fillSessionAttributes(request);

    requestURI = request.getRequestURI();
    sessionInvalidateFlag = false;
  }

  public String getParameter(String key) {
    return requestParameters.get(key)[0];
  }

  public Object getSessionAttribute(String attributeName) {
    return sessionAttributes.get(attributeName);
  }

  public Object setAttribute(String key, Object value) {
    return requestAttributes.put(key, value);
  }

  public void insertValues(HttpServletRequest request) {
    Iterator iterator = requestAttributes.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry<String, Object> pair = (Map.Entry) iterator.next();
      request.setAttribute(pair.getKey(), pair.getValue());
    }

    iterator = sessionAttributes.entrySet().iterator();
    HttpSession session = request.getSession(false);

    if (session != null) {
      while (iterator.hasNext()) {
        Map.Entry<String, Object> pair = (Map.Entry) iterator.next();
        session.setAttribute(pair.getKey(), pair.getValue());
      }

      if (sessionInvalidateFlag) {
        session.invalidate();
      }
    }
  }

  public void setSessionAttribute(String attributeName, Object attributeValue) {
    sessionAttributes.put(attributeName, attributeValue);
  }

  public void setSessionInvalidateFlag(boolean sessionInvalidateFlag) {
    this.sessionInvalidateFlag = sessionInvalidateFlag;
  }

}
