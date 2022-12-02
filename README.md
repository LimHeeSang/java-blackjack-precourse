# 기능 구현 목록

## 블랙잭 핵심 기능

- [ ] 플레이어 기능
    - [x] 게임을 시작할 때 배팅 금액을 정하는 기능
    - [x] 게임을 시작할 때 두 장의 카드를 지급받는 기능
    - [x] 카드를 한장 뽑는 기능
    - [ ] 블랙잭일 경우 베팅 금액의 1.5배를 딜러에게 받는 기능
    - [ ] 플레이어, 딜러 모두 블래잭인 경우 베팅 금액을 돌려받는 기능
    - [x] 플레이어를 저장하는 기능
    - [x] 플레이어를 모두 조회하는 기능
- [ ] 딜러 기능
    - [x] 게임을 시작할 때 두 장의 카드를 지급받는 기능
    - [ ] 처음 받은 두 장의 카드 합이 16이하면 카드 추가 뽑기
    - [ ] 처음 받은 두 장의 카드 합이 17이상이면 뽑을 수 없다
    - [ ] 21을 초과하면 그 시점까지 플레이어의 패에 상관없이 승리
    - [x] 한명의 플레이어와 플레이하는 기능
        - [x] 플레이어가 승리하는 기능
        - [x] 플레이어가 패배하는 기능
        - [x] 플레이어와 비기는 기능
    - [x] 플레이어만 블랙잭일 때 승리하는 기능
    - [ ] 딜러만 블랙잭일 때 승리하는 기능
- [x] 카드 기능
    - [x] 카드의 합을 계산하는 기능
    - [x] 주어진 숫자보다 큰지 계산하는 기능
    - [x] 주어진 숫자보다 작은지 계산하는 기능
    - [x] 주어진 숫자와 같은지 계산하는 기능
    - [x] 카드를 추가하는 기능
    - [x] 처음 두장의 카드가 블랙잭인지 확인하는 기능
        - [x] Ace 카드는 21이 안넘으면 11, 넘으면 1로 계산

## 예외 처리

## 입출력 기능

### 입력 기능

- [ ] 플레이어들을 입력받는 기능
- [ ] 베팅 금액을 입력받는 기능
- [ ] 카드를 받을지 여부를 입력받는 기능

### 출력 기능

- [ ] 플레이어들의 카드를 출력하는 기능
- [ ] 최종 수익을 출력하는 기능