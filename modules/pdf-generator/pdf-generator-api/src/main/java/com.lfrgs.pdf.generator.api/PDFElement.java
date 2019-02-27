package com.lfrgs.pdf.generator.api;

import com.liferay.portal.kernel.util.ArrayUtil;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 * @author Shane Merriss
 */
public abstract class PDFElement<T extends PDFElement<T>> {

	public PDFElement() {
	}

	public PDFElement(float height, float width, float[] margins) {
		_height = height;
		_width = width;
		_margins = ArrayUtil.clone(margins);
	}

	public abstract void draw(PDFContextWriter pdfContextWriter, float startX, float startY) throws IOException;

	public float getHeight() {
		return _height;
	}

	public float getMarginBottom() {
		return getMargins()[1];
	}

	public float getMarginLeft() {
		return getMargins()[2];
	}

	public float getMarginRight() {
		return getMargins()[3];
	}

	public float[] getMargins() {
		return _margins;
	}

	public float getMarginTop() {
		return getMargins()[0];
	}

	public float[] getPageMargins() {
		return _pageMargins;
	}

	public PDRectangle getPageRectangle() {
		return _pageRectangle;
	}

	public float getPageWritableHeight() {
		return getPageRectangle().getHeight()
			- getPageMargins()[0]
			- getPageMargins()[1];
	}

	public abstract T getPDFElement();

	public float getWidth() {
		return _width;
	}

	public float getWritableHeight() {
		return getHeight() - getMarginTop() - getMarginBottom();
	}

	public float getWritableWidth() {
		return getWidth() - getMarginLeft() - getMarginRight();
	}

	public T setBottomMargin(float bottomMargin) {
		_margins[1] = bottomMargin;

		return getPDFElement();
	}

	public T setHeight(float height) {
		_height = height;

		return getPDFElement();
	}

	public T setLeftMargin(float leftMargin) {
		_margins[2] = leftMargin;

		return getPDFElement();
	}

	public T setMargins(float topMargin, float bottomMargin, float leftMargin, float rightMargin) {
		_margins[0] = topMargin;
		_margins[1] = bottomMargin;
		_margins[2] = leftMargin;
		_margins[3] = rightMargin;

		return getPDFElement();
	}

	public T setMargins(float[] margins) {
		_margins = margins;

		return getPDFElement();
	}

	public T setPageMargins(float[] pageMargins) {
		_pageMargins = pageMargins;

		return getPDFElement();
	}

	public T setPageRectangle(PDRectangle pdRectangle) {
		_pageRectangle = pdRectangle;

		return getPDFElement();
	}

	public T setRightMargin(float rightMargin) {
		_margins[3] = rightMargin;

		return getPDFElement();
	}

	public T setTopMargin(float topMargin) {
		_margins[0] = topMargin;

		return getPDFElement();
	}

	public T setWidth(float width) {
		_width = width;

		return getPDFElement();
	}

	private static float[] _pageMargins = ArrayUtil.clone(PDFConstants.DEFAULT_DOCUMENT_MARGINS);
	private static PDRectangle _pageRectangle = PDRectangle.LETTER;
	private float _height = 3f;
	private float[] _margins = ArrayUtil.clone(PDFConstants.DEFAULT_MARGINS); 	// top, bottom, left, right
	private float _width;
}