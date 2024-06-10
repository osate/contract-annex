package org.osate.contract.gsn;

import java.util.List;
import java.util.stream.Collectors;

public record YamlFile(String name, String contents) {
	public YamlFile(String name, List<String> nodes) {
		this(name + ".gsn.yaml", nodes.stream().collect(Collectors.joining("\n\n")));
	}
}