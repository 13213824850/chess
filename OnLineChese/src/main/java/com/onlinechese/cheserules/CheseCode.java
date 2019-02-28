package com.onlinechese.cheserules;

import lombok.Getter;

@Getter
public enum CheseCode {

	Empty("无棋子",0),
	General("将",1),
	Vehicle("車", 2),
	Hourse("马", 3),
	Elephant("象",4),
	BodyGuard("士",5),
	Cannon("炮",6),
	Soldier("兵",7),
	
    Red("红方",0),
    Back("黑色",1);
	private String cheseName;
	private int code;

	private CheseCode(String cheseName, int code) {
		this.cheseName = cheseName;
		this.code = code;
	}
    public static CheseCode matchChese(int code) {
    	for(CheseCode cc : CheseCode.values()) {
    		if(cc.getCode() == code) {
    			return cc;
    		}
    	}
    	return null;
    }
}
