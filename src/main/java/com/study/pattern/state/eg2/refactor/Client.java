package com.study.pattern.state.eg2.refactor;

public class Client {
public static void main(String[] args) {
        
        VoteManager vm = new VoteManager();
        for(int i=0;i<10;i++){
            vm.vote("u1","A");
        }
    }
}