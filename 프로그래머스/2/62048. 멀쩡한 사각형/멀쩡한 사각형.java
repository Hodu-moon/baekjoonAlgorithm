/**
 * 멀쩡한 사각형 클래스
 *
 * @author RWB
 * @since 2021.12.26 Sun 22:31:31
 */
class Solution
{
	/**
	 * 해답 반환 메서드
	 *
	 * @param w: [int] 가로 길이
	 * @param h: [int] 세로 길이
	 *
	 * @return [int] 해답
	 */
	public long solution(int w, int h)
	{
		long ref = gcd(w, h);
		
		return ((long) w * h) - (((w / ref) + (h / ref) - 1) * ref);
	}
	
	/**
	 * 유클리드 호제법 연산결과 반환 메서드
	 *
	 * @param n: [int] 정수 1
	 * @param m: [int] 정수 2
	 *
	 * @return [int] 최대공약수
	 */
	private int gcd(int n, int m)
	{
		while (m != 0)
		{
			int r = n % m;
			
			n = m;
			m = r;
		}
		
		return n;
	}
}