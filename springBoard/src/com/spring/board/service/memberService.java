package com.spring.board.service;

import java.util.List;

import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.MemberVo;
import com.spring.board.vo.UserVo;

public interface memberService {

	public UserVo idCheck(UserVo userVo);

	public int insert(UserVo userVo);

	public List<BoardTypeVo> phonelist( );


	public UserVo pwCheck(UserVo userVo);
}
