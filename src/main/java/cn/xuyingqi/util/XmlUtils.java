package cn.xuyingqi.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * XML工具类
 * 
 * @author XuYQ
 *
 */
public final class XmlUtils {

	/**
	 * 私有构造方法
	 */
	private XmlUtils() {

	}

	/**
	 * JavaBean转XML
	 * 
	 * @param bean
	 *            JavaBean
	 * @param fragment
	 *            是否增加XML头
	 * @param encoding
	 *            XML头编码格式
	 * @param format
	 *            输出是否格式化
	 * @return
	 */
	public static final String bean2Xml(Object bean, boolean fragment, String encoding, boolean format) {

		try {

			JAXBContext context = JAXBContext.newInstance(bean.getClass());

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, fragment);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, format);

			StringWriter sw = new StringWriter();
			marshaller.marshal(bean, sw);

			return sw.toString();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * XML转JavaBean
	 * 
	 * @param xml
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2Bean(String xml, Class<T> clazz) {

		try {

			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			return (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
}