/*
 * Copyright 2010 - 2013 Ed Venaglia
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

package net.venaglia.nondairy.soylang.icons;

import javax.swing.Icon;

import com.intellij.openapi.util.IconLoader;
import consulo.ui.image.Image;

/**
 * User: ed
 * Date: 2/15/12
 * Time: 6:30 PM
 *
 * Holder class for icons used by the plugin
 */
public interface SoyIcons {

    public static final Image FILE = IconLoader.getIcon("/net/venaglia/nondairy/soylang/icons/soy.png");

    public static final Icon NAMESPACE = IconLoader.getIcon("/net/venaglia/nondairy/soylang/icons/soy-namespace.png");

    public static final Icon ALIAS = IconLoader.getIcon("/net/venaglia/nondairy/soylang/icons/soy-namespace-alias.png");

    public static final Icon TEMPLATE = IconLoader.getIcon("/net/venaglia/nondairy/soylang/icons/soy-template.png");

    public static final Icon DELTEMPLATE = IconLoader.getIcon("/net/venaglia/nondairy/soylang/icons/soy-deltemplate.png");

    public static final Icon PARAMETER = IconLoader.getIcon("/net/venaglia/nondairy/soylang/icons/soy-param.png");

    public static final Icon FUNCTION = IconLoader.getIcon("/net/venaglia/nondairy/soylang/icons/soy-function.png");
}
