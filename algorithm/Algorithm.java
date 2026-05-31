// 문제 1

// 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
// completion의 길이는 participant의 길이보다 1 작습니다.
// 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
// 참가자 중에는 동명이인이 있을 수 있습니다.
// 입출력 예
// participant	completion	return
// ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
// ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
// ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
// 입출력 예 설명
// 예제 #1
// "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

// 예제 #2
// "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

// 예제 #3
// "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

// 답:

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.keySet().iterator().next();
    }
}


// 문제 2.


// 당신은 폰켓몬을 잡기 위한 오랜 여행 끝에, 홍 박사님의 연구실에 도착했습니다. 홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
// 홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다. 따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다. 예를 들어 연구실에 총 4마리의 폰켓몬이 있고, 각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면 이는 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다. 이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.

// 첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
// 첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
// 첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
// 두 번째(1번), 세 번째(2번) 폰켓몬을 선택
// 두 번째(1번), 네 번째(3번) 폰켓몬을 선택
// 세 번째(2번), 네 번째(3번) 폰켓몬을 선택
// 이때, 첫 번째(3번) 폰켓몬과 네 번째(3번) 폰켓몬을 선택하는 방법은 한 종류(3번 폰켓몬 두 마리)의 폰켓몬만 가질 수 있지만, 다른 방법들은 모두 두 종류의 폰켓몬을 가질 수 있습니다. 따라서 위 예시에서 가질 수 있는 폰켓몬 종류 수의 최댓값은 2가 됩니다.
// 당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다. N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
// nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
// 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
// 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
// 입출력 예
// nums	result
// [3,1,2,3]	2
// [3,3,3,2,2,4]	3
// [3,3,3,2,2,2]	2
// 입출력 예 설명
// 입출력 예 #1
// 문제의 예시와 같습니다.

// 입출력 예 #2
// 6마리의 폰켓몬이 있으므로, 3마리의 폰켓몬을 골라야 합니다.
// 가장 많은 종류의 폰켓몬을 고르기 위해서는 3번 폰켓몬 한 마리, 2번 폰켓몬 한 마리, 4번 폰켓몬 한 마리를 고르면 되며, 따라서 3을 return 합니다.

// 입출력 예 #3
// 6마리의 폰켓몬이 있으므로, 3마리의 폰켓몬을 골라야 합니다.
// 가장 많은 종류의 폰켓몬을 고르기 위해서는 3번 폰켓몬 한 마리와 2번 폰켓몬 두 마리를 고르거나, 혹은 3번 폰켓몬 두 마리와 2번 폰켓몬 한 마리를 고르면 됩니다. 따라서 최대 고를 수 있는 폰켓몬 종류의 수는 2입니다.

// 답:
// Set으로 고유 종류 수를 구한 뒤, N/2와 비교해 작은 값을 반환.

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return Math.min(set.size(), nums.length / 2);
    }
}

// 문제 3: 

// 코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.

// 예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.

// 종류	이름
// 얼굴	동그란 안경, 검정 선글라스
// 상의	파란색 티셔츠
// 하의	청바지
// 겉옷	긴 코트
// 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
// 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
// 코니는 하루에 최소 한 개의 의상은 입습니다.
// 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
// 코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
// 같은 이름을 가진 의상은 존재하지 않습니다.
// clothes의 모든 원소는 문자열로 이루어져 있습니다.
// 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
// 입출력 예
// clothes	return
// [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
// [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
// 입출력 예 설명
// 예제 #1
// headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.

// 1. yellow_hat
// 2. blue_sunglasses
// 3. green_turban
// 4. yellow_hat + blue_sunglasses
// 5. green_turban + blue_sunglasses
// 예제 #2
// face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.

// 1. crow_mask
// 2. blue_sunglasses
// 3. smoky_makeup

// 답:
// 각 종류별 아이템 수를 HashMap으로 집계한 뒤,
// 각 종류에서 (개수 + 1)을 모두 곱하고 마지막에 1을 뺀다.
// +1: 해당 종류를 아예 안 입는 경우 포함
// -1: 아무것도 안 입는 경우 제외

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}

// 문제 4:

// 문제 설명
// 1이상의 정수로 이루어진 길이가 N인 1차원 정수 배열 arr가 주어집니다. 다음 규칙에 따라 배열 brr를 만듭니다.

// 배열 arr의 인덱스 순서대로 arr[i]를 배열 brr에 연속으로 arr[i]개씩 추가합니다.
// 예를 들어, arr가 [2, 1, 5]이면 brr는 [2, 2, 1, 5, 5, 5, 5, 5]입니다.

// brr의 부분 배열1 구간의 양 끝을 나타내는 l, r이 주어질 때 아래 2가지를 구하려고 합니다.

// K = brr의 l번째 원소부터 r번째 원소까지의 합 = brr[l-1] + brr[l] + brr[l+1] + ... + brr[r-2] + brr[r-1]
// C = 길이가 r - l + 1인 brr의 부분 배열 중 합이 K인 부분 배열의 개수
// 1차원 정수 배열 arr와 구간의 양 끝을 나타내는 정수 l, r이 매개변수로 주어집니다. 이때, 1차원 정수 배열 [K, C]를 return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 = N ≤ 100,000
// 1 ≤ arr[i] ≤ 100,000
// brr의 모든 원소의 합 ≤ 1015
// 1 ≤ l ≤ r ≤ arr의 모든 원소의 합
// l번째 원소부터 r번째 원소까지의 합을 구해야 합니다.
// 테스트 케이스 구성 안내
// 아래는 테스트 케이스 구성을 나타냅니다. 각 그룹은 하나 이상의 하위 그룹으로 이루어져 있으며, 하위 그룹의 모든 테스트 케이스를 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.

// 그룹	총점	테스트 케이스 그룹 설명
// #1	5%	l = r
// #2	15%	N ≤ 100, arr[i] ≤ 10
// #3	35%	정답이 C = 1인 테스트 케이스만 주어집니다.
// #4	45%	추가 제한 사항 없음
// 입출력 예
// arr	l	r	result
// [3, 2, 3, 1, 1]	5	7	[8, 2]
// [2, 2, 2]	2	2	[2, 6]
// [8, 8, 6, 5, 2, 9, 8, 4, 3, 10]	25	27	[15, 3]
// [70195, 25471, 7389, 58187, 18454, 90532, 97667, 17148, 91636, 2810]	126058	462933	[27554327568, 1]
// [16952, 70276, 16771, 37992, 87549, 54906, 36718, 20478, 57088, 27916, 51509, 83422, 51707, 18807, 80859, 2673, 37734, 93380]	149845	228204	[6860339640, 9190]
// [49134, 86806, 94548, 88849, 95022, 28334, 16637, 79487, 23773, 7314, 47370, 50269, 36573, 9415, 44674, 28096]	61242	88535	[2369282964, 59513]
// 입출력 예 설명
// 입출력 예 #1

// brr는 [3, 3, 3, 2, 2, 3, 3, 3, 1, 1]입니다. 5~7번째 원소로 이루어진 부분 배열의 합은 8(=K)입니다.
// [3, 3, 3, 2, 2, 3, 3, 3, 1, 1] 또한 부분 배열의 합이 8이며 길이가 3입니다.
// 위 두 경우 외에는 합이 8이고 길이가 3인 부분 배열은 존재하지 않습니다.
// [3, 3, 3, 2, 2, 3, 3, 3, 1, 1]은 부분 배열의 합이 8이지만 길이가 4이므로 C로 세지 않습니다.

// 따라서 [8, 2]를 return 해야 합니다.

// 입출력 예 #2

// brr는 [2, 2, 2, 2, 2, 2]입니다. 2~2번째 원소로 이루어진 부분 배열의 합은 2(=K)입니다. 합이 2이고 길이가 1인 부분 배열의 개수는 6개입니다.

// 따라서 [2, 6]을 return 해야 합니다.

// 입출력 예 #3

// [15, 3]을 return 해야 합니다.

// 입출력 예 #4

// [27554327568, 1]을 return 해야 합니다.

// 입출력 예 #5

// [6860339640, 9190]을 return 해야 합니다.

// 입출력 예 #6

// [2369282964, 59513]을 return 해야 합니다.

// 부분 배열이란 주어진 배열에서 연속된 원소들로 이루어진 배열을 의미합니다. ↩

// 답 :
// brr의 크기가 최대 10^10이라 실제 배열 생성 불가.
// arr[i]가 arr[i]번 반복되는 블록 구조를 이용해 이진탐색으로 K를 구하고,
// 슬라이딩 윈도우의 좌/우 끝이 블록 경계를 넘는 이벤트 지점만 처리해 C를 계산.
// 이벤트 사이 구간에서 윈도우 합은 등차수열 → 구간 내 K와 같은 위치를 O(1)로 카운트.

import java.util.*;

class Solution {
    private int[] arr;
    private long[] cumLen;        // cumLen[i] = arr[0]+...+arr[i-1]
    private long[] blockPrefSum;  // blockPrefSum[i] = arr[0]^2+...+arr[i-1]^2

    public long[] solution(int[] arr, long l, long r) {
        int N = arr.length;
        this.arr = arr;
        cumLen = new long[N + 1];
        blockPrefSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            cumLen[i + 1] = cumLen[i] + arr[i];
            blockPrefSum[i + 1] = blockPrefSum[i] + (long) arr[i] * arr[i];
        }
        long total = cumLen[N];
        long len = r - l + 1;

        long K = rangeSum(l, r);
        long C = countWindows(N, total, len, K);
        return new long[]{K, C};
    }

    // brr에서 위치 p(1-indexed)가 속한 블록 인덱스 반환
    private int blockOf(long p) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (cumLen[mid + 1] < p) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int getVal(long p) {
        return arr[blockOf(p)];
    }

    // brr[1..p]의 합 (1-indexed 누적합)
    private long prefixSum(long p) {
        if (p <= 0) return 0;
        int b = blockOf(p);
        return blockPrefSum[b] + (long) arr[b] * (p - cumLen[b]);
    }

    private long rangeSum(long l, long r) {
        return prefixSum(r) - prefixSum(l - 1);
    }

    // 길이 len인 윈도우 중 합이 K인 경우의 수
    private long countWindows(int N, long total, long len, long K) {
        if (total < len) return 0;

        // 이벤트: 좌끝/우끝이 블록 경계를 넘는 윈도우 시작 위치
        TreeSet<Long> eventSet = new TreeSet<>();
        eventSet.add(1L);
        eventSet.add(total - len + 2); // sentinel

        for (int i = 1; i < N; i++) {
            long leftEvent = cumLen[i] + 1;          // 좌끝이 블록 i로 진입
            if (leftEvent <= total - len + 1) eventSet.add(leftEvent);

            long rightEvent = cumLen[i] + 1 - len;   // 우끝(p+len)이 블록 i로 진입
            if (rightEvent >= 1 && rightEvent <= total - len + 1) eventSet.add(rightEvent);
        }

        long[] events = eventSet.stream().mapToLong(Long::longValue).toArray();
        long currentSum = rangeSum(1, len);
        long C = 0;

        for (int i = 0; i < events.length - 1; i++) {
            long pStart = events[i];
            long pEnd   = events[i + 1];
            long segLen = pEnd - pStart;

            // 한 스텝 이동 시 합의 변화량: brr[p+len] - brr[p] (구간 내 상수)
            long delta = (pStart + len <= total)
                    ? getVal(pStart + len) - getVal(pStart)
                    : 0;

            long diff = K - currentSum;
            if (delta == 0) {
                if (diff == 0) C += segLen;
            } else {
                if (diff % delta == 0) {
                    long offset = diff / delta;
                    if (offset >= 0 && offset < segLen) C++;
                }
            }
            currentSum += segLen * delta;
        }
        return C;
    }
}

// 문제 5.

// 문제 설명
// 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

// 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
// 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
// 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
// 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

// 제한사항
// genres[i]는 고유번호가 i인 노래의 장르입니다.
// plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
// genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
// 장르 종류는 100개 미만입니다.
// 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
// 모든 장르는 재생된 횟수가 다릅니다.
// 입출력 예
// genres	plays	return
// ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
// 입출력 예 설명
// classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

// 고유 번호 3: 800회 재생
// 고유 번호 0: 500회 재생
// 고유 번호 2: 150회 재생
// pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

// 고유 번호 4: 2,500회 재생
// 고유 번호 1: 600회 재생
// 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

// 답:
// 장르별 총 재생 횟수를 HashMap으로 집계 후 내림차순 정렬.
// 각 장르 내 노래를 재생 횟수 내림차순, 동률이면 고유번호 오름차순 정렬해 최대 2곡씩 수록.

// 답: 
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreTotal = new HashMap<>();
        HashMap<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + plays[i]);
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }

        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}


// 문제 6: 

// 문제 설명
// 어느 날, 전설 속에 전해 내려오는 비밀 주문서가 세상에 다시 모습을 드러냈습니다. 이 주문서에는 마법 세계에서 사용되는 모든 주문이 적혀 있는데, 각 주문은 알파벳 소문자 11글자 이하로 구성되어 있습니다. 주문서에는 실제로 마법적 효과를 지니지 않는 의미 없는 주문들 즉, 알파벳 소문자 11글자 이하로 쓸 수 있는 모든 문자열이 고대의 규칙에 따라 아래와 같이 정렬되어 있습니다.

// 글자 수가 적은 주문부터 먼저 기록된다.
// 글자 수가 같다면, 사전 순서대로 기록된다.
// 예를 들어, 주문서의 시작 부분은 다음과 같이 구성됩니다.

// "a"→"b"→"c"→"d"→"e"→"f"→...→"z"
// →"aa"→"ab"→...→"az"→"ba"→...→"by"→"bz"→"ca"→...→"zz"
// →"aaa"→"aab"→...→"aaz"→"aba"→...→"azz"→"baa"→...→"zzz"
// →"aaaa"→...→"aazz"→"abaa"→...→"czzz"→"daaa"→...→"zzzz"
// →"aaaaa"→...
// 하지만 이 주문서에는 오래전 봉인된 저주받은 주문들이 숨겨져 있었고, 이를 악용하려는 자들을 막기 위해 마법사들이 몇몇 주문을 주문서에서 삭제했습니다. 당신은 삭제가 완료된 주문서에서 n번째 주문을 찾아내야 합니다.

// 예를 들어, 주문서에서 "d", "e", "bb", "aa", "ae" 5개의 주문을 지웠을 때, 주문서에서 30번째 주문을 찾으려고 합니다.

// 1~3번째 주문은 "a", "b", "c" 입니다.
// "d"와 "e"는 삭제됐으므로 4~24번째 주문은 "f" ~ "z"입니다.
// "aa"는 삭제됐으므로 25~27번째 주문은 "ab", "ac", "ad"입니다.
// "ae"는 삭제됐으므로 28~30번째 주문은 "af", "ag", "ah"입니다.
// 따라서 30번째 주문은 "ah"가 됩니다. 삭제된 주문 중 “bb”와 같이 n번째 주문보다 뒤에 위치해 있어서 n번째 주문을 찾는 데 영향을 주지 않는 주문도 존재할 수 있습니다.

// 정수 n과 삭제된 주문들을 담은 1차원 문자열 배열 bans가 매개변수로 주어질 때, 삭제가 완료된 주문서의 n번째 주문을 return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ n ≤ 1015
// 1 ≤ bans의 길이 ≤ 300,000
// bans의 원소는 알파벳 소문자로만 이루어진 길이가 1 이상 11 이하인 문자열입니다.
// bans의 원소는 중복되지 않습니다.
// 입출력 예
// n	bans	result
// 30	["d", "e", "bb", "aa", "ae"]	"ah"
// 7388	["gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"]	"jxk"
// 테스트 케이스 구성 안내
// 아래는 테스트 케이스 구성을 나타냅니다. 각 그룹 내의 테스트 케이스를 모두 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.

// 그룹	총점	추가 제한 사항
// #1	15%	n ≤ 1,000, bans의 길이 ≤ 100
// #2	15%	n ≤ 1,000,000
// #3	70%	추가 제한 사항 없음
// 입출력 예 설명
// 입출력 예 #1

// 문제 예시와 같습니다.

// 입출력 예 #2

// 주어진 주문을 지운 후 주문서의 7,388 번째 주문은 "jxk"입니다.
// 따라서 "jxk"를 return 합니다.

// 답:
// 각 ban 문자열을 원본 주문서 rank로 변환 후 정렬.
// 이진탐색으로 "rank r까지 유효 주문 수(= r - rank≤r인 ban 수) >= n"인 최소 r을 구하고,
// 해당 rank를 문자열로 역변환.

import java.util.*;

class Solution {
    private long[] pow26 = new long[12];
    private long[] cumCount = new long[13]; // cumCount[k] = 26^1 + ... + 26^k

    public String solution(long n, String[] bans) {
        pow26[0] = 1;
        for (int i = 1; i <= 11; i++) pow26[i] = pow26[i - 1] * 26;
        for (int i = 1; i <= 11; i++) cumCount[i] = cumCount[i - 1] + pow26[i];

        long[] banRanks = new long[bans.length];
        for (int i = 0; i < bans.length; i++) banRanks[i] = rankOf(bans[i]);
        Arrays.sort(banRanks);

        long lo = n, hi = n + bans.length;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid - countBansUpTo(banRanks, mid) >= n) hi = mid;
            else lo = mid + 1;
        }
        return rankToString(lo);
    }

    private long countBansUpTo(long[] sorted, long r) {
        int lo = 0, hi = sorted.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (sorted[mid] <= r) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private long rankOf(String s) {
        int len = s.length();
        long rank = cumCount[len - 1] + 1;
        for (int i = 0; i < len; i++) rank += (long)(s.charAt(i) - 'a') * pow26[len - 1 - i];
        return rank;
    }

    private String rankToString(long r) {
        int len = 1;
        while (cumCount[len] < r) len++;
        long pos = r - cumCount[len - 1] - 1;
        char[] chars = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            chars[i] = (char)('a' + pos % 26);
            pos /= 26;
        }
        return new String(chars);
    }
}
