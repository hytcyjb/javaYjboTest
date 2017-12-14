package user.except;
/**
 * 该账号已经存在
 * @date 2017年12月14日15:11:54
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
