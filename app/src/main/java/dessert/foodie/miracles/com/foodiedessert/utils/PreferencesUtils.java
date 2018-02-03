package dessert.foodie.miracles.com.foodiedessert.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesUtils {

	// 放置boolean值
	public static void putBoolean(Context context, String key, boolean value) {
		// * 1 获取SharePreference
		// * 2 获取Editor
		// * 3 通过放key-value数据
		// * 4 提交
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		// 2 获取Editor
		Editor edit = sp.edit();
		// 通过edit放key-value数据
		edit.putBoolean(key, value);
		edit.commit();
	}

	// 取boolean值
	public static boolean getBoolean(Context context, String key, boolean defValue) {
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getBoolean(key, defValue);
	}

	// 取boolean值
	public static boolean getBoolean(Context context, String key) {
		return getBoolean(context, key, false);
	}

	// 放置String值
	public static void putString(Context context, String key, String value) {
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		// 2 获取Editor
		Editor edit = sp.edit();
		// 通过edit放key-value数据
		edit.putString(key, value);
		edit.commit();
	}

	// 取String值
	public static String getString(Context context, String key) {
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getString(key, "");
	}

	// 放置int值
	public static void putInt(Context context, String key, int value) {
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		// 2 获取Editor
		Editor edit = sp.edit();
		// 通过edit放key-value数据
		edit.putInt(key, value);
		edit.commit();
	}

	// 取int值
	public static int getInt(Context context, String key, int defValue) {
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getInt(key, defValue);
	}

	public static int getInt(Context context, String key) {
		return getInt(context, key, -1);
	}

	// 放置int值
	public static void putLong(Context context, String key, long value) {
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		// 2 获取Editor
		Editor edit = sp.edit();
		// 通过edit放key-value数据
		edit.putLong(key, value);
		edit.commit();
	}

	// 取int值
	public static long getLong(Context context, String key, long defValue) {
		// 1 获取SharePreference
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		return sp.getLong(key, defValue);
	}

	public static long geLong(Context context, String key) {
		return getLong(context, key, -1);
	}



}
