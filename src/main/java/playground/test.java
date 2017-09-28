package playground;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * created by chaoyi on 2017/9/20
 */
public class test {
	public static void main(String[] args) {
		Date startDate = new Date();
		if (startDate != null) {
			String dateStr = DateFormatUtils.format(startDate, "yyyy-MM-dd | ");
			dateStr +=getWeekOfDate(startDate);
			dateStr += DateFormatUtils.format(startDate, " | HH:mm");
			System.out.println(dateStr);
		}

	}

	/**
	 * 获取当前日期是星期几<br>
	 *
	 * @param dt
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

}
