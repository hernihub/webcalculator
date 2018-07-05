package au.herni.calculator.controllers;

import static au.herni.calculator.controllers.cons.App_Endpoints_Resources.*;
import static au.herni.calculator.controllers.cons.App_Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import au.herni.calculator.model.CalculationResponse;
import au.herni.calculator.services.CalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Principal controller for the REST calculator. Since this controller has methods which possesses up to three parameters, the order of
 * the mathematical operation is assumed to be from left to right, so, for instance, to subtract a, b and c, means that B is first
 * subtracted from A and then C is subtracted from this result.
 * @author Hernán Camilo
 *
 */
@Api(value="Web Calculator principal controller")
@RestController
@RequestMapping(value = API_REST_PATH)
public class WebCalculatorController {
	
	/**
	 * The actual calculator
	 */
	@Autowired
	private CalculatorService calculator;
	
	@GetMapping(value = {S})
	public ResponseEntity<?> apiWelcomeMapping() {
		
		String message = "<html><body><div align=\"center\">Welcome to the Web Calculator REST API - please visit <a href=\"http://localhost:8080/swagger-ui.html\">"
				+ "API doc </a> for a complete description of endpoints and be able to test them</div></body></html>";
		return ResponseEntity.ok(message);
	}
	
	@Cacheable(ADD_RESOURCE)
	@GetMapping(value = {ADD_1_ARG, ADD_2_ARG, ADD_3_ARG})
	@ApiOperation(value="Add one, two or three numbers")//Swagger doc
	public ResponseEntity<?> add(@PathVariable(name=OP1_PARAM_TEXT, required=true) Double  op1,
								 @PathVariable(name=OP2_PARAM_TEXT, required=false) Double op2, 
								 @PathVariable(name=OP3_PARAM_TEXT, required=false) Double op3) {
		CalculationResponse res = calculator.add(op1, op2, op3);
		return res.getResult().equals(-1L) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res) 
				                           : ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@Cacheable(SUB_RESOURCE)
	@GetMapping(value= {SUB_1_ARG, SUB_2_ARG, SUB_3_ARG})
	@ApiOperation(value="Subtract one, two or three numbers")
	public ResponseEntity<?> subtract(@PathVariable(name=OP1_PARAM_TEXT, required=true) Double op1, 
									  @PathVariable(name=OP2_PARAM_TEXT, required=false) Double op2,
									  @PathVariable(name=OP3_PARAM_TEXT, required=false) Double op3) {
		CalculationResponse res = calculator.subtract(op1, op2, op3);
		return res.getResult().equals(-1L) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res) 
                						   : ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@Cacheable(MUL_RESOURCE)
	@GetMapping(value= {MUL_1_ARG, MUL_2_ARG, MUL_3_ARG})
	@ApiOperation(value="Multiply one, two or three numbers")
	public ResponseEntity<?> multiply(@PathVariable(name=OP1_PARAM_TEXT, required=true) Double op1,
									  @PathVariable(name=OP2_PARAM_TEXT, required=false) Double  op2,
							    	  @PathVariable(name=OP3_PARAM_TEXT, required=false) Double  op3) {
		CalculationResponse res = calculator.multiply(op1, op2, op3);
		return res.getResult().equals(-1L) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res) 
                						   : ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@Cacheable(DIV_RESOURCE)
	@GetMapping(path=DIV_PATH)
	@ApiOperation(value="Divide two numbers; the result is zero if the divisor is zero")
	public ResponseEntity<?> divide(@PathVariable(name=OP1_PARAM_TEXT, required=true) Long op1, 
					   				@PathVariable(name=OP2_PARAM_TEXT, required=true) Long op2) {
		CalculationResponse res = calculator.divide(op1, op2);
		return res.getResult().equals(-1L) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res) 
                						   : ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@Cacheable(POW_RESOURCE)
	@GetMapping(path=POW_PATH)
	@ApiOperation(value="Raises number 1 to the powe of number two")
	public ResponseEntity<?> power(@PathVariable(name=OP1_PARAM_TEXT) double op1, @PathVariable(name=OP2_PARAM_TEXT) double op2) {
		CalculationResponse res = calculator.power(op1, op2);
		return res.getResult().equals(-1L) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res) 
				   						   : ResponseEntity.status(HttpStatus.OK).body(res);
	}
		
	@Cacheable(SQR_RESOURCE)
	@GetMapping(path=SQR_PATH)
	@ApiOperation(value="Finds out the square root of number 1")
	public ResponseEntity<?> square(@PathVariable(name=OP1_PARAM_TEXT) double op1) {
		CalculationResponse res = calculator.square(op1);
		return res.getResult().equals(-1L) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res)
										   : ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@Cacheable(PERC_RESOURCE)
	@GetMapping(path=PERC_PATH)
	@ApiOperation(value="Finds out the op1 percentage of number op2")
	public ResponseEntity<?> percentage(@PathVariable(name=OP1_PARAM_TEXT) double op1, @PathVariable(name=OP2_PARAM_TEXT) double op2) {
		CalculationResponse res = calculator.percentage(op1, op2);
		return res.getResult().equals(-1L) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res)
										   : ResponseEntity.status(HttpStatus.OK).body(res);
	}
}