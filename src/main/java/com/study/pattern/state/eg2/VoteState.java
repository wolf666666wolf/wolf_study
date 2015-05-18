package com.study.pattern.state.eg2;

public interface VoteState {

	public void vote(String user, String voteItem, VoteManager voteManager);
}
