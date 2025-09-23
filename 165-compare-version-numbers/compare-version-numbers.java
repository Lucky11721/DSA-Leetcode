class Solution {
    public int compareVersion(String version1, String version2) {


        String[] ch1 = version1.split("\\.");
        String[] ch2 =version2.split("\\.");

        System.out.println(Arrays.toString(ch1));
          System.out.println(Arrays.toString(ch2));
        int i = 0;
        int j = 0;

        while(i < ch1.length && j < ch2.length ){
            int v1 = Integer.parseInt(ch1[i]);
            int v2 = Integer.parseInt(ch2[j]);
            System.out.println(v1);
            System.out.println(v2);

            if(v1 > v2){
                return 1;
            }
            else if(v1 < v2){
                return -1;
            }

            i++;
            j++;


        }
        if(i == ch1.length && j < ch2.length){
            while(j < ch2.length){
                int v2 = Integer.parseInt(ch2[j]);

                if(v2 > 0) return -1;

                j++;
            }
        }
           if(j == ch2.length && i < ch1.length){
            while(i < ch1.length){
               int v1 = Integer.parseInt(ch1[i]);
               if(v1 > 0) return 1;
               i++;
            }
        }


        return 0;

    
    }
}