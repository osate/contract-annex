package org.osate.contract.contract;

import org.osate.contract.contract.impl.SourceImpl;

public class PathSourceImpl extends SourceImpl implements Source {

	String path = "";
	Source orgSource;

	public PathSourceImpl() {
		super();
		orgSource = new SourceImpl();
	}

	public PathSourceImpl(Source source, String path) {
		this.orgSource = source;
		this.path = path;
	}

	public String getArgumentPath() {
		return path;
	}

	@Override
	public
	Language getLanguage() {
		return orgSource.getLanguage();
	}

	@Override
	public
	void setLanguage(Language value) {
		orgSource.setLanguage(value);
	}

	@Override
	public
	String getSource() {
		return orgSource.getSource();
	}

	@Override
	public void setSource(String value) {
		orgSource.setSource(value);
	}

	@Override
	public IString getInter() {
		return orgSource.getInter();
	}

	@Override
	public void setInter(IString value) {
		orgSource.setInter(value);
	}
}
