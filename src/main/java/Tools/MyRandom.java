package Tools;


import java.util.Random;

/**
 * Created by Administrator on 2017/7/21.
 * 随机数处理类
 */
public class MyRandom {
    final static LoggerControler log = LoggerControler.getLogger(MyRandom.class);

    /**
     * 生成随机数字,
     *
     * @param length 长度
     * @return 生成后的数字
     */
    public  long getNumRandom(int length) {
        long num = 0;
//            Math.random() 生成一个[0.0, 1.0)期间的随机数
//        Math.pow(double a ,double b) a的b次方
        num = Math.abs((long) (Math.random() * Math.pow(10, length)));
        log.info(String.valueOf(num));
        return num;
    }

    /**
     * 生成 X 到 X 的随机数
     *
     * @param min 最小
     * @param max 最大
     * @return 随机数
     */
    public  long getNumRandom(int min, int max) {
        int num = 0;
        Random random = new Random();
//       nextInt(2) 生成一个 [0,2) 之间的随机数
        num = Math.abs(random.nextInt(max - min + 1) + min);
        log.info(String.valueOf(num));
        return num;
    }

    //生成一个小于i的随机数
    public int getrandom(int i){
        Random A = new Random();
        int C = Math.abs(A.nextInt(i));
        return C;
    }

    /**
     * 生成随机数字和字母,
     *
     * @param length 长度
     * @return 生成后的字符串
     */
    public  String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
//            生成一个 [0,2) 之间的随机数
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equals(charOrNum)) {
                //输出是大写字母还是小写字母 根据ASCII值 A:65 a:97
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equals(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        log.info("生成随机数"+val);
        return val;
    }
}
