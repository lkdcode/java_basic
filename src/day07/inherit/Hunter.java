package day07.inherit;


public class Hunter extends Player {
    int concentration; // 마력 게이지

    public Hunter(String nickName) {
        super(nickName);
        this.concentration = 20;
    }

    public void summonBeast() {
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# concentration = " + concentration);
    }
}