package au.herni.calculator.services;

import java.util.Optional;
import au.herni.calculator.model.CalculationResponse;

/**
 * Service interface to expose mathematical operations from a calculator.
 * @author Hernán Camilo
 *
 */
public interface CalculatorService {
	
	public CalculationResponse add(Double  op1, Double op2, Double op3);
	
	public CalculationResponse subtract(Double  op1, Double op2, Double op3);
	
	public CalculationResponse multiply(Double  op1, Double op2, Double op3);
	
	public CalculationResponse divide(Long  op1, Long op2);
	
	public CalculationResponse power(double op1, double op2);
	
	public CalculationResponse square(double op1);
	
	public CalculationResponse percentage(double op1, double op2);
}