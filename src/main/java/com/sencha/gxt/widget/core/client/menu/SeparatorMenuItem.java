/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.widget.core.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.dom.XDOM;

/**
 * Adds a separator bar to a menu, used to divide logical groups of menu items.
 */
public class SeparatorMenuItem extends Item {

  public interface SeparatorMenuItemAppearance extends ItemAppearance {

    void render(SafeHtmlBuilder result);

  }

  /**
   * Creates a new separator menu item.
   */
  public SeparatorMenuItem() {
    this(GWT.<SeparatorMenuItemAppearance> create(SeparatorMenuItemAppearance.class));
  }

  public SeparatorMenuItem(SeparatorMenuItemAppearance appearance) {
    super(appearance);
    hideOnClick = false;
    SafeHtmlBuilder markupBuilder = new SafeHtmlBuilder();
    appearance.render(markupBuilder);
    Element item = XDOM.create(markupBuilder.toSafeHtml());
    setElement(item);
  }

  @Override
  protected void onClick(NativeEvent be) {
    // do not call super
  }
}
