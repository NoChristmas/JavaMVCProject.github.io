package kr.member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class CheckDuplicatedEmailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//전송된 데이터 반환
		String email = request.getParameter("email");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.checkMemberEmail(email);
		
		Map<String,String> mapAjax = 
				new HashMap<String,String>();
		if(member==null) {//이메일 미중복
			mapAjax.put("result", "emailNotFound");
		}else {//이메일 중복
			mapAjax.put("result", "emailDuplicated");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		//key와 value의 쌍으로 되어 있는 Map 데이터를
		//JSON형식의 문자열 데이터로 변환 후 반환
		String ajaxData = 
				mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);		
		//JSP 경로 반환
		return "/WEB-INF/views/common/ajax_view.jsp";
	}

}