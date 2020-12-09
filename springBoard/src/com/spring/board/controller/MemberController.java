package com.spring.board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.service.memberService;
import com.spring.board.vo.UserVo;

@Controller
public class MemberController {

	@Autowired
	memberService service;
	
	@RequestMapping(value = "/member/logout.do")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate(); 
		return "redirect:/board/boardList.do";
	}

	@RequestMapping(value = "/member/join.do")
	public String join(Model model) {
		// 데이터에서 번호 앞자리 가져오기
		model.addAttribute("phoneList", service.phonelist());
		
		return "/member/join";
	}

	@RequestMapping(value = "/member/joinAction.do")
	@ResponseBody
	public int joinAction(Model model, UserVo userVo, HttpServletRequest request) {

		return service.insert(userVo);
	}

	@RequestMapping(value = "/member/login.do")
	public String login(Model model) {
		return "member/login";
	}

	@RequestMapping(value = "/member/loginAction.do")
	@ResponseBody
	public String loginAction(Model model, UserVo userVo, HttpServletRequest request)
			throws UnsupportedEncodingException {
		HttpSession session = request.getSession();
		String message = "";
		// 데이터 아이디 비번이랑 비교하기 
		if (service.idCheck(userVo) != null) {
			// 아이디 잇음
			message = "1";
			// pw체크 
			if (service.pwCheck(userVo) != null) {
				// 비번 성공
				message = "2";
				userVo = service.idCheck(userVo);
				// 세션 부여
				session.setAttribute("logId", userVo.getUSER_ID());
				session.setAttribute("logName", userVo.getUSER_NAME());
			} else {
				// 비번실패
				message = "3";
			}
		} else {
			// 아이디 없을
			message = "0";
		}
		return message;
	}

	@RequestMapping(value = "/member/idCheck.do")
	@ResponseBody
	public String idCheck(Model model, UserVo userVo, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String message = "";
		if (service.idCheck(userVo) == null) {
			// 가입가능
			message = "1";
		} else {
			// 가입불가능
			message = "0";
		}

		return message;
	}
	
}
