package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.AddFormControl;
import com.yedam.control.AddMemberControl;
import com.yedam.control.MainControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.SubControl;
import com.yedam.control.indexControll;
import com.yedam.control.introControll;



@WebServlet("*.do")
public class FrontController extends HttpServlet{
	//url pattern = 실행되는 기능 -> map 컬렉션에 지정.
	
	Map<String, Control> map;
	
	
	public FrontController () {
		System.out.println("FrontController 생성자");
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드");
		map.put("/main.do", new MainControl());
		map.put("/sub.do", new SubControl());
		
		//기능등록.
		map.put("/addMember.do", new AddMemberControl());
		map.put("/addForm.do", new AddFormControl()); //회원등록페이지.
		map.put("/intro.do", new introControll());
		map.put("/index.do", new indexControll());
		map.put("/memberList.do", new MemberListControl());
	}
	
	//-> 톰캣이 이닛과 서비스사이에서 밑에거 두개 객체를 생성함.(HttpServletRequest,HttpServletReponse)
	//그래서 서비스메서드한테 전달해줌.
	//HttpServletRequest
	//HttpServletReponse
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("service 메소드");
		String uri = req.getRequestURI(); //http://localhost/BoardWeb/main.do // uri = BoardWeb/main.do //  BoardWeb(프로젝트명)/main.do(요청하는 페이지)
		String context =  req.getContextPath(); // /BoardWeb
		String page = uri.substring(context.length()); // /main.do
		System.out.println(page);
		
		Control control = map.get(page);
		control.exec(req, resp);
		
		
	}
	
	
}
