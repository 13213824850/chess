package com.onlinechese.cheserules;

import org.springframework.stereotype.Component;

import com.onlinechese.vo.GeneralIndex;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Rule {
	/* 默认传进来的坐标点在棋盘内
	 * 象棋规则： 棋盘由横9竖10 9*1组成 可以看成一个二维数组 有7种旗子两方阵营组成
	 * 返回true则符合规则
	 */
	public static boolean checkRules(int[][] cheses, int startX, int startY, int endX, int endY) {
		int code = cheses[startX][startY];
		//判断拿起的棋子是否是自己的
		if(cheses[startX][startY] == 0 || !RuleUtil.equalsMe(code, cheses[startX][startY])) {
			return false;
		}
		if(RuleUtil.equalsMe(code, cheses[endX][endY])) {
			return false;
		}
		CheseCode cc = CheseCode.matchChese(Math.abs(code));
		log.info("cc",cc.getCheseName());
		switch (cc) {
		case General:
			return checkGeneral(cheses, startX, startY, endX, endY);
		case Vehicle:
			return checkVehicle(cheses, startX, startY, endX, endY);
		case Hourse:
			return checkHourse(cheses, startX, startY, endX, endY);
		case Elephant:
			return checkElephant(cheses, startX, startY, endX, endY);
		case BodyGuard:
			return checkBodyGuard(cheses, startX, startY, endX, endY);
		case Cannon:
			return checkCannon(cheses, startX, startY, endX, endY);
		case Soldier:
			return checkSoldier(cheses, startX, startY, endX, endY);
		}
		return false;
	}

	/*
	 * 兵走棋规则
	 * 己方战营只能前进一格过楚河 增加可在X轴移动  
	 */
	private static boolean checkSoldier(int[][] cheses, int startX, int startY, int endX, int endY) {
		int code = cheses[startX][startY];
		boolean checkICamp = RuleUtil.checkICamp(code, startY);
		int result = code > 0 ? 1 : -1 ; //由于判断棋子在棋盘哪方 从而判断兵前进一步 y轴始末差是1 还是-1 
		if(checkICamp) {
			if(startX == endX && endY - startY == result)return true;
		}else if(!checkICamp){
			if(startX == endX && endY - startY == result)return true;
		    if(startY == endY && Math.abs(startX - endX) == 1) return true;
		}
		return false;
	}

	/*
	 * 炮规则 end位置若有对方棋子 始末中间需要一个棋子 若没有棋子 则中间无棋子
	 * 横竖走 
	 */
	private static boolean checkCannon(int[][] cheses, int startX, int startY, int endX, int endY) {
		//不吃棋
		if(cheses[endX][endY] == 0) {
			//遍历中间是否有棋子
			return checkMiddle(cheses, startX, startY, endX, endY);
		}else if(cheses[endX][endY] != 0){
			int count = 0;
			if(startX - endX == 0 ) {
				//遍历y轴始末中间有且自有一个棋子返回true  否则false
				int start = startY - endY > 0 ? endY : startY;
				int end = startY - endY > 0 ? startY : endY;
				for(int i = start + 1 ; i < end; i++) {
					if(cheses[startX][i] != 0) {
						count++;
					}
				}
				
				log.info("棋子移动中间的棋子数量{}",count);
				if(count == 1) {
					return true;
				}else {
					return false;
				}
			}else if(startY - endY == 0) {
				//遍历X轴始末中间有没有棋子
				int result = startX - endX > 0 ? endX : startX;
				int end = startX - endX > 0 ? startX : endX;
				for(int i = result + 1 ; i < end; i++) {
					if(cheses[i][startY] != 0) {
						count++;
					}
				}
				log.info("棋子移动中间的棋子数量{}",count);
				if(count == 1) {
					return true;
				}else {
					return false;
				}
				
			}
		}
		return false;
	}

	/*
	 * 士规则
	 * 活动范围x:3 - 5 y:0 - 2 && 7 - 9
	 */
	private static boolean checkBodyGuard(int[][] cheses, int startX, int startY, int endX, int endY) {
		
		if(endX >= 3 && endX <= 5) {
			//检查士的位置
			if((endY >= 0 && endY <= 2) || (endY >= 7 && endY <= 9)) {
				if(Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * 象走棋规则
	 * 轴差2 轴中心不能有棋子
	 */
	private static boolean checkElephant(int[][] cheses, int startX, int startY, int endX, int endY) {
		boolean checkICamp = RuleUtil.checkICamp(cheses[startX][startY], startY);
		boolean checkICampEnd = RuleUtil.checkICamp(cheses[startX][startY], endY);
		if(!(checkICamp && checkICamp)) return false;
		if(Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 2) {
			//取值result靠近0,0点
			int resultX = (startX + endX)/2;
			int resultY = (startY + endY)/2;
			if(cheses[resultX][resultY] == 0 ) {
				return true;
			}
		}
		return false;
	}

	/*
	 * 車规则 横竖走 始末中间不能有棋子
	 */
	private static boolean checkVehicle(int[][] cheses, int startX, int startY, int endX, int endY) {
		return checkMiddle(cheses,startX,startY,endX,endY);
	}

	
	private static boolean checkMiddle(int[][] cheses,int startX, int startY, int endX, int endY) {
		if(startX == endX ) {
			//遍历y轴始末中间有没有棋子
			int result = startY - endY > 0 ? endY : startY;
			int end = startY - endY > 0 ? startY : endY;
			for(int i = result + 1 ; i < end; i++) {
				if(cheses[startX][i] != 0) {
					return false;
				}
			}
			return true;
		}else if(startY == endY ) {
			//遍历X轴始末中间有没有棋子
			int result = startX - endX > 0 ? endX : startX;
			int end = startX - endX > 0 ? startX : endX;
			for(int i = result + 1 ; i < end; i++) {
				if(cheses[i][startY] != 0) {
					return false;
				}
			}
			return true;
		}
		return false;
		
	}

	/*
	 * 马走棋规则 两格斜对角 不能别马腿
	 * 利用始末轴点差判断需要在哪个地方检验是否别马腿
	 * 如x轴绝对值差2 需要在startX+1 位置判断有没有棋子
	 * 
	 */
	
	private static boolean checkHourse(int[][] cheses, int startX, int startY, int endX, int endY) {
		int code = 0;
		if(Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2 ) {
			code = cheses[startX][(startY + endY)/2];
		}else if(Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1) {
			 code = cheses[(startX + endX)/2][startY];
		}else {
			return false;
		}
		log.info("->{}在马腿位置", code);
		//判断是否别马腿是的话返回false
		if(code == 0  ) return true;
		return false;
	}

	/*
	 * 将走棋规则 在田字里面走 3 <= endX <= 5    0 <= endY <= 2
	 * 只能横竖走 不能落棋在已存在己方的棋子上面
	 */
	private static boolean checkGeneral(int[][] cheses, int startX, int startY, int endX, int endY) {
		int code = cheses[startX][startY];
		if(code > 0) {
			if(!(3 <= endX && endX <= 5 && 0 <= endY && endY <= 2)) return false;

		}else {
			if(!(3 <= endX && endX <= 5 && 7 <= endY && endY <= 9)) return false;
		}
		int resultX = endX - startX;
		int resultY = endY - startY;
		int result = Math.abs(resultX) + Math.abs(resultY);
		if(result == 1) {
			return true;
		}
	
		return false;
	}
	
	//判断是否将军code 移动的棋子
		public static boolean jiangJun(int[][]cheses, int code) {
			int len = cheses.length;
			int lenj = cheses[0].length;
			GeneralIndex generalIndex = getGeneralIndex(code, cheses);
			int x = generalIndex.getX();
			int y = generalIndex.getY();
				//判断黑方被将军否
				//查黑方将位置
				for(int i = 0; i < len; i++ ) {
					for(int j = 0; j < lenj; j++ ) {
						if((cheses[i][j] > 0 && code > 0) || (cheses[i][j] < 0 && code < 0)
								&& checkRules(cheses, i, j, x, y)) {
								return true;
						}
					}
				}
			return false;
		}
		
		//查找对方将位置
		public static GeneralIndex getGeneralIndex(int code, int[][] cheses) {
			GeneralIndex generalIndex = new GeneralIndex();
			int y = 0;
			if(code > 0) {
				y = 7;
			}else {
				y = 0;
			}
			for(int i = 3; i <= 5; i++ ) {
				for(int j = y; j <= y+2; j++ ) {
					if(Math.abs(cheses[i][j]) == CheseCode.General.getCode()) {
						generalIndex.setX(i);
						generalIndex.setY(j);
						return generalIndex;
					}
					
				}
			}
			return generalIndex;
		}
	
}
