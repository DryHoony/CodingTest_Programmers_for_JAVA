package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.HashMap;
import java.util.Map;

public class ItemPickUp { // 아이템 줍기
    // 합쳐진 다각형에서 테두리로만 이동하므로, 시계방향 or 반시계 방향 밖에 없음
    // 경로를 어떻게 구상하냐,,,,내부 외부 구분필요
    // 구현도 못했다,,너무 복잡,,,다시

    static class Node{
//        int[] index;
        Node adj1;
        Node adj2;
        boolean visited;

        public Node() {
            adj1 = null;
            adj2 = null;
            visited = false;
        }

        //        public Node(int[] index) {
//            this.index = index;
//        }
//
//        public int[] getIndex() {
//            return index;
//        }

        public Node getAdj1() {
            return adj1;
        }

        public void setAdj1(Node adj1) {
            this.adj1 = adj1;
        }

        public Node getAdj2() {
            return adj2;
        }

        public void setAdj2(Node adj2) {
            this.adj2 = adj2;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}; // 지형, 값은 1~50
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        // character >> item 최단거리 return

        Map<int[], Node> nodeMap = new HashMap<>();
        Node node;
        Node preNode;


        for(int[] rec:rectangle){
            int a = rec[0]; // 가로
            int A = rec[2];
            int b = rec[1]; // 세로
            int B = rec[3];

            // 꼭지점 노드 미리 생성
            node = new Node();
//            if(isNotInside(rectangle, new int[] {a,b})) nodeMap.put(new int[] {a,b}, node);
//            if(isNotInside(rectangle, new int[] {a,B})) nodeMap.put(new int[] {a,B}, node);
//            if(isNotInside(rectangle, new int[] {A,b})) nodeMap.put(new int[] {A,b}, node);
//            if(isNotInside(rectangle, new int[] {A,B})) nodeMap.put(new int[] {A,B}, node);

            // 임시출력
            if(isNotInside(rectangle, new int[] {a,b})){
                nodeMap.put(new int[] {a,b}, node);
                System.out.println("꼭지점 노드 "+ a+" "+b);
            }
            if(isNotInside(rectangle, new int[] {a,B})){
                nodeMap.put(new int[] {a,B}, node);
                System.out.println("꼭지점 노드 "+ a+" "+B);
            }
            if(isNotInside(rectangle, new int[] {A,b})){
                nodeMap.put(new int[] {A,b}, node);
                System.out.println("꼭지점 노드 "+ A+" "+b);
            }
            if(isNotInside(rectangle, new int[] {A,B})){
                nodeMap.put(new int[] {A,B}, node);
                System.out.println("꼭지점 노드 "+ A+" "+B);
            }

            // 이동가능한 노드할당 연산
            for (int i = a+1; i <= A; i++) { // 가로

                if(isNotInside(rectangle, new int[] {i,b})){ //가로 아래

                    node = nodeMap.get(new int[] {i,b}); // 있으면 호출
                    if (node == null) node = new Node(); // 없으면 노드생성
                    System.out.println("노드 가로 >> "+ i +" "+b);

                    // 간선 생성
                    preNode = nodeMap.get(new int[] {i-1,b}); // 범위 벗어남 주의
                    if(preNode != null){ // 이전 노드가 있으면 연결
                        System.out.println("간선존재 - 이전 노드 "+ (i-1)+" "+b);
                        if(node.getAdj1() == null){
                            node.setAdj1(preNode);
                        }else node.setAdj2(preNode);

                        if(preNode.getAdj1() == null){
                            preNode.setAdj1(node);
                        }else preNode.setAdj2(node);
                    }
                    // map에 추가
                    nodeMap.put(new int[] {i,b}, node);

                }

                if(isNotInside(rectangle, new int[] {i,B})){ // 가로 위
                    node = nodeMap.get(new int[] {i,B}); // 있으면 호출
                    if (node == null) node = new Node(); // 없으면 노드생성
                    System.out.println("노드 가로 >> "+ i +" "+B);

                    // 간선 생성
                    preNode = nodeMap.get(new int[] {i-1,B});
                    if(preNode != null){ // 이전 노드가 있으면 연결
                        System.out.println("간선존재 - 이전 노드 "+ (i-1)+" "+B);
                        if(node.getAdj1() == null){
                            node.setAdj1(preNode);
                        }else node.setAdj2(preNode);

                        if(preNode.getAdj1() == null){
                            preNode.setAdj1(node);
                        }else preNode.setAdj2(node);
                    }

                    // map에 추가
                    nodeMap.put(new int[] {i,B}, node);
                }

            }

            for (int j = b+1; j <= B; j++) { // 세로

                if(isNotInside(rectangle, new int[] {a,j})){ // 세로 왼

                    node = nodeMap.get(new int[] {a,j}); // 있으면 호출
                    if (node == null) node = new Node(); // 없으면 노드생성
                    System.out.println("노드 세로 >> "+ a +" "+j);

                    // 간선 생성
                    preNode = nodeMap.get(new int[] {a,j-1});
                    if(preNode != null){ // 이전 노드가 있으면 연결
                        System.out.println("간선존재 - 이전 노드 "+ a+" "+(j-1));
                        if(node.getAdj1() == null){
                            node.setAdj1(preNode);
                        }else node.setAdj2(preNode);

                        if(preNode.getAdj1() == null){
                            preNode.setAdj1(node); // 인접1
                        }else preNode.setAdj2(node); // 인접2
                    }

                    // map에 추가
                    nodeMap.put(new int[] {a,j}, node);
                }

                if(isNotInside(rectangle, new int[] {A,j})){ // 세로 오
                    node = nodeMap.get(new int[] {A,j}); // 있으면 호출
                    if (node == null) node = new Node(); // 없으면 노드생성
                    System.out.println("노드 세로 >> "+ A +" "+j);


                    // 간선 생성
                    preNode = nodeMap.get(new int[] {A,j-1});
                    if(preNode != null){ // 이전 노드가 있으면 연결
                        System.out.println("간선존재 - 이전 노드 "+ A+" "+(j-1));
                        if(node.getAdj1() == null){
                            node.setAdj1(preNode);
                        }else node.setAdj2(preNode);

                        if(preNode.getAdj1() == null){
                            preNode.setAdj1(node);
                        }else preNode.setAdj2(node);
                    }

                    // map에 추가
                    nodeMap.put(new int[] {A,j}, node);
                }

            }

        }


//        System.out.println("노드는 몇개일까? >> "+ nodeMap.size());
//        for(int[] key:nodeMap.keySet()){
//            System.out.println(key[0] + " " + key[1]);
//        }

//        System.out.println("답은 >> 아직,,");
    }

    public static boolean isNotInside(int[][] rectangle, int [] node){
        for(int[] rec:rectangle){
            if(rec[0] < node[0] && node[0] < rec[2] &&
            rec[1] < node[1] && node[1] < rec[3])
                return false;
        }

        return true;
    }
}
