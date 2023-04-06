package day09.music;

import java.util.List;

public class SystemController {
    private InputView inputView;
    private SingerRepository singerRepository;

    public SystemController() {
        this.inputView = new InputView();
        this.singerRepository = new SingerRepository();
    }

    public void start() {
        while (true) {
            menuView();
            System.out.print(">> ");
            String inputMenuNumber = inputView.menuNumber();

            switch (inputMenuNumber) {
                case "1":
                    insertMenu();
                    break;
                case "2":
                    songListViewMenu();
                    break;
                case "3":
                    exit();
                default:
                    System.out.println("\n# 잘 못 입력하셨습니다. 다시 입력해주세요. \n");
            }
        }
    }

    private void menuView() {
        System.out.println("\n**** 음악 관리 프로그램 ****");
        System.out.println("# 현재 등록된 가수: " + singerRepository.getSingerList().size() + "명");
        System.out.println("# 1. 노래 등록하기");
        System.out.println("# 2. 노래 정보 검색");
        System.out.println("# 3. 프로그램 종료");
        System.out.println("============================");
    }

    private void insertMenu() {
        System.out.println("\n# 노래 등록을 시작합니다.");
        System.out.print("- 가수명: ");
        String inputSinger = inputView.singerName();
        System.out.print("- 곡명: ");
        String inputSong = inputView.songName();
        validateSinger(inputSinger, inputSong);
    }

    private void validateSinger(String inputSinger, String inputSong) {
        Singer singer = findSingerByName(inputSinger);

        if (singer == null || singerRepository.getSingerList().isEmpty()) {
            insertNewSinger(inputSinger, inputSong);
        } else {
            addSong(singer, inputSong);
        }
    }

    private void addSong(Singer singer, String inputSongName) {
        List<String> songList = singer.getSongList();
        for (String song : songList) {
            if (song.equals(inputSongName)) {
                System.out.println("# [" + inputSongName + "] 은(는) 이미 등록된 노래입니다.");
                return;
            } else {
                singer.insertSong(inputSongName);
                System.out.println("# " + singer.getName() + "님의 노래 목록에 '" + inputSongName + "' 곡이 추가 되었습니다.");
                return;
            }
        }
    }

    private void insertNewSinger(String name, String song) {
        singerRepository.insertSinger(new Singer(name, song));
        System.out.println("# 아티스트 [" + name + "]님이 신규 등록되었습니다.");
    }

    private Singer findSingerByName(String name) {
        List<Singer> singerList = singerRepository.getSingerList();

        for (Singer singer : singerList) {
            if (singer.getName().equals(name)) {
                return singer;
            }
        }

        return null;
    }

    private void songListViewMenu() {
        System.out.println("\n# 검색할 가수명을 입력하세요.");
        System.out.print("- 가수명: ");

        String inputName = inputView.singerName();

        Singer singer = findSingerByName(inputName);
        if (singer != null) {
            singerInformation(singer);
        } else {
            System.out.println("# 해당 가수는 등록되지 않았습니다.");
        }
    }

    private void singerInformation(Singer singer) {
        List<String> songList = singer.getSongList();

        System.out.println("\n# " + singer.getName() + "님의 노래목록");
        System.out.println("=============================================");

        for (int i = 0; i < songList.size(); i++) {
            System.out.println("* " + (i + 1) + ". " + songList.get(i));
        }

        System.out.println();
    }

    private void exit() {
        System.out.println("\n# 프로그램을 종료합니다.");
        System.exit(0);
    }

}
