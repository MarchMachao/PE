package cn.vito.coding.check.utils;

import java.io.File;
import java.io.FileOutputStream;

import sun.misc.BASE64Decoder;

/**
 * 
 * @author baijw
 * 
 * @date 2017年6月7日 下午9:42:59
 */
@SuppressWarnings("restriction")
public class Base64Utils {

	/**
	 * 保存base64加密的图片
	 * @param str64				加密后的字符串
	 * @param uri				路径
	 * @param fileName			文件名
	 * @throws Exception
	 */
	public static void saveBase64File(String str64,String uri,String fileName) throws Exception{
		FileOutputStream os = new FileOutputStream(new File(uri+fileName));
		byte[] image = decodeBASE64(str64); 
		os.write(image);
		try {
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] decodeBASE64(String str) throws Exception {
		if (str != null) {
			return new BASE64Decoder().decodeBuffer(str);
		}
		return null;
	}
	
}
