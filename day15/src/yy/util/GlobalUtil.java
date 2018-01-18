package yy.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @describe 全局变量 
 * @author yjbo
 * @date 2018年1月7日 下午9:47:03
 */
public class GlobalUtil {

	public static List gHobby = Arrays.asList("唱歌","跳舞","看电影","学习","逛街","演讲"); //使用String[]利用<c:foreach>获取的时候有问题，获取不了，需要石油list形式；
	public static List gKind = Arrays.asList("非客户","普通客户","重要客户"); 
}
