/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.theme.base.client.toolbar;

import com.sencha.gxt.theme.base.client.container.HBoxLayoutDefaultAppearance;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar.ToolBarAppearance;

public abstract class ToolBarBaseAppearance extends HBoxLayoutDefaultAppearance implements ToolBarAppearance {

  public interface ToolBarBaseStyle {
    String toolBar();

    String moreButton();
  }

}
