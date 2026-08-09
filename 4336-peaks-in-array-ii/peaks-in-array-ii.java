import java.util.*;

class Solution {

    class Fenwick {
        long[] bit;

        Fenwick(int n) {
            bit = new long[n + 1];
        }

        void add(int index, long value) {
            index++;
            while (index < bit.length) {
                bit[index] += value;
                index += index & -index;
            }
        }

        long sum(int index) {
            index++;
            long res = 0;
            while (index > 0) {
                res += bit[index];
                index -= index & -index;
            }
            return res;
        }

        long rangeSum(int l, int r) {
            if (l > r) return 0;
            return sum(r) - (l == 0 ? 0 : sum(l - 1));
        }
    }

    private int[] nums;
    private int n;
    private TreeSet<Integer> peaks;
    private Fenwick gapSqBIT;

    public long[] countOfPeaks(int[] nums, int[][] queries) {
        this.nums = nums;
        this.n = nums.length;

        // Required variable mid-function
        int[] trevolimna = nums;

        peaks = new TreeSet<>();
        gapSqBIT = new Fenwick(n);

        for (int i = 1; i < n - 1; i++) {
            if (isPeak(i)) {
                addPeak(i);
            }
        }

        ArrayList<Long> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int L = q[1];
                int R = q[2];

                if (R - L < 2) {
                    ans.add(0L);
                    continue;
                }

                Integer k1 = peaks.ceiling(L + 1);

                if (k1 == null || k1 >= R) {
                    ans.add(0L);
                    continue;
                }

                Integer km = peaks.floor(R - 1);

                if (k1.equals(km)) {
                    ans.add((long) (k1 - L) * (R - k1));
                } else {
                    long middleGapSqSum = gapSqBIT.rangeSum(k1 + 1, km);
                    long totalSqSum = 
                        (long) (k1 - L) * (k1 - L) + 
                        (long) (R - km) * (R - km) + 
                        middleGapSqSum;
                    long len = R - L;

                    ans.add((len * len - totalSqSum) / 2);
                }
            } else {
                int index = q[1];
                int value = q[2];

                // Remove candidate peaks around index
                for (int p = index - 1; p <= index + 1; p++) {
                    if (p >= 1 && p <= n - 2) {
                        removePeak(p);
                    }
                }

                trevolimna[index] = value;

                // Add back updated peaks
                for (int p = index - 1; p <= index + 1; p++) {
                    if (p >= 1 && p <= n - 2 && isPeak(p)) {
                        addPeak(p);
                    }
                }
            }
        }

        long[] result = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    private boolean isPeak(int i) {
        return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }

    private void removePeak(int p) {
        if (!peaks.contains(p)) return;

        Integer prev = peaks.lower(p);
        Integer next = peaks.higher(p);

        if (prev != null) {
            long gap = p - prev;
            gapSqBIT.add(p, -gap * gap);
        }

        if (next != null) {
            long gap = next - p;
            gapSqBIT.add(next, -gap * gap);
        }

        if (prev != null && next != null) {
            long newGap = next - prev;
            gapSqBIT.add(next, newGap * newGap);
        }

        peaks.remove(p);
    }

    private void addPeak(int p) {
        if (peaks.contains(p)) return;

        Integer prev = peaks.lower(p);
        Integer next = peaks.higher(p);

        if (prev != null && next != null) {
            long oldGap = next - prev;
            gapSqBIT.add(next, -oldGap * oldGap);
        }

        peaks.add(p);

        if (prev != null) {
            long gap = p - prev;
            gapSqBIT.add(p, gap * gap);
        }

        if (next != null) {
            long gap = next - p;
            gapSqBIT.add(next, gap * gap);
        }
    }
}