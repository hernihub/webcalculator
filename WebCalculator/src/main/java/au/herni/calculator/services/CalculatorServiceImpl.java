package au.herni.calculator.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import au.herni.calculator.model.CalculationResponse;
import static au.herni.calculator.controllers.cons.App_Constants.*;

/**
 * Model for the actual in-memory calculator
 * @author Hernán Camilo
 *
 */
@Component
public class CalculatorServiceImpl implements CalculatorService {
	
	/**
	 * Logger for the application that is going to be created in the same folder the JAR file is running.
	 */
	private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);
	
	public CalculationResponse add(Double  op1, Double op2, Double op3) {
		logger.info("add method invoked");
		CalculationResponse cres = new CalculationResponse();
		try {
			if(op2 != null && op3 != null)
				cres.setResult(op1 + op2 + op3);
			else if(op2 != null)
				cres.setResult(op1 + op2);
			else
				cres.setResult(op1);
			cres.setResponseCode(OK_COMPUTER);
			cres.setMessage("add operation");
		}
		catch (NumberFormatException e) {
			cres.setResponseCode(OKNOTOK);
			cres.setResult(new Long(-1L));
			cres.setMessage(e.getMessage());
		}
		return cres;
	}
	
	public CalculationResponse subtract(Double  op1, Double op2, Double op3) {
		logger.info("subtract method invoked");
		CalculationResponse cres = new CalculationResponse();
		try {
			if(op2 !=null && op3!=null)
				cres.setResult(op1 - op2 - op3);
			else if(op2!=null)
				cres.setResult(op1 - op2);
			else
				cres.setResult(op1);
			cres.setResponseCode(OK_COMPUTER);
			cres.setMessage("subtract operation");
		}
		catch (NumberFormatException e) {
			cres.setResponseCode(OKNOTOK);
			cres.setResult(new Long(-1L));
			cres.setMessage(e.getMessage());
		}
		return cres;
	}
	
	public CalculationResponse multiply(Double  op1, Double op2, Double op3) {
		logger.info("multiply method invoked");
		CalculationResponse cres = new CalculationResponse();
		try {
			if(op2!=null && op3!=null)
				cres.setResult(op1 * op2 * op3);
			else if(op2!=null)
				cres.setResult(op1 * op2);				
			else
				cres.setResult(op1);
			cres.setResponseCode(OK_COMPUTER);
			cres.setMessage("multiply operation");
		}
		catch (Exception e) {
			cres.setResponseCode(OKNOTOK);
			cres.setResult(new Long(-1L));
			cres.setMessage(e.getMessage());
		}
		return cres;
	}
	
	public CalculationResponse divide(Long  op1, Long op2) {
		logger.info("divide method invoked");
		CalculationResponse cres = new CalculationResponse();
		try {
			if(op2!=null)
				cres.setResult(Math.floorDiv(op1, op2));				
			else
				cres.setResult(0L);//Division by zero is zero is opinionated				
			cres.setResponseCode(OK_COMPUTER);
			cres.setMessage("divide operation");
		}
		catch (Exception e) {
			cres.setResponseCode(OKNOTOK);
			cres.setResult(new Long(-1L));
			cres.setMessage(e.getMessage());
		}
		return cres;
	}
	
	public CalculationResponse power(double  op1, double op2) {
		logger.info("power method called");
		CalculationResponse cres = new CalculationResponse();
		try {
			cres.setResult(Math.pow(op1, op2));
			cres.setResponseCode(OK_COMPUTER);
			cres.setMessage("power operation");
		}
		catch (Exception e) {
			cres.setResponseCode(OKNOTOK);
			cres.setResult(new Double(-1L));
			cres.setMessage(e.getMessage());
		}
		return cres;
	}
	
	public CalculationResponse square(double op1) {
		logger.info("square method called");
		CalculationResponse cres = new CalculationResponse();
		try {
			cres.setResult(Math.sqrt(op1));
			cres.setResponseCode(OK_COMPUTER);
			cres.setMessage("square operation");
		}
		catch (Exception e) {
			cres.setResponseCode(OKNOTOK);
			cres.setResult(new Double(-1L));
			cres.setMessage(e.getMessage());
		}
		return cres;
	}
	
	public CalculationResponse percentage(double op1, double op2) {
		logger.info("percentage method called");
		CalculationResponse cres = new CalculationResponse();
		try {
			cres.setResult( (Double)(op2 * op1) / 100 );
			cres.setResponseCode(OK_COMPUTER);
			cres.setMessage("percentage operation");
		}
		catch (Exception e) {
			cres.setResponseCode(OKNOTOK);
			cres.setResult(new Double(-1L));
			cres.setMessage(e.getMessage());
		}
		return cres;
	}
}