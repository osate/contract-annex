package org.osate.contract.gsn;

import java.util.List;

public record YamlFolder(String name, List<YamlFile> files) {
}