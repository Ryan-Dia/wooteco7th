package menu.dto;

import java.util.List;
import java.util.Map;

public record RecommendedMenu(Map<String, List<String>> recommendedMenu, List<String> categoryBox) {
}
