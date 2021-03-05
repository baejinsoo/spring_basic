package hello.core.order;

import hello.core.discount.DiscountPolicy;
// import hello.core.discount.FixDiscountPolicy;
// import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //  private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); 기존 할인 정책
//  private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); 변경된 할인 정책, 이렇게 하면 DIP 위반
//  현재는 추상 클래스(DiscountPolicy)와 구현 클래스(FixDiscountPolicy()) 모두에 의존해 있다. 이를 추상 클래스에만 의존하도록 바꿔야함
//  해결방안 : 인터페이스에만 의존하도록 설계와 코드 변경 후, 클라이언트인(OrderServiceImpl)에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야함
    private final DiscountPolicy discountPolicy; // DIP는 지켰지만, 구체 객체가 없기때문에 null 에러 발생
    private final MemberRepository memberRepository; // => AppConfig의 생성자 주입을 통해 해결

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
