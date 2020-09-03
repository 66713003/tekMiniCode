package tek;

import org.junit.Test;

/**
 * @Auther: Jim
 * @Date: 2020/9/2 - 09 - 02 - 23:46
 * @Description: tek
 * @version: 1.0
 */
public class TestTekMiniCode {
    /**
     * 测试两个数的数组
     */
    @Test
    public void TestTek(){
        TekMiniCode.processData(new int []{2,3});
    }

    /**
     * 测试单个数的组合
     */
    @Test
    public void TestOne(){
        TekMiniCode.processData(new int []{9});
    }

    /**
     * 测试两个数的数组，其中一个数小于10，另一个大于10的组合
     */
    @Test
    public void TestSec(){
        TekMiniCode.processData(new int []{4,35});
    }

    /**
     * 测试包含0或1的数组
     */
    @Test
    public void TestThree(){
        //含0数组
        TekMiniCode.processData(new int []{0,3});
        //含1数组
        TekMiniCode.processData(new int []{1,5});
    }

    /**
     * 测试多位数的数组
     */
    @Test
    public void TestFour(){
        //含3个数的数组
        TekMiniCode.processData(new int []{0,3,7});
        //含4个数的数组,且其中有大于10的数
        TekMiniCode.processData(new int []{0,3,8,34});
        //含4个数的数组,且其中有多个大于10的数
        TekMiniCode.processData(new int []{0,29,8,34});
    }
}
