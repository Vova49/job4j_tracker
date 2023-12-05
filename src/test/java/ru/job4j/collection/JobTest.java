package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompareAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Task A", 1),
                new Job("Task B", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(
                new Job("Task A", 1),
                new Job("Task B", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Task B", 2),
                new Job("Task A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Task B", 2),
                new Job("Task A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
    @Test
    public void whenCompareCombinedComparator() {
        Comparator<Job> combinedComparator = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = combinedComparator.compare(
                new Job("Task A", 1),
                new Job("Task B", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareCombinedComparatorWithEqualNames() {
        Comparator<Job> combinedComparator = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = combinedComparator.compare(
                new Job("Task A", 1),
                new Job("Task A", 2)
        );
        assertThat(rsl).isLessThan(0);
    }
}
