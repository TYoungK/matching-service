# matching-service

## 소개

- 사용자 생성 및 조회
- 토스페이먼츠 결제 승인 처리 및 결과 반환
- 쿠폰 생성 및 조회

## 기술 스택

- Java 21
- Spring Boot 3.4.4
- Gradle 8.13(Wrapper)
- Spring Data JPA
- Springdoc OpenAPI (Swagger) -> API 문서 자동화
- MySQL
- Docker

## 프로젝트 구조
```text
matching_service
    ├─common
    │  ├─enums
    │  └─exception
    │      ├─coupon
    │      ├─payments
    │      └─user
    └─domain
        ├─coupon
        │  ├─controller
        │  ├─dto
        │  ├─entity
        │  ├─repository
        │  └─service
        ├─payments
        │  ├─controller
        │  ├─dto
        │  ├─entity
        │  ├─repository
        │  └─service
        └─user
            ├─controller
            ├─dto
            ├─entity
            ├─repository
            └─service
```

## 빌드 및 실행

MySQL까지 포함된 단일 Docker 컨테이너로 실행됩니다. 별도 설치 없이 다음 명령어로 실행 가능합니다.


```bash
./gradlew build
docker build -t matching-service .
```

```bash
docker run -p 8080:8080 -p 3307:3306 matching-service
```
> 참고: DB는 init.sql을 통해 빌드 시 생성됩니다.
## API 문서

Swagger UI를 통해 API 문서를 확인할 수 있습니다.

http://localhost:8080/swagger-ui.html