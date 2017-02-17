package org.sf.boot.deployable.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello...";
	}

}
