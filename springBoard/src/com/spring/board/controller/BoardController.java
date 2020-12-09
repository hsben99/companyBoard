package com.spring.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.HomeController;
import com.spring.board.service.boardService;
import com.spring.board.vo.BoardTypeVo;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.PageVo;
import com.spring.board.vo.UserVo;
import com.spring.common.CommonUtil;

@Controller
public class BoardController {

	@Autowired
	boardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/board/boardList.do", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model, PageVo pageVo, BoardVo boardVo) throws Exception {
		

		List<BoardVo> boardList = new ArrayList<BoardVo>();
		List<BoardTypeVo> boardTypeList = new ArrayList<BoardTypeVo>();
		int page = 1;
		int totalCnt = 0;
		String codeId="";
		
		if (boardVo.getPageNo() == 0) {
			boardVo.setPageNo(page);
		}
		
		//배열 값 db에서 받아오기
		boardTypeList = boardService.boardTypeList();
		for (int i = 0; i < boardTypeList.size(); i++) {
			codeId += boardTypeList.get(i).getCODE_ID()+",";
		}
		String codeIdArr[]= codeId.split(",");		
		if (boardVo.getSearchCheck() == null) {
			boardVo.setSearchCheck(codeIdArr);
		} 
		boardList = boardService.SelectBoardList(boardVo);
		totalCnt = boardService.selectBoardCnt(boardVo);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardTypeList", boardTypeList);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("pageNo", page);

		return "board/boardList";
	}

	@RequestMapping(value = "/board/boardWrite.do", method = RequestMethod.GET)
	public String boardWrite(Locale locale, Model model) throws Exception {

		List<BoardTypeVo> typeList = boardService.boardTypeList();
		model.addAttribute("typeList", typeList);
		return "board/boardWrite";
	}

	@RequestMapping(value = "/board/boardWriteAction.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardWriteAction(Locale locale, BoardVo boardVo) throws Exception {

		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		System.out.println("크리에이터!!!"+boardVo.getCreator());
		int resultCnt = boardService.boardInsert(boardVo);
		
		result.put("success", (resultCnt > 0) ? "Y" : "N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ", result);
		System.out.println("callbackMsg::" + callbackMsg);
		return callbackMsg;
	}

//delete
	@RequestMapping(value = "/board/boardDelete.do")
	@ResponseBody
	public String boardDelete(Model model, BoardVo boardVo) throws IOException {
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		int resultCnt = boardService.boardDelete(boardVo);
		result.put("success", (resultCnt > 0) ? "Y" : "N");

		String callbackMsg = commonUtil.getJsonCallBackString(" ", result);

		return callbackMsg;
	}

	@RequestMapping(value = "/board/{boardType}/{boardNum}/boardView.do", method = RequestMethod.GET)
	public String boardView(Locale locale, Model model, @PathVariable("boardType") String boardType,
			@PathVariable("boardNum") int boardNum) throws Exception {

		BoardVo boardVo = new BoardVo();
		boardVo = boardService.selectBoard(boardType, boardNum);
		
		//board.creator 로 user.ID 가져와야함
		UserVo userVo = boardService.jointable(boardVo.getCreator()); 
		System.out.println("userVO!!!!!!"+userVo.getUSER_ID());
		
		model.addAttribute("userName", userVo.getUSER_NAME());
		model.addAttribute("boardType", boardType);
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", boardVo);

		return "/board/boardView";
	}

//updatef 
	@RequestMapping(value = "/board/{boardType}/{boardNum}/boardUpdatef.do")
	public String boardUpdatef(Model model, BoardVo boardVo, @PathVariable("boardType") String boardType,
			@PathVariable("boardNum") int boardNum) throws Exception {

		boardVo = boardService.selectBoard(boardType, boardNum);
		model.addAttribute("board", boardVo);

		return "board/boardUpdatef";
	}

	// update
	@RequestMapping(value = "/board/boardUpdateAction.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardUpdateAction(Locale locale, BoardVo boardVo) throws Exception {
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		int resultCnt = boardService.boardUpdate(boardVo);
		result.put("success", (resultCnt > 0) ? "Y" : "N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ", result);
		System.out.println("callbackMsg::" + callbackMsg);
		return callbackMsg;
	}

	@RequestMapping(value = "/board/searchList.do", method = RequestMethod.GET)
	public String searchList(Locale locale, Model model, PageVo pageVo, BoardVo boardVo) throws Exception {

		List<BoardVo> boardList = new ArrayList<BoardVo>();

		int page = 1;
		int totalCnt = 0;

		if (pageVo.getPageNo() == 0) {
			pageVo.setPageNo(page);
		}

		boardList = boardService.SelectBoardList(boardVo);
		totalCnt = boardService.selectBoardCnt(boardVo);

		model.addAttribute("boardList", boardList);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("pageNo", page);

		return "board/boardList";
	}
	//없어도됨
	/*@RequestMapping(value = "/board/listCheck.do")
	public String checkList(Model model, BoardVo boardVo, PageVo pageVo) throws Exception {
		List<BoardTypeVo> typeList = new ArrayList<BoardTypeVo>();
		typeList = boardService.boardTypeList();

		int page = 1;
		int totalCnt = 0;

		if (boardVo.getPageNo() == 0) {
			boardVo.setPageNo(page);// BoardVo 가 PageVo 상속받아서
		}

		String[] searchCheck = { "a01", "a02", "a03","a04" };

		if (boardVo.getSearchCheck() == null) {
			boardVo.setSearchCheck(searchCheck);
		}

		List<BoardVo> list = null;
		if (boardVo.getSearchCheck() != null && boardVo.getSearchCheck().length > 0) {
			list = boardService.checkList(boardVo);
		} else {
			list = boardService.SelectBoardList(boardVo);
		}
		totalCnt = boardService.selectBoardCnt();
		
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("boardList", list);
		model.addAttribute("boardTypeList", typeList);
		return "board/boardList";
	}
	 */
	
}
