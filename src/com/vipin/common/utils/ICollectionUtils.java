package com.vipin.common.utils;

import java.util.Collection;

public class ICollectionUtils {

	public static boolean isEmpty(Collection<?> kollection) {
		return kollection == null || kollection.size() == 0;
	}

	public static boolean isNotEmpty(Collection<?> kollection) {
		return kollection != null && kollection.size() > 0;
	}

	public static boolean isNotEmpty(Object kollection) {
		return kollection != null;
	}

	public static boolean isEmpty(Object obj) {
		return obj == null;
	}
}
