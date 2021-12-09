package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.StudentDAO;
import com.hanul.dao.TestDAO;
import com.hanul.dto.TestDTO;

public class examAction implements Action {
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		TestDTO dto = new TestDTO();
		
		
		dto.setSubject(request.getParameter("subject"));
		
		
		
		
		
		System.out.println(dto.getTest10());
		
		TestDAO dao = new TestDAO();
		dao.getSubject(dto);
		
		
		response.setContentType("text/html; charset=utf-8");
		
		
		return null;
	}
}
