import java.util.*;
import java.util.stream.Collectors;

public class Allergies {

    private int score;
    List<Allergen> allergenList;

    Allergies(int score) {
        this.score = score;
        prepList();
    }

    public boolean isAllergicTo(Allergen allergen) {
        return Optional.of(allergenList).get().contains(allergen);
    }

    public void prepList() {
        allergenList = new ArrayList<>();
        int maxScore = Arrays.asList(Allergen.values()).stream().mapToInt(Allergen::getScore).sum();
        score = (score > maxScore) ? (score % maxScore) : score;
        Arrays.asList(Allergen.values()).stream().sorted((o1, o2) -> o2.getScore() - o1.getScore())
                .collect(Collectors.toList()).forEach(allergen -> {
            if (allergen.getScore() <= score) {
                allergenList.add(allergen);
                score = score - allergen.getScore();
            }
        });
        Collections.sort(allergenList);
    }

    public List<Allergen> getList() {
        return allergenList;
    }
}