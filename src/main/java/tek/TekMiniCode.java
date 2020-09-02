package tek;

import java.util.*;

/**
 * @Auther: Jim
 * @Date: 2020/9/2 - 09 - 02 - 20:48
 * @Description: tekMiniTest
 * @version: 1.0
 */
public class TekMiniCode {

    private static Map<Integer,String> getNumMap(){
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(2,"a,b,c");
        map.put(3,"d,e,f");
        map.put(4,"g,h,i");
        map.put(5,"j,k,l");
        map.put(6,"m,n,o");
        map.put(7,"p,q,r,s");
        map.put(8,"t,u,v");
        map.put(9,"w,x,y,z");
        return map;
    }

    public static void processData(int[] arr){
        if(arr!=null&&arr.length>0){
            Map<Integer,String> map=getNumMap();
            String rightStr="";
            arr=arraySplit(arr);
            for(int i=0;i<arr.length;i++){
                rightStr=ergodic(map.get(arr[i]),rightStr);
            }
            System.out.println(rightStr.replaceAll(","," "));
        }
    }

    private static String ergodic(String leftStr,String rightStr){
        String [] leftStrs=leftStr!=null?leftStr.split(","):new String[]{};
        String [] rightStrs=rightStr!=null?rightStr.split(","):new String[]{};
        StringBuilder str=new StringBuilder();
        for(int i=0;i<leftStrs.length;i++){
            for(int j=0;j<rightStrs.length;j++){
                str.append(leftStrs[i]).append(rightStrs[j]).append(",");
            }
        }
        return str.toString();
    }

    private static int [] arraySplit(int [] arr){
        //判断数组是否含有大于9的数，并将大于9的数字拆分
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%10>0){
                if(arr[i]/10>1)list.add(arr[i]/10);
                if(arr[i]%10>1)list.add(arr[i]%10);
            }else{
                if(arr[i]>1)list.add(arr[i]);
            }
        }
        return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::valueOf).toArray();
    }
}
