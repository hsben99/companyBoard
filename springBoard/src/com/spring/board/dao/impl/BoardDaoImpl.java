package com.spring.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.UserVo;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String selectTest() throws Exception {
		// TODO Auto-generated method stub
		
		 String a = sqlSession.selectOne("board.boardList"); 
		  
		
		return a;
	}
	/**
	 * 
	 * */
	@Override
	public List<BoardVo> selectBoardList(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.boardList",boardVo);
	}
	
	@Override
	public int selectBoardCnt(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.boardTotal",boardVo);
	}
	
	@Override
	public BoardVo selectBoard(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.boardView", boardVo);
	}
	
	@Override
	public int boardInsert(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.boardInsert", boardVo);
	}
	@Override
	public int boardDelete(BoardVo boardVo)  {
		return sqlSession.delete("board.boardDelete",boardVo);
	}
	@Override
	public int boardUpdate(BoardVo boardVo) {
		return sqlSession.delete("board.boardUpdate",boardVo);
	}
	@Override
	public List<BoardVo> checkList(BoardVo boardVo) {
		return sqlSession.selectList("board.boardList",boardVo); 
	}
	@Override
	public List<BoardTypeVo> boardTypeList() {
		return sqlSession.selectList("board.boardTypeList");
	}
	@Override
	public UserVo jointable(String creator) {
		return sqlSession.selectOne("member.jointable",creator);
	}
	
	
	
}
