/**
 * Copyright (C)2004 dGIC Corporation.
 *
 * This file is part of djUnit plugin.
 *
 * djUnit plugin is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * djUnit plugin is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with djUnit plugin; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 */
package jp.co.dgic.testing.common.virtualmock;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

class ArgumentValueList {

	private Hashtable argumentValues = new Hashtable();

	public void clear() {
		argumentValues.clear();
	}

	public Object get(String key) {
		return get(key, 0);
	}

	public Object get(String key, int index) {
		List values = getValueList(key);
		if (values == null) return null;
		if (values.size() <= index) return null;

		return values.get(index);
	}

	public void put(String key, Object value) {
		List values = getValueList(key);
		if (values == null) values = new LinkedList();

		values.add(value);

		argumentValues.put(key, values);
	}

	public Enumeration keys() {
		return argumentValues.keys();
	}

	public int size(String key) {
		List values = getValueList(key);
		if (values == null) return 0;
		return values.size();
	}

	protected List getValueList(String key) {
		List values = getValueListByFullName(key);
		if (values == null) {
			values = getValueListBySimplename(key);
		}
		return values;
	}

	protected List getValueListByFullName(String key) {
		if (!argumentValues.containsKey(key)) {
			return null;
		}
		return (List) argumentValues.get(key);
	}

	protected List getValueListBySimplename(String key) {
		Enumeration e = argumentValues.keys();

		String keyString = null;
		while (e.hasMoreElements()) {
			keyString = (String) e.nextElement();
			if (keyString.endsWith("." + key)) {
				return getValueListByFullName(keyString);
			}
		}

		return null;
	}
}
