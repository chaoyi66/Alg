package playground;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUtil {
	private static Pattern p_img = Pattern.compile("<(img|IMG)(.*?)()(/>|></img>|>)");
	private static Pattern src_values = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')(\\s*|\t|\r|)");


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "";
		text = processTextFromAndroid(text);
		StringBuilder sb = new StringBuilder();
		int last = 0;
		Matcher imgMatcher = p_img.matcher(text);
		while (imgMatcher.find()) {
			int start = imgMatcher.start();
			int end = imgMatcher.end();
			sb.append(text.substring(last, start));
			String imgStr = imgMatcher.group(0);
			Matcher srcMatcher = src_values.matcher(imgStr);
			if (srcMatcher.find()) {
				String src = srcMatcher.group(3);
				BufferedImage image = getBufferedImage(src);
				if (image != null) {
					int width = image.getWidth();
					int height = image.getHeight();
					sb.append("<img src=\"").append(src).append("\" width=\"").append(width).append("\" height=\"").append(height).append("\">");
				}

			}
			last = end;
		}
		text=sb.toString();

	}

	private static String processTextFromAndroid(String desc) {
		//TODO 去掉<body>以外的标签
		Pattern p = Pattern.compile("<body>(.*)</body>");
		Matcher m = p.matcher(desc);
		if (m.find()) {
			desc = m.group(1);
		}
		return desc;
	}


	/**
	 * @param imgUrl 图片地址
	 * @return
	 */
	public static BufferedImage getBufferedImage(String imgUrl) {
		URL url = null;
		InputStream is = null;
		BufferedImage img = null;
		try {
			url = new URL(imgUrl);
			is = url.openStream();
			img = ImageIO.read(is);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}

}
