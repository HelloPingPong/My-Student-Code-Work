package com.techelevator;

public class Bid {

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}

	public String getBidder() {
		return bidder;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	@Override
	public String toString() {
		return "Bidder: " + bidder + "\nAmount: " + bidAmount;
	}

	@Override
	public boolean equals(Object obj) {
		Bid otherBid = (Bid) obj;
		if (this.bidder.equals( otherBid.getBidder() ) &&
				this.bidAmount == otherBid.getBidAmount()) {
			return true;
		}
		return false;
	}
}
