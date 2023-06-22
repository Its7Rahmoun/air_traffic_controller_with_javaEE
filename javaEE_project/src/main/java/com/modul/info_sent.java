package com.modul;

import java.io.Serializable;

public class info_sent implements Serializable {
	
	private position pos;
	private int planeId;
	public position getPos() {
		return pos;
	}
	public void setPos(position pos) {
		this.pos = pos;
	}
	public info_sent(position pos, int plane) {
		super();
		this.pos = pos;
		this.planeId = plane;
	}

	
	public int getPlaneId() {
		return planeId;
	}
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}
	public info_sent() {

	}
	

}
