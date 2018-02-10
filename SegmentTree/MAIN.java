import java.util.*;
class MAIN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = {-999, -1, 23, 23, 9, 90, 1};
		SegmentTree st = new SegmentTree(A);
		int val = st.rangeMinQuery(1, 3, 1, 6, 1);
		System.out.println(val);
	}
}
class SegmentTree {
	final int INF = (int)(1e18);
	int[] tree;
	SegmentTree(int[] input) {
		int n = input.length;
		for (; n != 0 && ((n & (n - 1)) == 0); n <<= 1);
		// 1 - indexed tree
		tree = new int[2 * n];
		Arrays.fill(tree, INF);
		constructST(input, 1, input.length, 1);
	}
	public void constructST(int[] input, int lo, int hi, int pos) {
		if (lo == hi) {
			tree[pos] = input[lo];
			return;
		} else if (hi > lo) {
			return;
		}
		int mid = (lo + hi) >> 1;
		constructST(input, lo, mid, pos << 1);
		constructST(input, mid + 1, hi, pos << 1 | 1);
		tree[pos] = Math.min(tree[pos << 1], tree[pos << 1 | 1]);
	}
	public int rangeMinQuery(int qlo, int qhi, int lo, int hi, int pos) {
		if (hi > lo) {
			return INF;
		}
		if (qlo <= lo && qhi >= hi) {
			return tree[pos];
		} else if (qhi < lo || qlo > hi) {
			return INF;
		} else {
			int mid = (lo + hi) >> 1;
			return Math.min(rangeMinQuery(qlo, qhi, lo, mid, pos << 1), rangeMinQuery(qlo, qhi, mid + 1, hi, pos << 1 | 1));
		}
	}
}