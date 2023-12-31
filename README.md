# baseballLogic
baseball Game Logic

#### 0. 게임 규칙
- 규칙1: 숫자 3개의 자리수까지 일치시키면 3Strike로 게임 성공
- 규칙2: 숫자만 맞출 경우, ball로 힌트 제공 (조건에 1개 부합시: 1ball, 2개 부합시: 2ball, 3개 부합시: 3ball)
- 규칙3: 숫자와 자리수 모두 맞췄을 경우, Strike로 힌트 제공 (조건에 1개 부합시: 1Strike, 2개 부합시: 2Strike, 3개 부합시: 3Strike)
- 규칙4: 3Strike를 맞추는데 시도한 횟수 카운팅 됨 (더 적게 카운팅된 사람이 win)

#### 1. 1차 설계 방향
- SOLID 원칙에 근거하여 클래스 작성
- Interface: baseball Game 외에도 메소드를 구체화하여 사용가능한 부분은 인터페이스로 처리
- Class: baseball 내에서도 기능을 대분류하여 클래스로 구분함 [ 1)게임 스타터 버튼, 2)게임 동작, 3)결과판독, 3)타입캐스팅, 4)유효성검사, 5)인터페이스 구현클래스 ]

#### 2. 1차 자체 평가
- 로직 정상 작동 수행 확인 완료
- SRP(Single Responsibility Principle): 1메서드 = 1기능 ok.. (유효성 검사 클래스는 애매한거 같음..)
- OCP(Open-Closed Principle): 입출력 부분에 적용
- LSP(Liskov Substitution Principle): 개념을 정확하게 이해하지 못하고 있는거 같음..
- ISP(Interface Segregation Principle): 입출력 부분과 난수 생성 부분에 적용
- DIP(Dependency Inversion Principle): 개념을 정확하게 이해하지 못하고 있는거 같음..
- 결론: SOLID에 대한 개념 부족으로, 현 코드에 반영이 되어 있는지 스스로 판단하지 못함 (LSP부터 이어서 정리해야함)

#### 3. 1차 피드백 (정언구 대리님)
- 객체 학습을 위한 학습으로, 현 코드는 절차지향적으로 설계되어 있음.
- 때문에 객체지향적으로 재설계할 필요가 있음.
- 객체지향과 절차지향 구분을 위해 아래 내용 학습하면 도움됨.
- 학습 키워드: 1)유틸리티 클래스와 객체 클래스에 대한 차이점, 2)singleton pattern과 객체지향
- SOLID 관련 학습 키워드: 1)LSP(isa, hasa), 2)DIP(추상화)
- 느낀점: 현 코드에는 상태 추적이 전혀 불가능하기 때문에 객체 생성이 전혀 이루어지지 않고 있는거 같음. 2차 설계에서는 객체 그리고 객체 간 협력(필요한 협력인지) 등을 고려하여 작업하자.

#### 4. 2차 설계 방향
- 객체 지향적으로 코드 수정
- 게임이라는 객체는 투수, 타자, 심판, 조이스틱의 객체로 구성됨
- 투수, 타자, 심판, 조이스틱이 각자의 역할을 수행하며 게임이라는 객체가 형성됨 (필수적 협력관계)
- 최종 결과 판독을 위해 횟수 체크를 위한 변수 이용함
- 투수: 컴퓨터로 난수로 3개의 숫자를 생성함
- 타자: 사용자로 3개의 숫자를 입력함
- 심판: 유효성 검사를 담당함

#### 5. 2차 자체 평가
- 로직 정상 작동 수행 확인 완료
- SRP(Single Responsibility Principle): 1메서드 = 1기능 ok
- OCP(Open-Closed Principle): 입출력 부분 적용
- LSP(Liskov Substitution Principle)
  - is-a: x (상속관계 없음)
  - has-a
  1) BaseballGame 객체가 BaseballPitcher, BaseballBatter, BaseballUmpire, InputOutputHandler 객체를 포함
  2) BaseballBatter 객체가 InputOutputHandler를 포함
- ISP(Interface Segregation Principle): 입출력 부분 적용
- DIP(Dependency Inversion Principle): 의존성 주입(LSP의 has-a관계와 이어지는거 같음)
- 결론: SOLID 관점에서 해석능력이 아직도 부족함. 방향성 검토 후 SOLID 개념잡은 후 재평가 및 코드수정이 필요함.

#### 6. 2차 피드백 (정언구 대리님)
- 객체지향 코드를 작성하는 이유는?
- 유지보수 측면에서 효율성을 증대시켜, 프로그램을 관리하는데 발생되는 비용을 최소화할 수 있음.
- 객체지향 언어를 사용하는데 있어 개발자 간의 설계 가이드라인 맥락으로, 가독성 증대 및 원활한 의시소통, 그리고 코드 작성자에 대한 의존성을 줄일 수 있다.
- is-a 관계와 has-a 관계의 차이 ---- 학습 필요
- interface 활용시 이점
- mututable 위험성 ---- 학습 필요
- 객체와 메시지의 관계
- 느낀점: 객체에 대해 조금 더 고찰할 필요성을 느겼다. 작은 규모의 프로젝트라 객체지향으로 코드를 작성해야하는 이유에 대해서 피부로 느끼지 못했지만 항상 수천, 수만, 수십만개로 상황을 확장하여 사고하는 방식을 잊지말자.<br/> 2차 피드백을 통해 객체지향 코드를 지향해야하는 이유에 대해 이해하였고, 이를 위해서는 객체에 대한 고찰이 필요함을 인지하였다.<br/> 내가 생각하는 객체란 본연의 것 그 자체이다. 가장 쉽게 이해할 수 있는 예시는 "사람"이다. 각각의 고유값을 가지고 있으며, 매 순간 상황에 맞는 동작을 일으킨다. 또한 필요에 따라 타인과 협력관계를 형성하며 상황을 해결하기도 한다. 이처럼 모든 상황을 세부화하면 객체화시킬 수 있을 것이다. 알고리즘을 실생활에 적용시켜 사고하는 것처럼 객체화도 생활속에 적용하면 코드 설계 및 생활속 판단에 이로울거 같다.<br/> 결론은 객체 관련 책을 읽고, 사고성을 기르자. 

#### 7. 3차 설계 및 자체 평가
객체에 대한 고찰 후 3차 설계 및 리팩토리 진행. 크게 변화한 부분을 3구역으로 나누면, 메시지 부분, 추상화 부분, 안전성 부분으로 분류되며 상세 내용은 아래와 같음.
##### 메시지 부분
- 어떤 메시지를 전달할 것인가? DTO로 메시지 처리
- ball이 전달하는 내용물: 컴퓨터 닌수 / 사용자 입략 숫자
- result가 전달하는 내용물: 카운트(스트라이크, 볼, 횟수), 결과(참, 거짓 핀별)

##### 추상화 부분
- 추상화가 꼭 필요한 부분은 무엇이 있을까? 인터페이스 사용
- 투수(컴퓨터): 숫자생성을 포함
- 타자(유저): 숫자입렷을 포함
- 심판: 투수와 타자 일치여부 판독을 포함

##### 안전성 부분
- 코드의 안전성은 어떻게 보장할 것인가? 접근제한자 및 캡슐화 사용
- 노출이 불필요한 부분은 접근제한자를 이용
- 인터페에스 메소드 구현을 직접 하기보다, 실제 동작 메소드를 private로 처리하여 로직 노출 방지

#### 8. 3차 피드백 (정언구 대리님)
- close 메소드 고찰 (Object: finalize 메소드를 갖기 때문에 불필요하진 않은가?)
- 유연성 있는 코드에 조금 더 포커스 ex> 규칙 숫자 3개 입력: 유효성 검사에 직접적으로 3을 입력하고 있는 부분
- Dto vs Vo 구분
- 결론: 조금 더 공부한 후 코드를 보안하자
