package com.likou;

public class DivideSolution_5_8 {
    public static void main(String[] args) {
        System.out.println(new DivideSolution_5_8().divide(2147483647, 2));
        System.out.println(new DivideSolution_5_8().divide2(2147483647, 2));
//        System.out.println(new DivideSolution_5_8().quickAdd2(2, 5, 2));
//        System.out.println(new DivideSolution_5_8().quickAdd(-2, 5, -2));

    }

    public int divide(int dividend, int divisor) {

        //被除数最小的时候
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            else if (divisor == -1) return Integer.MAX_VALUE;

        }
        // 除数最小
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        //除数为0
        if (divisor == 0) return 0;


        // 二分法查找
        // 将 res  设置 负数

        boolean flag = true;
        if (dividend < 0) {
            dividend = -dividend;
            flag = false;
        }
        if (divisor < 0) {
            divisor = -divisor;
            flag = !flag;
        }
        int left = 0, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean b = quickAdd2(divisor, mid, dividend);
            if (b) {
                ans = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return flag ? ans : -ans;
    }


    private boolean quickAdd2(int a, int b, int c) {
        int result = 0, add = b;
        while (a != 0) {
            if ((a & 1) != 0) {
                if (result  > c-add) {
                    return false;
                }
                result += add;
            }
            if (a != 1) {
                if (add  > c-add) {
                    return false;
                }
                add += add;
            }
            a >>= 1;
        }
        return true;
    }


    public int divide2(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }

}
