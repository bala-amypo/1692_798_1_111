public interface CompatibilityScoreRecordRepository
        extends JpaRepository<CompatibilityScoreRecord, Long> {
    List<CompatibilityScoreRecord> findByStudentAIdOrStudentBId(Long a, Long b);
}
