public class TrieTester2 {
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
    System.out.println(trie.contains("abde"));
    trie.update("abde" , "abxx");
    System.out.println(trie.contains("abde"));
    System.out.println(trie.contains("abxx"));
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
  Node root;
  
  Trie() {
    root = new Node();
  }
  public void insert(String str) {
    Node curr = root;
    for (char c : str.toCharArray()) {
      if (curr.nodes[c - 'a'] == null) {
        curr.nodes[c - 'a'] = new Node();
      }
      curr = curr.nodes[c - 'a'];
    }
    ++curr.cnt;
  }
  public boolean contains(String str) {
    Node curr = root;
    for (char c : str.toCharArray()) {
      if (curr.nodes[c - 'a'] == null) {
        return false;
      }
      curr = curr.nodes[c - 'a'];
    }
    if (curr == null || curr.cnt == 0) {
      return false;
    }
    return true;
  }
  public void delete(String str) {
    Node curr = root;
    for (char c : str.toCharArray()) {
      if (curr.nodes[c - 'a'] == null) {
        throw new RuntimeException("String does not exist");
      }
      curr = curr.nodes[c - 'a'];
    }
    if (curr == null || curr.cnt == 0) {
        throw new RuntimeException("String does not exist");
    }
    --curr.cnt;
  }
  public void update(String oldS, String newS) {
    delete(oldS);
    insert(newS);
  }
}
