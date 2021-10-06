# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 기능
* 게임(BaseballGame)
    * 투수, 타자, 심판을 선언하여 게임을 진행
    * 게임결과가 3스트라이크라면 게임종료
    * 게임종료 시, 사용자는 게임재개 또는 완전종료를 선택 가능

* 투수(Pitcher)
    * 사용자의 임의 숫자(3개) 입력
    * 유효성검사: 최대입력 갯수만큼 입력했는지, 1~9만 입력했는지, 중복된 숫자가 없는지

* 타자(Hitter)
    * 컴퓨터가 중복되지 않는 임의 숫자(3개)를 생성

* 심판(Referee)
    * 사용자가 입력한 임의 숫자와 컴퓨터가 생성한 임의 숫자를 비교
        - 위치와 숫자가 일치하면 스트라이크
        - 위치는 다르지만 숫자가 일치하면 볼
    * 게임결과 선언
        - 볼, 스트라이크 카운트를 출력 하거나
        - 볼, 스트라이크 카운트가 없으면 '낫싱'을 출력
        - 임의 숫자 갯수와 스트라이크 수가 동일하면 게임종료 선언
