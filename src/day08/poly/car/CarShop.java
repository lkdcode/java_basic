package day08.poly.car;

public class CarShop {
    Car[] cars;
    Car mustangs;
    Car stingers;
    Car tucsons;

    // 대리점에 차를 입고하는 기능
    public void importCar() {
        cars = new Car[]{
                new Mustang(),
                new Mustang(),
                new Mustang(),
                new Stinger(),
                new Tucson(),
        };
        // 문자열과 정수와 논리를 배열에 담을 수 있는가?
        Object[] oArr = {
                50, 30, 3.3, "zzzz", false,
                new Mustang(), new Stinger(),
        };
    }

    // 주행 테스트 기능
    public void runTest() {
        importCar();
        for (Car car : cars) {
            car.accelerate();
        }
    }

    // 차를 고객에게 인도하는 기능
    public Car exportCar(int money) {
        if (money == 6000) return new Mustang();
        if (money == 5000) return new Stinger();
        if (money == 3000) return new Tucson();
        return null;
    }

}
