package programmers.highScoreKit.heap;

import java.util.*;

public class DiskController { // 디스크 컨트롤러
    // 평균(전체 작업시간)을 가장 줄이는 방법으로 처리
    // 작업시간이 길때 대기작업 수가 많으면 손해(대기시간 * 대기작업 수)
    // 따라서 해당 시점에서 가장 짧은 작업을 시행(대기잡업 수 를 줄이자) >> 최소값 정렬(Heap >> Priority Queue)

    static List<int[]> heap = new ArrayList<>();

    static void swap(int i, int j){ // i,j 위치 교환
        int[] n = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, n);
    }

    static void heapAdd(int[] n){
        heap.add(n);
        int c = heap.size()-1; // 자식노드 index
        int p = (c-1)/2; // 부모노드 index

        // 힙ok or c==0 때까지(뿌리 노드 될때까지) 연산(swap)
        while(c!=0){
            if(heap.get(p)[1] > heap.get(c)[1]){ // 자식노드가 더 작으면
                swap(p,c);
                c = p;
                p = (c-1)/2;
            }
            else break; // 힙 완성

        }
    }

    static int[] heapGet(){
        int[] min = heap.get(0);
        int l = heap.size();

        heap.set(0, heap.get(l-1)); // 루트 노드에 마지막 노드 삽입
        heap.remove(l-1); // 마지막 노드 삭제
        l--;

        // 힙 재구성 - 뿌리 노드부터
        int p=0;
        int lc,rc;

        while (2*p+2 < l){ // 양쪽 자식노드가 더 없을 때 까지
            lc = 2*p+1;
            rc = 2*p+2;

            if(heap.get(p)[1] > heap.get(lc)[1] && heap.get(rc)[1] >= heap.get(lc)[1]){ // 왼쪽 자식
                swap(p,lc);
                p = lc;
            }
            else if(heap.get(p)[1] > heap.get(rc)[1] && heap.get(lc)[1] >= heap.get(rc)[1]){ // 오른쪽 자식
                swap(p,rc);
                p = rc;
            }
            else break; // 부모가 젤 큼(크거나 같음)

        }

        // 왼쪽 자식노드만 있을 경우 따로 연산
        if(2*p+1<l){
            lc = 2*p+1;
            if(heap.get(p)[1] > heap.get(lc)[1]) swap(p,lc);
        }

        return min;
    }

    public static void main0(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};  // [요청시간, 소요시간] >> 요청시간 순으로 정렬되어 있을까?
        int time = 0; // 현재시간(절대위치)
        int count = 0; // 소요'시간' + 대기'시간'*대기작업수
        int jobIndex=0;
        int[] job;
        int[] nextjob;

        // 첫 작업
        job = jobs[jobIndex];
        jobIndex++;
        nextjob = jobs[jobIndex]; // jobs 의 길이가 1일때는 그냥 예외처리 할 것
        jobIndex++;

        // timeFlow 기준 ver - 매초 연산하기에 비효율적 일수 있다. - 추후 개선
//        while (jobIndex<jobs.length){
//
//            if(job[0] <= time && time < job[1]){ // 현재 job 을 연산 - 그동안 들어오는 job 은 heap 에 쌓아둔다
//                count += 1 + heap.size();
//
//                if(nextjob[0] == time){ // 다음작업 요청시간이면
//                    input(nextjob); // heap에 등록
//                    nextjob = jobs[jobIndex];
//                    jobIndex++; // while 문 밖에서 마무리 연산 필요
//                }
//            }
//            else{ // 현재 job 연산 끝이면 heap 에서 다음연산 받아온다.
//                job = output();
//
//                if(nextjob[0] == time){ // 다음작업 요청시간이면
//                    input(nextjob); // heap에 등록
//                    nextjob = jobs[jobIndex];
//                    jobIndex++; // while 문 밖에서 마무리 연산 필요
//                }
//            }
//
//            time++;
//        }


















    }


    public static void main1(String[] args) { // ver1 - 계산 겁나 복잡,,예시부터 틀림
        int[][] jobs = {{0,3},{1,9},{2,6}};  // [요청시'각', 소요시간] >> 요청시간 순으로 정렬되어 있을까? >> 아니라면 이것도 heap으로 최소부터 뽑자

        // jobs 길이 1일때, 예외처리
//        if(jobs.length==1) return jobs[0][1] - jobs[0][0];
        int time = 0; // 현재시간(절대위치)
        int count = 0; // 소요'시간' + 대기'시간'*대기작업수 = '시간' * (1+대기작업수)


        int[] job = jobs[0];
        int[] nextjob = jobs[1]; // heap 에 들어갈 준비(대기)
        int jobIndex=2;

        // 중간연산 - while 문으로 돌리자!, nextjob 이 없을 때까지
        // "작업의 요청시'각'과 실제 시작시'각'은 다를 수 있다. 따라서 시'간'만 더해줄 것!"

        while (jobIndex < jobs.length){ // nextjob이 존재할 때 까지

            if(time < job[0]){ // 현재작업 완료 And 다음작업 요청이 아직 안들어온 상태이면? (공강)
//            count += 0;
                time = job[0];
            }

            if(nextjob[0] < time + job[1]){ // 다음 작업 요청시간 - heap에 추가
                count += (nextjob[0]-time) * (1+ heap.size());
                time = nextjob[0];
                heapAdd(nextjob); // 힙에 대기작업 추가
                nextjob = jobs[jobIndex]; // nextjob 업그레이드 >> IndexOutOf 안나게 조심
                jobIndex++;

            } else if (nextjob[0] > time+job[1]) { // 현재작업 연산종료
                count += (job[0] + job[1] - time) * (1+ heap.size()); // 현재 job 의 어느위치인지 알 수 없네,, 중간중간에 nextjob 연산 할 수 있기에, 현재 job 에서의 위치정보 변수 추가 필요 >> 에라이 안해!!
                time = job[0]+job[1];
                // job종료 다음job heap에서 받아오기
                if(heap.isEmpty()){
                    // heap에 대기중인 job도 없고 nextjob까지 공강이다 - nextjob이 heap을 거치지 않고 바로 job에 할당
                    job = nextjob;
                    nextjob = jobs[jobIndex]; // nextjob 업그레이드 >> IndexOutOf 안나게 조심
                    jobIndex++;
                }
                else job = heapGet();


            } else { // nextjob[0] == time+job[1]
                count += (nextjob[0]-time) * (1+ heap.size());
                time = nextjob[0];

                // 시간먼저 연산후, 위의 두 if문 연산(같이 수정 필요)

                heapAdd(nextjob); // 힙에 대기작업 추가
                nextjob = jobs[jobIndex]; // nextjob 업그레이드 >> IndexOutOf 안나게 조심
                jobIndex++;

                // job종료 다음job heap에서 받아오기
                job = heapGet(); // 방금 위에서 추가했으므로 heap.empty() 일리가 없음
            }
        }

        // jobs 는 모두 턴 상태, heap 과 nextjob 남아있는 연산 마무리
        boolean nextjobRemain = true;
        while(!heap.isEmpty()){ // heap 에 남은작업 다 끝날때 까지

            // heap 에 쌓인연산을 모두 처리해야 하기에 공강이 있을 수 없음
            // nextjob이 언제 처리되는지가 관건
            if(nextjobRemain){

                if(nextjob[0] < time + job[1]){ // nextjob 연산
                    count += (nextjob[0]-time)*(1+ heap.size());
                    time = nextjob[0];
                    heapAdd(nextjob);

                    nextjobRemain = false;
                }
                else if (nextjob[0] > time + job[1]) { // job 연산
                    count += (job[0]+job[1] - time)*(1+ heap.size());
                    time = job[0]+job[1];
                    job = heapGet();
                }
                else{ // nextjob[0] == time + job[1]
                    count += (nextjob[0]-time)*(1+ heap.size());
                    time = nextjob[0];
                    heapAdd(nextjob);
                    nextjobRemain = false;

                    job = heapGet();
                }
            }
            else{ // nextjob이 없을 때 >> heap-job 연산만 마무리하자
                count += (job[0]+job[1] - time)*(1+ heap.size());
                time = job[0]+job[1];
                job = heapGet();
            }
        }

        // 마지막 job 과 nextjob 확인 연산 (요청시간이 굉~장히 늦게 주어졌을 때 nextjob 있을 수도,,, outliar)
        // heap은 다 털었고, nextjob이 남아있다면 공강>=0, 즉, job 연산후 nextjob 연산하면 된다.
        count += job[0]+job[1] - time;
        time = job[0]+job[1];

        if(nextjobRemain){
            count += nextjob[1]; // 작업시'간'만 추가

            // job 중간에 겹치는 경우
            if(nextjob[0] < job[0] + job[1]){
                count += job[0] + job[1] - nextjob[0];
            }
        }


        // return 확인
        System.out.println(count/jobs.length);

    }


    public static void main2(String[] args) { // ver2 - 겹치는 막대기 길이 착안 ,, 꼴랑 3/20개 맞음,,
//        int[][] jobs = {{0,3},{1,9},{2,6}}; // return 9  // [요청시'각', 소요시'간']
//        int[][] jobs = {{1,2},{2,2},{2,4},{7,2}}; // return 16/4 = 4
//        int[][] jobs = {{1,2},{2,2},{2,4},{7,2},{20,5}}; // return 21/5 = 4
        int[][] jobs = {{0,1},{5,3}}; // return 4/2 = 2

        // 길이 1일때 예외처리
//        if(jobs.length==1) return jobs[0][1] - jobs[0][0];
//        System.out.println(heap);
        int l = jobs.length;
        int time=0; // 시'각'
        int count=0;
        int[] workingJob = jobs[0]; // 초기화
        int jobIndex = 1;


        while (jobIndex < l){

            if(time < workingJob[0]){ // 공강제거
                time = workingJob[0];
            }

            // workingJob 연산
            time += workingJob[1]; // workingJob[0]에서 출발하기에 문제없음
            // >> ver1의 문제가 이건가?!! "작업의 요청시'각'과 실제 시작시'각'은 다를 수 있다. 따라서 시'간'만 더해줄 것!"
            count += workingJob[1]*(1 + heap.size());

            // 대기작업 heap 추가 연산
            while(jobs[jobIndex][0] <= time){ // 요청시'각' <= time 인 job을 모두 받는다.
                heapAdd(jobs[jobIndex]); // heap 에 추가
                count += time - jobs[jobIndex][0]; // count 에 시간간격(time-요청시'각') 추가.

                jobIndex++;
                if(jobIndex == l) break;
            }

            // workingJob 갱신
            if(heap.isEmpty()){ // 대기작업 없으면(heap.isEmpty), heap거치지 않고 바로 할당 >> 공강연산으로 올라감
                workingJob = jobs[jobIndex];
                jobIndex++;
            }
            else{ // 대기작업 있으면 shortest 할당
                workingJob = heapGet();
            }
        }


        // 모두 대기열 heap에 등록 - 순차적으로 처리만 하면 끝
        while(!heap.isEmpty()){
            if(time < workingJob[0]){ // 공강제거 - heap 에 대기타는 이상 공강없을 것 같은데 안전빵으루
                time = workingJob[0];
            }
            // workingJob 연산
            time += workingJob[1]; // workingJob[0]에서 출발하기에 문제없음
            // >> ver1의 문제가 이건가?!! "작업의 요청시'각'과 실제 시작시'각'은 다를 수 있다. 따라서 시'간'만 더해줄 것!"
            count += workingJob[1]*(1 + heap.size());

            // 대기작업 heap 에 더 추가할 게 없음, workingJob 갱신만
            workingJob = heapGet();

        }

        // 마지막 workingJob 연산
        if(time < workingJob[0]){ // 공강제거
            time = workingJob[0];
        }
        // workingJob 연산
        time += workingJob[1]; // workingJob[0]에서 출발하기에 문제없음
        // >> ver1의 문제가 이건가?!! "작업의 요청시'각'과 실제 시작시'각'은 다를 수 있다. 따라서 시'간'만 더해줄 것!"
        count += workingJob[1]*(1 + heap.size());

        //결과확인
        System.out.println(count);
        System.out.println(count/l);

    }


    public static void main3(String[] args) { // ver3 - ver2를 개선 - 똑같이 실패,,3/20 문제를 잘 못 이해했나,,
        // 걸린시간 = 수행시간 + 지연시간
        // 수행시간 : job[1] 의 길이 합
        // 지연시간 : (job 의 실제 시작시간(time) - job[0]) 의 합

//        int[][] jobs = {{0,3},{1,9},{2,6}}; // return 9  // [요청시'각', 소요시'간']
//        int[][] jobs = {{1,2},{2,2},{2,4},{7,2}}; // return 16/4 = 4
//        int[][] jobs = {{1,2},{2,2},{2,4},{7,2},{20,5}}; // return 21/5 = 4
        int[][] jobs = {{0,1},{5,3}}; // return 4/2 = 2

        // 길이 1일때 예외처리
//        if(jobs.length==1) return jobs[0][1] - jobs[0][0];
//        System.out.println(heap);
        int l = jobs.length;
        int time=0; // 시'각'
        int count=0;
        int[] workingJob = jobs[0]; // 초기화
        int jobIndex = 1;

        while (jobIndex < l){

            // workingJob 시간연산 = 수행시간 + 지연시간(time - workingJob[0])
            if(time < workingJob[0]){ // 공강(지연 X)
                time = workingJob[0] + workingJob[1]; //끝나는 시'각'에 맞춤
                count += workingJob[1]; // 수행시'간' 만 더해줌
            }
            else{ // 지연 존재
                count += workingJob[1] + time - workingJob[0]; // 수행시간 + 지연시간
                time += workingJob[1]; // 시작시'각'과 요청시'각'이 일치하지 않아 수행시'간'만 흐름(더해줌)
            }

            // 대기작업 heap 추가 연산
            while(jobs[jobIndex][0] <= time){ // 요청시'각' <= time 인 job을 모두 받는다.
                heapAdd(jobs[jobIndex]); // heap 에 추가

                jobIndex++;
                if(jobIndex == l) break;
            }

            // workingJob 갱신
            if(heap.isEmpty()){ // 대기작업 없으면(heap.isEmpty), heap거치지 않고 바로 할당 >> 공강연산으로 올라감
                workingJob = jobs[jobIndex];
                jobIndex++;
            }
            else{ // 대기작업 있으면 shortest 할당
                workingJob = heapGet();
            }
        }

        // 모두 대기열 heap에 등록 - 순차적으로 처리만 하면 끝
        while(!heap.isEmpty()){

            // workingJob 시간연산 = 수행시간 + 지연시간(time - workingJob[0])
            if(time < workingJob[0]){ // 공강(지연 X)
                time = workingJob[0] + workingJob[1]; //끝나는 시'각'에 맞춤
                count += workingJob[1]; // 수행시'간' 만 더해줌
            }
            else{ // 지연 존재
                count += workingJob[1] + time - workingJob[0]; // 수행시간 + 지연시간
                time += workingJob[1]; // 시작시'각'과 요청시'각'이 일치하지 않아 수행시'간'만 흐름(더해줌)
            }

            // 대기작업 heap 에 더 추가할 게 없음, workingJob 갱신만
            workingJob = heapGet();

        }

        // 마지막 workingJob 연산
        if(time < workingJob[0]){ // 공강(지연 X)
            time = workingJob[0] + workingJob[1]; //끝나는 시'각'에 맞춤
            count += workingJob[1]; // 수행시'간' 만 더해줌
        }
        else{ // 지연 존재
            count += workingJob[1] + time - workingJob[0]; // 수행시간 + 지연시간
            time += workingJob[1]; // 시작시'각'과 요청시'각'이 일치하지 않아 수행시'간'만 흐름(더해줌)
        }


        //결과확인
        System.out.println(count);
        System.out.println(count/l);
    }

}
