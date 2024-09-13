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
import com.yedam.control.EventControl;
import com.yedam.control.GetMemberControl;
import com.yedam.control.JavaScriptControl;
import com.yedam.control.MainControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModFormControl;
import com.yedam.control.ModifyMemberControl;
import com.yedam.control.RemoveMemberControl;
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
		map.put("/javascript.do", new JavaScriptControl());
		
		// fullcalendar 관련.
		map.put("/eventList.do", new EventControl());
		map.put("/addEvent.do", new EventControl());
		map.put("/removeEvent.do", new EventControl());
		map.put("/chart.do", new EventControl());
		map.put("/showChart.do", new EventControl());
		
		Map<String, Control> memberMenu = MenuMember.getInstance().menuMap();
		Map<String, Control> boardMenu  = MenuBoard.getInstance().menuMap();
		Map<String, Control> replyMenu = MenuReply.getInstance().menuMap();
		
		
		//이렇게 나눈 이유는 충돌위험떄문에 한개의 파일에 작업을 여러사람이 나눠서 써서 충돌위험있음.
		
		map.putAll(memberMenu);//멤버관련 메뉴추가
		map.putAll(boardMenu);//게시글 관련 추가
		map.putAll(replyMenu);
		//기능등록.
//		map.put("/addMember.do", new AddMemberControl());  //회원등록처리
//		map.put("/addForm.do", new AddFormControl()); //회원등록페이지.
//		map.put("/intro.do", new introControll());
//		map.put("/index.do", new indexControll());
//		map.put("/memberList.do", new MemberListControl()); 
//		map.put("/getMember.do", new GetMemberControl()); // 회원아이디를 기준으로 상세조회;
//		map.put("/modifyForm.do", new ModFormControl());  //수정화면 호출
//		map.put("/modifyMember.do", new ModifyMemberControl()); //수정처리
//		map.put("/removeMember.do", new RemoveMemberControl());
		
		//가능을 추가합니다.
	}
	
	//-> 톰캣이 이닛과 서비스사이에서 밑에거 두개 객체를 생성함.(HttpServletRequest,HttpServletReponse)
	//그래서 서비스메서드한테 전달해줌.
	//HttpServletRequest ->서비스탄생순간 사라짐
	//HttpServletReponse
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//요청방식이 post일경우에 body포함된 문자열 인코딩
		
		System.out.println("service 메소드");
		String uri = req.getRequestURI(); //http://localhost/BoardWeb/main.do // uri = BoardWeb/main.do //  BoardWeb(프로젝트명)/main.do(요청하는 페이지)
		String context =  req.getContextPath(); // /BoardWeb
		String page = uri.substring(context.length()); // /main.do
		
		Control control = map.get(page);
		control.exec(req, resp);
		
		
	}
	
	
}
