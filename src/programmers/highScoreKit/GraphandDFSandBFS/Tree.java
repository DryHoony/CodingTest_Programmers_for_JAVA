package programmers.highScoreKit.GraphandDFSandBFS;

public class Tree { // 트리 구조
    int count;

    public Tree(){
        count = 0;
    }

    public class Node {
        Object data;
        Node left;
        Node right;

        // 생성 시 매개변수를 받아 초기화 하는 방법으로만 선언 가능
        public Node(Object data){
            this.data = data;
            left = null;
            right = null;
        }

        public void addLeft(Node node){
            left = node;
            count++;
        }

        public void addRight(Node node){
            right = node;
            count++;
        }

        public void deleteLeft() {
            left = null;
            count--;
        }

        public void deleteRight() {
            right = null;
            count--;
        }
    }

    public Node addNode(Object data){
        Node n = new Node(data);
        return n;
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.data + " ");
        // 재귀 탐색
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }


    public static void main(String[] args) {
        // 트리 생성
        Tree tree = new Tree();

        // 노드 생성
        Node node1 = tree.addNode(1);
        Node node2 = tree.addNode(2);
        Node node3 = tree.addNode(3);
        Node node4 = tree.addNode(4);
        Node node5 = tree.addNode(5);
        Node node6 = tree.addNode(6);
        Node node7 = tree.addNode(7);

        // 트리 연결관계 생성
//           1
//          2  3
//         4 5 6 7
        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);
        node3.addRight(node7);


        // 출력
        System.out.print("전위 순회 >> ");
        tree.preOrder(node1);
        System.out.println();
        System.out.print("중위 순회 >> ");
        tree.inOrder(node1);
        System.out.println();
        System.out.print("후위 순회 >> ");
        tree.postOrder(node1);
        System.out.println();



    }
}
