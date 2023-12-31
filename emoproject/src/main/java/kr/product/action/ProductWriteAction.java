package kr.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.controller.Action;
import kr.product.dao.ProductDAO;
import kr.product.vo.ProductDetailVO;
import kr.product.vo.ProductManageVO;
import kr.util.FileUtil;

public class ProductWriteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		//회원번호 check - 로그인 여부
		if(user_num == null) {//로그인 X
			return "redirect:/member/loginForm.do";
		}
		
		//회원등급 check - 관리자 계정 여부
		Integer user_auth = (Integer)session.getAttribute("user_auth");
		if(user_auth < 9) {	//관리자 계정이 아니다
			return "/WEB-INF/views/common/notice.jsp";
		}

		
		//관리자로 로그인한 경우
		MultipartRequest multi = FileUtil.createFile(request);
		
		ProductManageVO product = new ProductManageVO();
		ProductDetailVO product_detail = new ProductDetailVO();
		
		product.setProduct_category(Integer.parseInt(multi.getParameter("category")));
		product.setProduct_status(Integer.parseInt(multi.getParameter("status")));
		
		product_detail.setProduct_name(multi.getParameter("name"));
		product_detail.setProduct_title(multi.getParameter("title"));
		product_detail.setProduct_info(multi.getParameter("info"));
		product_detail.setProduct_photo1(multi.getFilesystemName("photo1"));
		product_detail.setProduct_photo2(multi.getFilesystemName("photo2"));
		product_detail.setProduct_origin(multi.getParameter("origin"));
		product_detail.setProduct_real_price(Integer.parseInt(multi.getParameter("real_price")));
		product_detail.setProduct_price(Integer.parseInt(multi.getParameter("price")));
		product_detail.setProduct_stock(Integer.parseInt(multi.getParameter("stock")));
		product_detail.setProduct_discount(Integer.parseInt(multi.getParameter("discount")));
		
		ProductDAO dao = ProductDAO.getInstance();
		dao.insertItem(product, product_detail);
		
		//refresh 정보를 응답 헤더에 추가, 등록 후 2초뒤에 list.do로 이동
		//response.addHeader("Refresh", "2;url=list.do");
				
		request.setAttribute("accessMsg", "성공적으로 등록되었습니다.");
		request.setAttribute("accessUrl", "productlist.do");
				
		//accessMsg,accessUrl 설정시 잘못된 접근입니다 라는 문구가아니라 지정된 문구, 경로로 이동
		return "/WEB-INF/views/common/notice.jsp";
	}

}
