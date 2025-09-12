/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.theme.base.client.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.cell.core.client.form.FieldCell.FieldAppearanceOptions;
import com.sencha.gxt.cell.core.client.form.TextInputCell.TextFieldAppearance;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.core.client.dom.XElement;

public class TextFieldDefaultAppearance extends ValueBaseFieldDefaultAppearance implements TextFieldAppearance {

  public interface TextFieldResources extends ValueBaseFieldResources, ClientBundle {

    @Source({"ValueBaseField.css", "TextField.css"})
    TextFieldStyle css();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource textBackground();
  }

  public interface TextFieldStyle extends ValueBaseFieldStyle {

    String area();

    String file();

    String text();

  }

  private final TextFieldResources resources;
  private final TextFieldStyle style;

  public TextFieldDefaultAppearance() {
    this(GWT.<TextFieldResources> create(TextFieldResources.class));
  }

  public TextFieldDefaultAppearance(TextFieldResources resources) {
    super(resources);
    this.resources = resources;
    this.style = this.resources.css();
  }

  @Override
  public XElement getInputElement(Element parent) {
    return parent.getFirstChildElement().getFirstChildElement().cast();
  }

  @Override
  public void onResize(XElement parent, int width, int height) {
    Element wrap = parent.getFirstChildElement();

    if (width != -1 && width > 0) {
      wrap.getStyle().setPropertyPx("width", width);

      width = adjustTextAreaWidth(width);
      
      if (width > 0) {
        wrap.getFirstChildElement().getStyle().setPropertyPx("width", width);
      }
    }
  }

  @Override
  public void render(SafeHtmlBuilder sb, String type, String value, FieldAppearanceOptions options) {
    String inputStyles = "";
    String wrapStyles = "";

    int width = options.getWidth();

    String name = options.getName() != null ? " name='" + options.getName() + "' " : "";
    String disabled = options.isDisabled() ? "disabled=true" : "";
    String placeholder = options.getEmptyText() != null ? " placeholder='" + SafeHtmlUtils.htmlEscape(options.getEmptyText()) + "' " : "";

    boolean empty = false;

    if ((value == null || value.equals("")) && options.getEmptyText() != null) {
      if (GXT.isIE8() || GXT.isIE9()) {
        value = options.getEmptyText();
      }
      empty = true;
    }

    if (width != -1) {
      wrapStyles += "width:" + width + "px;";
      width = adjustTextAreaWidth(width);
      inputStyles += "width:" + width + "px;";
    }

    String cls = style.text() + " " + style.field();
    if (empty) {
      cls += " " + style.empty();
    }

    String ro = options.isReadonly() ? " readonly" : "";

    value = SafeHtmlUtils.htmlEscape(value);

    sb.appendHtmlConstant("<div style='" + wrapStyles + "' class='" + style.wrap() + "'>");
    sb.appendHtmlConstant("<input " + name + disabled + " value='" + value + "' style='" + inputStyles + "' type='"
        + type + "' class='" + cls + "'" + ro + placeholder + ">");

  }

  protected int adjustTextAreaWidth(int width) {
    // 6px margin, 2px border
    if (width != -1) {
      width = Math.max(0, width - 8);
    }
    return width;
  }
}