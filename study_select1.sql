
--문제 1.
-- 다음은 어느 자동차 대여 회사에서 대여중인 자동차들의 정보를 담은 CAR_RENTAL_COMPANY_CAR 테이블입니다. CAR_RENTAL_COMPANY_CAR 테이블은 아래와 같은 구조로 되어있으며, CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS 는 각각 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트를 나타냅니다.

-- Column name	Type	Nullable
-- CAR_ID	INTEGER	FALSE
-- CAR_TYPE	VARCHAR(255)	FALSE
-- DAILY_FEE	INTEGER	FALSE
-- OPTIONS	VARCHAR(255)	FALSE
-- 자동차 종류는 '세단', 'SUV', '승합차', '트럭', '리무진' 이 있습니다. 자동차 옵션 리스트는 콤마(',')로 구분된 키워드 리스트(예: '열선시트', '스마트키', '주차감지센서')로 되어있으며, 키워드 종류는 '주차감지센서', '스마트키', '네비게이션', '통풍시트', '열선시트', '후방카메라', '가죽시트' 가 있습니다.

-- 문제
-- CAR_RENTAL_COMPANY_CAR 테이블에서 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금을 출력하는 SQL문을 작성해주세요. 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림하고, 컬럼명은 AVERAGE_FEE 로 지정해주세요.

-- 예시
-- 예를 들어 CAR_RENTAL_COMPANY_CAR 테이블이 다음과 같다면

-- CAR_ID	CAR_TYPE	DAILY_FEE	OPTIONS
-- 1	세단	16000	가죽시트,열선시트,후방카메라
-- 2	SUV	14000	스마트키,네비게이션,열선시트
-- 3	SUV	22000	주차감지센서,후방카메라,가죽시트
-- 'SUV' 에 해당하는 자동차들의 평균 일일 대여 요금은 18,000 원 이므로, 다음과 같은 결과가 나와야 합니다.

-- AVERAGE_FEE
-- 18000

--답 :

SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';

-- 결과값: AVERAGE_FEE = 93727


-- 문제 2.
-- FIRST_HALF 테이블은 아이스크림 가게의 상반기 주문 정보를 담은 테이블입니다.FIRST_HALF 테이블 구조는 다음과 같으며, SHIPMENT_ID, FLAVOR, TOTAL_ORDER는 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다.

-- NAME	TYPE	NULLABLE
-- SHIPMENT_ID	INT(N)	FALSE
-- FLAVOR	VARCHAR(N)	FALSE
-- TOTAL_ORDER	INT(N)	FALSE
-- 문제
-- 상반기에 판매된 아이스크림의 맛을 총주문량을 기준으로 내림차순 정렬하고 총주문량이 같다면 출하 번호를 기준으로 오름차순 정렬하여 조회하는 SQL 문을 작성해주세요.

-- 예시
-- 예를 들어 FIRST_HALF 테이블이 다음과 같을 때

-- SHIPMENT_ID	FLAVOR	TOTAL_ORDER
-- 101	chocolate	3200
-- 102	vanilla	2800
-- 103	mint_chocolate	1700
-- 104	caramel	2600
-- 105	white_chocolate	3100
-- 106	peach	2450
-- 107	watermelon	2150
-- 108	mango	2900
-- 109	strawberry	3100
-- 110	melon	3150
-- 111	orange	2900
-- 112	pineapple	2900
-- 상반기 아이스크림 맛을 총주문량을 기준으로 내림차순 정렬하고 총주문량이 같은 경우 출하 번호를 기준으로 오름차순 정렬하면 chocolate, melon, white_chocolate, strawberry, mango, orange, pineapple, vanilla, caramel, peach, watermelon, mint_chocolate 순서대로 조회되어야 합니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.

-- FLAVOR
-- chocolate
-- melon
-- white_chocolate
-- strawberry
-- mango
-- orange
-- pineapple
-- vanilla
-- caramel
-- peach
-- watermelon
-- mint_chocolate

--답 :

SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC;

-- 결과값:
-- FLAVOR
-- chocolate
-- white_chocolate
-- strawberry
-- vanilla
-- caramel
-- peach
-- mint_chocolate


-- 문제 3.
-- 다음은 어느 한 서점에서 판매중인 도서들의 도서 정보(BOOK) 테이블입니다.

-- BOOK 테이블은 각 도서의 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.

-- Column name	Type	Nullable	Description
-- BOOK_ID	INTEGER	FALSE	도서 ID
-- CATEGORY	VARCHAR(N)	FALSE	카테고리 (경제, 인문, 소설, 생활, 기술)
-- AUTHOR_ID	INTEGER	FALSE	저자 ID
-- PRICE	INTEGER	FALSE	판매가 (원)
-- PUBLISHED_DATE	DATE	FALSE	출판일
-- 문제
-- BOOK 테이블에서 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력하는 SQL문을 작성해주세요.
-- 결과는 출판일을 기준으로 오름차순 정렬해주세요.

-- 예시
-- 예를 들어 BOOK 테이블이 다음과 같다면

-- BOOK_ID	CATEGORY	AUTHOR_ID	PRICE	PUBLISHED_DATE
-- 1	인문	1	10000	2020-01-01
-- 2	경제	2	9000	2021-02-05
-- 3	인문	2	11000	2021-04-11
-- 4	인문	3	10000	2021-03-15
-- 5	생활	1	12000	2021-01-10
-- 조건에 속하는 도서는 도서 ID 가 3, 4인 도서이므로 다음과 같습니다.

-- BOOK_ID	PUBLISHED_DATE
-- 3	2021-04-11
-- 4	2021-03-15
-- 그리고 출판일 오름차순으로 정렬하여야 하므로 다음과 같은 결과가 나와야 합니다.

-- BOOK_ID	PUBLISHED_DATE
-- 4	2021-03-15
-- 3	2021-04-11
-- 주의사항
-- PUBLISHED_DATE의 데이트 포맷이 예시와 동일해야 정답처리 됩니다.

--답 :

SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
WHERE YEAR(PUBLISHED_DATE) = 2021
  AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC;

-- 결과값:
-- BOOK_ID	PUBLISHED_DATE
-- 3	    2021-1024 


-- 문제 4.
-- 다음은 종합병원에 등록된 환자정보를 담은 PATIENT 테이블입니다. PATIENT 테이블은 다음과 같으며 PT_NO, PT_NAME, GEND_CD, AGE, TLNO는 각각 환자번호, 환자이름, 성별코드, 나이, 전화번호를 의미합니다.

-- Column name	Type	Nullable
-- PT_NO	VARCHAR(10)	FALSE
-- PT_NAME	VARCHAR(20)	FALSE
-- GEND_CD	VARCHAR(1)	FALSE
-- AGE	INTEGER	FALSE
-- TLNO	VARCHAR(50)	TRUE
-- 문제
-- PATIENT 테이블에서 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회하는 SQL문을 작성해주세요. 이때 전화번호가 없는 경우, 'NONE'으로 출력시켜 주시고 결과는 나이를 기준으로 내림차순 정렬하고, 나이 같다면 환자이름을 기준으로 오름차순 정렬해주세요.

-- 예시
-- PATIENT 테이블이 다음과 같을 때

-- PT_NO	PT_NAME	GEND_CD	AGE	TLNO
-- PT22000003	브라운	M	18	01031246641
-- PT22000004	크롱	M	7	NULL
-- PT22000006	뽀뽀	W	8	NULL
-- PT22000009	한나	W	12	01032323117
-- PT22000012	뿡뿡이	M	5	NULL
-- PT22000013	크리스	M	30	01059341192
-- PT22000014	토프	W	22	01039458213
-- PT22000018	안나	W	11	NULL
-- PT22000019	바라	W	10	01079068799
-- PT22000021	릴로	W	33	01023290767
-- SQL을 실행하면 다음과 같이 출력되어야 합니다.

-- PT_NAME	PT_NO	GEND_CD	AGE	TLNO
-- 한나	PT22000009	W	12	01032323117
-- 안나	PT22000018	W	11	NONE
-- 바라	PT22000019	W	10	01079068799
-- 뽀뽀	PT22000006	W	8	NONE

--답 :

SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12
  AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC;

-- 결과 값: 
-- PT_NAME	PT_NO	GEND_CD	AGE	TLNO
-- 한나	PT22000009	W	12	01032323117
-- 안나	PT22000018	W	11	NONE
-- 바라	PT22000019	W	10	01079068799
-- 스티치	PT22000022	W	9	NONE
-- 뽀뽀	PT22000006	W	8	NONE


-- 문제 5.
-- 다음은 어느 의류 쇼핑몰의 온라인 상품 판매 정보를 담은 ONLINE_SALE 테이블 입니다. ONLINE_SALE 테이블은 아래와 같은 구조로 되어있으며 ONLINE_SALE_ID, USER_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE는 각각 온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일을 나타냅니다.

-- Column name	Type	Nullable
-- ONLINE_SALE_ID	INTEGER	FALSE
-- USER_ID	INTEGER	FALSE
-- PRODUCT_ID	INTEGER	FALSE
-- SALES_AMOUNT	INTEGER	FALSE
-- SALES_DATE	DATE	FALSE
-- 동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.

-- 문제
-- ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요. 결과는 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.

-- 예시
-- 예를 들어 ONLINE_SALE 테이블이 다음과 같다면

-- ONLINE_SALE_ID	USER_ID	PRODUCT_ID	SALES_AMOUNT	SALES_DATE
-- 1	1	3	2	2022-02-25
-- 2	1	4	1	2022-03-01
-- 4	2	4	2	2022-03-12
-- 3	1	3	3	2022-03-31
-- 5	3	5	1	2022-04-03
-- 6	2	4	1	2022-04-06
-- 2	1	4	2	2022-05-11
-- USER_ID 가 1인 유저가 PRODUCT_ID 가 3, 4인 상품들을 재구매하고, USER_ID 가 2인 유저가 PRODUCT_ID 가 4인 상품을 재구매 하였으므로, 다음과 같이 결과가 나와야합니다.

-- USER_ID	PRODUCT_ID
-- 1	4
-- 1	3
-- 2	4

--답 :

SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) >= 2
ORDER BY USER_ID ASC, PRODUCT_ID DESC;


-- 문제 6.

-- 다음은 아이스크림 가게의 상반기 주문 정보를 담은 FIRST_HALF 테이블과 아이스크림 성분에 대한 정보를 담은 ICECREAM_INFO 테이블입니다. FIRST_HALF 테이블 구조는 다음과 같으며, SHIPMENT_ID, FLAVOR, TOTAL_ORDER 는 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다. FIRST_HALF 테이블의 기본 키는 FLAVOR입니다.

-- NAME	TYPE	NULLABLE
-- SHIPMENT_ID	INT(N)	FALSE
-- FLAVOR	VARCHAR(N)	FALSE
-- TOTAL_ORDER	INT(N)	FALSE
-- ICECREAM_INFO 테이블 구조는 다음과 같으며, FLAVOR, INGREDITENT_TYPE 은 각각 아이스크림 맛, 아이스크림의 성분 타입을 나타냅니다. INGREDIENT_TYPE에는 아이스크림의 주 성분이 설탕이면 sugar_based라고 입력되고, 아이스크림의 주 성분이 과일이면 fruit_based라고 입력됩니다. ICECREAM_INFO의 기본 키는 FLAVOR입니다. ICECREAM_INFO테이블의 FLAVOR는 FIRST_HALF 테이블의 FLAVOR의 외래 키입니다.

-- NAME	TYPE	NULLABLE
-- FLAVOR	VARCHAR(N)	FALSE
-- INGREDIENT_TYPE	VARCHAR(N)	FALSE
-- 문제
-- 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.

-- 예시
-- 예를 들어 FIRST_HALF 테이블이 다음과 같고

-- SHIPMENT_ID	FLAVOR	TOTAL_ORDER
-- 101	chocolate	3200
-- 102	vanilla	2800
-- 103	mint_chocolate	1700
-- 104	caramel	2600
-- 105	white_chocolate	3100
-- 106	peach	2450
-- 107	watermelon	2150
-- 108	mango	2900
-- 109	strawberry	3100
-- 110	melon	3150
-- 111	orange	2900
-- 112	pineapple	2900
-- ICECREAM_INFO 테이블이 다음과 같다면

-- FLAVOR	INGREDIENT_TYPE
-- chocolate	sugar_based
-- vanilla	sugar_based
-- mint_chocolate	sugar_based
-- caramel	sugar_based
-- white_chocolate	sugar_based
-- peach	fruit_based
-- watermelon	fruit_based
-- mango	fruit_based
-- strawberry	fruit_based
-- melon	fruit_based
-- orange	fruit_based
-- pineapple	fruit_based
-- 상반기 아이스크림 총주문량이 3,000보다 높은 아이스크림 맛은 chocolate, strawberry, melon, white_chocolate입니다. 이 중에 아이스크림의 주 성분이 과일인 아이스크림 맛은 strawberry와 melon이고 총주문량이 큰 순서대로 아이스크림 맛을 조회하면 melon, strawberry 순으로 조회되어야 합니다. 따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다.

-- FLAVOR
-- melon
-- strawberry

-- 답:

SELECT F.FLAVOR
FROM FIRST_HALF F
JOIN ICECREAM_INFO I ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER > 3000
  AND I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY F.TOTAL_ORDER DESC;


-- 문제 7.

-- 다음은 종합병원에 속한 의사 정보를 담은DOCTOR 테이블입니다. DOCTOR 테이블은 다음과 같으며 DR_NAME, DR_ID, LCNS_NO, HIRE_YMD, MCDP_CD, TLNO는 각각 의사이름, 의사ID, 면허번호, 고용일자, 진료과코드, 전화번호를 나타냅니다.

-- Column name	Type	Nullable
-- DR_NAME	VARCHAR(20)	FALSE
-- DR_ID	VARCHAR(10)	FALSE
-- LCNS_NO	VARCHAR(30)	FALSE
-- HIRE_YMD	DATE	FALSE
-- MCDP_CD	VARCHAR(6)	TRUE
-- TLNO	VARCHAR(50)	TRUE
-- 문제
-- DOCTOR 테이블에서 진료과가 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용일자를 조회하는 SQL문을 작성해주세요. 이때 결과는 고용일자를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬해주세요.

-- 예시
-- DOCTOR 테이블이 다음과 같을 때

-- DR_NAME	DR_ID	LCNS_NO	HIRE_YMD	MCDP_CD	TLNO
-- 루피	DR20090029	LC00010001	2009-03-01	CS	01085482011
-- 패티	DR20090001	LC00010901	2009-07-01	CS	01085220122
-- 뽀로로	DR20170123	LC00091201	2017-03-01	GS	01034969210
-- 티거	DR20100011	LC00011201	2010-03-01	NP	01034229818
-- 품바	DR20090231	LC00011302	2015-11-01	OS	01049840278
-- 티몬	DR20090112	LC00011162	2010-03-01	FM	01094622190
-- 니모	DR20200012	LC00911162	2020-03-01	CS	01089483921
-- 오로라	DR20100031	LC00010327	2010-11-01	OS	01098428957
-- 자스민	DR20100032	LC00010192	2010-03-01	GS	01023981922
-- 벨	DR20100039	LC00010562	2010-07-01	GS	01058390758
-- SQL을 실행하면 다음과 같이 출력되어야 합니다.

-- DR_NAME	DR_ID	MCDP_CD	HIRE_YMD
-- 니모	DR20200012	CS	2020-03-01
-- 뽀로로	DR20170123	GS	2017-03-01
-- 벨	DR20100039	GS	2010-07-01
-- 자스민	DR20100032	GS	2010-03-01
-- 패티	DR20090001	CS	2009-07-01
-- 루피	DR20090029	CS	2009-03-01
-- 주의사항
-- 날짜 포맷은 예시와 동일하게 나와야합니다.

-- 답:

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD IN ('CS', 'GS')
ORDER BY HIRE_YMD DESC, DR_NAME ASC;
