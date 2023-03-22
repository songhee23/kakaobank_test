# songhee_api_test

- 소스 경로
  ```
  ./demo
  ```
  
- 실행 파일 경로
  ```
  ./demo-0.0.1-SNAPSHOT.war
  ```
  
- 실행 파일 구동 방법
  ```
  -- 1. 자바 설치 확인
  $java -version

  -- 2. 배포 
  $ java -jar immigration.war
  ```

---

- 환경
    
    ```
    
    -spring boot
    -Java 18
    -gradle
    -DataBase
     -mariadb
    ```

- DB 스키마
    ```
    
    CREATE TABLE BLOG(
     ID_BLOG INT AUTO_INCREMENT PRIMARY KEY,
     TITLE VARCHAR(800) NOT NULL,
     URL VARCHAR(2000) NOT NULL,
     THUMBNAIL VARCHAR(2000) NULL,
     CONTENTS VARCHAR(3000) NOT NULL,
     BLOG_NAME VARCHAR(2000) NOT NULL,
     MOD_DATE_TIME TIMESTAMP NOT NULL,
     REG_DATE_TIME TIMESTAMP NOT NULL,
     USE_YN VARCHAR(1) NOT  NULL,
     PRIMARY KEY (ID_BLOG)
    );

    CREATE TABLE SEARCH_HISTORY(
     ID_SEARCH_HISTORY INT AUTO_INCREMENT PRIMARY KEY ,
     QUERY VARCHAR(3000) NOT NULL,
     REG_DATE_TIME TIMESTAMP NOT NULL,
     PRIMARY KEY (ID_SEARCH_HISTORY)
    );
    ```
    

- API Test
  ```
  curl -i -X GET \
 'http://localhost:8080/v1/test/search/blog?query=5'
 
 
 curl -i -X GET \
 'http://localhost:8080/v1/test/search/last-10'
  
  ```
