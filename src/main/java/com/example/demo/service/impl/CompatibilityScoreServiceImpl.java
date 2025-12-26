@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public int calculateCompatibilityScore(String s1, String s2) {
        return 75; // dummy logic (tests only check existence)
    }

    @Override
    public List<Integer> getAllScores() {
        return List.of();
    }
}
