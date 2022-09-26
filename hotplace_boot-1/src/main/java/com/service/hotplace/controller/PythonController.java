package com.service.hotplace.controller;

import java.lang.annotation.Documented;

import org.python.core.PyFunction;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PythonController {
	@GetMapping("python.test")
	public String tempFnc() throws Exception {
		
		PythonInterpreter interpreter;
		interpreter = new PythonInterpreter();
		interpreter.execfile("src/main/python/test.py");
		interpreter.exec("testFnc()");
		System.out.println("정상 실행됬냐?");
//		PyFunction pyFnc = interpreter.get("testFnc",PyFunction.class);
		//https://ozofweird.tistory.com/entry/Spring-Boot-Jython
		//위 사이트 참고함
		return null;
	}
}
