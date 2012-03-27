package com.common.tools.util;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumberUtil {
    /**
     * 格式化数字，例如：12345转化为12,345 //按照四舍五入
     * 
     * @param dValue
     *            被格式化的数值
     * @param iScale
     *            小数点后保留位数,不足补0
     * @return
     */
    public static String formatNumber(double dValue, int iScale) {
    	if(Double.isNaN(dValue)){
    		dValue=0.0d;
    	}
    	DecimalFormat df = null;
    	StringBuffer sPattern = new StringBuffer(",##0");
    	if (iScale > 0) {
    		sPattern.append(".");
    		for (int i = 0; i < iScale; i++) {
    			sPattern.append("0");
    		}
    	}
    	df = new DecimalFormat(sPattern.toString());
    	String str = df.format(dValue);
    	return str;
    }
    /**
     * 格式化数字，按照截位
     * 
     * @param dValue
     *            被格式化的数值
     * @param iScale
     *            小数点后保留位数,不足补0
     * @return
     */
    public static String formatNumberByCut (double dValue, int iScale) {
		if(Double.isNaN(dValue)){
    		dValue=0.0d;
    	}
    	DecimalFormat df = null;
    	StringBuffer sPattern = new StringBuffer(",##0");
    	String str = null;
    	if (iScale >= 0) {
    		sPattern.append(".");
    		for (int i = 0; i < iScale+1; i++) {
    			sPattern.append("0");
    		}
    	}
    	df = new DecimalFormat(sPattern.toString());
    	str = df.format(dValue);
    	if(iScale == 0) {
        	str = str.substring(0, str.length() - 2);
    	} else {
    		str = str.substring(0, str.length() - 1);
    	}
    	return str;
	}
    /**
     * 格式化数字，例如：12345.32转化为12,345.32
     * 
     * @param dValue
     *            被格式化的数值
     * @return
     */
    public static String formatNumber(double dValue) {
    	if(Double.isNaN(dValue)){
    		dValue=0.0d;
    	}
    	DecimalFormat df = null;
    	StringBuffer sPattern = new StringBuffer(",##0");
    	String sValue = String.valueOf(dValue);
    	int point = sValue.indexOf(".");
    	int iScale = sValue.substring(point, sValue.length()-1).length();
    	if (iScale > 0) {
    		sPattern.append(".");
    		for (int i = 0; i < iScale; i++) {
    			sPattern.append("0");
    		}
    	}
    	df = new DecimalFormat(sPattern.toString());
    	String str = df.format(dValue);
    	return str;
    }
    
    /**
     * double数据保留小数点位数，返回字符串
     * @param value
     * @param iScale
     * @return
     */
    public static String formatPointBits(double value,int iScale){
    	if(Double.isNaN(value)){
    		value=0.0d;
    	}
    	DecimalFormat df = null;
    	StringBuffer sPattern = new StringBuffer("##0");
    	if (iScale > 0) {
    		sPattern.append(".");
    		for (int i = 0; i < iScale; i++) {
    			sPattern.append("0");
    		}
    	}    
    	df = new DecimalFormat(sPattern.toString());
    	String result = df.format(value);
    	return result;
    }
    public static String formatDotNumber(double dValue) {
    	if(Double.isNaN(dValue)){
    		dValue=0.0d;
    	}
    	DecimalFormat df = null;
    	StringBuffer sPattern = new StringBuffer(",##0.0000000000");
    	df = new DecimalFormat(sPattern.toString());
    	String str = df.format(dValue);
    	while(str.endsWith("0") && str.indexOf(".") != str.length() - 3){
    		str = str.substring(0, str.length() - 1);
    	}
    	return str;
    }
    
    public static String formatNumber(long lValue) {
    	return formatNumber((double) lValue, 0);
    }
    
    /**
	 * 解析格式化的字符串，转化为数值，例如：12,345.00转化为12345
	 * 
	 * @param text
	 *            被格式化的数值
	 * @return
	 */
	public static double parseNumber(String text) {
		int index = text.indexOf(",");
		String sbNumber = "";
		while (index != -1) {
			sbNumber += text.substring(0, index);
			text = text.substring(index + 1, text.length());
			index = text.indexOf(",");
		}
		sbNumber += text;
		return Double.parseDouble(sbNumber);
	}
	
    /**
	 * 解析格式化的字符串，转化为数值，例如：12,345.00转化为12345,增加为空的判断
	 * 
	 * @param text
	 *            被格式化的数值
	 * @return
	 */
	public static double parseNumber4Null(String text) {
		if(text == null || text.equals("")){
			return Double.parseDouble("0");
		}
		int index = text.indexOf(",");
		String sbNumber = "";
		while (index != -1) {
			sbNumber += text.substring(0, index);
			text = text.substring(index + 1, text.length());
			index = text.indexOf(",");
		}
		sbNumber += text;
		return Double.parseDouble(sbNumber);
	}
	/**
	 * 判断字符串是否为数字
	 * @return true：为数字 false：非数字
	 */
	public static boolean isNumeric(String str)
	{
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if(!isNum.matches())
		{
			return false;
		}
		return true;
	} 

	public static long parseLong(String text) {
		int index = text.indexOf(",");
		String sbNumber = "";
		while (index != -1) {
			sbNumber += text.substring(0, index);
			text = text.substring(index + 1, text.length());
			index = text.indexOf(",");
		}
		sbNumber += text;
		System.out.println(sbNumber);
		return Long.parseLong(sbNumber);
	}
    public static String toString(double number) {
	NumberFormat format = NumberFormat.getInstance();

	format.setGroupingUsed(false);

	return format.format(number);
    }

    public static String toString(Number number) {
	NumberFormat format = NumberFormat.getInstance();

	format.setGroupingUsed(false);

	return format.format(number);
    }

    public static double percent(double number) {
	NumberFormat format = NumberFormat.getInstance();

	format.setMaximumFractionDigits(4);
	format.setGroupingUsed(false);

	return Double.parseDouble(format.format(number));
    }

    /**
         * 返回传入数字的百分数
         * 
         * @param number
         * @return
         */
    public static String percentString(double number) {
	NumberFormat format = NumberFormat.getPercentInstance();

	format.setMaximumFractionDigits(4);
	format.setGroupingUsed(false);

	return format.format(number);
    }

    public static String percentString(Number number) {
	NumberFormat format = NumberFormat.getPercentInstance();

	format.setMaximumFractionDigits(4);
	format.setGroupingUsed(false);

	return format.format(number);
    }

    // 四舍五入取两位小数
    public static double to2dec(double number) {
	NumberFormat format = NumberFormat.getInstance();

	format.setMaximumFractionDigits(2);
	format.setGroupingUsed(false);

	return Double.parseDouble(format.format(number + 1.0e-5));// 防止0.005被舍掉
    }
    // 四舍五入取n位小数

    public static Double to2dec(double number,int digit) {
	NumberFormat format = NumberFormat.getInstance();

	format.setMaximumFractionDigits(digit);
	format.setGroupingUsed(false);
	int num = digit+2;
	return Double.parseDouble(format.format(number + java.lang.Math.pow(0.1, num)));// 防止0.005被舍掉

    }
    /**
         * 四舍五入保留两位小数
         * 
         * @param number
         * @return
         */
    public static Double to2dec(Number number) {
	NumberFormat format = NumberFormat.getInstance();

	format.setMaximumFractionDigits(2);
	format.setGroupingUsed(false);

	return Double.valueOf(format.format(number.doubleValue() + 1.0e-5));// 防止0.005被舍掉
    }
    /**
     * 结果:0:number1 == number2 , 结果: -1:number1< number2 ,  结果:1: number1> number2
     * @param number1
     * @param number2
     * @return
     */
    public static int  compareDouble(double number1,double number2) {
    	
    	BigDecimal   bA   =   new   BigDecimal(number1);   
    	BigDecimal   bB   =   new   BigDecimal(number2);    
    	return  bA.compareTo(bB) ;   
    }
    
    public static String to2decString(double number) {
		NumberFormat format = NumberFormat.getInstance();
	
		format.setMaximumFractionDigits(2);
		format.setGroupingUsed(false);
	
		return format.format(number);
    }

    public static String to2decString(Number number) {
	if (number == null)
	    return "";
	NumberFormat format = NumberFormat.getInstance();

	format.setMaximumFractionDigits(2);
	format.setGroupingUsed(false);

	return format.format(number);
    }

    public static String usdString(double number) {
	NumberFormat format = NumberFormat.getInstance();

	format.setCurrency(Currency.getInstance(Locale.US));

	return format.format(number);
    }

    /**
         * 将传入数字格式化为美元
         * 
         * @param number
         * @return
         */
    public static String usdString(Number number) {
	NumberFormat format = NumberFormat.getInstance();

	format.setCurrency(Currency.getInstance(Locale.US));

	return format.format(number);
    }
    
    /**
     * 格式化金额显示
     * @param obj要格式化数据,num为小数点位数
     * @return
     */
    public static String getFormatStyle(Object obj, int num){
    	NumberFormat nf=NumberFormat.getNumberInstance();
    	nf.setMinimumFractionDigits(num);
    	return nf.format(obj);
    }
    
    /**
     * 转化百分比为小数,ex:传入是50%,输出是0.5
     * @param obj 要格式化的百分比
     * @return 
     * */
    public static Double getNumberfrompercent(String str){
	String percentstr=str.substring(0,str.length()-1);
	Double num=Double.valueOf(percentstr);
	return num/100;
    }
    
    /**
     * 格式化金额
     * @param obj 要格式化的金额
     * @param iScale 保留的小数位数
     * @return Double 类型的金额，保留小数位数后面的金额直接截去
     *
     * */
    public static Double getDirectNumberfromIsScale(String str,int iScale){
	int index = str.indexOf(".");
	String sstr=str.substring(0,index);
	String estr=str.substring(index+1, str.length());
	if (estr.length()>iScale)
	    estr=estr.substring(0,iScale);
	return Double.valueOf(sstr+"."+estr);
	
    }
    
    /**
     * 加法
     * @param v1
     * @param v2
     * @return
     */
    public static Double add(Double v1,Double v2){
	  BigDecimal b1 = new BigDecimal(String.valueOf(v1));
	  BigDecimal b2 = new BigDecimal(String.valueOf(v2));
	  return b1.add(b2).doubleValue();
    }

	 /**
	  * 减法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static Double sub(Double v1,Double v2){
	  BigDecimal b1 = new BigDecimal(String.valueOf(v1));
	  BigDecimal b2 = new BigDecimal(String.valueOf(v2));
	  return b1.subtract(b2).doubleValue();
	 }

	 /**
	  * 乘法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static Double mul(Double v1,Double v2){
	  BigDecimal b1 = new BigDecimal(String.valueOf(v1));
	  BigDecimal b2 = new BigDecimal(String.valueOf(v2));
	  return b1.multiply(b2).doubleValue();
	 }

	 /**
	  * 除法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static Double div(Double v1,Double v2,int scale){
	  BigDecimal b1 = new BigDecimal(String.valueOf(v1));
	  BigDecimal b2 = new BigDecimal(String.valueOf(v2));
	  return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	 }
	
	/**
	 * 除法
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 保留位数
	 * @param roundType 截位方式，与BigDecimal所定义的一致
	 * @return
	 */
	public static Double div(Double v1,Double v2,int scale, int roundType){
		  BigDecimal b1 = new BigDecimal(String.valueOf(v1));
		  BigDecimal b2 = new BigDecimal(String.valueOf(v2));
		  return b1.divide(b2,scale,roundType).doubleValue();
		 }
	
	public static Double divByUp(Double v1,Double v2,int scale){
		  BigDecimal b1 = new BigDecimal(String.valueOf(v1));
		  BigDecimal b2 = new BigDecimal(String.valueOf(v2));
		  return b1.divide(b2,scale,BigDecimal.ROUND_UP).doubleValue();
	}

	/**
	 * 截位除法
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 保留位数
	 * @return
	 */
	public static Double divByDown(Double v1,Double v2,int scale){
		BigDecimal b1 = new BigDecimal(String.valueOf(v1));
		BigDecimal b2 = new BigDecimal(String.valueOf(v2));
		return b1.divide(b2,scale,BigDecimal.ROUND_DOWN).doubleValue();
	}
	
	 /**
	  * 四舍五入
	 * @param v
	 * @param limited
	 * @return
	 */
	public static Double round(Double v,int scale){
	  BigDecimal b = new BigDecimal(String.valueOf(v));
	  return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	 }
	
	public static Double roundByDown(Double v,int scale){
		  BigDecimal b = new BigDecimal(String.valueOf(v));
		  return b.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
		 }
	public static Double roundByUp(Double v,int scale){
		  BigDecimal b = new BigDecimal(String.valueOf(v));
		  return b.setScale(scale, BigDecimal.ROUND_UP).doubleValue();
		 }
	/**
	 * 初始化double数量
	 * @param d
	 * @param value
	 * @return
	 */
	public static Double initDouble(Double d,Double value){
	    
	    return d==null?0d:new BigDecimal(String.valueOf(value)).doubleValue();
	}
	/**
	 * 截取2位小数
	 * @param num
	 * @return
	 */
    public static Double getFactnumber(Double num){
    	String amount=num.toString();
    	int pos=amount.indexOf(".");
    	String strFront=amount.substring(0,pos);
    	String strEnd=amount.substring(pos+1,amount.length());
    	if (strEnd!=null && strEnd.length()>2)
    	    strEnd=strEnd.substring(0,2);
    	return Double.valueOf(strFront+"."+strEnd);
        }
    /**
     * 把一个BigDecimal转换成Long
     * @param num
     * @return
     */
    public static Long getLongFromBigdecimal(BigDecimal num){
    	if(num == null){
    		return null;
    	}else{
    		return new Long(num.longValue());
    	}
    }
    /**
     * 把一个BigDecimal转换成Integer
     * @param num
     * @return
     */
    public static Integer getIntegerFromBigdecimal(BigDecimal num){
    	if(num == null){
    		return null;
    	}else{
    		return new Integer(num.intValue());
    	}
    }
    /**
     * 取消科学计算法
     * @param num
     * @return
     */
    public static String cancelScientificAth (String  amount){
    	Double double1  = Double.valueOf(amount);
		DecimalFormat df = new DecimalFormat("###0.00"); 
//		保留两位小数且不用科学计数法，并使用千分位 
		amount = df.format(double1);
		return amount;
    }
    
   
    	
    	private final static String[] _NUMUPPER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" }; 
    	
    	private final static String[] _SMALLUNIT = { "", "拾","佰","仟"}; 
    	private final static String[] _BIGUNIT = { "","", "万","亿"}; 
    	private final static String[] _AMONTUNIT = { "元","角", "分"}; 
    	
    	 
    	
    	//小写转大写
    	public static String amountConvert2Cn(String amount){
    		
    		final  String ZERO = "0000";

    		StringBuilder buff = new StringBuilder();
    		
    		String[] splits = amount.replaceAll(",", "").split("\\.");
    		final String yuan = splits[0];
    		//final String jiaofen = splits[1];
    		
    		int btyes = yuan.length();
    		//分割段数（4位一段，第一段位数<=4）
    		int partCounts = btyes%4==0?btyes/4:(btyes/4+1);
    		//第一部分长度
    		int firstPartLen = btyes%4==0?4:btyes%4;
    		//
    		String smallNumConvert = smallNumConvert(yuan.substring(0,firstPartLen));
    		buff.append(formatAllZore(smallNumConvert,_BIGUNIT[partCounts]));
    	
    		for (int i = 1; i < partCounts; i++) {
    			String temp = yuan.substring(firstPartLen+i*4-4,firstPartLen+i*4);
    			if(!ZERO.equals(temp)){
    				buff.append(formatAllZore(smallNumConvert(temp),_BIGUNIT[partCounts-i]));
    			}
    		
    		}
    		
    		buff.append(_AMONTUNIT[0]);
    		
    		return buff.toString().replaceAll("零+", "零");
    	}
    	
    	private static String formatAllZore(String numConvert,String unit){
    		return "零".equals(numConvert)?numConvert:(numConvert+unit);
    	}
    	
    	/**
    	 * 千位计数以内转换处理
    	 * @param num 1234
    	 * @return
    	 */
    	private static String smallNumConvert(String num){
    		StringBuilder buff = new StringBuilder();
    		
    		if(Integer.parseInt(num)==10)
    			return "拾";
    		if(Integer.parseInt(num)==0)
    			return "零";
    		
    		char[] arrays = num.toCharArray();
    		
    		for (int i = 0; i < arrays.length; i++) {
    			int number = Integer.parseInt(String.valueOf(arrays[i]));
    			buff.append(_NUMUPPER[number]);
    			if(number!=0){
    				buff.append(_SMALLUNIT[arrays.length-i-1]);
    			}
    		}
    		
    		String tmp = buff.toString().replaceAll("零+", "零");
    		if(tmp.endsWith("零"))
    			tmp = tmp.substring(0,tmp.length()-1);
    		return tmp;
    	}

    	public static void main(String[] args){
    		System.out.println(amountConvert2Cn("201000101"));
    		System.out.println(formatDotNumber(20000.000500));
    	}
}
