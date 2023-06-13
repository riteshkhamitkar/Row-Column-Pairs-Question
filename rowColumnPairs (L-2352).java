class Solution {
  class Node {
    Map<Integer, Node> next = new HashMap<>();
    int cnt;
  }

  public int equalPairs(int[][] grid) {
    int n = grid.length, ans = 0;
    Node root = new Node();

    for (var row : grid) {
      Node ptr = root;

      for (var val : row) {
        if (ptr.next.containsKey(val))
          ptr = ptr.next.get(val);
        else {
          Node newNode = new Node();
          ptr.next.put(val, newNode);
          ptr = newNode;
        }
      }
      ptr.cnt++;
    }
    for (var i=0; i<n; i++) {
      Node ptr = root;

      for (var j=0; j<n; j++) {
        if (ptr.next.containsKey(grid[j][i]))
          ptr = ptr.next.get(grid[j][i]);
        else break;
      }
      ans += ptr.cnt;
    }
    return ans;
  }
}
