package com.uca.capas.Tarea_MVC_2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/ingresar")
	public String index() {
		return "commons/index";
	}
	
	@RequestMapping("/parametros1")
	public ModelAndView parametros1(HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView();
		List<String> lista = new ArrayList<>();
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String birth = request.getParameter("Fnacimiento");
		String place = request.getParameter("Lnacimiento");
		String school = request.getParameter("colegio");
		String phone = request.getParameter("Tfijo");
		String celphone = request.getParameter("Tmovil");
		int flag = 0;
		
		String minDate ="2003-01-01"; 
		Date newBirthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
		Date newMinDate = new SimpleDateFormat("yyyy-MM-dd").parse(minDate);
		
		
		if(nombres.length() > 25 || nombres.length() < 1) {
			lista.add("Informacion incorrecta - Nombres: Ingrese un maximo de 25 caracteres y minimo 1");
			flag = 1;
		}
		if(apellidos.length() > 25 || apellidos.length() < 1) {
			lista.add("Informacion incorrecta - Apellidos: Ingrese un maximo de 25 caracteres y minimo 1");
			flag = 1;
		}
	    if(newBirthDate.compareTo(newMinDate) < 0) {
	    	lista.add("Informacion incorrecta - Fecha de nacimiento: Ingresa una fecha despues de enero 1 de 2003");
	    	flag = 1;
	    }
		if(place.length() > 25 || place.length() < 1) {
			lista.add("Informacion incorrecta - Lugar de nacimiento: Ingrese un maximo de 25 caracteres y minimo 1");
			flag = 1;
		}
		if(school.length() > 100 || school.length() < 1) {
			lista.add("Informacion incorrecta - Instituto de precedencia: Ingrese un maximo de 100 caracteres y minimo 1");
			flag = 1;
		}
		if(phone.length() != 8) {
			lista.add("Informacion incorrecta - Numero de telefono: Ingrese un numero de 8 digitos porfavor");
			flag = 1;
		}
		if(celphone.length() != 8) {
			lista.add("Informacion incorrecta - Numero de celular: Ingrese un numero de 8 digitos porfavor \n");
			flag = 1;
		}
		
		mav.addObject("formulario", lista);
		if(flag == 1)
			mav.setViewName("commons/Resultado");
		else {
			mav.setViewName("commons/NoErrores");
		}
		return mav;
	}
}

