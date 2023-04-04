package day07.lotto;

import java.util.*;

import static java.lang.Math.*;

public class Lotto {
    private static List<Integer> getLottoNumbers() {
        List<Integer> winNumbers = new ArrayList<>();

        while (winNumbers.size() < 6) {
            int number = (int) floor(random() * 45) + 1;
            if (!winNumbers.contains(number)) winNumbers.add(number);
        }

        Collections.sort(winNumbers);
        return winNumbers;
    }

    public static void information() {
        System.out.println(getLottoNumbers());
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputNumbers = new ArrayList<>();

        System.out.print("# 첫 번째 번호를 입력해주세요 >> ");
        inputNumbers.add(sc.nextInt());
        System.out.print("# 두 번째 번호를 입력해주세요 >> ");
        inputNumbers.add(sc.nextInt());
        System.out.print("# 세 번째 번호를 입력해주세요 >> ");
        inputNumbers.add(sc.nextInt());
        System.out.print("# 네 번째 번호를 입력해주세요 >> ");
        inputNumbers.add(sc.nextInt());
        System.out.print("# 다섯 번째 번호를 입력해주세요 >> ");
        inputNumbers.add(sc.nextInt());
        System.out.print("# 여섯 번째 번호를 입력해주세요 >> ");
        inputNumbers.add(sc.nextInt());

        int count = 1;
        Collections.sort(inputNumbers);

        reset:
        while (true) {
            List<Integer> lotto = getLottoNumbers();
            System.out.println("# " + count++ + "번째 시도! ##### 입력한 번호 >> " + inputNumbers + " 당첨 번호 >>>   " + lotto);

            for (int i = 0; i < inputNumbers.size(); i++) {
                if (lotto.get(i) != inputNumbers.get(i)) continue reset;
            }
            break;
        }
        System.out.println("# " + count + "번만에 당첨");
    }

}
