package au.herni.calculator.error;

import java.util.Map;

/**
 * 
 * @author hquevedo
 *
 */
public class JsonError {

    public Integer status;
    public String error;
    public String message;
    public String timeStamp;
    public String trace;

    public JsonError(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }

}