package com.study.pattern.state.eg2.refactor;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {

	 //持有状体处理对象
    private VoteState state = new NormalVoteState();
    //记录用户投票的结果，Map<String,String>对应Map<用户名称，投票的选项>
    private Map<String,String> mapVote = new HashMap<String,String>();
    //记录用户投票次数，Map<String,Integer>对应Map<用户名称，投票的次数>
    private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();
    /**
     * 获取用户投票结果的Map
     */
    public Map<String, String> getMapVote() {
        return mapVote;
    }
    /**
     * 投票
     * @param user    投票人
     * @param voteItem    投票的选项
     */
    public void vote(String user,String voteItem){
 
        //然后转调状态对象来进行相应的操作
        state.vote(user, voteItem, this);
    }
	public VoteState getState() {
		return state;
	}
	public void setState(VoteState state) {
		this.state = state;
	}
	
	public Integer getVoteCount(String user) {
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }		
		return oldVoteCount;
	}
	public void addUserVoteCount(String user){
		Integer oldVoteCount = getVoteCount(user);
		mapVoteCount.put(user, oldVoteCount+1);
	}
//	public void setMapVoteCount(Map<String, Integer> mapVoteCount) {
//		this.mapVoteCount = mapVoteCount;
//	}
//	public void setMapVote(Map<String, String> mapVote) {
//		this.mapVote = mapVote;
//	}	
    
    
}
