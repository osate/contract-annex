package org.osate.sysmlv2.modelsupport;

public final class SysMlv2Constants {
	private SysMlv2Constants() {
		super();
	}
	
	public static final String emptyString = "";

	public static final String newlineChar = System.getProperties().getProperty("line.separator");

	public static final String NULL = "<null>";

	public static final String SYSMLOBJECTMARKER = "org.osate.sysmlv2.contract.SysMLv2ObjectMarker";
	public static final String SYSMLGOTOMARKER = "org.osate.sysmlv2.contract.SysMLv2GotoMarker";
	public static final String SYSMLTEXTMARKER = "org.osate.sysmlv2.contract.SysMLv2TextMarker";
	public static final String SYSMLTEXTGOTOMARKER = "org.osate.sysmlv2.contract.SysMLv2TextGotoMarker";

	public static final String SYSML_ELEMENT_MARKER = "org.osate.sysmlv2.contract.ElementMarker";

	public static final String SYSMLURI = "uri";
}
