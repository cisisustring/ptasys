package io.renren.common.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {


    public final static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(MD5("asdf123"));

        long dTime = System.currentTimeMillis()/1000;
        long cTime = Long.parseLong("1521103342");
        double pZcl = Double.parseDouble("1200");
        double one = dTime -cTime;
        if (one<=0)
        {
            System.out.println(one);
        }
        BigDecimal nnn = new BigDecimal(new Double(one*pZcl)  / (new Double(30*24*3600)));
        double d = nnn.setScale(8,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);


//        double two = pZcl / (30 * 24 * 60 * 60 * 1000);
//        double sNum= one * two;
//        BigDecimal bigDecimal = new BigDecimal(sNum);
//        double d = bigDecimal.setScale(8,BigDecimal.ROUND_HALF_UP).doubleValue();
        //mvSatnum.setText(d + " SAT");



    }

    public final static String md5(String content) {
        //用于加密的字符
        char[] md5String = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = content.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {   //  i = 0
                byte byte0 = md[i];  //95
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5
                str[k++] = md5String[byte0 & 0xf];   //   F
            }

            //返回经过加密后的字符串
            return new String(str);

        } catch (Exception e) {
            return null;
        }
    }
}
