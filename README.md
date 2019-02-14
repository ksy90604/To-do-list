# To-do-list(server)
RESTful api를 사용하여 구현한 To-do list web application
># 1.개발도구
## 1) To-do List server
```
- Framework : Spring Boot 2.1.2
- DB : H2(in-memory DB)
- Build Tool : maven
- 사용언어 및 구현 기술 : Java, JPA, Rest api
```
## 2) To-do List client
```
- Framework : Spring Boot 2.1.2
- Build Tool : maven
- 사용언어 및 구현 기술 : Java, Jquery, Javascrpit, ajax, json
```

># 2.개발환경
```
- OS : windows8 64bit
- IDE : Eclipse photon
- JDK 1.8
```

># 3. 실행 방법

## eclipse 사용 시 
```
- project 마우스 오른쪽 버튼 클릭 > Run As > Spring Boot App
```
## To-do list server
> Port 변경 시 : ..src\main\resources\application.properties 에서 수정
```
- 로컬호스트 접속 url : http://localhost:8080/task/list
- 기본으로 입력 된 데이터가 나오는지 확인
- 포함되어 있는 sql 문으로 기본 값 세팅
 >task/src/main/resources/schema.sql
 >task/src/main/resources/import.sql
```
## To-do list client
```
- 로컬호스트 접속 url : http://localhost:8090/client/toDoList
```
># 4. 기능
```
* 텍스트로 된 할 일 추가(POST)
  * 할일 추가 시 다른 할 일 참조 가능
* 할일 수정(PUT)
* 할일 목록 조회(GET)
* 사용자는 할일을 완료처리(PUT)
  * 참조가 걸린 완료되지 않은 할 일이 있다면 완료처리 불가 
```
