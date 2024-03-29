/*
 * Copyright 2010 - 2012 Ed Venaglia
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.venaglia.nondairy.i18n;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;
import com.intellij.AbstractBundle;

public class I18N extends AbstractBundle
{
	private static final I18N ourInstance = new I18N();

	private I18N()
	{
		super("messages.I18N");
	}

	public static String message(@PropertyKey(resourceBundle = "messages.I18N") String key)
	{
		return ourInstance.getMessage(key);
	}

	public static String message(@PropertyKey(resourceBundle = "messages.I18N") String key, Object... params)
	{
		return ourInstance.getMessage(key, params);
	}

	@NonNls
	@Deprecated
	public static String msg(@NonNls String key, Object... args)
	{
		return message(key, args);
	}
}
