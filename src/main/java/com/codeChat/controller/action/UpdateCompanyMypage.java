package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyDAO;
import com.codeChat.dto.CompanyVO;

public class UpdateCompanyMypage implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		
		String url = "mypage/updateCompanyMypage.jsp";

		CompanyVO companyVO = new CompanyVO();
		
		companyVO.setId(request.getParameter("id"));
		
		companyVO.setPassword(request.getParameter("password"));
		companyVO.setName(request.getParameter("name"));
		companyVO.setAdmin_num(Integer.parseInt(request.getParameter("admin_num")));

		System.out.println("UpdateCompanyMypage : " + companyVO.getId());
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		companyDAO.updateCompany(companyVO);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
