package com.indus.training.core.controller;

import com.indus.training.core.domain.CalciInput;
import com.indus.training.core.domain.CalciOutput;
import com.indus.training.core.exception.CalciException;
import com.indus.training.core.impl.Calci;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calci")
public class CalciController {
	private final Calci calciService = new Calci();

	@PostMapping("/add")
	@ResponseBody
	public CalciOutput add(@RequestBody CalciInput input) throws CalciException {
		return calciService.addition(input);
	}

	@PostMapping("/subtract")
	@ResponseBody
	public CalciOutput subtract(@RequestBody CalciInput input) throws CalciException {
		return calciService.subtract(input);
	}

	@PostMapping("/multiply")
	@ResponseBody
	public CalciOutput multiply(@RequestBody CalciInput input) throws CalciException {
		return calciService.multiply(input);
	}

	@PostMapping("/divide")
	@ResponseBody
	public CalciOutput divide(@RequestBody CalciInput input) throws CalciException {
		return calciService.division(input);
	}
}
