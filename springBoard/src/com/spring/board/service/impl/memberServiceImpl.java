package com.spring.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.MemberDao;
import com.spring.board.service.memberService;
import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.MemberVo;
import com.spring.board.vo.UserVo;
@Service
public class memberServiceImpl implements memberService{
@Autowired
MemberDao dao;
	
	@Override
	public UserVo idCheck(UserVo userVo) {
		return dao.idCheck(userVo);
	}

	@Override
	public int insert(UserVo userVo) {
		return dao.insert(userVo);
	}

	@Override
	public List<BoardTypeVo> phonelist() {
		return dao.phonelist();
	}

	@Override
	public UserVo pwCheck(UserVo userVo) {
		return  dao.pwCheck(userVo);
	}

}
