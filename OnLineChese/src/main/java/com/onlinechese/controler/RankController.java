package com.onlinechese.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinechese.service.RankService;
import com.onlinechese.util.Msg;

import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping("/rank")
public class RankController {

	@Autowired
	RankService rankService;
	
	//获取段位信息
	@ApiOperation(value="查询玩家段位信息")
	@GetMapping("/getRank/{userName}")
	public Msg getRankByUserId(@PathVariable("userName") String userName) {
		return rankService.getRankByIdMsg(userName);
	}
}
