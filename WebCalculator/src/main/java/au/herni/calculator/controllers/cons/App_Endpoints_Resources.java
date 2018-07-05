package au.herni.calculator.controllers.cons;

import static au.herni.calculator.controllers.cons.App_Constants.*;

/**
 * API end-point path string constants
 * @author Hernán Camilo
 *
 */
public interface App_Endpoints_Resources {
	
	/**
	 * Resources
	 */
	public static final String API_ROOT_CONTEXT = "/webcalculator";
	public static final String API_VERSION  = "/v1";
	public static final String ADD_RESOURCE = "/add";
	public static final String SUB_RESOURCE = "/subtract";
	public static final String MUL_RESOURCE = "/multiply";
	public static final String DIV_RESOURCE = "/divide";
	public static final String POW_RESOURCE = "/power";
	public static final String SQR_RESOURCE = "/square";
	public static final String PERC_RESOURCE = "/percentage";
	
	/**
	 * Combined paths: API context plus mathematical operations as end-points with path variables
	 */
	public static final String API_REST_PATH = API_ROOT_CONTEXT + API_VERSION;
	
	public static final String ADD_1_ARG = ADD_RESOURCE + S + L + OP1_PARAM_TEXT + R;
	
	public static final String ADD_2_ARG = ADD_1_ARG + S + L + OP2_PARAM_TEXT + R;
	
	public static final String ADD_3_ARG = ADD_2_ARG + S + L + OP3_PARAM_TEXT + R;
	
	public static final String SUB_1_ARG = SUB_RESOURCE + S + L + OP1_PARAM_TEXT + R;
			
	public static final String SUB_2_ARG = SUB_1_ARG + S + L + OP2_PARAM_TEXT + R;
	
	public static final String SUB_3_ARG = SUB_2_ARG + S + L + OP3_PARAM_TEXT + R;
	
	public static final String MUL_1_ARG = MUL_RESOURCE + S + L + OP1_PARAM_TEXT + R;
	
	public static final String MUL_2_ARG = MUL_1_ARG + S + L + OP2_PARAM_TEXT + R;
	
	public static final String MUL_3_ARG = MUL_2_ARG + S + L + OP2_PARAM_TEXT + R;
	
	public static final String DIV_PATH = DIV_RESOURCE + S + L + OP1_PARAM_TEXT + R + S + L + OP2_PARAM_TEXT + R;
	
	public static final String POW_PATH = POW_RESOURCE + S + L + OP1_PARAM_TEXT + R + S + L + OP2_PARAM_TEXT + R;
	
	public static final String SQR_PATH = SQR_RESOURCE + S + L + OP1_PARAM_TEXT + R;
	
	public static final String PERC_PATH = PERC_RESOURCE + S + L + OP1_PARAM_TEXT + R + S + L + OP2_PARAM_TEXT + R;	
}