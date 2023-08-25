package kr.member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.member.dao.MemberDAO;

public class AdminMemberExpireAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,String> mapAjax =
				new HashMap<String,String>();
		
		HttpSession session = 
				       request.getSession();
		Integer user_num = 
				(Integer)session.getAttribute(
						            "user_num");
		Integer user_auth=(Integer)session.getAttribute("user_auth");
		
		if(user_num==null) {//로그인이 되지 않은 경우
			mapAjax.put("result", "logout");
		}else {//로그인 된 경우
			int mem_num=Integer.parseInt(request.getParameter("mem_num"));
			MemberDAO dao=MemberDAO.getInstance();
			if(user_auth<9) {
				//관리자 아닐경우
				mapAjax.put("result", "wrongAccess");
			}else {
				dao.MemberOut(mem_num);
				mapAjax.put("result", "success");
			}
		}
		
		//JSON 데이터 생성
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = 
				mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);
		
		return "/WEB-INF/views/common/ajax_view.jsp";
	}


}
