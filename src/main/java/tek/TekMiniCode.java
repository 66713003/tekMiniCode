package tek;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @Auther: Jim
 * @Date: 2020/9/2 - 09 - 02 - 20:48
 * @Description: tekMiniTest
 * @version: 1.0
 */
public class TekMiniCode {

    private static Map<Integer,String[]> getLettersMap(){
        Map<Integer,String[]> map=new HashMap<Integer,String[]>();
        map.put(2,new String[]{"a","b","c"});
        map.put(3,new String[]{"d","e","f"});
        map.put(4,new String[]{"g","h","i"});
        map.put(5,new String[]{"j","k","l"});
        map.put(6,new String[]{"m","n","o"});
        map.put(7,new String[]{"p","q","r","s"});
        map.put(8,new String[]{"t","u","v"});
        map.put(9,new String[]{"w","x","y","z"});
        return map;
    }

    public static void processData(int[] arr){
        if(arr!=null&&arr.length>0){
            Map<Integer,String[]> map=getLettersMap();
            String [] rightStr=null;
            arr=arraySplit(arr);
            for(int i=0;i<arr.length;i++){
                //递归遍历数组相应，进行字母组合
                rightStr=ergodic(map.get(arr[i]),rightStr);
            }
            System.out.println(StringUtils.join(Arrays.asList(rightStr)," "));
        }
    }

    /**
     * 组合两个数组的数据
     * @param leftStr
     * @param rightStr
     * @return
     */
    private static String [] ergodic(String [] leftStr,String[] rightStr){
        String [] leftStrs=leftStr!=null?leftStr:new String[]{""};
        String [] rightStrs=rightStr!=null?rightStr:new String[]{""};
        StringBuilder str=new StringBuilder();
        for(int i=0;i<leftStrs.length;i++){
            for(int j=0;j<rightStrs.length;j++){
                str.append(rightStrs[j]).append(leftStrs[i]).append(",");
            }
        }
        return str.toString().split(",");
    }

    private static int [] arraySplit(int [] arr){
        //判断数组是否含有大于9的数，并将大于9的数字拆分
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%10>0){
                if(arr[i]/10>1){list.add(arr[i]/10);}
                if(arr[i]%10>1){list.add(arr[i]%10);}
            }else{
                if(arr[i]>1){list.add(arr[i]);}
            }
        }
        return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::valueOf).toArray();
    }
}
