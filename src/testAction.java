package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.StudentDAO;
import com.hanul.dto.StudentDTO;
import com.sun.org.apache.xml.internal.serialize.Printer;


public class testAction implements Action{

		@Override
		public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
	
			request.setCharacterEncoding("utf-8");
			StudentDTO dto = new StudentDTO();
			dto.setCode(Integer.parseInt(request.getParameter("code")));
			dto.setName(request.getParameter("name"));
			
			StudentDAO dao = new StudentDAO();
			dao.getStudent(dto);

			request.setAttribute("code", dto.getCode());
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>alert('"+dto.getName()+"학생 시험을 시작합니다.');");
			
			//action forward로 경로 설정
			ActionForward forward = new ActionForward();
			forward.setPath("board/exam.jsp");
			forward.setRedirect(false);		
			return forward;
	}
}
