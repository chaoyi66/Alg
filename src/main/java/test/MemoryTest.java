package test;

/**
*
* @Title: MemoryTest.java
* @Copyright: Copyright (c)2005
* @Description: <br>
* <br>
*              测试java虚拟机的内存占用情况
* @Created on 2014-1-21 上午11:40:35
* @author杨凯
*/
public class MemoryTest {
 
   /**
   * @param args
   */
   public static void main(String[]args) {
//      testStringBuffer();
       testString();
   }
 
   /**
   * 测试String实例对象的占用的内存
   */
   public static void testString() {
      String str = new String("abcdefghijklmn");
      int count = 0;
      System.out.println("当前虚拟机的最大内存：" + Runtime.getRuntime().maxMemory()/ 1024 / 1024 + "m------" + Runtime.getRuntime().maxMemory()+ "byte");
      System.out.println("循环前虚拟机已占内存：" + Runtime.getRuntime().totalMemory()/ 1024 / 1024 + "m====" + Runtime.getRuntime().totalMemory()+ "byte");
      while (true) {
          try {
               str += str;
               count++;
           } catch (Error e) {
               System.out.println("循环次数：" + count);
               System.out.println("字符串循环后的大小为：" + str.length() / 1024 / 1024 + "m-=-=-=" + str.length() + "byte");
               System.out.println("循环前虚拟机已占内存：" + Runtime.getRuntime().totalMemory()/ 1024 / 1024 + "m====" + Runtime.getRuntime().totalMemory()+ "byte");
               System.out.println("遇到错误：" + e);
               break;
          }
      }
      /*
       * 运行结果：
       * 当前虚拟机的最大内存：793m------832438272byte
          循环前虚拟机已占内存：127m====133234688byte
          循环次数：23
          字符串循环后的大小为：112m-=-=-=117440512byte
          循环前虚拟机已占内存：642m====673669120byte
          遇到错误：java.lang.OutOfMemoryError: Java heap space
       */
   }
 
   /**
    * 测试StringBuffer实例对象的占用的内存
   */
   public static void testStringBuffer(){
      StringBuffer sb = new StringBuffer("abcdefghijklmn");
      int count = 0;
      System.out.println("当前虚拟机的最大内存：" + Runtime.getRuntime().maxMemory()/ 1024 / 1024 + "m------" + Runtime.getRuntime().maxMemory()+ "byte");
      System.out.println("循环前虚拟机已占内存：" + Runtime.getRuntime().totalMemory()/ 1024 / 1024 + "m====" + Runtime.getRuntime().totalMemory()+ "byte");
      while (true) {
          try {
               sb.append(sb);
               count++;
               System.out.println("循环次数：" + count);
               System.out.println("字符串循环后的大小为：" + sb.length() / 1024 / 1024 + "m-=-=-=" + sb.length() + "byte");
          } catch (Error e) {
               System.out.println("循环后虚拟机已占内存：" + Runtime.getRuntime().totalMemory()/ 1024 / 1024 + "m====" + Runtime.getRuntime().totalMemory()+ "byte");
               System.out.println("遇到错误：" + e);
               break;
          }
		}
		/*
		 * 运行结果： 当前虚拟机的最大内存：793m------832438272byte
		 * 循环前虚拟机已占内存：127m====133234688byte 循环次数：23
		 * 字符串循环后的大小为：112m-=-=-=117440512byte 循环前虚拟机已占内存：539m====566108160byte
		 * 遇到错误：java.lang.OutOfMemoryError: Java heap space
		 * 
		 */
   }
}