package com.study.pattern.state.eg2.refactor;

public class RepeatVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
        //重复投票，暂时不做处理
        System.out.println("请不要重复投票");
        voteManager.addUserVoteCount(user);
        if(voteManager.getVoteCount(user)>= 4){
        	voteManager.setState(new SpiteVoteState());
        }
        
	}

}
