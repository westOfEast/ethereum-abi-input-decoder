import org.apache.commons.lang3.StringUtils;
import util.ABIHexUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NewABIDecoder {
	private List<String> types = new ArrayList<>();
	private List<String> values = new ArrayList<>();
	List<String> processValues = new ArrayList<>();
	private List<String> results;

	public String run(String paramTypes, String paramInput) {
		parseParamTypes(paramTypes);
		parseParamInput(paramInput);
		results = new ArrayList<>();

		decode();

		String result = StringUtils.join(results, ",");
		return result;
	}

	public void decode() {

		int n = types.size();
		for (int i = 0; i < n; i++) {
			String type = types.get(i);
			//动态数组
			if (type.equals("bytes") || type.equals("string") || type.matches("[\\w]+\\[\\]")) {
				parseDynamicArray(i);
			}

//			//动态数组
//			if (type.equals("bytes") || type.equals("string") || type.matches("[\\w]+\\[\\]")) {
//				parseDynamicArray(i);
//				n--;
//				i--;
//			}
//
//			//静态数组
//			else if (type.matches("[\\w]+\\[(\\d)+\\]")) {
//				parseStaticArray(i);
//				i--;
//				n--;
//			}
//
//			//非数组（静态或动态）
//			else if (type.matches("[\\w]+")) {
//				parseStaticType(i);
//				n--;
//				i--;
//			}
//
//			//类型中含有非法符号
//			else {
//				//System.out.println("未知数据类型：" + type);
//				results.clear();
//				return;
//			}
		}
	}

	public void parseDynamicArray(int i) {
		//获取数据位置
		int position = ABIHexUtil.Hex32ToInteger(values.get(i))/32;
		//获取数据长度
		int dataLength = ABIHexUtil.Hex32ToInteger(values.get(position));
		//获取数据 ,解析获取的数据
		String type = types.get(i);
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		if (type.equals("string")) {
			for (int j = 1; j <= dataLength; j++) {
				String value = values.get(position + j);
				if (value.endsWith("000")) {
					value = trimZero(value);
					appendInTerm(buffer,value);
				} else {
					appendInTerm(buffer,value);
				}
			}
		} else if(type.equals("bytes[]")){
			//遍历
			for (int j = 1; j <= dataLength; j++) {
				//获取数据相对位置
				int offset = ABIHexUtil.Hex32ToInteger(values.get(position + j))/32;
				//获取数据绝对位置
				int dataBeginPosition = position + offset +1;
				//获取数据长度
				int childDataLength = ABIHexUtil.Hex32ToInteger(values.get(dataBeginPosition))/32;
				//获取数据
				StringBuffer childData = new StringBuffer("0x");
				for(int dataPos = 1;dataPos<= childDataLength;dataPos++){
					childData.append(values.get(dataBeginPosition + dataPos));
				}
				appendInTerm(buffer,childData.toString());
			}
		}else if(type.startsWith("uint")){
			for (int j = 1; j <= dataLength; j++) {
				String value = parseStaticType(values.get(position + j),type);
				appendInTerm(buffer,value);
			}
		}else {
			for (int j = 1; j <= dataLength; j++) {
				String value = values.get(position + j);
				appendInTerm(buffer,value);
			}
		}
		buffer.append("]");
		results.add(String.valueOf(buffer));
	}

	private void appendInTerm(StringBuffer buffer,String value){
		if(!"[".equals(buffer.toString())){
			buffer.append(",");
		}

		buffer.append(value);
	}

	public String parseStaticType(String value,String type) {

		//uint4...256或int4...256
		if (type.contains("int")) {
			BigInteger integer = ABIHexUtil.Hex32ToUInt(value);
			return integer.toString();
		}

		//bytes4...256
		else if (type.matches("bytes[\\d]+")) {
			//String bytes = ABIHexUtil.Hex32ToBytes(values.get(i));
			return  trimZero(value);
		}

		//address
		else if (type.equals("address")) {
			return ABIHexUtil.addressToHex32(value);
		}

		//bool
		else if (type.contains("bool")) {
			boolean flag = ABIHexUtil.Hex32ToBool(value);
			return String.valueOf(flag);
		}
		//未知类型
		throw new RuntimeException("未知类型");
	}

	public String trimZero(String value) {
		int i;
		for (i = value.length(); i > 0; i--) {
			if (value.charAt(i-1) == '0') {
				continue;
			} else {
				break;
			}
		}
		value = value.substring(0, i);
		return value;
	}

	public void parseParamTypes(String paramTypes) {
		paramTypes = paramTypes.replaceAll("[() ]", "");
		String[] data = paramTypes.split(",");
		for (String d : data) {
			types.add(d);
		}
	}

	public void parseParamInput(String input) {
		if (input.contains("0x") && input.length() % 64 != 0) {
			input = input.substring(10);
		}

		int num = input.length() / 64;

		for (int i = 0; i < num; i++){
			String value = input.substring(0, 64);
			values.add(value);
			input = input.substring(64);
		}

		processValues.addAll(values);
	}
}
