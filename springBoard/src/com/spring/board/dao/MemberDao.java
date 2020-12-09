package com.spring.board.dao;

import java.util.List;

import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.MemberVo;
import com.spring.board.vo.UserVo;

public interface MemberDao {
	public UserVo idCheck(UserVo userVo);

	public int insert(UserVo userVo);

	public List<BoardTypeVo> phonelist();

	public UserVo pwCheck(UserVo userVo);
	
}
