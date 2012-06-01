package com.diycomputerscience.example.sanddi;

public class BoardState {

	private boolean open;
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public boolean isOpen() {
		return this.open;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (open ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardState other = (BoardState) obj;
		if (open != other.open)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "" + this.open;
	}
}
