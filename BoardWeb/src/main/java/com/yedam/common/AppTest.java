package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AppTest {

	public static void main(String[] args) {
		
		SqlSessionFactory factory =  DataSource.getInstance();
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		
		
//		List<BoardVO> list = mapper.selectList();
//		list.forEach(board -> {
//			System.out.println(board.toString()); 
//		});
		BoardService svc = new BoardServiceImpl();
//		svc.boardList().forEach(System.out::println); // board -. System.out.println(board)
		BoardVO board = new BoardVO();
//		board.setTitle("입력테스트");
//		board.setContent("내용입니다");
//		board.setWriter("김씨");
//		svc.addBoard(board);
		board.setBoardNo(257);
		board.setTitle("수정테스트11");
		board.setContent("수정내용입니다");
		board.setWriter("김씨aa");
//		System.out.println(board.toString());
//		svc.modifyBoard(board);
//		svc.removeBoard(257);
//		svc.boardList().forEach(System.out::println); // board -. System.out.println(board)
		
		SearchDTO search = new SearchDTO();
		search.setSearchCondition("T");
		search.setKeyword("java");
		search.setPage(1);
		
		svc.boardList(search).forEach(System.out::println);
		
	}

}
