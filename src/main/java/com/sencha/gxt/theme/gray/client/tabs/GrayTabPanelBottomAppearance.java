/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.theme.gray.client.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.widget.core.client.TabPanel.TabPanelBottomAppearance;

public class GrayTabPanelBottomAppearance extends GrayTabPanelAppearance implements TabPanelBottomAppearance {

  public interface BottomTemplate extends Template {

    @XTemplate(source = "TabPanelBottom.html")
    SafeHtml render(TabPanelStyle style);

  }

  public GrayTabPanelBottomAppearance() {
    this(GWT.<GrayTabPanelResources> create(GrayTabPanelResources.class), GWT
        .<BottomTemplate> create(BottomTemplate.class), GWT.<ItemTemplate> create(ItemTemplate.class));
  }

  public GrayTabPanelBottomAppearance(GrayTabPanelResources resources, BottomTemplate template,
      ItemTemplate itemTemplate) {
    super(resources, template, itemTemplate);
  }

  @Override
  public XElement getBar(XElement parent) {
    return parent.getLastChild().cast();
  }

  @Override
  public void onScrolling(XElement parent, boolean scrolling) {
    parent.selectNode("." + style.tabFooter()).setClassName(style.tabScrolling(), scrolling);
  }

  @Override
  public XElement getStrip(XElement parent) {
    return parent.selectNode("." + style.tabStripBottom());
  }

}
