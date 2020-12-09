package com.spring.board.service;

import java.util.List;

import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.PageVo;
import com.spring.board.vo.UserVo;

public interface boardService {

	public String selectTest() throws Exception;

	public List<BoardVo> SelectBoardList(BoardVo boardVo) throws Exception;

	public BoardVo selectBoard(String boardType, int boardNum) throws Exception;

	public int selectBoardCnt(BoardVo boardVo) throws Exception;

	public int boardInsert(BoardVo boardVo) throws Exception;

	public int boardDelete(BoardVo boardVo);

	public int boardUpdate(BoardVo boardVo);

	public List<BoardVo> checkList(BoardVo boardVo);

	public List<BoardTypeVo> boardTypeList();

	public UserVo jointable(String creator);

}
