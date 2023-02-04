# 💁‍♂️SpringBoot-Project(Funiture Shoppingmall)
- SpringBoot와 JPA를 이용한 가구 쇼핑몰
<br>



## ⚙프로젝트 개발 환경
- 운영체제 : Microsoft Windows 11
- 통합개발환경(IDE) : IntelliJ
- JDK Version : JDK 11
- 스프링부트 Version : 2.7.7
- 데이터베이스 : MySQL
- 빌드툴 : Maven
- 관리툴 : Git, GitHub

<br>

## 📗프로젝트 기술 스택📗
- <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" /> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" /> <img src="https://img.shields.io/badge/JS-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white" /> <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white" /> <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=Thymeleaf&logoColor=white" />
- <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white" /> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white" />
- <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" /> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white" />

<br>

## 🖊DB 모델링
![shoppingmall (3)](https://user-images.githubusercontent.com/106241314/215694670-38b41fa9-21aa-4326-8189-a13deb2fadc4.png)


1.&nbsp; member : 회원 정보 테이블


2.&nbsp; cart : 회원의 장바구니 목록 테이블


3.&nbsp; cart_item : 장바구니에 담긴 상품 정보 테이블


4.&nbsp; orders : 쇼핑몰 회원들의 주문 목록 테이블


5.&nbsp; order_item : 주문된 상품 정보 테이블


6.&nbsp; item : 상품 정보 테이블


7.&nbsp; item_img : 상품에 대한 이미지 정보를 담고 있는 테이블
<br>


## 🔧구현 기능
- 회원(Member) : 회원가입, 로그인, 로그아웃 
<br>     < Spring Security를 이용하여 구현, 유효성 검증 사용 >
- 상품(Item) : 상품등록, 상품조회, 상품관리
<br>     < modelmapper 라이브러리, Querydsl 이용 >
<br> 상품수정, 상품 상세 페이지
- 주문(Order) : 상품주문, 주문내역 조회, 주문 취소

<br>

## 메인화면


<br>

![메인화면](https://user-images.githubusercontent.com/106241314/216755638-5e4768c2-f0ff-4bdd-8077-079b949b80d3.png)

<br>

![메인화면2](https://user-images.githubusercontent.com/106241314/216755785-eee2b926-8841-4467-8a75-8e76e08079d8.png)

<br>
* 메인화면에는 가구 쇼핑몰의 대표적인 배너와 관리자들이 등록한 상품의 이름, 상세설명, 가격을 보여주었습니다. Thymeleaf Layout Dialect dependency를 추가하여 하나의 layout 페이지를 여러페이지에 적용할 수 있게 하였습니다. 그리고 footer, header를 만들고 layout에서 변경되는 영억엔 fragment="content"로 설정하여 만들페이지를 끼워 넣었습니다. Navbar는 부트스트랩을 참고하여 만들었고 header영역에도 추가 하였습니다. 회원가입, 상품등록, 주문 등 이후에 메인페이지로 돌아갈 수 있게 main.html를 만들었습니다.
<br>

## 로그인, 회원가입

<br>

![로그인페이지](https://user-images.githubusercontent.com/106241314/216755806-59419d80-ce15-4161-895d-26929597b27f.png)

<br>

![회원가입페이지](https://user-images.githubusercontent.com/106241314/216755814-db85fcee-b4ad-4cec-9801-2059f027bb96.png)

<br>

* 회원가입, 로그인은 security dependency를 추가하여 구현하였습니다. 그에 따라 WebSecurityConfigurerAdapter를 상속 받는 SecurityConfig.java를 만들어 보안 설정을 하였습니다. 각각 멤버가 일반 유저인지 관리자인지 구분할 수 있게 Role.java 코드를 작성했습니다. 회원가입 페이지는 부트스트랩을 참고하여 변형하여 사용하였습니다. validation dependency를 추가하여 회원 가입 처리를 할때 유효성 검증을 할 수 있게하여 해당페이지에 이유를 보여주도록 하였습니다. 로그인, 로그아웃은 비밀번호 암호화를 위해 PasswordEncoder를 사용하였고 MemberService가 UserDetailsService를 구현하게 하여 기능을 만들었습니다.
<br>

## 상품등록, 관리 ( 관리자용 )

<br>

![상품등록화면](https://user-images.githubusercontent.com/106241314/216755823-4ad60866-5cb8-4caa-89a4-9ca371bf9b20.png)

<br>

![상품관리화면](https://user-images.githubusercontent.com/106241314/216755826-1aaadfbb-4f45-451f-86a5-ca4462f9ec13.png)

<br>

* 상품등록과 관리는 관리자만 이용할 수 있게 구현하였으며, 관리에서 상품이름에 링크를 걸어 들어가면 수정까지 할 수 있게 하였습니다. 상품 등록을 함에 있어서 이미지를 추가 할 수 있게 fileService를 만들어 이용하였습니다. JPA의 Auditing 기능을 이용하기위해  AuditorAware 인터페이스를 구현하여 공통으로 엔티티가 저장 또는 수정될 때 자동으로 등록일, 수정일, 등록자, 수정자를 입력해주게 하였습니다. 보통 테이블에는 위의 4가지를 모두 넣어주지만 어떤 테이블은 등록자, 수정자를 넣지않아 BaseTimeEntity만 상속받을 수 있도록 BaseTimeEntity를 생성하였습니다. 그리고 상속받을 수 있게 BaseEntity도 생성했습니다.
<br>

## 상품 담기, 장바구니 내역, 구매 이력 ( 회원용 )

<br>


![회원메인상품선택](https://user-images.githubusercontent.com/106241314/216755879-354d401d-06f8-4611-8a8f-2d24a05bfd73.png)

<br>


![장바구니화면](https://user-images.githubusercontent.com/106241314/216755973-b0b21c3f-cc2e-416b-8d1f-102afd2ea4f3.png)

<br>

![구매이력화면](https://user-images.githubusercontent.com/106241314/216755956-4a73db4a-45b8-48d6-be11-2f52217ffede.png)

<br>

## 💻API 명세서
|View|Method|End Point|
|:----:|:----:|:----:|
|메인 페이지|Get|/|
|회원 가입 페이지|Get|/members/new|
|회원 가입|Post|/members/new|
|로그인 에러 페이지|Get|/members/login/error|
|로그인|Get|/members/login|
|상품 등록|Post|/admin/item/new|
|상품 등록 페이지|Get|/admin/item/new|
|상품 조회|Get|/admin/item/{itemId}|
|상품 수정|Post|/admin/item/{itemId}|
|상품 관리|Get|/admin/items, /admin/items/{page}|
|상품 상세 페이지|Get|/item/{itemId}|
|장바구니 담기|Post|/cart|
|장바구니 페이지|Get|/cart|
|장바구니 상품 수정|Patch|/cartItem/{cartItemId}|
|장바구니 상품 제거|Delete|/cartItem/{cartItemId}|
|장바구니 상품 주문|Post|/cart/orders|
|주문하기|Post|/order|
|주문 내역 페이지|Get|/orders, /orders/{page}|
|주문 취소|Post|/order/{orderId}/cancel|
<br>



## 🎓프로젝트 개발 동기와 하면서 느낀점🎓
이 프로젝트를 개발한 동기는 자바, 스프링부트, 스프링 시큐리티, JPA 등의 기술을 이론적으로 숙지한 뒤 이런것들을 어떻게 활용하고 


이를 통해 서버가 작동하는 원리가 궁금하여 관련된 강의와 서적을 참고하여 간단한 쇼핑몰을 만들어보게 되었다.


그리고 완벽하지 않지만 나만의 프로젝트를 개발하는 것이 백엔드 개발의 전체적인 흐름을 잡을 수 있고 


개발하다 궁금한 점들을 찾아가며 해결하는 과정을 통해 개발자로 가는 첫걸음 뗀다고 생각하여 최선을 다했다. 


기초가 중요하기 때문에 개념 또한 잘 숙지하며 공부를 했다.

