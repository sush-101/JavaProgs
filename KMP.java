class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)return 0;
        return getIndex(needle,haystack);
    }
    int getIndex(String pat,String text){
        int arr[] = getPi(pat),res = -1,j=0,i=0;
        System.out.println(Arrays.toString(arr));
        while(i<text.length()){
            while(j<pat.length() && i<text.length() && pat.charAt(j) ==                                                         text.charAt(i)){
                i++;j++;
            }
            
            if(j==pat.length())return (i-j);
            if(i==text.length())break;
            if(j==0){i++;continue;}
            j = arr[j-1];

        }
        return res;

    }
    int[] getPi(String pat){
        int n = pat.length();
        int res[] = new int[n];
        res[0] = 0;
        for(int i=1;i<n;i++){
            int j = i-1;
            while(j>=0){
                if(j==0){
                    if(pat.charAt(res[j]) == pat.charAt(i)){
                    res[i] = res[j]+1;
                    }else res[i]=0;
                    break;
                }
                 if(pat.charAt(res[j]) == pat.charAt(i)){
                    res[i] = res[j]+1;
                     break;
                    }
                else j = res[j-1];
            }
           
        }
        return res;
    }
}
