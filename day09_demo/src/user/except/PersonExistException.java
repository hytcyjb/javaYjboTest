package user.except;
/**
 * ���˺��Ѿ�����
 * @date 2017��12��14��15:11:54
 * @author yjbo 
 */
@SuppressWarnings("serial")
public class PersonExistException extends Exception {
	
	
	public PersonExistException(String str){
		  try {
			throw new Exception(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
