# baseballLogic
baseball Game Logic
- 규칙1: 숫자 3개의 자리수까지 일치시키면 3Strike로 게임 성공
- 규칙2: 숫자만 맞출 경우, ball로 힌트 제공 (조건에 1개 부합시: 1ball, 2개 부합시: 2ball, 3개 부합시: 3ball)
- 규칙3: 숫자와 자리수 모두 맞췄을 경우, Strike로 힌트 제공 (조건에 1개 부합시: 1Strike, 2개 부합시: 2Strike, 3개 부합시: 3Strike)

#### 1. 설계 방향
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

#### 3. 피드백
