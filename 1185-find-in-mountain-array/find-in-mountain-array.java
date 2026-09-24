/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peak = findpeak(mountainArr,0,n-1);

        int index = increasing(mountainArr,0,peak,target);

        if(index !=-1){
            return index;
        }

        return decreasing(mountainArr,peak+1,n-1,target);
    }

    public int findpeak(MountainArray mountainArr, int left,int right){
        while(left<right){
            int mid = left+(right-left)/2;

            if(mountainArr.get(mid)< mountainArr.get(mid+1)){
                left = mid+1;
            }
            else{
                right = mid;
            }

            
        }
        return left;
    }

    public int increasing(MountainArray mountainArr,int left,int right,int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            int val = mountainArr.get(mid);
            if( val == target){
                return mid;
            }

            else if(val<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return -1;
    }

    public int decreasing(MountainArray mountainArr,int left,int right,int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            int val = mountainArr.get(mid);
            if( val == target){
                return mid;
            }

            else if(val>target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return -1;
    }

}