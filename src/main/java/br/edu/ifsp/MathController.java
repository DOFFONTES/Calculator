package br.edu.ifsp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.exception.UnsuportedMathOperationResponse;

@RestController
public class MathController {
	
	@RequestMapping(value= "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationResponse
				("Por favor entre com valor númerico");
		}	
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value= "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationResponse
				("Por favor entre com valor númerico");
		}	
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sub;
	}
	
	@RequestMapping(value= "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationResponse
				("Por favor entre com valor númerico");
		}	
		Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return mult;
	}
	
	@RequestMapping(value= "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationResponse
				("Por favor entre com valor númerico");
		}	
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return div;
	}
	
	@RequestMapping(value= "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationResponse
				("Por favor entre com valor númerico");
		}	
		Double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return mean;
	}
	
	@RequestMapping(value= "/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if(!isNumeric(number)) {
			throw new UnsuportedMathOperationResponse
				("Por favor entre com valor númerico");
		}	
		Double square = Math.sqrt(convertToDouble(number));
		return square;
	}
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}