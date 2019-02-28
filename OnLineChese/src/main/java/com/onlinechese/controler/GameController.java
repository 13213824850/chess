package com.onlinechese.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinechese.service.GameService;
import com.onlinechese.util.Msg;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/play")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@ApiOperation(value="获取棋盘信息",notes="棋盘对应存储id  用户执哪方棋子")
	@GetMapping("/getCheckBoardInfo")
	public Msg getCheckBoardInfo(@CookieValue(value="usercookie") String cookie) {
		return gameService.getCheckBoardInfo(cookie);
	}
	@GetMapping("/getCookie")
	public String getCookie(@CookieValue("usercookie")String cookie) {
		return cookie;
	}
}
