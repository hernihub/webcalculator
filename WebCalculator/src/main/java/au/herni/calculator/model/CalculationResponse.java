package au.herni.calculator.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Response wrapper model for the results returned by the calculator service to the controller.
 * @author Hernán Camilo
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(description="Response wrapper for the calculation")
public class CalculationResponse {
	@ApiModelProperty(value="Response code for the calculation")
	private String responseCode;
	private Object result;
	private String message;
	
	@Override
	public boolean equals(Object obj) {
		return result.equals(  ( (CalculationResponse) obj).result );
	}
	
	@Override
	public int hashCode() {
		return responseCode.hashCode();
	}
}