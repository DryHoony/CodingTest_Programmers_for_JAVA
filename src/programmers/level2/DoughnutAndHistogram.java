package programmers.level2;

import programmers.level1.IfDivisorCountEven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoughnutAndHistogram { // 도넛과 막대 그래프
    // 크기 n에 대해
    // 도넛 모양 그래프 : n개 정점, n개 간선, 순회
    // 막대 모양 그래프 : n개 정점, n-1개 간선, 단반향
    // 8자 모양 그래프 : 2n+1개 정점, 2n+2개 간선



    public static void main(String[] args) {
        int[][] edges; // 길이 1~1,000,000 값 1~1,000,000
        int[] result;

        // case 1
        edges = new int[][]{{2,3},{4,3},{1,1},{2,1}}; // 간선정보
        result = new int[] {2,1,1,0}; // 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프 수, 8자 모양 그래프 수

        // case 2
        edges = new int[][] {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        result = new int[] {4,0,1,2};

        solution3(edges);
    }

    public static int[] solution4(int[][] edges){ // node 자료구조 ver
        Map<Integer, Integer> nextNodeMap = new HashMap<>();
//        Map<Integer, Integer> preNodeMap = new HashMap<>(); // 순환안되는 '막대연산'을 위해 역추적 용
        ArrayList<int[]> duplicatedEdges = new ArrayList<>();
        boolean[] usedNode = new boolean[1000001]; // node 사용 여부, default 는 false

        int[] answer = new int[4];
//        int constructNode;

        //////////////// edges 연산
        for (int[] edge:edges){

            // case0: 셀프도넛모양, 미리 처리 >> answer[1], usedNode;
            if(edge[0] == edge[1]){
                nextNodeMap.put(edge[0],edge[1]);
                // 도넛완성
                answer[1]++;
                usedNode[edge[0]] = true;

                continue;
            }

            // case1: if not(nextNodeMap.containsKey()) -> 정상할당(new)
            if(!nextNodeMap.containsKey(edge[0])){
                nextNodeMap.put(edge[0],edge[1]);
                int startNode = edge[0];
                int endNode = edge[1];
                int nextNode = edge[1];
                // case1.1 : if(고리연산), 도넛모양완성 -> answer[1], usedNode
                while(nextNodeMap.get(nextNode) != null){
                    nextNode = nextNodeMap.get(nextNode); // nullPointException 가능 -> while 문에서 연산
                    if(nextNode == startNode){
                        // 도넛완성
                        answer[1]++;
                        // userNode 할당
                        usedNode[startNode] = true;
                        nextNode = endNode;
                        while(nextNode != startNode){
                            usedNode[nextNode] = true;
                            nextNode = nextNodeMap.get(nextNode);
                        }
                        break;
                    }
                    else if(nextNode == endNode){
                        // 헛바퀴
                        break;
                    }
                }
            }
            else { // case2: else(case1) key 존재시 duplicatedEdges 에 할당 (생성노드 or 8자모양)
                duplicatedEdges.add(edge);
            }

        }

        ArrayList<Integer> constructNodeList = new ArrayList<>();
        ///////////////// duplicatedEdges 연산
        for(int[] edge:duplicatedEdges){ // 생성노드 or 8자노드중심

            int startNode = edge[0];
            int endNode = edge[1];
            int nextNode = edge[1];
            boolean isConstructor = true;
            ArrayList<Integer> fakeCircle = new ArrayList<>();
            // edge '시작'하는(생성 Node 와 구분) 고리 만들어질 경우, 8자 모양 -> answer[1], answer[3], usedNode
            while(nextNodeMap.get(nextNode) != null){
                nextNode = nextNodeMap.get(nextNode);
                if(nextNode == startNode){
                    // 8자 완성
                    answer[1]--;
                    answer[3]++;
                    // usedNode 할당
                    usedNode[startNode] = true;
                    nextNode = endNode;
                    while(nextNode != startNode){
                        usedNode[nextNode] = true;
                        nextNode = nextNodeMap.get(nextNode);
                    }
                    isConstructor = false;
                    break;
                }
                else if(fakeCircle.contains(nextNode)){
                    // 헛바퀴 - 생성노드
                    break;
                }
                fakeCircle.add(nextNode);

            }

            if(isConstructor){
//                constructNodeList.add(edge[0]);
                answer[0] = edge[0];
            }

            // 생성자 출발 막대노드 >> answer[2]
            if(nextNodeMap.get(nextNode) == null){
                answer[2]++; // 마지막 연산이므로 갯수만 세면 ok
                nextNode = edge[1];
                usedNode[nextNode] = true;
                while(nextNodeMap.get(nextNode) != null){
                    nextNode = nextNodeMap.get(nextNode);
                    usedNode[nextNode] = true;
                }

            }
        }

        // duplicatedEdge 반복문 연산 완료 후 끝까지 남아있는 값이 생성노드 -> answer[0]
//        System.out.println("생성노드 확인 -> " + constructNodeList);
//        System.out.println("당연히 다 같겠지? 아님 곤란빤스");
//        System.out.println();

//        answer[0] = constructNodeList.get(0);


        // nextNodeMap 를 순회하면서 사용되지 않은 노드 if(!usedNode)이면 막대 모양 연산 -> answer[2];
        for(int i:nextNodeMap.keySet()){
            if(usedNode[i]) {
                System.out.println(i + "노드는 사용됨");
            }
            else if(i == answer[0]){
                System.out.println(i + "노드는 생성노드");
                // 생성노드에서 막대 check - duplicatedEdges 에서 확인 (예제 2 참조)
            }
            else {
                System.out.println(i + "노드는 사용안됨");
                // 막대 연산 start (예제 1 참조)
                boolean isNewBar = true;
                int nextNode = i;
                usedNode[nextNode] = true;
//                System.out.println("막대연산");
                while(nextNodeMap.get(nextNode) != null){
                    nextNode = nextNodeMap.get(nextNode);
                    if(usedNode[nextNode]) isNewBar = false;
                    else usedNode[nextNode] = true;
                }

                if(isNewBar) answer[2]++;


            }
        }

        System.out.println("answer 출력확인 >> " + answer[0] + ", "+ answer[1] + ", "+ answer[2] + ", "+ answer[3]);
        return answer;
    }

    public static int[] solution3(int[][] edges){ // node 자료구조 ver
        Map<Integer, Integer> nextNodeMap = new HashMap<>();
//        Map<Integer, Integer> preNodeMap = new HashMap<>(); // 순환안되는 '막대연산'을 위해 역추적 용
        ArrayList<int[]> duplicatedEdges = new ArrayList<>();
        boolean[] usedNode = new boolean[1000001]; // node 사용 여부, default 는 false

        int[] answer = new int[4];
//        int constructNode;

        //////////////// edges 연산
        for (int[] edge:edges){

            // case0: 셀프도넛모양, 미리 처리 >> answer[1], usedNode;
            if(edge[0] == edge[1]){
                nextNodeMap.put(edge[0],edge[1]);
                // 도넛완성
                answer[1]++;
                usedNode[edge[0]] = true;

                continue;
            }

            // case1: if not(nextNodeMap.containsKey()) -> 정상할당(new)
            if(!nextNodeMap.containsKey(edge[0])){
                nextNodeMap.put(edge[0],edge[1]);
                int startNode = edge[0];
                int endNode = edge[1];
                int nextNode = edge[1];
                // case1.1 : if(고리연산), 도넛모양완성 -> answer[1], usedNode
                while(nextNodeMap.get(nextNode) != null){
                    nextNode = nextNodeMap.get(nextNode); // nullPointException 가능 -> while 문에서 연산
                    if(nextNode == startNode){
                        // 도넛완성
                        answer[1]++;
                        // userNode 할당
                        usedNode[startNode] = true;
                        nextNode = endNode;
                        while(nextNode != startNode){
                            usedNode[nextNode] = true;
                            nextNode = nextNodeMap.get(nextNode);
                        }
                        break;
                    }
                    else if(nextNode == endNode){
                        // 헛바퀴
                        break;
                    }
                }
            }
            else { // case2: else(case1) key 존재시 duplicatedEdges 에 할당 (생성노드 or 8자모양)
                duplicatedEdges.add(edge);
            }

        }

        ArrayList<Integer> constructNodeList = new ArrayList<>();
        ///////////////// duplicatedEdges 연산
        for(int[] edge:duplicatedEdges){ // 생성노드 or 8자노드중심

            int startNode = edge[0];
            int endNode = edge[1];
            int nextNode = edge[1];
            boolean isConstructor = true;
            ArrayList<Integer> fakeCircle = new ArrayList<>();
            // edge '시작'하는(생성 Node 와 구분) 고리 만들어질 경우, 8자 모양 -> answer[1], answer[3], usedNode
            while(nextNodeMap.get(nextNode) != null){
                nextNode = nextNodeMap.get(nextNode);
                if(nextNode == startNode){
                    // 8자 완성
                    answer[1]--;
                    answer[3]++;
                    // usedNode 할당
                    usedNode[startNode] = true;
                    nextNode = endNode;
                    while(nextNode != startNode){
                        usedNode[nextNode] = true;
                        nextNode = nextNodeMap.get(nextNode);
                    }
                    isConstructor = false;
                    break;
                }
                else if(fakeCircle.contains(nextNode)){
                    // 헛바퀴 - 생성노드
                    break;
                }
                fakeCircle.add(nextNode);

            }

            if(isConstructor){
//                constructNodeList.add(edge[0]);
                answer[0] = edge[0];
            }

            // 생성자 출발 막대노드 >> answer[2]
            if(nextNodeMap.get(nextNode) == null){
                answer[2]++; // 마지막 연산이므로 갯수만 세면 ok
                nextNode = edge[1];
                usedNode[nextNode] = true;
                while(nextNodeMap.get(nextNode) != null){
                    nextNode = nextNodeMap.get(nextNode);
                    usedNode[nextNode] = true;
                }

            }
        }

        // duplicatedEdge 반복문 연산 완료 후 끝까지 남아있는 값이 생성노드 -> answer[0]
//        System.out.println("생성노드 확인 -> " + constructNodeList);
//        System.out.println("당연히 다 같겠지? 아님 곤란빤스");
//        System.out.println();

//        answer[0] = constructNodeList.get(0);


        // nextNodeMap 를 순회하면서 사용되지 않은 노드 if(!usedNode)이면 막대 모양 연산 -> answer[2];
        for(int i:nextNodeMap.keySet()){
            if(usedNode[i]) {
                System.out.println(i + "노드는 사용됨");
            }
            else if(i == answer[0]){
                System.out.println(i + "노드는 생성노드");
                // 생성노드에서 막대 check - duplicatedEdges 에서 확인 (예제 2 참조)
            }
            else {
                System.out.println(i + "노드는 사용안됨");
                // 막대 연산 start (예제 1 참조)
                boolean isNewBar = true;
                int nextNode = i;
                usedNode[nextNode] = true;
//                System.out.println("막대연산");
                while(nextNodeMap.get(nextNode) != null){
                    nextNode = nextNodeMap.get(nextNode);
                    if(usedNode[nextNode]) isNewBar = false;
                    else usedNode[nextNode] = true;
                }

                if(isNewBar) answer[2]++;


            }
        }

        System.out.println("answer 출력확인 >> " + answer[0] + ", "+ answer[1] + ", "+ answer[2] + ", "+ answer[3]);
        return answer;
    }

    static int[] answer;
    static int[] nodes;
    static int nextNode;

    public static boolean circle(int start){
        nextNode = start;
        ArrayList<Integer> circlePrint = new ArrayList<>(); // 출력용
        circlePrint.add(start); // 출력용

        while(true){
            nextNode = nodes[nextNode];
            circlePrint.add(nextNode); // 출력용
            if(nextNode==0){
                return false;
            }
            else if(nextNode == start){
                // 고리-도넛 완성
//                answer[1]++;
                // 출력
                System.out.println("도넛 출력 >> " + circlePrint);
                // nodesFinished 연산 추가
                while(nodesNotFinished[nextNode]){
                    nodesNotFinished[nextNode] = false;
                    nextNode = nodes[nextNode];
                }

                return true;
                // nodes 초기화 X, duplicatedNode 연산에서 나머지 처리
            }
        }
    }

    public static boolean circle(int start, int target){
        nextNode = start;
        ArrayList<Integer> circleFlag = new ArrayList<>(); // 고리 확인용
        circleFlag.add(target);
        circleFlag.add(start);
        ArrayList<Integer> circlePrint = new ArrayList<>(); // 출력용
        circlePrint.add(target); // 출력용
        circlePrint.add(start); // 출력용

//        System.out.println("target = " + target);

        while(true){
            nextNode = nodes[nextNode];
            if(nextNode==0)
                return false;
            else if(nextNode == target){
                // 고리-도넛 완성
                circlePrint.add(nextNode);
                System.out.println("도넛 출력 >> " + circlePrint); // 출력용
                return true;
            }
            if(circleFlag.contains(nextNode)){ // 예외처리
                return false;
            }
            else circleFlag.add(nextNode);
            circlePrint.add(nextNode); // 출력용
        }
    }

    public static int[] solution1(int[][] edges){ // int[1000000] 사이즈에 다음 노드 표현
        answer = new int[4]; // // 생성정점, 도넛 그래프의 수, 막대 그래프 수, 8자 그래프 수
        nodes = new int[1000001]; // nodes[i]=j
        ArrayList<int[]> duplicatedEdges = new ArrayList<int[]>(); // 중복된 노드
        ArrayList<int[]> duplicatedEdgesRemain = new ArrayList<int[]>(); // 남은 중복된 노드


        // 1. edge 를 nodes 에 할당, 고리연산-도넛 >> nodes, duplicatedEdges, answer[1]
        for(int[] edge:edges){
            if(nodes[edge[0]] != 0)
                duplicatedEdges.add(edge);
            else
            {
                nodes[edge[0]] = edge[1]; // 할당
                // 순환 고리 연산 >> answer[1]
                if(circle(edge[0]))
                    answer[1]++;


            }
        }

        // 2. duplicatedEdges 를 다시 nodes 에 할당, 고리연산-8자 >> duplicatedEdgesRemain, answer[1], answer[3]
        for(int[] edge:duplicatedEdges){
            // 순환 고리 연산
            if(circle(edge[1], edge[0])){ // 8자고리인지, 생성노드 인지 구분 필요
                answer[1]--; // 도넛 고리 2개로
                answer[3]++; // 8자 고리 만듬
            }
            else {
                duplicatedEdgesRemain.add(edge);
            }
        }

//        System.out.println("duplicatedEdgesRemain = " + duplicatedEdgesRemain);
        // 3. 생성노드 찾기, duplicatedEdges 에서 이미 연결된 고리(nodes[edge[1]])로 이어지면 생성노드! > answer[0]
//        int firstNode = -1;
        for(int[] edge:duplicatedEdges){
            if(nodes[edge[1]] != 0){
//                firstNode = edge[0];
                answer[0] = edge[0];
                break;
            }
        }
//        System.out.println("생성노드 = " + firstNode);
//        System.out.println("duplicatedEdgesRemain = " + duplicatedEdgesRemain);
        System.out.println(duplicatedEdgesRemain.get(0)[0] + ", " + duplicatedEdgesRemain.get(0)[1]);
        // 예제 1번의 [4,3] 막대를 못잡는다 >> 1. 에서 할당한 nodes 값이 사용됬는지 확인여부 flag 필요!

        ArrayList<ArrayList<Integer>> barGraphs = new ArrayList<>();
        ArrayList<Integer> newBar;
        boolean newFlag;
        // 4. 남은 duplicatedEdgesRemain 에서 막대 찾기>> answer[2]
        for(int[] edge:duplicatedEdgesRemain){
            if(edge[0]==answer[0] && nodes[edge[1]]!=0) continue; // 생성노드 무시 (연산에서 제끼기)
            newFlag = true;

            for(ArrayList<Integer> bar:barGraphs){
                if(bar.contains(edge[0])){
                    bar.add(edge[1]);
                    newFlag = false;
                    break;
                } else if (bar.contains(edge[1])) {
                    bar.add(edge[0]);
                    newFlag = false;
                    break;
                }
            }

            if(newFlag){
                newBar = new ArrayList<>();
                newBar.add(edge[0]);
                newBar.add(edge[1]);
                barGraphs.add(newBar);
            }

        }
        answer[2] = barGraphs.size();
        System.out.println("barGraphs = " + barGraphs);


        System.out.println();
        System.out.println("답 출력!");
        System.out.println("생성 노드 = " + answer[0]);
        System.out.println("도넛 갯수 = " + answer[1]);
        System.out.println("막대 갯수 = " + answer[2]);
        System.out.println("8자 갯수 = " + answer[3]);
        return null;
    }

    static boolean[] nodesNotFinished;
    public static int[] solution2(int[][] edges){ // int[1000000] 사이즈에 다음 노드 표현
        answer = new int[4]; // // 생성정점, 도넛 그래프의 수, 막대 그래프 수, 8자 그래프 수
        nodes = new int[1000001]; // nodes[i]=j
        nodesNotFinished = new boolean[1000001]; // true 이면 연산 미완료 상태
        ArrayList<int[]> duplicatedEdges = new ArrayList<int[]>(); // 중복된 노드
        ArrayList<int[]> duplicatedEdgesRemain = new ArrayList<int[]>(); // 남은 중복된 노드


        // 1. edge 를 nodes 에 할당, 고리연산-도넛 >> nodes, duplicatedEdges, answer[1]
        for(int[] edge:edges){

            if(nodes[edge[0]] != 0)
                duplicatedEdges.add(edge);
            else
            {
                nodes[edge[0]] = edge[1]; // 할당
                nodesNotFinished[edge[0]] = true;
                // 순환 고리 연산 >> answer[1]
                if(circle(edge[0]))
                    answer[1]++;


            }
        }

        // 2. duplicatedEdges 를 다시 nodes 에 할당, 고리연산-8자 >> duplicatedEdgesRemain, answer[1], answer[3]
        for(int[] edge:duplicatedEdges){
            // 순환 고리 연산
            if(circle(edge[1], edge[0])){ // 8자고리인지, 생성노드 인지 구분 필요
                answer[1]--; // 도넛 고리 2개로
                answer[3]++; // 8자 고리 만듬
            }
            else {
                duplicatedEdgesRemain.add(edge);
            }
        }

//        System.out.println("duplicatedEdgesRemain = " + duplicatedEdgesRemain);
        // 3. 생성노드 찾기, duplicatedEdges 에서 이미 연결된 고리(nodes[edge[1]])로 이어지면 생성노드! > answer[0]
//        int firstNode = -1;
        for(int[] edge:duplicatedEdges){
            if(nodes[edge[1]] != 0){
//                firstNode = edge[0];
                answer[0] = edge[0];
                break;
            }
        }
//        System.out.println("생성노드 = " + firstNode);
//        System.out.println("duplicatedEdgesRemain = " + duplicatedEdgesRemain);
        System.out.println(duplicatedEdgesRemain.get(0)[0] + ", " + duplicatedEdgesRemain.get(0)[1]);
        // 예제 1번의 [4,3] 막대를 못잡는다 >> 1. 에서 할당한 nodes 값이 사용됬는지 확인여부 flag 필요!

        ArrayList<ArrayList<Integer>> barGraphs = new ArrayList<>();
        ArrayList<Integer> newBar;
        boolean newFlag;
        // 4. 남은 duplicatedEdgesRemain 에서 막대 찾기>> answer[2]
        // nodesFinished 값이 false 인 nodes 값 연산 필요
        // 수정 필요!! >> 막대가 따로따로 구성될 경우 여러개로 쪼개질 수 있다.
        for(int[] edge:duplicatedEdgesRemain){

            if(edge[0]==answer[0] && nodes[edge[1]]!=0) continue; // 생성노드 무시 (연산에서 제끼기)
            newFlag = true;

            for(ArrayList<Integer> bar:barGraphs){
                if(edge[1] == bar.get(0)) {
                    bar.add(0,edge[0]); // bar 앞에 추가
                    newFlag = false;
                    break;
                }
                else if(bar.getLast() == edge[0]){
                    bar.add(edge[1]); // bar 뒤에 추가
                    newFlag = false;
                    break;
                }
            }

            if(newFlag){
                newBar = new ArrayList<>();
                newBar.add(edge[0]);
                newBar.add(edge[1]);
                barGraphs.add(newBar);
            }

        }

        int[] edge;
        // nodeFinished 값 false 인 nodes 추가
        for (int i = 0; i < nodesNotFinished.length; i++) {
            if(nodesNotFinished[i]){
                System.out.println(i+"인덱스 미완료 상태 -> 추가 연산");
                edge = new int[]{i, nodes[i]};

                if(edge[0]==answer[0] && nodes[edge[1]]!=0) continue; // 생성노드 무시 (연산에서 제끼기)
                newFlag = true;

                for(ArrayList<Integer> bar:barGraphs){
                    if(edge[1] == bar.get(0)) {
                        bar.add(0,edge[0]); // bar 앞에 추가
                        newFlag = false;
                        break;
                    }
                    else if(bar.getLast() == edge[0]){
                        bar.add(edge[1]); // bar 뒤에 추가
                        newFlag = false;
                        break;
                    }
                }

                if(newFlag){
                    newBar = new ArrayList<>();
                    newBar.add(edge[0]);
                    newBar.add(edge[1]);
                    barGraphs.add(newBar);
                }
            }
        }

        // 막대기 이어지는 것 겹치기 or 생성노드 연결은 제외


        answer[2] = barGraphs.size();
        System.out.println("barGraphs = " + barGraphs);


        System.out.println();
        System.out.println("답 출력!");
        System.out.println("생성 노드 = " + answer[0]);
        System.out.println("도넛 갯수 = " + answer[1]);
        System.out.println("막대 갯수 = " + answer[2]);
        System.out.println("8자 갯수 = " + answer[3]);
        return null;
    } // 미완성 >> 시간초과


}
