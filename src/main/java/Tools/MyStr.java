package Tools;

/**
 * Created by Administrator on 2017/7/21.
 * 字符截取处理类
 */
public class MyStr {

//    subStrStart(String str, int end);//正向截取
//    subStrEnd(String str, int start);//反向截取
//    subStr(String str, int length);//支持双向截取，length>0正向截取，<0，反向截取
//    subStr(String str, int start, int end);//支持双向截取，start、length>0正向截取，<0，反向截取。
    /**
     * 从头开始截取
     *
     * @param str 字符串
     * @param end 结束位置
     * @return
     */
    public  String subStrStart(String str, int end){
        return subStr(str, 0, end);
    }

    /**
     * 从尾开始截取
     *
     * @param str 字符串
     * @param start 开始位置
     * @return
     */
    public  String subStrEnd(String str, int start){
        return subStr(str, str.length()-start, str.length());
    }

    /**
     * 截取字符串 （支持正向、反向截取）<br/>
     *
     * @param str 待截取的字符串
     * @param length 长度 ，>=0时，从头开始向后截取length长度的字符串；<0时，从尾开始向前截取length长度的字符串
     * @return 返回截取的字符串
     * @throws RuntimeException
     */
    public  String subStr(String str, int length) throws RuntimeException{
        if(str==null){
            throw new NullPointerException("字符串为null");
        }
        int len = str.length();
        if(len<Math.abs(length)){
            throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(length)));
        }
        if(length>=0){
            return subStr(str, 0,length);
        }else{
            return subStr(str, len-Math.abs(length), len);
        }
    }


    /**
     * 截取字符串 （支持正向、反向选择）<br/>
     *
     * @param str 待截取的字符串
     * @param start 起始索引 ，>=0时，从start开始截取；<0时，从length-|start|开始截取
     * @param end 结束索引 ，>=0时，从end结束截取；<0时，从length-|end|结束截取
     * @return 返回截取的字符串
     * @throws RuntimeException
     */
    public  String subStr(String str, int start, int end) throws RuntimeException{
        if(str==null){
            throw new NullPointerException("");
        }
        int len = str.length();
        int s = 0;//记录起始索引
        int e = 0;//记录结尾索引
        if(len<Math.abs(start)){
            throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(start)));
        }else if(start<0){
            s = len - Math.abs(start);
        }else if(start<0){
            s=0;
        }else{//>=0
            s = start;
        }
        if(len<Math.abs(end)){
            throw new StringIndexOutOfBoundsException("最大长度为"+len+"，索引超出范围为:"+(len-Math.abs(end)));
        }else if (end <0){
            e = len - Math.abs(end);
        }else if (end==0){
            e = len;
        }else{//>=0
            e = end;
        }
        if(e<s){
            throw new StringIndexOutOfBoundsException("截至索引小于起始索引:"+(e-s));
        }

        return str.substring(s, e);
    }

    /**
     * 用指定字符串数组相连接，并返回
     *
     * @param strs 字符串数组
     * @param splitStr 连接数组的字符串
     * @return
     */
    public  String join(String[] strs, String splitStr){
        if(strs!=null){
            if(strs.length==1){
                return strs[0];
            }
            StringBuffer sb = new StringBuffer();
            for (String str : strs) {
                sb.append(str).append(splitStr);
            }
            if(sb.length()>0){
                sb.delete(sb.length()-splitStr.length(), sb.length());
            }
            return sb.toString();
        }
        return null;
    }

    //按照指定符号截取
    public String[] StrByIndex(String str,String index){
        if(str!=null && str.contains(index)){
            int key=str.trim().indexOf(index);
            String[] result=new String[2];
            result[1]=str.substring(0,key);
            result[2]=str.substring(key+1);
            return result;
        }
        return null;
    }
}
