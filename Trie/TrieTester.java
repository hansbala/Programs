public class TrieTester {
  public static void main(String[] args) {
    String[] allStrings = new String[4];
    allStrings[0] = "abcd";
    allStrings[1] = "abde";
    allStrings[2] = "abce";
    allStrings[3] = "prst";
    Trie trie = new Trie();
    for (String s : allStrings) {
      trie.insert(s);
    }
    trie.delete("prst");
    trie.delete("prst");
    System.out.println(trie.contains("prst"));
  }
}
class Node {
  Node[] nodes;
  int cnt;
  Node() {
    nodes = new Node[26];
    cnt = 0;
  }
}
class Trie {
  Node head;
  Trie() {
    head = new Node();
  }
  public void insert(String str) {
    Node curr = head;
    for (int i = 0; i < str.length(); i++) {
      if (curr.nodes[str.charAt(i) - 'a'] == null) {
        curr.nodes[str.charAt(i) - 'a'] = new Node();
      }
      curr = curr.nodes[str.charAt(i) - 'a'];
    }
    ++curr.cnt;
  }
  public boolean contains(String str) {
    Node curr = head;
    for (int i = 0; i < str.length(); i++) {
      if (curr.nodes[str.charAt(i) - 'a'] == null) {
        return false;
      }
      curr = curr.nodes[str.charAt(i) - 'a'];
    }
    if (curr == null || curr.cnt == 0) {
      return false;
    }
    return true;
  }
  public void delete(String str) {
    Node curr = head;
    for (int i = 0; i < str.length(); i++) {
      if (curr.nodes[str.charAt(i) - 'a'] == null) {
        throw new RuntimeException();
      }
      curr = curr.nodes[str.charAt(i) - 'a'];
    }
    if (curr == null || curr.cnt == 0) {
      throw new RuntimeException();
    }
    --curr.cnt;
  }
  public void update(String oldS, String newS) {
    delete(oldS);
    insert(newS);
  }
}