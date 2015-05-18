package com.study.pattern.state.eg2.refactor;

public class NormalVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
        //正常投票，记录到投票记录中
//        voteManager.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功");
        voteManager.addUserVoteCount(user);
        voteManager.setState(new RepeatVoteState());
     }

}
