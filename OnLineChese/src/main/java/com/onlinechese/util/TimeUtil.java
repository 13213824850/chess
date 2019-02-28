package com.onlinechese.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String getDifferTime(Date now, Date old) {
		long time = (now.getTime() - old.getTime());
		if (time > 2592000) {
			return "最后登录时间为：" + new SimpleDateFormat().format(old);
		}
		String differTime;
		int day = 0;
		if (time > 108000) {
			day = (int) (time / 108000);
			time = time % 108000;
		}
		int hourse = 0;
		if (time > 3600) {
			hourse = (int) (time / 3600);
			time = time % 3600;
		}
		int minutes = (int) (time / 60);
		if (day > 0) {
			differTime = day + "天";
		} else {
			if (hourse > 0) {
				differTime = hourse + "时";
			} else {
				differTime = minutes + "分钟";
			}
		}

		return differTime + "前在线";

	}
}
