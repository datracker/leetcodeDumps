class Node {
    int count;
    Set<String> keys;
    Node prev;
    Node next;

    public Node(int count) {
        this.count = count;
        this.keys = new HashSet<>();
    }
}

class AllOne {

    private Map<String, Integer> keyCountMap;
    private Map<Integer, Node> countNodeMap;
    private Node head;
    private Node tail;

    /** Initialize your data structure here. */
    public AllOne() {
        keyCountMap = new HashMap<>();
        countNodeMap = new HashMap<>();
        head = new Node(Integer.MIN_VALUE); // Dummy head
        tail = new Node(Integer.MAX_VALUE); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    /** Helper method to add a new node between prevNode and nextNode */
    private void addNode(Node newNode, Node prevNode, Node nextNode) {
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
    }

    /** Helper method to remove a node from the linked list */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        countNodeMap.remove(node.count);
    }

    /** Increments the count of the string key by 1. */
    public void inc(String key) {
        int count = keyCountMap.getOrDefault(key, 0);
        keyCountMap.put(key, count + 1);

        Node currentNode = countNodeMap.get(count);
        Node newNode;

        if (count > 0) {
            currentNode.keys.remove(key);
        }

        if (countNodeMap.containsKey(count + 1)) {
            newNode = countNodeMap.get(count + 1);
        } else {
            newNode = new Node(count + 1);
            countNodeMap.put(count + 1, newNode);
            if (count == 0) {
                // Insert after head
                addNode(newNode, head, head.next);
            } else {
                // Insert after currentNode
                addNode(newNode, currentNode, currentNode.next);
            }
        }
        newNode.keys.add(key);

        if (count > 0 && currentNode.keys.isEmpty()) {
            removeNode(currentNode);
        }
    }

    /** Decrements the count of the string key by 1. */
    public void dec(String key) {
        int count = keyCountMap.get(key);
        Node currentNode = countNodeMap.get(count);
        currentNode.keys.remove(key);

        if (count == 1) {
            keyCountMap.remove(key);
        } else {
            keyCountMap.put(key, count - 1);
            Node newNode;
            if (countNodeMap.containsKey(count - 1)) {
                newNode = countNodeMap.get(count - 1);
            } else {
                newNode = new Node(count - 1);
                countNodeMap.put(count - 1, newNode);
                // Insert before currentNode
                addNode(newNode, currentNode.prev, currentNode);
            }
            newNode.keys.add(key);
        }

        if (currentNode.keys.isEmpty()) {
            removeNode(currentNode);
        }
    }

    /** Returns one of the keys with maximal count. */
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    /** Returns one of the keys with minimum count. */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */