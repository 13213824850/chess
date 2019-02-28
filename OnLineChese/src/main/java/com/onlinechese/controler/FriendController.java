package com.onlinechese.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinechese.service.FriendService;
import com.onlinechese.util.Msg;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	@ApiOperation(value="我的好友列表")
	@RequestMapping("/getFriends/{userName}/{pn}")
	public Msg getFriends(@PathVariable("userName") String userName, @PathVariable("pn")Integer pn) {
		return friendService.getFriends(userName, pn);
	}
	
}
