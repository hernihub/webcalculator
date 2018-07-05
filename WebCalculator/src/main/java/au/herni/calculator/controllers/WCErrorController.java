package au.herni.calculator.controllers;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import au.herni.calculator.error.JsonError;

/**
 * Principal controller for the REST calculator. Since this controller has methods which possesses up to three parameters, the order of
 * the mathematical operation is assumed to be from left to right, so, for instance, to subtract a, b and c, means that B is first
 * subtracted from A and then C is subtracted from this result.
 * @author Hernán Camilo
 *
 */
@RestController
public class WCErrorController implements ErrorController {
	
	private static final String PATH = "/error";
	
	@Autowired
    private ErrorAttributes errorAttributes;
	
	@RequestMapping(value = PATH)
    JsonError error(HttpServletRequest request, HttpServletResponse response, WebRequest webRequest) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        return new JsonError(response.getStatus(), getErrorAttributes(request, webRequest, true));
    }
	
	@Override
    public String getErrorPath() {
        return PATH;
    }
	
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, WebRequest webRequest,
            boolean includeStackTrace) {
    	//RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }
}