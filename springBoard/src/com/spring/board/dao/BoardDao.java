package com.spring.board.dao;

import java.util.List;

import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.UserVo;

public interface BoardDao {

	public String selectTest() throws Exception;

	public List<BoardVo> selectBoardList(BoardVo boardVo) throws Exception;

	public BoardVo selectBoard(BoardVo boardVo) throws Exception;

	public int selectBoardCnt(BoardVo boardVo) throws Exception;

	public int boardInsert(BoardVo boardVo) throws Exception;

	public int boardDelete(BoardVo boardVo);

	public int boardUpdate(BoardVo boardVo);

	public List<BoardVo> checkList(BoardVo boardVo);

	public List<BoardTypeVo> boardTypeList();

	public UserVo jointable(String creator);

}
