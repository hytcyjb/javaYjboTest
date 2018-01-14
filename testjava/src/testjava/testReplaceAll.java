package testjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class testReplaceAll {
	@Test
	public void test() {
//		insertCustomer(new Customer("杨建波4", "男", "1992-05-06", "18501481884", "yangjbm@yonyou.com", "看电影,学习", "普通客户",
//				"偶遇同楼的女生遛狗，一次就让人绝望了，这辈子是追不上她了"));
		
		String str = "爱是飒飒<a href=''>你好<h1>北来看看了看你看</h1>京</a>你早飒飒克萨科技";
//		str = str.replaceAll("(&lt;(?i)a[^]*/?&gt;)", "");
//		System.out.println("JDBCUtil.test()"+str);
//		 String regex = "<[a]>.*</[a]>";
//		 String regex = "<[Hh]1>.*</[Hh]1>";
//		 Pattern pattern = Pattern.compile(regex);
//	        Matcher matcher = pattern.matcher(str);
//	        StringBuffer sb1 = new StringBuffer();
//	        while(matcher.find())
//	        {
//	            sb1.append(matcher.replaceAll("")+"\n");
//	           
//	        }
	        System.out.println("==="+delHTMLTag(str));
	        System.out.println("==="+stripHtml(str));
	}
	/**
	* 把html内容转为文本
	* @param html 需要处理的html文本
	* @param filterTags 需要保留的html标签样式
	* @return
	*/
	public static String trimHtml2Txt(String html, String[] filterTags){
	    html = html.replaceAll("\\<head>[\\s\\S]*?</head>(?i)", "");//去掉head
	    html = html.replaceAll("\\<!--[\\s\\S]*?-->", "");//去掉注释
	    html = html.replaceAll("\\<![\\s\\S]*?>", "");
	    html = html.replaceAll("\\<style[^>]*>[\\s\\S]*?</style>(?i)", "");//去掉样式
	    html = html.replaceAll("\\<script[^>]*>[\\s\\S]*?</script>(?i)", "");//去掉js
	    html = html.replaceAll("\\<w:[^>]+>[\\s\\S]*?</w:[^>]+>(?i)", "");//去掉word标签
	    html = html.replaceAll("\\<xml>[\\s\\S]*?</xml>(?i)", "");
	    html = html.replaceAll("\\<html[^>]*>|<body[^>]*>|</html>|</body>(?i)", "");
	    html = html.replaceAll("\\\r\n|\n|\r", " ");//去掉换行
	    html = html.replaceAll("\\<br[^>]*>(?i)", "\n\r");
	    List<String> tags = new ArrayList<String>();
	    List<String> s_tags = new ArrayList<String>();
	    List<String> halfTag = Arrays.asList(new String[]{"img","table","thead","th","tr","td"});//
	    if(filterTags != null && filterTags.length > 0){
	      for (String tag : filterTags) {
	        tags.add("<"+tag+(halfTag.contains(tag)?"":">"));//开始标签
	        if(!"img".equals(tag)) tags.add("</"+tag+">");//结束标签
	        s_tags.add("#REPLACETAG"+tag+(halfTag.contains(tag)?"":"REPLACETAG#"));//尽量替换为复杂一点的标记,以免与显示文本混合,如：文本中包含#td、#table等
	        if(!"img".equals(tag)) s_tags.add("#REPLACETAG/"+tag+"REPLACETAG#");
	      }
	    }
//	    html = StringUtils.replaceEach(html, tags.toArray(new String[tags.size()]), s_tags.toArray(new String[s_tags.size()]));
	    html = html.replaceAll("\\</p>(?i)", "\n\r");
	    html = html.replaceAll("\\<[^>]+>", "");
//	    html = StringUtils.replaceEach(html,s_tags.toArray(new String[s_tags.size()]),tags.toArray(new String[tags.size()]));
	    html = html.replaceAll("\\ ", " ");
	    return html.trim();
	}
	public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    } 
	public static String stripHtml(String content) { 
		// <p>段落替换为换行 
		content = content.replaceAll("<p .*?>", "\r\n"); 
		// <br><br/>替换为换行 
		content = content.replaceAll("<br\\s*/?>", "\r\n"); 
		// 去掉其它的<>之间的东西 
		content = content.replaceAll("\\<.*?>", ""); 
		// 还原HTML 
		// content = HTMLDecoder.decode(content); 
		return content; 
		}
	
}
