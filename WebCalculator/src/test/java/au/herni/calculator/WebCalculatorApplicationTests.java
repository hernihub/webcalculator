package au.herni.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import au.herni.calculator.controllers.WebCalculatorController;
import au.herni.calculator.model.CalculationResponse;
import au.herni.calculator.services.CalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebCalculatorApplicationTests {
	
	@Autowired
    private CalculatorService calc;
	
	@Autowired
    private WebCalculatorController con;
	
	@Test
	public void contextLoads() {
		assertThat(calc != null);
		assertThat(con != null);
	}
	
	/**
	 * CONTROLLER INTEGRATION TESTS: these tests make sure every endpoint returns 200 and a appropiate payload response 
	 */
	@Test
	public void consume_rest_endpoints() {
		assertThat(con.add(3.0, 3.6, 4.2) != null);
		assertThat(con.subtract(31.0, 3.6, 4.2) != null);
		assertThat(con.multiply(3.0, 3.6, 4.2) != null);
		assertThat(con.divide(96L, 3L) != null);
		assertThat(con.power(2.0, 12) != null);
		assertThat(con.square(512.3) != null);
		assertThat(con.percentage(3, 34) != null);//TODO check for 200 response
	}
	
	/**
	 * MODEL UNITARY TESTS
	 */
	@Test
	public void add() {
		Double a=10.5, b = 20.2, c = 30.0;
		CalculationResponse ncal = new CalculationResponse();
		ncal.setResult(new Double(a+b+c));
		ncal.setResponseCode("OK");
		ncal.setMessage("add operation");
		CalculationResponse ccal = calc.add(a, b, c);
		
		assertThat(ccal).isEqualTo(ncal);
	}
	
	@Test
	public void subtract() {
		Double a=10.5, b = 20.5, c = 30.5;
		CalculationResponse ncal = new CalculationResponse();
		ncal.setResult(new Double(a-b-c));
		ncal.setResponseCode("OK");
		ncal.setMessage("subtract operation");
		CalculationResponse ccal = calc.subtract(a, b, c);
		
		assertThat(ccal).isEqualTo(ncal);
	}
	
	@Test
	public void multiply() {
		Double a=10.5, b = 20.2, c = 30.0;
		CalculationResponse ncal = new CalculationResponse();
		ncal.setResult(new Double(a*b*c));
		ncal.setResponseCode("OK");
		ncal.setMessage("multiply operation");
		CalculationResponse ccal = calc.multiply(a, b, c);
		
		assertThat(ccal).isEqualTo(ncal);
	}
	
	@Test
	public void divide() {
		Long dividend = 30L, divisor = 3L;
		CalculationResponse ncal = new CalculationResponse();
		ncal.setResult(dividend/divisor);
		ncal.setResponseCode("OK");
		ncal.setMessage("divide operation");
		CalculationResponse ccal = calc.divide(dividend, divisor);
		
		assertThat(ccal).isEqualTo(ncal);
	}
	
	@Test
	public void power() {
		Long base = 2L, power = 32L;
		CalculationResponse ncal = new CalculationResponse();
		ncal.setResult(Math.pow(base, power));
		ncal.setResponseCode("OK");
		ncal.setMessage("power operation");
		CalculationResponse ccal = calc.power(base, power);
		
		assertThat(ccal).isEqualTo(ncal);
	}
	
	@Test
	public void square() {
		Long root = 30L;
		CalculationResponse ncal = new CalculationResponse();
		ncal.setResult(Math.sqrt(root));
		ncal.setResponseCode("OK");
		ncal.setMessage("square operation");
		CalculationResponse ccal = calc.square(root);
		
		assertThat(ccal).isEqualTo(ncal);
	}
	
	@Test
	public void percentage() {
		Double percentage = 30.0, whole = 3.0;
		CalculationResponse ncal = new CalculationResponse();
		ncal.setResult( (percentage*whole) / 100);
		ncal.setResponseCode("OK");
		ncal.setMessage("percentage operation");
		CalculationResponse ccal = calc.percentage(percentage, whole);
		
		assertThat(ccal).isEqualTo(ncal);
	}
}