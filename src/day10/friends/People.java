package day10.friends;

import java.util.ArrayList;
import java.util.List;

public class People {
    private String nickName; // 닉네임

    // 팔로워 목록
    private List<People> followers;

    // 팔로워 대기목록
    private List<People> followerWaitList;

    // 팔로잉 목록
    private List<People> followings;

    public People(String nickName) {
        this.nickName = nickName;
        this.followers = new ArrayList<>();
        this.followerWaitList = new ArrayList<>();
        this.followings = new ArrayList<>();
    }

    // 팔로워 대기목록에 팔로우 요청한 사람을 추가하는 기능
    public void addFollowerWaitList(People requestPerson) {
        this.followerWaitList.add(requestPerson);
    }

    // 팔로워 목록에 팔로우 수락한 사람을 추가하는 기능
    public void addFollower(People requestsPerson) {
        // 내 팔로워 목록에 상대방 추가
        this.followers.add(requestsPerson);
        // 내 팔로워 대기목록에서 상대방 삭제
        this.followerWaitList.remove(requestsPerson);
        // 상대방의 팔로잉 목록에 나 추가ㄷㄱㅇㄹㅊ
        requestsPerson.followings.add(this);
    }

    // 팔로워 대기목록에서 닉네임들을 보여주는 기능
    public List<String> showFollowerWaitPerson() {
        // 팔로워대기목록 사람들 이름만 저장할 리스트
        List<String> waitListNames = new ArrayList<>();

        for (People people : followerWaitList) {
            waitListNames.add(people.nickName);
        }

        return waitListNames;
    }


    // 팔로워 목록에서 닉네임들을 보여주는 기능
    public List<String> showFollower() {
        List<String> waitListNames = new ArrayList<>();

        for (People people : followers) {
            waitListNames.add(people.nickName);
        }

        return waitListNames;
    }

}