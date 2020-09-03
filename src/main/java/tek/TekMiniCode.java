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

    private static final Map<Integer,String[]> MAP2 = new HashMap<Integer,String[]>(8);

    static{
        MAP2.put(0,new String[]{});
        MAP2.put(1,new String[]{});
        MAP2.put(2,new String[]{"a","b","c"});
        MAP2.put(3,new String[]{"d","e","f"});
        MAP2.put(4,new String[]{"g","h","i"});
        MAP2.put(5,new String[]{"j","k","l"});
        MAP2.put(6,new String[]{"m","n","o"});
        MAP2.put(7,new String[]{"p","q","r","s"});
        MAP2.put(8,new String[]{"t","u","v"});
        MAP2.put(9,new String[]{"w","x","y","z"});
    }

    public static Map<Integer,String[]> getLettersMap2(){
        return Collections.unmodifiableMap(MAP2);
    }

    public static void processData(int[] arr){
        if( arr != null && arr.length > 0 ){
            Map<Integer,String[]> map = getLettersMap2();
            int len = arr.length;
            String [] rightStr = null;
            for( int i = 0 ; i < arr.length ; i++ ){
                if(arr[i]>9){
                    rightStr = ergodic(map.get(arr[i]/10),rightStr);
                    rightStr = ergodic(map.get(arr[i]%10),rightStr);
                }else{
                    rightStr = ergodic(map.get(arr[i]),rightStr);
                }
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
}
