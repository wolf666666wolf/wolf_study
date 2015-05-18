package com.study.pattern.state.eg2.refactor;

public interface VoteState {

	public void vote(String user, String voteItem, VoteManager voteManager);
}
