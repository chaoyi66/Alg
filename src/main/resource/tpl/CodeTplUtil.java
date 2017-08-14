package com.cc.xt.market.service.utils;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;

public class CodeTplUtil {
	final static String TYPE_SERVICE = "service";
	final static String TYPE_I_SERVICE = "Iservice";
	final static String TYPE_SERVICE_IMPL = "service_impl";
	final static String TYPE_CONTROLLER = "controller";
	final static String tplPath = "C:\\work\\git\\xt-market\\xt-market-web\\doc\\tpl";
	final static String targetPath = "Z:\\xt\\";

	public static void main(String[] args) {
		// 创建目录
		CodeTplUtil.createDir(targetPath);

		// 创建临时文件
		List<String> prefixs = Lists.newArrayList("activity", "empStatus",
				"env", "motive", "motiveCat",
				"product", "saleTarget", "saleTargetSplit");
		// // 创建临时文件
		// List<String> prefixs = Lists.newArrayList();
		// // prefixs.add("");
		// prefixs.add("reward");
		// prefixs.add("signin");
//		prefixs.add("operateLog");
		// prefixs.add("reportReason");
		buildController(targetPath, prefixs);
		buildService(targetPath, prefixs);
		buildIService(targetPath, prefixs);
		buildServiceImpl(targetPath, prefixs);
//		buildCurlTest(targetPath, prefixs);
		buildDubboProvider(targetPath, prefixs);
		buildDubboConsumer(targetPath, prefixs);
		try {
			Runtime.getRuntime().exec("cmd /c start " + targetPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void buildDubboConsumer(String targetPath, List<String> prefixs) {
		System.out.println("******************************************");
		System.out.println("***************consumer*******************");
		System.out.println("******************************************");
		for (String prefix : prefixs) {
			System.out.println();
			System.out.println(String.format(
					"<dubbo:reference id=\"%sService\" interface=\"com.cc.course.api.I%sService\" version=\"${cc.course.service.version} \"check=\"false\" />",
					prefix, char1Upper(prefix)));
		}

	}

	private static void buildDubboProvider(String targetPath, List<String> prefixs) {
		System.out.println("******************************************");
		System.out.println("***************provider*******************");
		System.out.println("******************************************");

		for (String prefix : prefixs) {
			System.out.println();
			System.out.println(String.format(
					"<dubbo:service interface=\"com.cc.course.api.I%sService\" ref=\"%sService\" version=\"${cc.course.service.version}\" />",
					char1Upper(prefix), prefix));
		}

	}

	private static void buildCurlTest(String targetPath, List<String> prefixs) {
		for (String prefix : prefixs) {
			System.out.println();
			System.out.println(String.format("curl -d \"name=testAdd\" localhost:8080/course-web/%s/add", prefix));
			System.out.println(
					String.format("curl -d \"id=1&name=testUpdate\" localhost:8080/course-web/%s/update", prefix));
			System.out.println(String.format("curl \"localhost:8080/course-web/%s/select?id=1\"", prefix));
			System.out.println(String.format("curl \"localhost:8080/course-web/%s/selectList?\"", prefix));
			// System.out.println(String.format("curl
			// \"localhost:8080/course-web/%s/selectPage?pageInfo.pageSize=10&pageInfo.pageNum=1\"",
			// prefix));
			System.out.println(String.format("curl -d \"id=1\" localhost:8080/course-web/%s/delete", prefix));
		}
		// TODO Auto-generated method stub

	}

	private static void buildController(String targetPath, List<String> prefixs) {
		String suffix = "Controller.java";
		for (String prefix : prefixs) {
			CodeTplUtil.createFile(targetPath + "/controller/", prefix, suffix, TYPE_CONTROLLER);
		}
	}

	private static void buildService(String targetPath, List<String> prefixs) {
		String suffix = "Service.java";
		for (String prefix : prefixs) {
			CodeTplUtil.createFile(targetPath + "/intf/", prefix, suffix, TYPE_SERVICE);
		}
	}

	private static void buildIService(String targetPath, List<String> prefixs) {
		String suffix = "Service.java";
		for (String prefix : prefixs) {
			CodeTplUtil.createFile(targetPath + "/api/", "I", prefix, suffix, TYPE_I_SERVICE);
		}
	}

	private static void buildServiceImpl(String targetPath, List<String> prefixs) {
		String suffix = "ServiceImpl.java";
		for (String prefix : prefixs) {
			CodeTplUtil.createFile(targetPath + "/impl/", prefix, suffix, TYPE_SERVICE_IMPL);
		}
	}

	public static boolean createFile(String dir, String prefix, String suffix, String type) {
		return createFile(dir, "", prefix, suffix, type);
	}

	public static boolean createFile(String dir, String tag, String prefix, String suffix, String type) {
		String destFileName = dir + tag + char1Upper(prefix) + suffix;
		File file = new File(destFileName);
		if (file.exists()) {
			System.out.println(destFileName + "目标文件已存在，删除后重建！");
			file.delete();
		}
		if (destFileName.endsWith(File.separator)) {
			System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
			return false;
		}
		// 判断目标文件所在的目录是否存在
		if (!file.getParentFile().exists()) {
			// 如果目标文件所在的目录不存在，则创建父目录
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {
				System.out.println("创建目标文件所在目录失败！");
				return false;
			}
		}
		// 创建目标文件
		try {
			if (file.createNewFile()) {
				buildFile(type, file, prefix);
				//System.out.println("创建单个文件" + destFileName + "成功！");
				return true;
			} else {
				System.out.println("创建单个文件" + destFileName + "失败！");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());
			return false;
		}
	}

	private static void buildFile(String type, File file, String prefix)
			throws UnsupportedEncodingException, IOException {
		String tplPath = getTpl(type);
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(tplPath))));
		StringBuffer strBuf = new StringBuffer();
		for (String tmp1 = null; (tmp1 = bufReader.readLine()) != null; tmp1 = null) {
			// 替换UC操作
			String tmp = new String(tmp1.toString().getBytes("UTF-8"));
			tmp = tmp.replaceAll("%ss", prefix);
			tmp = tmp.replaceAll("%su", char1Upper(prefix));
			tmp = tmp.replaceAll("%as", prefix.toLowerCase());
			strBuf.append(tmp);
			strBuf.append(System.getProperty("line.separator"));
		}
		bufReader.close();
		String strBuf2 = new String(strBuf.toString().getBytes("UTF-8"));
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.write(strBuf2.toString().toCharArray());
		printWriter.flush();
		printWriter.close();

	}

	private static String getTpl(String type) {
		switch (type) {
			case TYPE_SERVICE:
				return tplPath + "service.java";
			case TYPE_I_SERVICE:
				return tplPath + "Iservice.java";
			case TYPE_SERVICE_IMPL:
				return tplPath + "serviceImpl.java";
			case TYPE_CONTROLLER:
				return tplPath + "controller.java";
		}
		return null;

	}

	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			dir.delete();
			System.out.println(destDirName + "目录已经存在,删除后重建");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建目录
		if (dir.mkdirs()) {
			//System.out.println("创建目录" + destDirName + "成功！");
			return true;
		} else {
			System.out.println("创建目录" + destDirName + "失败！");
			return false;
		}
	}

	public static String createTempFile(String prefix, String suffix, String targetPath) {
		File tempFile = null;
		if (targetPath == null) {
			try {
				// 在默认文件夹下创建临时文件
				tempFile = File.createTempFile(prefix, suffix);
				// 返回临时文件的路径
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("创建临时文件失败！" + e.getMessage());
				return null;
			}
		} else {
			File dir = new File(targetPath);
			// 如果临时文件所在目录不存在，首先创建
			if (!dir.exists()) {
				if (!CodeTplUtil.createDir(targetPath)) {
					System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
					return null;
				}
			}
			try {
				// 在指定目录下创建临时文件
				tempFile = File.createTempFile(prefix, suffix, dir);
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("创建临时文件失败！" + e.getMessage());
				return null;
			}
		}
	}

	private static String char1Upper(String name) {
		if (name != null) {
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		return name;
	}

}
