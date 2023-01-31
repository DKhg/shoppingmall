# SpringBoot-Project(Funiture Shoppingmall)
- SpringBoot와 JPA를 이용한 가구 쇼핑몰
<br>


## 프로젝트 개발 환경
- 운영체제 : Microsoft Windows 11
- 통합개발환경(IDE) : IntelliJ
- JDK Version : JDK 11
- 스프링부트 Version : 
- 데이터베이스 : MySQL
- 빌드툴 : Maven
- 관리툴 : Git, GitHub

<br>

## 프로젝트 기술 스택
- HTML, CSS, JS, BOOTSTRAP, THYMELEAF
- SpringBoot, Spring Security, Spring Data JPA, Spring Web, Lombok
- Hibernate, MySQL

<br>

## DB 모델링
![shoppingmall (3)](https://user-images.githubusercontent.com/106241314/215694670-38b41fa9-21aa-4326-8189-a13deb2fadc4.png)
<br>


## 구현 기능
- 회원(Member) : 회원가입, 로그인, 로그아웃 
<br> < Spring Security를 이용하여 구현, 유효성 검증 사용 >
- 상품(Item) : 상품등록, 상품조회, 상품관리
<br> < modelmapper 라이브러리, Querydsl 이용 >
<br>    상품수정, 상품 상세 페이지
- 주문(Order) : 상품주문, 주문내역 조회, 주문 취소

<br>

## API 명세
|View|Method|End Point|
|----|----|----|
|회원 가입 페이지|Get|/member/new|
|회원 가입|Post|/member/new|
|로그인 페이지|Get|/member/login|
|로그인|Post|/member/login|
|상품 등록|Post|/admin/item/new|
|상품 등록 페이지|Get|/admin/item/new|
|상품 조회|Get|/admin/item/{itemId}, /admin/items, /admin/items/{page}|
|상품 수정|Post|/admin/item/{itemId}|
|장바구니 담기|Post|/cart|
|장바구니 페이지|Get|/cart|
|장바구니 상품 수정|Patch|/cartItem/{cartItemId}|
|장바구니 상품 제거|Delete|/cartItem/{cartItemId}|
|장바구니 상품 주문|Post|/cart/orders|
|주문하기|Post|/order|
|주문 내역 페이지|Get|/orders, /orders/{page}|
|주문 취소|Post|/order/{orderId}/cancel|



