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
//		insertCustomer(new Customer("���4", "��", "1992-05-06", "18501481884", "yangjbm@yonyou.com", "����Ӱ,ѧϰ", "��ͨ�ͻ�",
//				"ż��ͬ¥��Ů���޹���һ�ξ����˾����ˣ��Ⱳ����׷��������"));
		
		String str = "������<a href=''>���<h1>���������˿��㿴</h1>��</a>�����쪿����Ƽ�";
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
	* ��html����תΪ�ı�
	* @param html ��Ҫ�����html�ı�
	* @param filterTags ��Ҫ������html��ǩ��ʽ
	* @return
	*/
	public static String trimHtml2Txt(String html, String[] filterTags){
	    html = html.replaceAll("\\<head>[\\s\\S]*?</head>(?i)", "");//ȥ��head
	    html = html.replaceAll("\\<!--[\\s\\S]*?-->", "");//ȥ��ע��
	    html = html.replaceAll("\\<![\\s\\S]*?>", "");
	    html = html.replaceAll("\\<style[^>]*>[\\s\\S]*?</style>(?i)", "");//ȥ����ʽ
	    html = html.replaceAll("\\<script[^>]*>[\\s\\S]*?</script>(?i)", "");//ȥ��js
	    html = html.replaceAll("\\<w:[^>]+>[\\s\\S]*?</w:[^>]+>(?i)", "");//ȥ��word��ǩ
	    html = html.replaceAll("\\<xml>[\\s\\S]*?</xml>(?i)", "");
	    html = html.replaceAll("\\<html[^>]*>|<body[^>]*>|</html>|</body>(?i)", "");
	    html = html.replaceAll("\\\r\n|\n|\r", " ");//ȥ������
	    html = html.replaceAll("\\<br[^>]*>(?i)", "\n\r");
	    List<String> tags = new ArrayList<String>();
	    List<String> s_tags = new ArrayList<String>();
	    List<String> halfTag = Arrays.asList(new String[]{"img","table","thead","th","tr","td"});//
	    if(filterTags != null && filterTags.length > 0){
	      for (String tag : filterTags) {
	        tags.add("<"+tag+(halfTag.contains(tag)?"":">"));//��ʼ��ǩ
	        if(!"img".equals(tag)) tags.add("</"+tag+">");//������ǩ
	        s_tags.add("#REPLACETAG"+tag+(halfTag.contains(tag)?"":"REPLACETAG#"));//�����滻Ϊ����һ��ı��,��������ʾ�ı����,�磺�ı��а���#td��#table��
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
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //����script��������ʽ 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //����style��������ʽ 
        String regEx_html="<[^>]+>"; //����HTML��ǩ��������ʽ 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //����script��ǩ 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //����style��ǩ 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //����html��ǩ 

        return htmlStr.trim(); //�����ı��ַ��� 
    } 
	public static String stripHtml(String content) { 
		// <p>�����滻Ϊ���� 
		content = content.replaceAll("<p .*?>", "\r\n"); 
		// <br><br/>�滻Ϊ���� 
		content = content.replaceAll("<br\\s*/?>", "\r\n"); 
		// ȥ��������<>֮��Ķ��� 
		content = content.replaceAll("\\<.*?>", ""); 
		// ��ԭHTML 
		// content = HTMLDecoder.decode(content); 
		return content; 
		}
	
}
