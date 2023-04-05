package day07.inherit;


import static day07.util.Utility.makeLine;

public class Mage extends Player {
    int mana; // 마력 게이지

    public Mage(String nickName) {
        super(nickName);
        this.mana = 100;
    }

    // 썬더볼트
    public void thunderBolt(Player... targets) {
        System.out.println("# " + this.nickName + "님 썬더볼트 시전!!!!");
        makeLine();

        for (Player target : targets) {
            if (target == this) {
                System.out.println("## 본인은 공격 불가 ##");
                continue;
            }
            int damage = thunderBoltDamage();
            target.attackSetHp(damage);
            System.out.println(target.nickName + "님이 " + damage + "의 피해를 입었습니다.(남은 체력: " + target.hp + ")");
        }
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# mana " + this.mana);
    }

    public int thunderBoltDamage() {
        return (int) (Math.random() * 6) + 10;
    }
}
