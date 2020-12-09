package com.spring.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.MemberDao;
import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.MemberVo;
import com.spring.board.vo.UserVo;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public UserVo idCheck(UserVo userVo) {
		return sqlSession.selectOne("member.idCheck",userVo);
	}

	@Override
	public int insert(UserVo userVo) {
		return sqlSession.insert("member.insert",userVo);
	}

	@Override
	public List<BoardTypeVo> phonelist( ) {
		return sqlSession.selectList("member.phonelist");
	}

	@Override
	public UserVo pwCheck(UserVo userVo) {
		return sqlSession.selectOne("member.pwCheck",userVo);
	}

}
