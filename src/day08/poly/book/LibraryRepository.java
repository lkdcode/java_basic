package day08.poly.book;

import day04.array.StringList;

import static day08.poly.book.RentStatus.*;

/**
 * 도서관리 시스템 데이터 처리
 */
public class LibraryRepository {
    // 회원 정보
    private static BookUser bookUser;
    // 도서들의 정보
    private static Book[] bookList;

    static {
        bookList = new Book[]{
                new CookBook("기적의 집밥책", "김해진", "청림라이프", true),
                new CartoonBook("떨어지면 끝장맨", "스에노부 케이코", "대원씨아이", 18),
                new CookBook("삐뽀삐뽀 119 이유식", "허정훈", "유니책방", false),
                new CartoonBook("원펀맨", "One", "대원씨아이", 15),
                new CartoonBook("이세계로 전이했으니 치트를 살려 마법검사가 되기로 했다", "Shinkoshoto", "대원씨아이", 12),
                new CookBook("오늘은 아무래도 덮밥", "이마이 료", "참돌", true),
        };
    }

    // 유저를 등록하는 기능
    public void register(BookUser userInfo) {
        bookUser = userInfo;
    }

    // 마이페이지 기능

    /**
     * 여기에 있는 bookUser 정보 리턴
     */
    public BookUser findBookUser() {
        return bookUser;
    }

    // 모든 책의 정보를 알려주는 메서드
    public String[] getBookInfoList() {
        String[] infoList = new String[bookList.length];

        for (int i = 0; i < infoList.length; i++) {
            infoList[i] = bookList[i].info();
        }

        return infoList;
    }

    // 검색어를 받으면 해당 검색어를 포함하는 제목을 가진
    // 책 정보들을 리턴
    public String[] searchBookInfoList(String keyword) {
        StringList list = new StringList();

        for (Book book : bookList) {
            String title = book.getTitle();
            if (title.contains(keyword)) list.push(book.info());
        }

        return list.getsArr();
    }

    // 도서 저자 이름으로 검색
    public String findByAuthor(String author) {
        String info = "";

        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                if (book instanceof CookBook) info += "CookBook\n";
                else info += "# CartoonBook\n";
                info += "# 도서명: " + book.getTitle() + "\n";
                info += "# 저자: " + book.getAuthor() + "\n";
                info += "# 출판사: " + book.getPublisher() + "\n";

                if (book instanceof CookBook) {
                    info += "# 쿠폰유무: ";
                    info += ((CookBook) book).isCoupon() ? "있음\n" : "없음\n";
                } else {
                    info += "# 연령제한: ";
                    info += ((CartoonBook) book).getAccessAge() + "세\n";
                }
            }
        }

        return info;
    }

    // 도서 대여 처리
    public RentStatus rentBook(int rentNumber) {
        // 대여를 원하는 책 추출
        Book wishBook = bookList[rentNumber - 1];
        // 책의 분류에 따라 다른 처리
        if (wishBook instanceof CookBook) {
            CookBook cookBook = (CookBook) wishBook;
            // 쿠폰 유무를 확인
            if (cookBook.isCoupon()) {
                bookUser.setCouponCount(bookUser.getCouponCount() + 1);
                return RENT_SUCCESS_WITH_COUPON;
            } else {
                return RENT_SUCCESS;
            }
        } else if (wishBook instanceof CartoonBook) {
            // 연력제한을 확인
            CartoonBook cartoonBook = (CartoonBook) wishBook;
            if (bookUser.getAge() >= cartoonBook.getAccessAge()) {
                // 빌릴 수 있는 경우
                return RENT_SUCCESS;
            } else {
                return RENT_FAIL;
            }
        }

        return RENT_FAIL;
    }
}
