package druid.test;

import com.google.gson.Gson;
import org.joda.time.DateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class WriteTestData {
	static String[] provinces = new String[]{"北京", "上海", "广东", "江苏", "湖北", "四川", "云南", "浙江"};

	public static void main(String[] args) {
		int files = 500;
		int rows = 10 * 10000;
		CountDownLatch latch = new CountDownLatch(files);
		long t1 = System.currentTimeMillis();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		for (int i = 1; i <= files; i++) {
			int finalJ = i;
			new Thread(() -> {
				try {
					OutputStreamWriter writer = null;
					String pathname = "/Users/chaoyi/Desktop/cluster/imply-data/testData/5000w/test" + finalJ + ".json";
					File file = new File(pathname);
					if (!file.exists()) {
						file.createNewFile();
					} else {
						file.delete();
						file.createNewFile();
					}
					FileOutputStream fop = new FileOutputStream(file);
					writer = new OutputStreamWriter(fop, "UTF-8");
					// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

					for (int j = 1; j <= rows; j++) {
						User user = new User();
						user.setName(UUID.randomUUID().toString().substring(0, 8));
						user.setIp(getRandomIp());
						int age = new Random().nextInt(99);
						user.setProvince(getProvince());
						user.setAge(age);
						user.setTimestamp(df
								.format(new DateTime()
										.minusSeconds(Math.abs((int) (new Random().nextGaussian() * 86400)))
										.toDate()));
						user.setSex(j & 1);
						user.setSalary(Math.abs((int) new Random().nextGaussian()) * 100000);
						user.setClick(new Random().nextInt(5));
						user.setStayTime(new Random().nextInt(120));
						String s = new Gson().toJson(user);
						writer.append(s + "\r\n");
						// System.out.println(s);
					}

					// 写入到缓冲区

					writer.flush();
					writer.close();
					latch.countDown();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}).start();

		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		System.out.println((t2 - t1) + "ms");
		System.out.println("end");

	}

	private static String getProvince() {
		return provinces[new Random().nextInt(8)];
	}

	public static String getRandomIp() {
		//ip范围
		int[][] range = {{607649792, 608174079},//36.56.0.0-36.63.255.255
				{1038614528, 1039007743},//61.232.0.0-61.237.255.255
				{1783627776, 1784676351},//106.80.0.0-106.95.255.255
				{2035023872, 2035154943},//121.76.0.0-121.77.255.255
				{2078801920, 2079064063},//123.232.0.0-123.235.255.255
				{-1950089216, -1948778497},//139.196.0.0-139.215.255.255
				{-1425539072, -1425014785},//171.8.0.0-171.15.255.255
				{-1236271104, -1235419137},//182.80.0.0-182.92.255.255
				{-770113536, -768606209},//210.25.0.0-210.47.255.255
				{-569376768, -564133889}, //222.16.0.0-222.95.255.255
		};

		Random rdint = new Random();
		int index = rdint.nextInt(10);
		String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
		return ip;
	}

	public static String num2ip(int ip) {
		int[] b = new int[4];
		String x = "";

		b[0] = (int) ((ip >> 24) & 0xff);
		b[1] = (int) ((ip >> 16) & 0xff);
		b[2] = (int) ((ip >> 8) & 0xff);
		b[3] = (int) (ip & 0xff);
		x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer
				.toString(b[3]);

		return x;
	}


	/**
	 * 生成随机密码
	 *
	 * @param pwd_len 生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String genRandomNum(int pwd_len) {
// 26*2个字母+10个数字
		final int maxNum = 62;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为62-1
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

}
