package src.main.java.codechallenges;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftJoin {
  public Map<String, List<String>> leftJoin(Map<String, String> synonyms, Map<String, String> antonyms) {
    Map<String, List<String>> output = new HashMap<>();

    for (String key : synonyms.keySet()) {
      List<String> values = new ArrayList<>();
      values.add(synonyms.get(key));

      values.add(antonyms.getOrDefault(key, null));

      output.put(key, values);
    }

    return output;
  }
}
