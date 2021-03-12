package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 private 으로 하나 static 으로 가지고 있음 -> 클래스 레벨에 올라가기 때문에 딱 하나만 존재
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
