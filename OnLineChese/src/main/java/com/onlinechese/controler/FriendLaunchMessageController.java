package com.onlinechese.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinechese.service.FriendLaunchMessageService;
import com.onlinechese.util.Msg;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/friendLaunchMessage")
@CrossOrigin
public class FriendLaunchMessageController {

	@Autowired
	FriendLaunchMessageService friendLaunchMessageService;
	
	@ApiOperation(value="同意或拒绝好友请求")
	@PostMapping("/updateFriendLaunch/{launchUserName}/{state}/{cookie}")
	public Msg updateFriendLaunch(@PathVariable("cookie") String cookie, @PathVariable("state") Integer state
			, @PathVariable("launchUserName")String launchUserName) {
		return friendLaunchMessageService.updateFriendMessage(state, launchUserName, cookie);
	}
}
