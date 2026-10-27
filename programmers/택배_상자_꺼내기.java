package programmers;

public class 택배_상자_꺼내기 {
    public int solution(int n, int w, int num) {
        int numIdx = num - 1;
        int r = numIdx / w;

        int c = (r % 2 == 0) ? (numIdx % w) : (w - 1 - (numIdx % w));

        int maxR = (n - 1) / w;

        int topBox = (maxR % 2 == 0) ? (maxR * w + c + 1) : (maxR * w + (w - 1 - c) + 1);

        return (topBox <= n) ? (maxR - r + 1) : (maxR - r);
    }
}
