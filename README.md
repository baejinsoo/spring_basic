# spring_basic

### 비즈니스 요구사항과 설계

#### 회원

>[git commit](https://github.com/baejinsoo/spring_basic/commit/11c2f1e25d7dcebc8ee9ba74b91ffa7ee6bf2785)
>
>[test commit](https://github.com/baejinsoo/spring_basic/commit/d510a3e23e546743d8287c43fe392f3b3efea73c)

- 회원을 가입하고 조회할 수 있다.
- 회원은 일반과 VIP 두 가지 등급이 있다.
- 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.

#### 주문과 할인 정책

> [git commit](https://github.com/baejinsoo/spring_basic/commit/cac74e7d7cd6e6e612e56eba636f721be7a1cbf3)

- 회원은 상품을 주문할 수 있다.
- 회원 등급에 따라 할인 정책을 적용할 수 있다.
- 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용한다. (후에 변경 가능)
- 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 있다.(미확정)



### 새로운 할인 정책 개발

 새로운 할인 정책을 확장해보자.

- vip 1000원 고정 금액 할인 => 금액당 %할인

**AppConfig 생성**

애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스를 생성해서 DIP 해결(구현객체에는 의존하지 않고 인터페이스에만 의존하도록 변경)

👉 AppConfig는 구체 클래스를 선택한다. 애플리케이션이 어떻게 동작할지 전체 구성을 책임짐