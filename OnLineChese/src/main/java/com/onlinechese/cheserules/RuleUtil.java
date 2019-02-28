package com.onlinechese.cheserules;

import com.onlinechese.vo.CheseIndex;
import com.onlinechese.vo.GeneralIndex;

public class RuleUtil {

	/*
	 * 判断棋子是本方还是 对面 
	 * @param code 传入的棋子编码
	 *        equalsCode 对比的棋子
	 *        是自己放的返回true
	 */
	public static boolean equalsMe(int code, int equalsCode) {
		if(equalsCode == 0) {
			return false;
		}
		return Math.abs(code + equalsCode) == Math.abs(code) + Math.abs(equalsCode) ? true : false;
	}
	
	/*
	 * 判断是否己方阵营 是返回true
	 * 否则 false
	 */
	public static boolean checkICamp(int code, int startY) {
		if(code > 0 && startY <= 4 && startY >= 0) {
			return true;
		}else if(code < 0 && startY <= 9 && startY >= 5 ) {
			return true;
		}
		return false;
	}
	public static int[][] initCheckerboard(){
		/*int[][] cheses ={
				{2,3,4,5,1,5,4,3,2},
				{0,0,0,0,0,0,0,0,0},
				{0,6,0,0,0,0,0,6,0},
				{7,0,7,0,7,0,7,0,7},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{-7,0,-7,0,-7,0,-7,0,-7},
				{0,-6,0,0,0,0,0,-6,0},
				{0,0,0,0,0,0,0,0,0},
				{-2,-3,-4,-5,-1,-5,-4,-3,-2}
		};*/
		//反转为x y轴对应
		int[][] cheses = {
				{2,0,0,7,0,0,-7,0,0,-2},
				{3,0,6,0,0,0,0,-6,0,-3},
				{4,0,0,7,0,0,-7,0,0,-4},
				{5,0,0,0,0,0,0,0,0,-5},
				{1,0,0,7,0,0,-7,0,0,-1},
				{5,0,0,0,0,0,0,0,0,-5},
				{4,0,0,7,0,0,-7,0,0,-4},
				{3,0,6,0,0,0,0,-6,0,-3},
				{2,0,0,7,0,0,-7,0,0,-2},
		};
		return cheses;
	}
	//检查棋子走位是否在棋盘 在返回true
	public static boolean checkOutBoard(CheseIndex cheseIndex) {
		int startX = cheseIndex.getStartX();
		if(!(startX>= 0 && startX <= 8))return false;
		int startY = cheseIndex.getStartY();
		if(!(startY>= 0 && startY <= 9))return false;
		int endX = cheseIndex.getEndX();
		if(!(endX>= 0 && endX <= 8))return false;
		int endY = cheseIndex.getEndY();
		if(!(endY>= 0 && endY <= 9))return false;
		return true;
	}
	//endcode 落下棋子的位置棋子 此时棋子落子已经通过检验
	public static boolean winGame(int endCode) {
		if(endCode == 0) {
			return false;
		}
		if(Math.abs(endCode) == CheseCode.General.getCode() ){
			return true;
		}
		return false;
	}
	
	
	
}
