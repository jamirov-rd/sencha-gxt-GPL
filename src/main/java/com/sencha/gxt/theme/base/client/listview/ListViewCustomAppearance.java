/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.theme.base.client.listview;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.theme.base.client.listview.ListViewDefaultAppearance.ListViewDefaultResources;
import com.sencha.gxt.widget.core.client.ListView.ListViewAppearance;

@SuppressWarnings("javadoc")
public abstract class ListViewCustomAppearance<M> implements ListViewAppearance<M> {

  private ListViewDefaultResources resources = GWT.create(ListViewDefaultResources.class);
  protected String itemSelector;
  protected String overStyle;
  protected String selectedStyle;

  public ListViewCustomAppearance(String itemSelector) {
    this(itemSelector, null, null);
  }

  public ListViewCustomAppearance(String itemSelector, String overStyle, String selStyle) {
    this.itemSelector = itemSelector;
    this.overStyle = overStyle;
    this.selectedStyle = selStyle;

    resources.css().ensureInjected();
  }

  @Override
  public Element findCellParent(XElement item) {
    return item;
  }

  @Override
  public Element findElement(XElement child) {
    return child.findParentElement(itemSelector, 10);
  }

  @Override
  public List<Element> findElements(XElement parent) {
    NodeList<Element> nodes = parent.select(itemSelector);
    List<Element> temp = new ArrayList<Element>();
    for (int i = 0; i < nodes.getLength(); i++) {
      temp.add(nodes.getItem(i));
    }

    return temp;
  }

  @Override
  public void onOver(XElement item, boolean over) {
    if (overStyle != null) {
      item.setClassName(overStyle, over);
    }
  }

  @Override
  public void onSelect(XElement item, boolean select) {
    if (selectedStyle != null) {
      item.setClassName(selectedStyle, select);
    }
  }

  @Override
  public void render(SafeHtmlBuilder builder) {
    builder.appendHtmlConstant("<div class='" + resources.css().view() + "'></div>");
  }

  @Override
  public void renderEnd(SafeHtmlBuilder builder) {
  }

  @Override
  public abstract void renderItem(SafeHtmlBuilder builder, SafeHtml content);

}